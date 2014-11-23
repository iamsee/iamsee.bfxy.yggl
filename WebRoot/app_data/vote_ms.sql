USE [vote_ms]
GO
/****** Object:  Table [dbo].[tb_vote]    Script Date: 06/23/2014 11:28:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_vote](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[beselected] [varchar](50) NOT NULL,
	[votenum] [int] NOT NULL,
 CONSTRAINT [PK_tb_vote] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tb_vote] ON
INSERT [dbo].[tb_vote] ([id], [beselected], [votenum]) VALUES (1, N'王老师单口相声', 5703)
INSERT [dbo].[tb_vote] ([id], [beselected], [votenum]) VALUES (2, N'杨老师神一般速度', 2805)
INSERT [dbo].[tb_vote] ([id], [beselected], [votenum]) VALUES (3, N'李老师超能和的水', 4000)
INSERT [dbo].[tb_vote] ([id], [beselected], [votenum]) VALUES (4, N'蔡老师超多的服务器', 10466)
INSERT [dbo].[tb_vote] ([id], [beselected], [votenum]) VALUES (5, N'冯老师多方的认识', 7005)
INSERT [dbo].[tb_vote] ([id], [beselected], [votenum]) VALUES (6, N'其他老师百变的表情', 3871)
SET IDENTITY_INSERT [dbo].[tb_vote] OFF
/****** Object:  Table [dbo].[tb_user]    Script Date: 06/23/2014 11:28:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[pwd] [varchar](32) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tb_user] ON
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1, N'123', N'aaa')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (2, N'123', N'123')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (3, N'123', N'aaa')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (4, N'123', N'aaa')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (5, N'123', N'aaa')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (8, N'123', N'123')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (10, N'333', N'333')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (11, N'222', N'222')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (12, N'333', N'333')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (13, N'333', N'333')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1013, N'321', N'321')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1014, N'3214', N'3124')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1015, N'421r423', N'213421')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1016, N'421312', N'4213')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1017, N'', N'')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1018, N'', N'')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1019, N'123', N'123')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1020, N'232', N'232')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (6, N'123', N'aaa')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (7, N'123', N'aaa')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (9, N'123', N'123')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1021, N'iamsee', N'iamsee')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1022, N'e21421', N'3214')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1023, N'', N'')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1024, N'', N'')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1025, N'123321', N'123321')
INSERT [dbo].[tb_user] ([id], [name], [pwd]) VALUES (1026, N'3434343', N'343434')
SET IDENTITY_INSERT [dbo].[tb_user] OFF
/****** Object:  Table [dbo].[tb_admin]    Script Date: 06/23/2014 11:28:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_admin](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[pwd] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tb_admin] ON
INSERT [dbo].[tb_admin] ([id], [name], [pwd]) VALUES (1, N'root', N'root')
SET IDENTITY_INSERT [dbo].[tb_admin] OFF
