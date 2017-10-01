# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models


# Create your models here.
class Movie(models.Model):
	name = models.CharField(max_length=50, verbose_name='电影名字')
	introduction = models.TextField(max_length=2000, verbose_name='影音简介')
	cover_image = models.ImageField(upload_to='images/movie/', default='images/default.jpeg',
	                                verbose_name='海报封面（图片）')
	comment = models.CharField(max_length=500, verbose_name='个人评论')
	director = models.CharField(max_length=50, verbose_name='导演')
	type = models.CharField(max_length=50, verbose_name='电影类型')
	release_time = models.CharField(max_length=20, verbose_name='上映时间')
	starring = models.CharField(max_length=50, verbose_name='主演')
	production_cost = models.CharField(max_length=20, verbose_name='制片成本')
	filming_location = models.CharField(max_length=20, verbose_name='拍摄地点')
	film_length = models.CharField(max_length=10, verbose_name='片长')

	class Meta:
		verbose_name = '电影'
		verbose_name_plural = verbose_name


class Music(models.Model):
	name = models.CharField(max_length=50, verbose_name='歌曲名字')
	singer = models.CharField(max_length=50, verbose_name='演唱者')
	original_author = models.CharField(max_length=50, verbose_name='歌曲原唱')
	cover_image = models.ImageField(upload_to='images/music/', default='images/default.jpeg',
	                                verbose_name='海报封面（图片）')
	song = models.FileField(upload_to='media/', default='media/default.mp3',
	                        verbose_name='歌曲')
	album = models.CharField(max_length=50, verbose_name='所属专辑')
	language = models.CharField(max_length=50, verbose_name='歌曲语言')
	music_style = models.CharField(max_length=20, verbose_name='音乐风格')
	lyrics = models.TextField(max_length=2000,verbose_name='歌词')
	lyricswriter = models.CharField(max_length=50, verbose_name='填词')
	songwriter = models.CharField(max_length=50, verbose_name='填曲')
	song_length = models.CharField(max_length=10, verbose_name='歌曲时长')
	wonderful_lyrics = models.CharField(max_length=500, verbose_name='精彩歌词')
	class Meta:
		verbose_name = '歌曲'
		verbose_name_plural = verbose_name

