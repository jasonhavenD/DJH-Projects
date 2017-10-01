# -*- coding: utf-8 -*-
from models import *
import os


def get_movies():
	return Movie.objects.all()


def get_musics():
	return Music.objects.all()


def get_movie_id(id):
	return Movie.objects.get(id=str(id))


def get_music_id(id):
	return Music.objects.get(id=str(id))


# 删除多余的图片资源,保持与数据库的同步
def clear_extra_images(movies, musics):
	db_images = []
	for movie in movies:
		db_images.append(movie.cover_image)
	for music in musics:
		db_images.append(music.cover_image)
	rootdir_movie = u'static/images/movie'
	rootdir_music = u'static/images/music'
	files = os.listdir(rootdir_movie)
	for name in files:
		filename = u'images/movie/' + name
		if not is_image_exists(filename, db_images):
			os.remove('static/' + filename)
	files = os.listdir(rootdir_music)
	for name in files:
		filename = u'images/music/' + name
		if not is_image_exists(filename, db_images):
			os.remove('static/' + filename)


# 是否存在
def is_image_exists(img, images):
	return img in images
