# -*- coding: utf-8 -*-
# Generated by Django 1.11.5 on 2017-09-18 13:19
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('home', '0001_initial'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='music',
            options={'verbose_name': '\u6b4c\u66f2', 'verbose_name_plural': '\u6b4c\u66f2'},
        ),
        migrations.AlterField(
            model_name='movie',
            name='comment',
            field=models.CharField(max_length=500, verbose_name='\u4e2a\u4eba\u8bc4\u8bba'),
        ),
        migrations.AlterField(
            model_name='movie',
            name='introduction',
            field=models.CharField(max_length=2000, verbose_name='\u5f71\u97f3\u7b80\u4ecb'),
        ),
        migrations.AlterField(
            model_name='music',
            name='lyrics',
            field=models.TextField(max_length=2000, verbose_name='\u6b4c\u8bcd'),
        ),
        migrations.AlterField(
            model_name='music',
            name='wonderful_lyrics',
            field=models.CharField(max_length=500, verbose_name='\u7cbe\u5f69\u6b4c\u8bcd'),
        ),
    ]