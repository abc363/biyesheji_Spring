（1）创建数据库：websystem 数据库用户：root 密码：root123
（2）创建login表
create table user
(
    uid int auto_increment primary key,
    username varchar(60) not null,
    isDelete INT(20),
    password varchar(200) not null,
    createdUser varchar(60),
    createdTime varchar(100),
    modifiedUser varchar(60),
    modifiedTime varchar(100)
);
（3）插入一个用户：
直接在页面注册或者
INSERT INTO user VALUES 
(3,"testooo",0,"fdf6025fd0a0e39a3ea112b1c1c255fc0101f707194b13678162a41b0cfd7302","testooo","2020-12-17 12:14:41","testooo","2020-12-17 12:14:48");

（4）向项目中添加自己的数据库：
设置properties中数据库自己的用户名，密码
是root root123

（5）登录url：http://backend.windiiot.com
用户名：windiot  密码：qqq14836

（6）后台主页已被拦截登录（跨域获取session还没解决，用户名现在是写死了的）
（7）创建product表
create table product
(
     pid int auto_increment primary key,
       pro_Name VARCHAR(50) not null,//产品名称
       pro_Type VARCHAR(50) not null,//产品类型
       pro_Num INT(40) not null,//产品数量
       pro_State VARCHAR(100) not null,//产品状态
       pro_fontTiltOne VARCHAR(300),//正斜1图
       pro_file VARCHAR(300),//参考手册
       pro_info VARCHAR(800),//产品信息
       pro_finger VARCHAR(300),//快速入门指南
       pro_driver VARCHAR(300),//配置工具
       pro_manual VARCHAR(300),//user manual
       pro_video VARCHAR(300),//演示视频
       pro_fontTiltTwo VARCHAR(300),//正斜2图
       pro_backTiltOne VARCHAR(300),//背斜1图
       pro_backTiltTwo VARCHAR(300),//背斜2图
       pro_font VARCHAR(300),//正图
       pro_back VARCHAR(300),//背面图
        createdUser VARCHAR(50),
        createdTime  VARCHAR(80),
        modifiedUser VARCHAR(50),
        modifiedTime  VARCHAR(80)
);

（8）构建新闻表数据库
create table news
(
    nid int auto_increment primary key,
    new_title varchar(60) not null,//新闻标题
    new_image varchar(200) not null,//新闻正图
    new_date varchar(60) not null,//新闻日期
    new_type varchar(10) not null,//新闻类型
    new_intro varchar(400) not null,//新闻介绍
    new_content longtext not null,//新闻信息
    createdUser VARCHAR(50),
    createdTime  VARCHAR(60),
    modifiedUser varchar(60),
    modifiedTime varchar(60)
);
（9）阿里云信息
endpoint=oss-cn-beijing.aliyuncs.com
keyid=LTAI4Fh6jrpVy1UV4HBhd7jb
keysecret=oNW8cZTRoPFxPbXYoQbeinrydmwR4y
bucketname=windiiot