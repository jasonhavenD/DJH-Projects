from django.conf.urls import url
from . import views


urlpatterns = [
	url(r'^$', views.index),
	url(r'resume$', views.resume),
	url(r'movie/(?P<id>[0-9]+)$', views.movie),
	url(r'music/(?P<id>[0-9]+)$', views.music),
	url(r'contact', views.contact),
	url(r'download', views.download),

	url(r'[.]*', views.error),
]
