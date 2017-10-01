# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

import mydb

from django.http.response import HttpResponse

from django.http import StreamingHttpResponse

import uuid

from django.views.decorators.csrf import csrf_exempt, csrf_protect

from django.core.mail import send_mail


# Create your views here.

def index(request):
	# 根据数据库读取相应的资源,把数据看以外的图片资源删除
	movies = mydb.get_movies()
	musics = mydb.get_musics()
	mydb.clear_extra_images(movies, musics)
	return render(request, 'index.html', locals())


def resume(request):
	return render(request, 'resume.html', locals())


def movie(request, id):
	try:
		movie = mydb.get_movie_id(id)
	except Exception as e:
		return error(request)
	return render(request, 'movie.html', locals())


def music(request, id):
	try:
		music = mydb.get_music_id(id)
	except Exception as e:
		return error(request)
	return render(request, 'music.html', locals())


@csrf_exempt
def contact(request):
	# 获取信息
	name = request.POST['name']
	email = request.POST['email']
	msg_subject = request.POST['msg_subject']
	message = request.POST['message']
	# 邮件通知我
	result = '未发送状态'
	#email只能接收163邮箱
	postfix=email[-7:-4]
	if postfix!='163':
		return HttpResponse('目前只支持163邮箱，谢谢配合！', locals())
	try:
		send_mail(
			msg_subject,
			message,
			email,
			['jasonhaven@163.com'],
			fail_silently=False,
		)
		result = 'success'
	except Exception as e:
		result = '信息发送失败！'
	return HttpResponse(result, locals())


def download(request):
	def file_iterator(file_name, chunk_size=20480):
		with open(file_name) as f:
			while True:
				c = f.read(chunk_size)
				if c:
					yield c
				else:
					break
	response=''
	try:
		the_file_name = "static/resume_assets/resume.pdf"
		response = StreamingHttpResponse(file_iterator(the_file_name))
		response['Content-Type'] = 'application/octet-stream'
		response['Content-Disposition'] = 'attachment;filename="{0}"'.format(str(uuid.uuid1()) + '.pdf')
	except Exception as e:
		return error(request)
	return response

def error(request):
	return render(request, 'error.html', locals())
