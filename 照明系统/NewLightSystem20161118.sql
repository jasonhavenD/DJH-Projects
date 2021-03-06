USE [NewLightSystem]
GO
/****** Object:  Table [dbo].[delivercyclepolicy]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[delivercyclepolicy](
	[delivercyclepolicyid] [int] NOT NULL,
	[delivercycle] [int] NOT NULL,
	[delivercyclebenefits] [float] NOT NULL,
 CONSTRAINT [PK_delivercyclepolicy] PRIMARY KEY CLUSTERED 
(
	[delivercyclepolicyid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[coustomproduct]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[coustomproduct](
	[productid] [int] NULL,
	[customkey] [varchar](100) NULL,
	[customvalue] [varchar](100) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[company]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[company](
	[companyid] [int] NOT NULL,
	[money] [float] NULL,
	[frozenmoney] [float] NULL,
	[paypassword] [varchar](50) NULL,
	[companyname] [varchar](50) NULL,
	[managername] [varchar](50) NULL,
	[managerphone] [varchar](50) NULL,
	[idcardpicture] [varchar](255) NULL,
	[companylicensepicture] [varchar](255) NULL,
	[companypicture] [varchar](255) NULL,
	[longitude] [float] NULL,
	[latitude] [float] NULL,
	[province] [varchar](50) NULL,
	[city] [varchar](50) NULL,
	[district] [varchar](50) NULL,
	[detailaddress] [varchar](200) NULL,
	[email] [varchar](50) NULL,
	[fixphone] [varchar](50) NULL,
	[birthday] [datetime] NULL,
	[zipcode] [varchar](50) NULL,
	[state] [int] NOT NULL,
 CONSTRAINT [PK_company] PRIMARY KEY CLUSTERED 
(
	[companyid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (1, NULL, NULL, N'134577', N'物流中心1', N'fanxiaoyuan', N'111111111111111', N'/authenticImage/398112611654111941679402141201122844.png', N'/authenticImage/369243791410104505595118467410210614.jpg', N'/authenticImage/18105113548080125201262635561183110359.png', 107.261146, 34.369177, N'陕西', N'郑州', N'禹州', N'河南省禹州市张得乡', N'heihei', N'11111111111', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (2, NULL, NULL, N'134577', N'物流中心2', N'fanxiaoyuan', N'111111111111111', NULL, NULL, NULL, 1234.5, 234.5, N'河南', N'郑州', N'禹州', N'
河南省禹州市张得乡', N'heihei', N'11111111111', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (3, NULL, NULL, N'134577', N'物流中心3', N'fanxiaoyuan', N'111111111111111', NULL, NULL, NULL, 1234.5, 234.5, N'河南', N'郑州', N'禹州', N'
河南省禹州市张得乡', N'heihei', N'11111111111', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (8, NULL, NULL, N'3333', N'物流中心4', N'fanxiaoyuan', N'1111111111111', N'/authenticImage/10182851278457905633323744105294125.jpg', N'/authenticImage/10182851278457905633323744105294125.jpg', N'/authenticImage/1162971228164641121217651231211211149.jpg', 107.261146, 34.369177, N'陕西', N'郑州', N'宇宙', N'河南省禹州市长得像', N'哈哈', N'111111111111111111', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (9, NULL, NULL, N'3333', N'物流中心5', N'fanxiaoyuan', N'1111111111111', NULL, NULL, NULL, 1234.5, 34.369177, N'河南', N'郑州', N'宇宙', N'河南省禹州市长得像', N'哈哈', N'111111111111111111', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (10, NULL, NULL, N'3333', N'物流中心6', N'fanxiaoyuan', N'1111111111111', NULL, NULL, NULL, 1234.5, 234.5, N'河南', N'郑州', N'宇宙', N'河
南省禹州市长得像', N'哈哈', N'111111111111111111', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (12, NULL, NULL, N'', N'', N'', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (13, NULL, NULL, N'', N'', N'', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (14, NULL, NULL, N'', N'', N'', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (15, NULL, NULL, N'', N'', N'', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (16, NULL, NULL, N'', N'', N'', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (17, NULL, NULL, N'123456', N'张三的店', N'张三', N'15234567898', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'陕西省杨凌区', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (18, NULL, NULL, N'123456', N'张三的店', N'张三', N'15243567895', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (19, NULL, NULL, N'123', N'123', N'123', N'123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (20, NULL, NULL, N'123', N'123', N'123', N'12345678987', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'ppp', N'', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (61, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', N'灯具世家', N'张哲思', N'15236952658', N'/authenticImage/9028691213256339210212211332967060.jpg', N'/authenticImage/104109967791934532012160621021229881.jpg', N'/authenticImage/55103631929257124243917512188117124.jpg', 108.640034, 34.17353, N'陕西省', N'西安市', N'户县', N'电力设备', N'1254877522@qq.com', N'02986181328', NULL, NULL, 4)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (70, NULL, NULL, N'123456', N'丽丝尔的店', N'丽丝尔', N'15236956982', N'/authenticImage/125804959125988113384343862018857.jpg', N'/authenticImage/10182851278457905633323744105294125.jpg', N'/authenticImage/1162971228164641121217651231211211149.jpg', 116.162302, 40.069853, N'北京市', N'北京市', N'海淀区', N'温泉镇', N'', N'', NULL, NULL, 6)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (75, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', N'wspwspwsp', N'wsp', N'15203962504', N'/authenticImage/135092113606324106123113442574234940.jpg', N'/authenticImage/1712811451111120324223171241157910012880.jpg', N'/authenticImage/7828731133048790901264791125401650.jpg', 107.095721, 34.717975, N'陕西省', N'宝鸡市', N'千阳县', N'123', N'', N'', NULL, NULL, 6)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (76, NULL, NULL, N'd553d148479a268914cecb77b2b88e6a', N'江流儿的小
日子', N'江流儿', N'18722569875', NULL, NULL, NULL, 116.072393, 34.319262, N'河南省
', N'商丘市', N'夏邑县', N'李集镇45号', N'1236547891@qq.com', N'', NULL, NULL, 1)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (95, NULL, NULL, N'202cb962ac59075b964b07152d234b70', N'河南001物流
中心', N'石婧媛', N'15123982356', NULL, NULL, NULL, 113.082575, 34.469299, N'河南省
', N'郑州市', N'登封市', N'中越', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (101, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', N'陕西物流中
心', N'张三', N'13562358952', NULL, NULL, NULL, 108.975765, 34.21669, N'陕西省', N'
西安市', N'雁塔区', N'芙蓉园', NULL, NULL, NULL, NULL, 2)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (103, NULL, NULL, N'202cb962ac59075b964b07152d234b70', N'北京物流中
心', N'魏淑平', N'15029039705', NULL, NULL, NULL, 116.482306, 39.967717, N'北京市', N'北京市', N'朝阳区', N'', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (104, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', N'微微和开心
的店', N'shuping微', N'15203698520', NULL, NULL, NULL, 109.012356, 34.291659, N'陕
西省', N'西安市', N'灞桥区', N'星辰小区', N'12589636522@qq.com', N'4252695', NULL, NULL, 0)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (105, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', N'开心和快乐
的店', N'魏淑平', N'15029039705', N'/authenticImage/26108100764732210817735051251139591.jpg', N'/authenticImage/37393610341442911157269997105876233.jpg', N'/authenticImage/981051071142677356610735119108791093591.jpg', 107.167011, 34.672862, N'陕西省', N'宝鸡市', N'千阳县', N'南寨镇', N'', N'4292067', NULL, NULL, 6)
INSERT [dbo].[company] ([companyid], [money], [frozenmoney], [paypassword], [companyname], [managername], [managerphone], [idcardpicture], [companylicensepicture], [companypicture], [longitude], [latitude], [province], [city], [district], [detailaddress], [email], [fixphone], [birthday], [zipcode], [state]) VALUES (106, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', N'魏淑平魏淑
平', N'魏淑平', N'15029039705', N'/authenticImage/271201213916525538459201740267925.jpg', N'/authenticImage/7688637684601158817576319116951857.jpg', N'/authenticImage/871273011967541165961056564105844347.jpg', 109.078194, 35.141851, N'陕西省', N'铜川市', N'印台区', N'前期小区', N'', N'4292067', NULL, NULL, 6)
/****** Object:  Table [dbo].[pointexchagepolicy]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pointexchagepolicy](
	[pointexchangeid] [int] NOT NULL,
	[pointtomoney] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[information]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[information](
	[informationid] [int] NOT NULL,
	[informationtitle] [varchar](50) NOT NULL,
	[informationcontent] [text] NULL,
	[publishdatetime] [datetime] NOT NULL,
	[publishuserid] [int] NULL,
	[attchmentspath] [varchar](100) NULL,
	[type] [int] NULL,
	[hits] [int] NULL,
	[typename] [varchar](50) NULL,
 CONSTRAINT [PK_information] PRIMARY KEY CLUSTERED 
(
	[informationid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (1, N'资源下载1', N'<p>This is a test of 资源下载1!!!</p>', CAST(0x0000A6B200000000 AS DateTime), 73, NULL, 1, 1, N'资源下载')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (2, N'资源下载2', N'<p>This is a test of 资源下载2!!!</p>', CAST(0x0000A6B200000000 AS DateTime), 73, NULL, 1, 1, N'资源下载')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (3, N'新闻公告1', N'<p>This is a test of 新闻公告1!!!</p>', CAST(0x0000A6BC00000000 AS DateTime), 73, NULL, 2, 21, N'新闻公告')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (4, N'新闻公告2', N'<p>This is a test of 新闻公告2!!!</p>', CAST(0x0000A6BC00000000 AS DateTime), 73, NULL, 2, 22, N'新闻公告')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (5, N'新闻公告3', N'<p>This is a test of 新闻公告3!!!</p>', CAST(0x0000A6BC00000000 AS DateTime), 73, NULL, 2, 23, N'新闻公告')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (6, N'行业资讯1', N'<p>This is a test of 行业资讯1!!!</p>', CAST(0x0000A6BD00000000 AS DateTime), 73, NULL, 3, 31, N'行业资讯')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (7, N'行业资讯2', N'<p>This is a test of 行业资讯2!!!</p>', CAST(0x0000A6BD00000000 AS DateTime), 73, NULL, 3, 32, N'行业资讯')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (8, N'行业资讯3', N'<p>This is a test of 行业资讯3!!!</p>', CAST(0x0000A6BD00000000 AS DateTime), 73, NULL, 3, 33, N'行业资讯')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (9, N'行业资讯4', N'<p>This is a test of 行业资讯4!!!</p>', CAST(0x0000A6BD00000000 AS DateTime), 73, NULL, 3, 34, N'行业资讯')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (10, N'帮助中心1', N'<p>This is a test of 帮助中心1!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 4, 41, N'帮助中心')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (11, N'帮助中心2', N'<p>This is a test of 帮助中心2!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 4, 42, N'帮助中心')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (12, N'帮助中心3', N'<p>This is a test of 帮助中心3!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 4, 43, N'帮助中心')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (13, N'帮助中心4', N'<p>This is a test of 帮助中心4!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 4, 44, N'帮助中心')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (14, N'帮助中心5', N'<p>This is a test of 帮助中心5!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 4, 45, N'帮助中心')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (15, N'公司简介', N'<p>This is a test of 公司简介!!!</p>', CAST(0x0000A6C000000000 AS DateTime), 73, NULL, 5, 51, N'公司简介')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (16, N'招商政策', N'<p>This is a test of 招商政策5!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 6, 61, N'招商政策')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (17, N'发展愿景', N'<p>This is a test of 发展愿景5!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 7, 71, N'发展愿景')
INSERT [dbo].[information] ([informationid], [informationtitle], [informationcontent], [publishdatetime], [publishuserid], [attchmentspath], [type], [hits], [typename]) VALUES (18, N'联系我们', N'<p>This is a test of 联系我们5!!!</p>', CAST(0x0000A6BF00000000 AS DateTime), 73, NULL, 8, 81, N'联系我们')
/****** Object:  Table [dbo].[homeslides]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[homeslides](
	[pictureid] [int] NOT NULL,
	[picturename] [varchar](50) NOT NULL,
	[picturepath] [varchar](100) NOT NULL,
	[lowpicturepath] [varchar](100) NULL,
	[picturesequence] [int] NOT NULL,
	[forwardurl] [varchar](100) NULL,
	[picturestate] [int] NULL,
 CONSTRAINT [PK_homeslides] PRIMARY KEY CLUSTERED 
(
	[pictureid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[homeslides] ([pictureid], [picturename], [picturepath], [lowpicturepath], [picturesequence], [forwardurl], [picturestate]) VALUES (1, N'slide1', N'newpages/assets/images/demo/shop/banners/home_slider_1.jpg', N'newpages/assets/images/demo/shop/banners/home_slider_1.jpg', 1, NULL, NULL)
INSERT [dbo].[homeslides] ([pictureid], [picturename], [picturepath], [lowpicturepath], [picturesequence], [forwardurl], [picturestate]) VALUES (2, N'slide2', N'newpages/assets/images/demo/shop/banners/home_slider_2.jpg', N'newpages/assets/images/demo/shop/banners/home_slider_2.jpg', 3, NULL, NULL)
/****** Object:  Table [dbo].[userinfo]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[userinfo](
	[userinfoid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[phone] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[qq] [varchar](50) NULL,
	[weixin] [varchar](50) NULL,
	[weibo] [varchar](50) NULL,
	[taobao] [varchar](50) NULL,
	[zhifubao] [varchar](50) NULL,
	[password] [varchar](50) NOT NULL,
	[membertype] [int] NOT NULL,
	[state] [int] NULL,
	[registerdatetime] [datetime] NULL,
	[lastdatetime] [datetime] NULL,
 CONSTRAINT [PK_userinfo] PRIMARY KEY CLUSTERED 
(
	[userinfoid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[userinfo] ON
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (1, N'fanxiaoyuan', N'18220525830', NULL, NULL, NULL, NULL, NULL, NULL, N'202cb962ac59075b964b07152d234b70', 2, NULL, NULL, CAST(0x0000A62600B203E5 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (2, N'fanxy', N'18220525830', NULL, NULL, NULL, NULL, NULL, NULL, N'202cb962ac59075b964b07152d234b70', 4, 1, NULL, CAST(0x0000A6270152A7DD AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (3, N'fanxiaoyuan', N'18220525830', NULL, NULL, NULL, NULL, NULL, NULL, N'123456', 4, 1, NULL, NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (4, N'fanxiaoyuan', NULL, N'740842107@qq.com', NULL, NULL, NULL, NULL, NULL, N'123456', 4, 1, NULL, CAST(0x0000A593010F829B AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (5, N'fanxiaoyuan', NULL, N'123@qq.com', NULL, NULL, NULL, NULL, NULL, N'123456', 4, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (6, N'fanxiaoyuan', NULL, N'123@qq.com', NULL, NULL, NULL, NULL, NULL, N'123456', 4, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (8, N'hello', NULL, N'740842107@qq.com', NULL, NULL, NULL, NULL, NULL, N'c4ca4238a0b923820dcc509a6f75849b', 4, NULL, NULL, CAST(0x0000A60A017445B3 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (10, N'fanxiaoyuan', NULL, N'123@qq.com', NULL, NULL, NULL, NULL, NULL, N'123456', 4, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (61, N'152', NULL, N'15029039705', NULL, NULL, NULL, NULL, NULL, N'c4ca4238a0b923820dcc509a6f75849b', 4, 1, CAST(0x0000A59500F3620F AS DateTime), CAST(0x0000A612013859EC AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (62, N'', NULL, N'', NULL, NULL, NULL, NULL, NULL, N'', 4, 1, CAST(0x0000A59500F3C3D3 AS DateTime), CAST(0x0000A5F6014A0082 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (63, N'1523', NULL, N'15029039705', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A59500F43CB7 AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (64, N'12@qq.com', NULL, N'12@qq.com', NULL, NULL, NULL, NULL, NULL, N'12@qq.com', 4, 1, CAST(0x0000A59500F67C8A AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (65, N'115', NULL, N'11511511511', NULL, NULL, NULL, NULL, NULL, N'115', 4, 1, CAST(0x0000A59500F6BBE3 AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (66, N'777', NULL, N'7777777777', NULL, NULL, NULL, NULL, NULL, N'7', 4, 1, CAST(0x0000A59500F76FC3 AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (67, N'33', NULL, N'13333333333', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A59500F83F1F AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (68, N'11111', NULL, N'15029039705', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A59500F8C725 AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (70, N'wsp', NULL, N'1552655711@qq.com', NULL, NULL, NULL, NULL, NULL, N'123', 3, 1, CAST(0x0000A59501141F02 AS DateTime), CAST(0x0000A5FE016B3897 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (73, N'wei', NULL, N'fxy@qq.com', NULL, NULL, NULL, NULL, NULL, N'123456', 1, 1, CAST(0x0000A5950116BE64 AS DateTime), CAST(0x0000A6C200D8EF95 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (74, N'gkx', NULL, N'gkx@qq.com', NULL, NULL, NULL, NULL, NULL, N'123', 4, 1, CAST(0x0000A59501176B0E AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (75, N'www', N'1234567890', N'www@qq.com', NULL, NULL, NULL, NULL, NULL, N'202cb962ac59075b964b07152d234b70', 3, 1, CAST(0x0000A5950117E542 AS DateTime), CAST(0x0000A6C300247246 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (76, N'ping', NULL, N'ppp@qq.com', NULL, NULL, NULL, NULL, NULL, N'202cb962ac59075b964b07152d234b70', 4, 1, CAST(0x0000A5950119A44E AS DateTime), CAST(0x0000A6930162B41E AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (77, N'pppp', NULL, N'pppp@qq.com', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A5950119E06F AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (78, N'4444', NULL, N'4444@qq.com', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A595011A5B3E AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (79, N'5555', NULL, N'5555@qq.com', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A595011B961B AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (80, N'22222', NULL, N'22222@qq.com', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A595011C7A1D AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (81, N'uuuuu', NULL, N'uuuuu@qq.com', NULL, NULL, NULL, NULL, NULL, N'1', 4, 1, CAST(0x0000A595011D15A2 AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (82, N'uuuuu', NULL, N'711655@qq.com', NULL, NULL, NULL, NULL, NULL, N'123', 4, 1, CAST(0x0000A595011E865F AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (96, N'xiaoyuanfan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'00', 2, 1, CAST(0x0000A59B012C2197 AS DateTime), CAST(0x0000A628010D5F2C AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (97, N'测试邮箱注册', NULL, N'12547165@q
日q.com', NULL, NULL, NULL, NULL, NULL, N'123456', 4, 1, CAST(0x0000A5CD01002A65 AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (98, N'再次测试邮箱注册', NULL, N'1@qq.com', NULL, NULL, NULL, NULL, NULL, N'123456', 4, 1, CAST(0x0000A5CD0101AEBB AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (99, N'1111', NULL, N'11111@qq.com', NULL, NULL, NULL, NULL, NULL, N'123456', 4, 1, CAST(0x0000A5CD0102E06F AS DateTime), CAST(0x0000A5CD010330CD AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (100, N'照明系统', NULL, N'1234567@qq.com', NULL, NULL, NULL, NULL, NULL, N'654321', 4, 1, CAST(0x0000A5F601278819 AS DateTime), CAST(0x0000A5F601285D50 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (101, N'sx001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'sx001', 2, 0, CAST(0x0000A5F900CB56D7 AS DateTime), CAST(0x0000A6A30001055E AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (102, N'henan001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'henan001', 2, 1, CAST(0x0000A5FA014EF424 AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (103, N'北京001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京001', 2, 1, CAST(0x0000A60B0102FB4C AS DateTime), CAST(0x0000A60B0103245A AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (104, N'shuping', NULL, N'1256211655@qq.com', NULL, NULL, NULL, NULL, NULL, N'c6b310556a92ae7cc8483656d3ce85e1', 4, 1, CAST(0x0000A61F00A74132 AS DateTime), CAST(0x0000A62100CF669D AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (105, N'魏淑平', NULL, N'711655@qq.com', NULL, NULL, NULL, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', 3, 1, CAST(0x0000A62200E47575 AS DateTime), CAST(0x0000A62200F3C20C AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (106, N'魏一一', NULL, N'1254711655@qq.com', NULL, NULL, NULL, NULL, NULL, N'e10adc3949ba59abbe56e057f20f883e', 3, 1, CAST(0x0000A622015062C6 AS DateTime), CAST(0x0000A6220155C98C AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (107, N'fjwl', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'123456', 2, 1, CAST(0x0000A62901874BDC AS DateTime), CAST(0x0000A6290187C587 AS DateTime))
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (111, N'wen', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'123456', 2, 1, CAST(0x0000A68400B9B37A AS DateTime), NULL)
INSERT [dbo].[userinfo] ([userinfoid], [username], [phone], [email], [qq], [weixin], [weibo], [taobao], [zhifubao], [password], [membertype], [state], [registerdatetime], [lastdatetime]) VALUES (112, N'nym', N'13572917517', NULL, NULL, NULL, NULL, NULL, NULL, N'123', 4, 1, CAST(0x0000A6A1009158FA AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[userinfo] OFF
/****** Object:  Table [dbo].[producttype]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[producttype](
	[producttypeid] [int] IDENTITY(1,1) NOT NULL,
	[producttypename] [varchar](50) NOT NULL,
	[parentproducttypeid] [int] NULL,
	[producttypepicturepath] [varchar](100) NULL,
	[typecount] [int] NULL,
 CONSTRAINT [PK_producttype] PRIMARY KEY CLUSTERED 
(
	[producttypeid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[producttype] ON
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (1, N'节能灯', 19, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (2, N'球泡灯', 19, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (3, N'一体化筒灯', 19, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (4, N'天花射灯', 19, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (5, N'吸顶灯配件', 19, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (7, N'其他', 19, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (19, N'照明产品', -1, N'./newpages/assets/images/demo/600x400/15-min.jpg', 1)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (20, N'电工产品', -1, N'./newpages/assets/images/demo/600x400/20-min.jpg', 1)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (21, N'水暖产品', -1, N'./newpages/assets/images/demo/600x400/25-min.jpg', 1)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (22, N'电工产品二级分类1', 20, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (23, N'电工产品二级分类2', 20, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (24, N'电工产品二级分类3', 20, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (25, N'电工产品二级分类4', 20, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (26, N'电工产品二级分类5', 20, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (27, N'水暖产品二级分类1', 21, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (28, N'水暖产品二级分类2', 21, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (29, N'水暖产品二级分类3', 21, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (30, N'水暖产品二级分类4', 21, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (31, N'水暖产品二级分类5', 21, NULL, 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (37, N'水暖产品x', 21, N'', 2)
INSERT [dbo].[producttype] ([producttypeid], [producttypename], [parentproducttypeid], [producttypepicturepath], [typecount]) VALUES (38, N'水暖产品x1', 37, N'', 3)
SET IDENTITY_INSERT [dbo].[producttype] OFF
/****** Object:  Table [dbo].[productproperty]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[productproperty](
	[productid] [int] NOT NULL,
	[power] [varchar](50) NULL,
	[lampholder] [varchar](50) NULL,
	[colortemp] [varchar](50) NULL,
	[voltage] [varchar](50) NULL,
	[luminousflux] [varchar](50) NULL,
	[lightefficiency] [varchar](50) NULL,
	[colorrendering] [varchar](50) NULL,
	[beamangle] [varchar](50) NULL,
	[isemc] [varchar](50) NULL,
 CONSTRAINT [PK_productbulb] PRIMARY KEY CLUSTERED 
(
	[productid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (3, N'5W', N'', N'', N'', N'350Lm', N'>90Lm/W', N'>80', N'230度', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (8, N'9W', N'', N'', N'', N'700Lm', N'>90Lm/W', N'>80', N'240度', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (9, N'12W', N'E25', N'3600K', N'220V', N'', N'', N'', N'', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (12, N'10W', N'', N'', N'', N'50Lm', N'60Lm/W', N'4', N'4', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (13, N'14w', N'E27', N'6500k', N'220V', N'', N'', N'', N'', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (14, N'3W', N'', N'', N'', N'180-220Lm', N'>70Lm/W', N'80', N'/', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (17, N'24W', N'B22', N'6500k', N'220V', N'', N'', N'', N'', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (18, N'45W', N'E27', N'6500k', N'220V', N'', N'', N'', N'', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (21, N'3W', N'', N'', N'', N'220Lm', N'>75Lm/W', N'80', N'36度', N'
是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (22, N'5W', N'', N'', N'', N'380Lm', N'>75Lm/W', N'80', N'36度', N'
是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (24, N'12W', N'', N'', N'', N'1150Lm', N'110Lm/W', N'82', N'/', N'
否')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (25, N'16W', N'', N'', N'', N'1480Lm', N'110Lm/W', N'82', N'/', N'
是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (26, N'16W', N'', N'', N'', N'1500Lm', N'90Lm/W', N'70', N'/', N'否
')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (27, N'66W', N'', N'', N'', N'1400Lm', N'90Lm/W', N'70', N'/', N'是
')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (28, N'12W', N'', N'', N'', N'720-840Lm', N'>75Lm/W', N'80', N'36度
', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (29, N'32W', N'B22', N'6500K', N'220V', N'', N'', N'', N'', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (30, N'32W', N'E27', N'6500K', N'220V', N'', N'', N'', N'', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (31, N'45W', N'E27', N'6500K', N'220V', N'', N'', N'', N'', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (32, N'65W', N'E27', N'6500K', N'220V-240V', N'', N'', N'', N'', N'
是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (33, N'85W', N'E27', N'6500K', N'200V-240V', N'', N'', N'', N'', N'
是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (34, N'12W', N'', N'', N'', N'1050Lm', N'>90Lm/W', N'>80', N'240
度', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (35, N'7W', N'', N'', N'', N'420-480Lm', N'>70', N'80', N'/', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (36, N'9W', N'', N'', N'', N'540-600Lm/W', N'>70', N'80', N'/', N'
是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (37, N'12W', N'', N'', N'', N'720-840Lm', N'>70Lm/W', N'80', N'/', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (38, N'7W', N'', N'', N'', N'520Lm', N'>75', N'80', N'36度', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (39, N'20W', N'', N'', N'', N'1800Lm', N'70Lm/W', N'70', N'/', N'是
')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (40, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (41, N'1', N'1', N'', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (42, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (43, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (44, N'1', N'1', N'1', N'1', N'11', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (45, N'1', N'1', N'1', N'1', N'11', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (46, N'1', N'1', N'1', N'1', N'11', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (47, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (48, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (49, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (50, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (51, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (52, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (53, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (54, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (55, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (56, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (57, N'1', N'1', N'1', N'1', N'1', N'1', N'', N'1', N'是')
INSERT [dbo].[productproperty] ([productid], [power], [lampholder], [colortemp], [voltage], [luminousflux], [lightefficiency], [colorrendering], [beamangle], [isemc]) VALUES (58, N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'是')
/****** Object:  Table [dbo].[product_img]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product_img](
	[productimgid] [int] IDENTITY(1,1) NOT NULL,
	[productid] [int] NULL,
	[imgtype] [int] NULL,
	[imgurl] [varchar](100) NULL,
 CONSTRAINT [PK_product_img] PRIMARY KEY CLUSTERED 
(
	[productimgid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[product_img] ON
INSERT [dbo].[product_img] ([productimgid], [productid], [imgtype], [imgurl]) VALUES (1, 14, 2, N'product/721368123631173238017113198418123128.png')
INSERT [dbo].[product_img] ([productimgid], [productid], [imgtype], [imgurl]) VALUES (2, 14, 2, N'product/62271221127103421646829626116277683.png')
INSERT [dbo].[product_img] ([productimgid], [productid], [imgtype], [imgurl]) VALUES (3, 14, 2, N'product/35131181212410393826985120786288112109.png')
INSERT [dbo].[product_img] ([productimgid], [productid], [imgtype], [imgurl]) VALUES (4, 14, 2, N'product/2864688372113791181893134912212294107.png')
INSERT [dbo].[product_img] ([productimgid], [productid], [imgtype], [imgurl]) VALUES (5, 14, 2, N'product/9248116125161103831109461108663540125.png')
SET IDENTITY_INSERT [dbo].[product_img] OFF
/****** Object:  Table [dbo].[product]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product](
	[productid] [int] IDENTITY(1,1) NOT NULL,
	[producttypeid] [int] NOT NULL,
	[productname] [varchar](50) NOT NULL,
	[productpicture] [text] NULL,
	[productdiscribe] [text] NOT NULL,
	[price] [float] NOT NULL,
	[certifiedprice] [float] NOT NULL,
	[logisticsprice] [float] NOT NULL,
	[sendpoints] [int] NOT NULL,
	[inventoryquantity] [varchar](10) NULL,
	[issale] [int] NULL,
	[issnapup] [int] NULL,
	[isgroupon] [int] NULL,
	[iscrowdfunding] [int] NULL,
	[ishot] [int] NULL,
	[isnew] [int] NULL,
	[isrecommend] [int] NULL,
	[ispromotion] [int] NULL,
	[snapupstarttime] [datetime] NULL,
	[snapupendtime] [datetime] NULL,
	[snapupprice] [float] NULL,
	[snapupcertifiedprice] [float] NULL,
	[snapuplogisticsprice] [float] NULL,
	[snapupquantity] [int] NULL,
	[grouponstartquantity] [int] NULL,
	[grouponstarttime] [datetime] NULL,
	[grouponendtime] [datetime] NULL,
	[grouponprice] [float] NULL,
	[grouponcertifiedprice] [float] NULL,
	[grouponlogisticsprice] [float] NULL,
	[grouponquantity] [int] NULL,
	[crowfundingstartquantity] [int] NULL,
	[crowfundingdepositrate] [int] NULL,
	[crowfundingstarttime] [datetime] NULL,
	[crowfundingendtime] [datetime] NULL,
	[crowfundingprice] [float] NULL,
	[crowfundingcertifiedprice] [float] NULL,
	[crowfundinglogisticsprice] [float] NULL,
	[crowfundingquantity] [int] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[productid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[product] ON
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (3, 2, N'Q1系列球泡灯', N'/product/945674412521671177126110812262557.png|/product/6733638911581031979316811
1151121823.png|/product/605773221892961771129711843913468.png|/product/281061956611
0111204952118101581013198.png|/product/994512558531213275591861136610510446.png', N'Q1球泡灯', 50, 40, 30, 5, N'1', 1, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (8, 2, N'Q2系列球泡灯', N'/product/11593358510213538987411110811912232.png|/product/11083271258574861791850
85120341398.png|/product/441281171209580101051073328122123187685.png|/product/11384
812734421005936995912452812311.png|/product/1312869651048594117210636421953927.png', N'Q2系列球泡灯', 60, 50, 40, 44, N'1', 1, 0, 0, 0, 0, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (9, 7, N'配件', N'/product/952974127419617107173828476570108.png|/product/3557299168681251048865111
254546102.png|/product/5271109741164911788891091125895159676.png|/product/104102551
63581851221187538971031097112.png|/product/855460681991089113411125885112115121.png
', N'配件555', 12, 10, 9, 2, N'1', 1, 1, 0, 0, 0, 0, 0, NULL, CAST(0x0000A62100C8ACA8 AS DateTime), CAST(0x0000A6C50053D48C AS DateTime), 9, 7, 6, 3000, 50, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (12, 7, N'灯饰', N'/product/13827341121271037727505411111078775.png|/product/48631112108116231001004
99912161167102.png|/product/1589912237117181049113991134976580.png|/product/8771648
8124326496312150871441126100.png|/product/1212547111451241712561184945251024122.png
', N'灯饰555', 10, 10, 10, 2, N'1', 1, 0, 0, 0, 1, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (13, 1, N'HS系列节能灯', N'/product/35291071011233101559920392174205442.png|/product/36929262843053567313063
68522848.png|/product/94612974412480152012511080416910078.png|/product/126062105598
411992731564281010410461.png|/product/55491279559578251002159104194012023.png', N'
使用场景：吊灯 台灯 户外 厂房', 120, 100, 80, 10, N'1', 0, 0, 1, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 500, CAST(0x0000A61800000000 AS DateTime), CAST(0x0000A6CE00000000 AS DateTime), 100, 90, 80, 5000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (14, 3, N'F1系列一体化筒灯', N'/product/721368123631173238017113198418123128.png|/product/6227122112710342164682
9626116277683.png|/product/35131181212410393826985120786288112109.png|/product/2864
688372113791181893134912212294107.png|/product/924811612516110383110946110866354012
5.png', N'F1系列一体化筒灯', 125, 110, 100, 12, N'1', 1, 1, 0, 0, 0, 0, 0, NULL, CAST(0x0000A618016BEC10 AS DateTime), CAST(0x0000A6C600E40318 AS DateTime), 100, 95, 90, 500, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (17, 1, N'HS系列节能灯', N'/product/10984724133408948998611692466679125.png|/product/10333265997753561112455
1960874185.png|/product/267119295966657511525108826923.png|/product/931219181053111
02617102524649109.png|/product/89106248922859250471844751116623127.png', N'24w的节
能灯', 130, 110, 90, 11, N'1', 1, 1, 0, 0, 0, 0, 0, NULL, CAST(0x0000A61E00000000 AS DateTime), CAST(0x0000A6C700000000 AS DateTime), 120, 105, 98, 1000, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (18, 1, N'HS系列节能灯', N'/product/41394410568273510311911358569010547105.png|/product/77107711211098224725
78161255521459.png|/product/98527119986978841158496136492561.png|/product/784859918
012611131237830551112283.png|/product/117216863662193103126696860941689120.png', N'45w的节能灯', 120, 110, 90, 9, N'1', 1, 0, 0, 0, 1, 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (21, 4, N'G1系列天花射灯', N'/product/17219410357101985311891466965327537.png|/product/39115301182821624210691
5222910685119.png|/product/1104849581172882947911227568212547.png|/product/81548221
191183337556841323369860.png|/product/12467257481430937543031112784175.png', N'99', 50, 40, 30, 5, N'1', 1, 0, 1, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 99, CAST(0x0000A62100C95310 AS DateTime), CAST(0x0000A6C50172C9E0 AS DateTime), 45, 43, 40, 99, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (22, 4, N'G1系列天花射灯', N'/product/338552469688309112112688468156570.png|/product/7166962910421115997381634
782384155.png|/product/544268699210380112653311223596674105.png|/product/1271139835
8126848379923119811712448.png|/product/10111433530124104529520925417104360.png', N'99', 60, 50, 40, 6, N'1', 1, 0, 1, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 99, CAST(0x0000A62100C96CD8 AS DateTime), CAST(0x0000A6C600DD1990 AS DateTime), 55, 52, 50, 99, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (24, 5, N'A6吸顶灯配件', N'/product/474921159633442611435858340355321.png|/product/3511912112227201032360100
5142533877127.png|/product/96427677749222492236104371228857111.png|/product/1179058
525686113615849810690403961.png|/product/12571429769643010301012356121997523.png', N'翻译自国外crowdfunding一词，即大众筹资或群众筹资，香港译作「群众集资」，台湾译作「
群众募资」。由发起人、跟投人、平台构成。具有低门槛、多样性、依靠大众力量、注重创意的特
征，是指一种向群众募资，以支持发起的个人或组织的行为。一般而言是透过网络上的平台连结起
赞助者与提案者。群众募资被用来支持各种活动，包含灾害重建、民间集资、竞选活动、创业募资
、艺术创作、自由软件、设计发明、科学研究以及公共专案等。Massolution研究报告指出，2013
年全球总募集资金已达51亿美元，其中90%集中在欧美市场。世界银行报告更预测2025年总金额将
突破960亿美元，亚洲占比将大幅成长', 30, 25, 20, 5, N'1', 0, 1, 0, 0, 0, 0, 0, NULL, CAST(0x0000A62100C9A068 AS DateTime), CAST(0x0000A6C801198650 AS DateTime), 25, 23, 20, 55, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (25, 5, N'A6吸顶灯配件', N'/product/305812267109478086478440815112612359.png|/product/5824971231323263134582
973585949.png|/product/2918822933761831002380454567556.png|/product/126771204430401
0786118231206518099115.png|/product/1452396452354511821502393311882.png', N'4', 50, 45, 40, 4, N'1', 1, 0, 0, 0, 1, 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (26, 5, N'A8系列吸顶灯配件', N'/product/631263196363920464778767681236370.png|/product/1019081646954282978481182
890663338.png|/product/112741312011103376893410271311338.png|/product/5910166648767
122122552227124105545.png|/product/2193896234107493632145667651171468.png', N'翻译
自国外crowdfunding一词，即大众筹资或群众筹资，香港译作「群众集资」，台湾译作「群众募
资」。', 35, 32, 31, 3, N'1', 1, 0, 0, 0, 1, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (27, 5, N'A8系列吸顶灯配件', N'/product/731201001225767819010127811696088117.png|/product/9316101152332601130262
4690766282.png|/product/343692584412217812479123364343.png|/product/926810092283512
25101658653103233631.png|/product/3911627574101701278335918846172106.png', N'规划法
规风光好飞个很高 华国锋华国锋很高 发给广泛', 44, 42, 40, 6, N'1', 1, 0, 0, 0, 1, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (28, 3, N'F1系列一体化筒灯', N'/product/12111347756254113681412241837873102115.png|/product/64171156611211970317
0191104818539994.png|/product/56623463341255010453646454799594.png|/product/3567291
070609627608441941058452.png|/product/2741696847636510646111613412787317.png', N'F1
系列一体化筒灯', 150, 120, 110, 15, N'1', 1, 1, 0, 0, 0, 0, 0, NULL, CAST(0x0000A62100C9BEE0 AS DateTime), CAST(0x0000A6C90006DDD0 AS DateTime), 140, 110, 90, 1000, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (29, 1, N'HS系列节能灯', N'/product/425796183711154901126955344869869.png|/product/6333328572106227080118127
5521359711.png|/product/301001109345706299160826342266101.png|/product/120301062119
3428612728466277079.png|/product/1069042231211043356112054208920568.png', N'32w', 40, 35, 30, 4, N'1', 1, 0, 0, 1, 0, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, CAST(0x0000A6AE01198650 AS DateTime), CAST(0x0000A6C801198650 AS DateTime), 120, 110, 105, 56)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (30, 1, N'HS系列节能灯', N'/product/107658834324419446211595346012327.png|/product/7096158358810358122155642
999683.png|/product/4872771116100116592894102102374562118.png|/product/775108122169
501318120871345339345.png|/product/1083011312256652398522612328769110103.png', N'E27', 24, 22, 20, 3, N'1', 1, 0, 0, 0, 0, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (31, 1, N'HS系列节能灯', N'/product/10667109258812169677587186341030116.png|/product/29337956696668533269663
1724124.png|/product/117934659511531767986625760894.png|/product/471812677817234012
89121611858838.png|/product/276868991955310825742639410755123.png', N'新品', 10, 9, 8, 2, N'1', 1, 0, 0, 0, 0, 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (32, 1, N'HS系列节能灯', N'/product/98106536919610047510211595973712539.png|/product/11825564430633328835575
747016313.png|/product/628648729112595512267236820538110.png|/product/2496178712070
12161127137143331712540.png|/product/9310911819608085103425421031125031120.png', N'
新品', 30, 28, 25, 3, N'1', 1, 1, 0, 0, 0, 0, 0, NULL, CAST(0x0000A62100C9F5F4 AS DateTime), CAST(0x0000A6CE00000000 AS DateTime), 28, 27, 26, 2000, 50, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (33, 1, N'HS系列节能灯', N'/product/1281042425397361152430612511666.png|/product/532810989775123103844106103
429410417.png|/product/1227323013869844627639501037770110.png|/product/309210627226
72732837393661174511234.png|/product/21531257119739938687310523251269474.png', N'qqq', 32, 30, 28, 3, N'1', 1, 0, 0, 0, 0, 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (34, 2, N'Q3系列球泡灯', N'/product/4617428710720105981785124274791849.png|/product/246611748212787222319445
6113378101.png|/product/10732984675015656314667658707076.png|/product/2528897912780
543123111361235668578.png|/product/821148512210114105371147345115118124127104.png', N'恩恩', 23, 22, 20, 2, N'1', 1, 0, 0, 0, 0, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (35, 3, N'F1系列一体化筒灯', N'/product/1188419127083767199710923124677756.png|/product/631271490111761135086308
88986437941.png|/product/5837983143339107357418875069575.png|/product/6822633919977
1312526644732592349.png|/product/10762310867982187591151118901109.png', N'www', 20, 18, 16, 2, N'1', 1, 0, 1, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 50, CAST(0x0000A62100C9D650 AS DateTime), CAST(0x0000A6C700000000 AS DateTime), 18, 17, 15, 3000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (36, 3, N'F1系列一体化筒灯', N'/product/76511347125805103711221189488107464.png|/product/47751611140110186980824
4112219849114.png|/product/99110012272841204188651835829032.png|/product/1211731446
34110841371382766722102.png|/product/288365585910411103692346881051188144.png', N'ww', 20, 18, 16, 2, N'1', 1, 0, 0, 0, 0, 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (37, 3, N'F1系列一体化筒灯', N'/product/66229544125351116713264171112477548.png|/product/69211744211851025548126
124201263.png|/product/9819109581285012599369411430346112574.png|/product/612532310
211314112510661336878530.png|/product/101101558512362292114104756629288376.png', N'222', 25, 23, 22, 3, N'1', 1, 0, 0, 0, 0, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (38, 4, N'G1系列天花射灯', N'/product/1001281145710219884132962116833112438.png|/product/221211161191529865801
231275949125471.png|/product/931191448515651121072323708686083.png|/product/2810874
87143645471252712170149311755.png|/product/113974858622561153710612459267048126.png
', N'7W', 30, 28, 27, 3, N'1', 1, 0, 0, 0, 0, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (39, 5, N'A8系列吸顶灯配件', N'/product/621254917626478647651321190377464.png|/product/9590106575311658433416626
12519100127.png', N'222', 40, 35, 30, 4, N'1', 1, 0, 0, 0, 1, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (40, 1, N'1', N'/product/181021178010920972012816869011112466114.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (41, 1, N'2', N'/product/5239714565102111561412719161095791.JPG', N'111', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (42, 1, N'1', N'/product/8410569884109120864891294611321564.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (43, 1, N'1', N'/product/1208991148210141881189799161131074540.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (44, 1, N'1', N'/product/535211716100996463119181169644964024.JPG', N'1', 1, 12, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (45, 1, N'1', N'/product/535211716100996463119181169644964024.JPG', N'1', 1, 12, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (46, 1, N'1', N'/product/535211716100996463119181169644964024.JPG', N'1', 1, 12, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (47, 1, N'1111', N'/product/912591707739821141133511783111917958.JPG', N'12', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (48, 1, N'w', N'/product/395761796711483111273479863187118113.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (49, 1, N'w', N'/product/395761796711483111273479863187118113.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (50, 1, N'w', N'/product/395761796711483111273479863187118113.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (51, 1, N'w', N'/product/395761796711483111273479863187118113.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (52, 1, N'w', N'/product/395761796711483111273479863187118113.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (53, 1, N'w', N'/product/395761796711483111273479863187118113.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (54, 1, N'11', N'/product/338191809712221881262911112711378124.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (55, 1, N'w', N'/product/81669872299512717109101304391089366.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (56, 1, N'1', N'/product/8954210112532112975631204651298310.JPG', N'1', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (57, 1, N'w', N'/product/10410612664539660957410401128312953.JPG', N'<p>123<br/></p>', 1, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[product] ([productid], [producttypeid], [productname], [productpicture], [productdiscribe], [price], [certifiedprice], [logisticsprice], [sendpoints], [inventoryquantity], [issale], [issnapup], [isgroupon], [iscrowdfunding], [ishot], [isnew], [isrecommend], [ispromotion], [snapupstarttime], [snapupendtime], [snapupprice], [snapupcertifiedprice], [snapuplogisticsprice], [snapupquantity], [grouponstartquantity], [grouponstarttime], [grouponendtime], [grouponprice], [grouponcertifiedprice], [grouponlogisticsprice], [grouponquantity], [crowfundingstartquantity], [crowfundingdepositrate], [crowfundingstarttime], [crowfundingendtime], [crowfundingprice], [crowfundingcertifiedprice], [crowfundinglogisticsprice], [crowfundingquantity]) VALUES (58, 1, N'123', N'/product/54798345122113114100119307332694931.jpg', N'<p>12314<br/></p>', 11, 1, 1, 1, N'1', 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[product] OFF
/****** Object:  Table [dbo].[address]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[address](
	[addressid] [int] IDENTITY(1,1) NOT NULL,
	[companyid] [int] NOT NULL,
	[isdefault] [int] NULL,
	[consigneename] [varchar](50) NOT NULL,
	[consigneeaddress] [varchar](100) NOT NULL,
	[consigneephone] [varchar](50) NOT NULL,
	[zipcode] [varchar](10) NOT NULL,
 CONSTRAINT [PK_address] PRIMARY KEY CLUSTERED 
(
	[addressid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[address] ON
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (4, 1, 0, N'zhangsan', N'很
卡卡卡卡的股份的观点', N'111', N'123')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (8, 1, 0, N'lisi', N'西安市
', N'158222', N'123456')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (9, 1, 0, N'14', N'dd', N'z', N'a')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (11, 1, 0, N'1aaa', N'123', N'512', N'da115')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (15, 1, 1, N'121221', N'ad', N'12', N'12')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (16, 1, 0, N'zhang', N'ti', N'158', N'212110')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (18, 1, 0, N'asd', N'as', N'a', N'asd')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (19, 1, 0, N'asd', N'ads', N'ads', N'asd')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (20, 1, 0, N'da', N'123', N'aaa', N'sada')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (23, 75, 0, N'瓶瓶', N'陕西
省宝鸡市', N'18723658421', N'712100')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (24, 75, 1, N'我是小明', N'
陕西省宝鸡市千阳县', N'15203698520', N'712000')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (25, 104, 1, N'书苹', N'陕
西省西安市的街道有', N'18700259852', N'721200')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (26, 105, 0, N'魏淑平', N'
陕西省西北农林科技大学', N'15029039705', N'721200')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (27, 105, 1, N'张三', N'陕
西省杨陵区', N'18700259852', N'721200')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (28, 106, 1, N'魏淑平', N'
陕西省西北农林科技大学', N'15236985202', N'712100')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (29, 106, 1, N'张珊', N'陕
西省杨凌区五台山', N'18702658952', N'7412100')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (30, 75, 0, N'饭饭', N'河南
省禹州市张得乡坛口村五组', N'12345678900', N'712100')
INSERT [dbo].[address] ([addressid], [companyid], [isdefault], [consigneename], [consigneeaddress], [consigneephone], [zipcode]) VALUES (31, 76, 1, N'饭饭', N'河南
省郑州市新城区', N'1234567890', N'712100')
SET IDENTITY_INSERT [dbo].[address] OFF
/****** Object:  Table [dbo].[comment]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[comment](
	[commentid] [int] IDENTITY(1,1) NOT NULL,
	[companyid] [int] NOT NULL,
	[productid] [int] NOT NULL,
	[state] [int] NULL,
	[commentcontent] [varchar](200) NULL,
 CONSTRAINT [PK_comment] PRIMARY KEY CLUSTERED 
(
	[commentid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[comment] ON
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (1, 75, 25, 2, NULL)
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (2, 75, 25, 2, NULL)
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (3, 75, 25, 2, NULL)
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (4, 75, 25, 0, NULL)
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (5, 75, 25, 2, NULL)
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (6, 75, 25, 2, N'总体上 很好啊')
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (7, 75, 25, 2, N'很快就收到货了  质量很好  下次会在光临的')
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (8, 105, 18, 2, N'总体上是很满意的')
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (9, 106, 14, 0, N'很好')
INSERT [dbo].[comment] ([commentid], [companyid], [productid], [state], [commentcontent]) VALUES (10, 75, 12, 2, N'fs sd fsd')
SET IDENTITY_INSERT [dbo].[comment] OFF
/****** Object:  Table [dbo].[cartdetail]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cartdetail](
	[cartdetailid] [int] IDENTITY(1,1) NOT NULL,
	[companyid] [int] NOT NULL,
	[productid] [int] NOT NULL,
	[number] [int] NULL,
	[saletype] [int] NULL,
 CONSTRAINT [PK_cartdetail] PRIMARY KEY CLUSTERED 
(
	[cartdetailid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[favorite]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[favorite](
	[favoriteid] [int] IDENTITY(1,1) NOT NULL,
	[companyid] [int] NOT NULL,
	[productid] [int] NOT NULL,
	[collectiontime] [datetime] NULL,
 CONSTRAINT [PK_favorite_1] PRIMARY KEY CLUSTERED 
(
	[favoriteid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[favorite] ON
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (1, 1, 3, NULL)
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (7, 75, 3, CAST(0x0000A61A0113D71C AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (8, 75, 21, CAST(0x0000A61B00AC3784 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (9, 75, 18, CAST(0x0000A61D012E2A64 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (10, 75, 14, CAST(0x0000A61D015B8EB3 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (11, 75, 24, CAST(0x0000A61F00BEC6AA AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (12, 75, 8, CAST(0x0000A61F011F8012 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (13, 75, 33, CAST(0x0000A62000C9421C AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (14, 75, 39, CAST(0x0000A62000C9BB28 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (15, 75, 28, CAST(0x0000A62000CAFF07 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (16, 75, 17, CAST(0x0000A62000D2DEDD AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (17, 75, 38, CAST(0x0000A62000D43DB3 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (18, 75, 35, CAST(0x0000A62000FCBBA0 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (19, 75, 25, CAST(0x0000A6200104A67B AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (20, 106, 18, CAST(0x0000A6220150E340 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (21, 106, 26, CAST(0x0000A62201560730 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (22, 75, 26, CAST(0x0000A62600B3A4B1 AS DateTime))
INSERT [dbo].[favorite] ([favoriteid], [companyid], [productid], [collectiontime]) VALUES (23, 75, 12, CAST(0x0000A68101523B12 AS DateTime))
SET IDENTITY_INSERT [dbo].[favorite] OFF
/****** Object:  Table [dbo].[point]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[point](
	[pointid] [int] IDENTITY(1,1) NOT NULL,
	[companyid] [int] NOT NULL,
	[productid] [int] NOT NULL,
	[updatetime] [datetime] NULL,
	[type] [int] NULL,
	[pointamount] [int] NULL,
 CONSTRAINT [PK_point] PRIMARY KEY CLUSTERED 
(
	[pointid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[point] ON
INSERT [dbo].[point] ([pointid], [companyid], [productid], [updatetime], [type], [pointamount]) VALUES (3, 3, 8, CAST(0x0000A1E400000000 AS DateTime), 1, 450)
SET IDENTITY_INSERT [dbo].[point] OFF
/****** Object:  Table [dbo].[orderinfo]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orderinfo](
	[orderid] [int] IDENTITY(1,1) NOT NULL,
	[companyid] [int] NULL,
	[addressid] [int] NOT NULL,
	[oderstate] [int] NULL,
	[usedpoints] [float] NULL,
	[usedwalletamount] [float] NULL,
	[usedthirdpayment] [float] NULL,
	[lastprice] [float] NULL,
	[invoicetitle] [varchar](100) NULL,
	[createdatetime] [datetime] NULL,
	[paydatetime] [datetime] NULL,
	[finishidatetime] [datetime] NULL,
	[deliverycycle] [int] NULL,
	[comments] [varchar](50) NULL,
	[deliveryid] [varchar](50) NULL,
	[startdeliverytime] [datetime] NULL,
	[deliverycompany] [varchar](100) NULL,
 CONSTRAINT [PK_orderinfo] PRIMARY KEY CLUSTERED 
(
	[orderid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[orderinfo] ON
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (6, 75, 4, 1, 22, 2212, NULL, 150, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (7, 8, 4, 2, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (8, 8, 4, 2, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (9, 8, 4, 2, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (10, 75, 4, 1, 22, 22, NULL, 170, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (11, 75, 4, 3, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (12, 8, 4, 3, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (13, 8, 4, 4, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (14, 8, 4, 4, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (15, 8, 4, 4, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (16, 8, 4, 4, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (17, 75, 4, 6, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (18, 8, 4, 1, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (19, 75, 4, 6, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), CAST(0x0000A61D0122392A AS DateTime), 16, NULL, N'33333333333333333333', CAST(0x0000A58400000000 AS DateTime), N'顺风')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (20, 75, 4, 5, 22, 22, NULL, 6, NULL, NULL, CAST(0x0000A5E500000000 AS DateTime), NULL, 16, NULL, NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (38, 75, 23, 6, NULL, NULL, NULL, 225, N'666', CAST(0x0000A6200106AF6C AS DateTime), CAST(0x0000A62001193888 AS DateTime), CAST(0x0000A620011C232B AS DateTime), 6666, N'666', N'66669999', CAST(0x0000A62000000000 AS DateTime), N'圆通速递')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (40, 75, 23, 1, NULL, NULL, NULL, 150, N'个人发', CAST(0x0000A620016325ED AS DateTime), NULL, NULL, 10, N'请尽快送达', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (42, 104, 25, 3, NULL, NULL, NULL, 240, N'个人', CAST(0x0000A62100CFFA4D AS DateTime), CAST(0x0000A62100D0083E AS DateTime), NULL, 10, N'请尽快送达', N'87342903574938', CAST(0x0000A62900000000 AS DateTime), N'444')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (43, 75, 24, 1, NULL, NULL, NULL, 550, N'个人 ', CAST(0x0000A621011DC10E AS DateTime), NULL, NULL, 222, N'3333', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (44, 105, 26, 6, NULL, NULL, NULL, 330, N'个人发票', CAST(0x0000A62200E9244B AS DateTime), CAST(0x0000A62200E932B8 AS DateTime), CAST(0x0000A62200EA982F AS DateTime), 12, N'请尽
快送达哦', N'87342903574938', CAST(0x0000A62200000000 AS DateTime), N'圆通速递')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (45, 106, 29, 1, NULL, NULL, NULL, 2000, N'集体发票', CAST(0x0000A62201519B1A AS DateTime), NULL, NULL, 12, N'一定要完好无损', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (46, 106, 29, 1, NULL, NULL, NULL, 2000, N'集体发票', CAST(0x0000A6220151FB85 AS DateTime), NULL, NULL, 12, N'一定要完好无损', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (47, 106, 29, 1, NULL, NULL, NULL, 2000, N'集体发票', CAST(0x0000A622015200DF AS DateTime), NULL, NULL, 12, N'一定要完好无损', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (48, 106, 29, 1, NULL, NULL, NULL, 2000, N'集体发票', CAST(0x0000A622015200DF AS DateTime), NULL, NULL, 12, N'一定要完好无损', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (49, 106, 28, 6, NULL, NULL, NULL, 2000, N'集体发票', CAST(0x0000A62201535959 AS DateTime), CAST(0x0000A622015380CC AS DateTime), CAST(0x0000A6220155E514 AS DateTime), 12, N'一定
要尽快送达哦', N'8754213695', CAST(0x0000A62200000000 AS DateTime), N'圆通快递')
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (50, 75, 23, 1, NULL, NULL, NULL, NULL, N'', CAST(0x0000A62800F5E59E AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (51, 75, 23, 1, NULL, NULL, NULL, NULL, N'', CAST(0x0000A62800F65A15 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (52, 75, 24, 1, NULL, NULL, NULL, NULL, N'', CAST(0x0000A62800FD6E65 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (53, 75, 24, 1, NULL, NULL, NULL, NULL, N'', CAST(0x0000A62800FD892D AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (68, 75, 23, 1, NULL, NULL, NULL, 2768, N'', CAST(0x0000A62801230F50 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (69, 75, 23, 1, NULL, NULL, NULL, 2768, N'', CAST(0x0000A62801236AB5 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (71, 75, 24, 1, NULL, NULL, NULL, 2768, N'', CAST(0x0000A6280161668E AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (76, 75, 24, 1, NULL, NULL, NULL, 135, N'', CAST(0x0000A628016C4D6E AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (77, 76, 31, 1, NULL, NULL, NULL, 512, N'', CAST(0x0000A62900A92779 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (78, 76, 31, 1, NULL, NULL, NULL, 2500, N'gsdfgsdfg', CAST(0x0000A62901775C9D AS DateTime), NULL, NULL, 13, N'fsdf', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (79, 75, 24, 1, NULL, NULL, NULL, 32, N'', CAST(0x0000A68B014C2FB9 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (80, 75, 24, 1, NULL, NULL, NULL, 110, N'', CAST(0x0000A68B014D5625 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (81, 75, 30, 1, NULL, NULL, NULL, 120, N'', CAST(0x0000A68B014F0DAD AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (82, 75, 30, 1, NULL, NULL, NULL, 120, N'', CAST(0x0000A68B014FC81F AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (83, 75, 23, 1, NULL, NULL, NULL, 120, N'', CAST(0x0000A68B0150CFB5 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (84, 75, 23, 1, NULL, NULL, NULL, 120, N'', CAST(0x0000A68B0150DCEA AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (85, 75, 30, 1, NULL, NULL, NULL, 50, N'', CAST(0x0000A68B01527C26 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (86, 75, 30, 1, NULL, NULL, NULL, 50, N'', CAST(0x0000A68B01533C79 AS DateTime), NULL, NULL, NULL, N'', NULL, NULL, NULL)
INSERT [dbo].[orderinfo] ([orderid], [companyid], [addressid], [oderstate], [usedpoints], [usedwalletamount], [usedthirdpayment], [lastprice], [invoicetitle], [createdatetime], [paydatetime], [finishidatetime], [deliverycycle], [comments], [deliveryid], [startdeliverytime], [deliverycompany]) VALUES (87, 75, 30, 1, NULL, NULL, NULL, 45, N'', CAST(0x0000A6910170D7A9 AS DateTime), NULL, NULL, 15, N'给商家
留言', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[orderinfo] OFF
/****** Object:  Table [dbo].[inventory]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[inventory](
	[inventoryid] [int] IDENTITY(1,1) NOT NULL,
	[productid] [int] NOT NULL,
	[companyid] [int] NOT NULL,
	[inventoryquantity] [int] NULL,
 CONSTRAINT [PK_inventory] PRIMARY KEY CLUSTERED 
(
	[inventoryid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[inventory] ON
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (3, 3, 101, 1000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (5, 8, 101, 5000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (8, 9, 101, 10000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (9, 12, 101, 2500)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (13, 13, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (15, 14, 101, 5000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (23, 17, 101, 5000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (24, 18, 101, 1000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (25, 21, 101, 2000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (26, 22, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (27, 24, 101, 8000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (28, 25, 101, 2000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (29, 26, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (30, 27, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (31, 28, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (32, 29, 101, 1000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (33, 30, 101, 2000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (34, 31, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (35, 31, 101, 8000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (36, 33, 101, 2000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (37, 34, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (38, 35, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (39, 36, 101, 3000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (40, 37, 101, 1000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (41, 38, 101, 2000)
INSERT [dbo].[inventory] ([inventoryid], [productid], [companyid], [inventoryquantity]) VALUES (42, 39, 101, 3000)
SET IDENTITY_INSERT [dbo].[inventory] OFF
/****** Object:  Table [dbo].[walletserial]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[walletserial](
	[serialid] [int] IDENTITY(1,1) NOT NULL,
	[companyid] [int] NOT NULL,
	[orderid] [int] NOT NULL,
	[updatetime] [datetime] NULL,
	[type] [int] NULL,
	[amount] [float] NULL,
 CONSTRAINT [PK_walletserial] PRIMARY KEY CLUSTERED 
(
	[serialid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[walletserial] ON
INSERT [dbo].[walletserial] ([serialid], [companyid], [orderid], [updatetime], [type], [amount]) VALUES (9, 1, 9, CAST(0x0000A4D900000000 AS DateTime), 3, 800)
SET IDENTITY_INSERT [dbo].[walletserial] OFF
/****** Object:  Table [dbo].[orderdetail]    Script Date: 11/19/2016 02:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderdetail](
	[oderdetailid] [int] IDENTITY(1,1) NOT NULL,
	[orderid] [int] NOT NULL,
	[productid] [int] NOT NULL,
	[quantity] [int] NULL,
	[saletype] [int] NULL,
 CONSTRAINT [PK_orderdetail] PRIMARY KEY CLUSTERED 
(
	[oderdetailid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[orderdetail] ON
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (6, 7, 9, 6, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (7, 8, 9, 7, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (8, 10, 12, 8, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (9, 10, 9, 9, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (10, 11, 9, 10, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (11, 12, 9, 11, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (12, 13, 9, 12, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (13, 14, 9, 13, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (14, 15, 9, 14, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (15, 16, 9, 15, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (16, 17, 9, 16, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (17, 19, 12, 17, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (18, 19, 9, 18, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (19, 20, 12, 19, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (22, 6, 9, 7, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (23, 6, 9, 8, 1)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (25, 38, 25, 5, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (26, 40, 8, 3, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (28, 42, 18, 2, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (29, 43, 18, 5, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (30, 44, 18, 3, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (31, 49, 14, 20, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (106, 71, 26, 4, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (107, 71, 12, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (108, 71, 14, 2, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (109, 71, 3, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (110, 71, 8, 6, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (111, 71, 18, 17, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (112, 71, 22, 4, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (129, 76, 25, 3, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (130, 77, 8, 7, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (131, 77, 34, 4, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (132, 78, 3, 50, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (133, 79, 26, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (134, 80, 17, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (135, 81, 28, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (136, 82, 28, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (137, 83, 28, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (138, 84, 28, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (139, 85, 22, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (140, 86, 22, 1, NULL)
INSERT [dbo].[orderdetail] ([oderdetailid], [orderid], [productid], [quantity], [saletype]) VALUES (141, 87, 25, 1, NULL)
SET IDENTITY_INSERT [dbo].[orderdetail] OFF
/****** Object:  ForeignKey [FK_address_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[address]  WITH CHECK ADD  CONSTRAINT [FK_address_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[address] CHECK CONSTRAINT [FK_address_company]
GO
/****** Object:  ForeignKey [FK_cartdetail_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[cartdetail]  WITH CHECK ADD  CONSTRAINT [FK_cartdetail_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[cartdetail] CHECK CONSTRAINT [FK_cartdetail_company]
GO
/****** Object:  ForeignKey [FK_cartdetail_product]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[cartdetail]  WITH CHECK ADD  CONSTRAINT [FK_cartdetail_product] FOREIGN KEY([productid])
REFERENCES [dbo].[product] ([productid])
GO
ALTER TABLE [dbo].[cartdetail] CHECK CONSTRAINT [FK_cartdetail_product]
GO
/****** Object:  ForeignKey [FK_comment_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_comment_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK_comment_company]
GO
/****** Object:  ForeignKey [FK_comment_product]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_comment_product] FOREIGN KEY([productid])
REFERENCES [dbo].[product] ([productid])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK_comment_product]
GO
/****** Object:  ForeignKey [FK_favorite_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[favorite]  WITH CHECK ADD  CONSTRAINT [FK_favorite_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[favorite] CHECK CONSTRAINT [FK_favorite_company]
GO
/****** Object:  ForeignKey [FK_favorite_product]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[favorite]  WITH CHECK ADD  CONSTRAINT [FK_favorite_product] FOREIGN KEY([productid])
REFERENCES [dbo].[product] ([productid])
GO
ALTER TABLE [dbo].[favorite] CHECK CONSTRAINT [FK_favorite_product]
GO
/****** Object:  ForeignKey [FK_inventory_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[inventory]  WITH CHECK ADD  CONSTRAINT [FK_inventory_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[inventory] CHECK CONSTRAINT [FK_inventory_company]
GO
/****** Object:  ForeignKey [FK_inventory_product]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[inventory]  WITH CHECK ADD  CONSTRAINT [FK_inventory_product] FOREIGN KEY([productid])
REFERENCES [dbo].[product] ([productid])
GO
ALTER TABLE [dbo].[inventory] CHECK CONSTRAINT [FK_inventory_product]
GO
/****** Object:  ForeignKey [FK_orderdetail_orderinfo]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[orderdetail]  WITH CHECK ADD  CONSTRAINT [FK_orderdetail_orderinfo] FOREIGN KEY([orderid])
REFERENCES [dbo].[orderinfo] ([orderid])
GO
ALTER TABLE [dbo].[orderdetail] CHECK CONSTRAINT [FK_orderdetail_orderinfo]
GO
/****** Object:  ForeignKey [FK_orderdetail_product]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[orderdetail]  WITH CHECK ADD  CONSTRAINT [FK_orderdetail_product] FOREIGN KEY([productid])
REFERENCES [dbo].[product] ([productid])
GO
ALTER TABLE [dbo].[orderdetail] CHECK CONSTRAINT [FK_orderdetail_product]
GO
/****** Object:  ForeignKey [FK_orderinfo_address]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[orderinfo]  WITH CHECK ADD  CONSTRAINT [FK_orderinfo_address] FOREIGN KEY([addressid])
REFERENCES [dbo].[address] ([addressid])
GO
ALTER TABLE [dbo].[orderinfo] CHECK CONSTRAINT [FK_orderinfo_address]
GO
/****** Object:  ForeignKey [FK_orderinfo_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[orderinfo]  WITH CHECK ADD  CONSTRAINT [FK_orderinfo_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[orderinfo] CHECK CONSTRAINT [FK_orderinfo_company]
GO
/****** Object:  ForeignKey [FK_point_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[point]  WITH CHECK ADD  CONSTRAINT [FK_point_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[point] CHECK CONSTRAINT [FK_point_company]
GO
/****** Object:  ForeignKey [FK_point_product]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[point]  WITH CHECK ADD  CONSTRAINT [FK_point_product] FOREIGN KEY([pointid])
REFERENCES [dbo].[product] ([productid])
GO
ALTER TABLE [dbo].[point] CHECK CONSTRAINT [FK_point_product]
GO
/****** Object:  ForeignKey [FK_product_producttype]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_producttype] FOREIGN KEY([producttypeid])
REFERENCES [dbo].[producttype] ([producttypeid])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_producttype]
GO
/****** Object:  ForeignKey [FK_walletserial_company]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[walletserial]  WITH CHECK ADD  CONSTRAINT [FK_walletserial_company] FOREIGN KEY([companyid])
REFERENCES [dbo].[company] ([companyid])
GO
ALTER TABLE [dbo].[walletserial] CHECK CONSTRAINT [FK_walletserial_company]
GO
/****** Object:  ForeignKey [FK_walletserial_orderinfo]    Script Date: 11/19/2016 02:26:11 ******/
ALTER TABLE [dbo].[walletserial]  WITH CHECK ADD  CONSTRAINT [FK_walletserial_orderinfo] FOREIGN KEY([orderid])
REFERENCES [dbo].[orderinfo] ([orderid])
GO
ALTER TABLE [dbo].[walletserial] CHECK CONSTRAINT [FK_walletserial_orderinfo]
GO
