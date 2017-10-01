# -*- coding:utf-8 -*-
from django.contrib import admin
from models import *


# Register your models here.
class ArticleAdmin(admin.ModelAdmin):
	list_display = ('title', 'desc','click_count','date_publish')#显示列
	list_display_links = ('title', 'desc',)#显示列上的链接效果
	list_editable = ('click_count',)#可编辑的列

	fieldsets = (
		(None, {
			'fields': ('title', 'desc', 'content', 'user', 'category', 'tag',)
		}),
		('高级设置', {
			'classes': ('collapse',),#折叠状态
			'fields': ('click_count', 'is_recommend',)
		}),
	)

	class Media:
		js = (
			'/static/js/kindeditor-4.1.10/kindeditor-min.js',
			'/static/js/kindeditor-4.1.10/lang/zh_CN.js',
			'/static/js/kindeditor-4.1.10/config.js',
		)


class LinksAdmin(admin.ModelAdmin):
	#exclude =
	#fields =
	list_display = ('title', 'callback_url', 'date_publish')


admin.site.register(User)
admin.site.register(Tag)
admin.site.register(Article, ArticleAdmin)
admin.site.register(Category)
admin.site.register(Comment)
admin.site.register(Links, LinksAdmin)
admin.site.register(Ad)
