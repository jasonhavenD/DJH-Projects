# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.contrib import admin

from models import *


# Register your models here.
class MovieAdmin(admin.ModelAdmin):
	list_display = ('name', 'director', 'type', 'release_time', 'film_length')  # 显示列
	list_display_links = ('name',)  # 显示列上的链接效果
	list_editable = ('director', 'type', 'release_time', 'film_length')  # 可编辑的列

	class Media:
		js = (
			'/static/js/kindeditor-4.1.10/kindeditor-min.js',
			'/static/js/kindeditor-4.1.10/lang/zh_CN.js',
			'/static/js/kindeditor-4.1.10/config.js',
		)


class MusicAdmin(admin.ModelAdmin):
	list_display = ('name', 'singer', 'original_author', 'album', 'song_length')  # 显示列
	list_display_links = ('name',)  # 显示列上的链接效果
	list_editable = ('singer', 'original_author', 'album', 'song_length')  # 可编辑的列

	class Media:
		js = (
			'/static/js/kindeditor-4.1.10/kindeditor-min.js',
			'/static/js/kindeditor-4.1.10/lang/zh_CN.js',
			'/static/js/kindeditor-4.1.10/config.js',
		)


admin.site.register(Movie,MovieAdmin)
admin.site.register(Music,MusicAdmin)
