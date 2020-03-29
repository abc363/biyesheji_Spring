（1）创建数据库：websystem
（2）创建login表
create table login
(
    id int auto_increment primary key,
    username varchar(100) not null,
    salt varchar(500),
    isDelete int(20),
    password varchar(500) not null
);
（3）插入一个用户：
INSERT INTO login VALUES 
(1, "WindTech",'263641DC-4782-455D-B2B0-098434B2C536',0,'A5553D5FD25908C7495AA91D7E4C8C9D');

（4）向项目中添加自己的数据库：
设置properties中数据库自己的用户名，密码
我的是root 1234

（5）登录url：localhost:8080/web/login.html    
用户名：WindTech  密码：888888

（6）主页已被拦截登录
（7）创建product表
create table product
(
    pid int auto_increment primary key,
    pro_Name VARCHAR(50) not null,
    pro_Type VARCHAR(50) not null,
    pro_Num INT(40) not null,
    pro_State INT(10) not null,
    pro_img VARCHAR(40),
    pro_info VARCHAR(500)
);
插入几条产品数据
INSERT INTO product VALUES (1,'C2S01模块',"C2系列",432,1,'图片','这里是C2S01模块') ;

