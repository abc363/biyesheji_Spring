（1）创建数据库：websystem
（2）创建login表
create table user
(
    id int auto_increment primary key,
    username varchar(60) not null,
    salt VARCHAR(200),
    isDelete INT(20),
    password varchar(200) not null,
    createdUser varchar(60),
    createdTime varchar(100),
    modifiedUser varchar(60),
    modifiedTime varchar(100)
);
（3）插入一个用户：
直接在页面注册或者
INSERT INTO login VALUES 
(1, "WindTech",'263641DC-4782-455D-B2B0-098434B2C536',0,'A5553D5FD25908C7495AA91D7E4C8C9D',"XXX","XXX","XXX","XXX");

（4）向项目中添加自己的数据库：
设置properties中数据库自己的用户名，密码
我的是root 1234

（5）登录url：localhost:8080/web/login.html    
用户名：WindTech  密码：888888

（6）后台主页已被拦截登录
（7）创建product表
create table test
(
     pid int auto_increment primary key,
       pro_Name VARCHAR(50) not null,
       pro_Type VARCHAR(50) not null,
       pro_Num INT(40) not null,
       pro_State VARCHAR(100) not null,
       pro_fontTiltOne VARCHAR(300),
       pro_file VARCHAR(300),
       pro_info VARCHAR(800),
       pro_finger VARCHAR(300),
       pro_driver VARCHAR(300),
       pro_video VARCHAR(300),
       pro_fontTiltTwo VARCHAR(300),
       pro_backTiltOne VARCHAR(300),
       pro_backTiltTwo VARCHAR(300),
       pro_font VARCHAR(300),
       pro_back VARCHAR(300),
        createdUser VARCHAR(50),
        createdTime  VARCHAR(80),
        modifiedUser VARCHAR(50),
        modifiedTime  VARCHAR(80)
);
插入几条产品数据
INSERT INTO product VALUES (1,'C2S01模块',"C2系列",432,1,'图片','这里是C2S01模块',"XXX","XXX","XXX","XXX") ;

（8）可以在谷歌浏览器中进行页面的手机适配
手机适配使用了淘宝flexible布局，根据不同手机的dpr设置根字体大小，页面上使用的单位大部分为rem，还有个别vw，px。
使用了媒体查询，当PC端页面缩小时以及手机端640px-300px时，分别对应不同的布局。

