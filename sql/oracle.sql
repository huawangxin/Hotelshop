-- Create Schema By Sys as DBA
-- USER SQL
-- CREATE USER openlab IDENTIFIED BY open123 ;
-- ROLES
-- GRANT "CONNECT" TO openlab ;
-- GRANT "RESOURCE" TO openlab ;
-- drop table users;
--买家用户表
select goodid,goodname,price,types,states from sellergoods_wangxin where states='可预订'
create table buyer_wangxin
(
id number(20),
name varchar2(50),
pwd varchar2(50),
PRIMARY KEY (id),
--登陆用户名唯一性约束
constraint name_unique unique(name)
)
-- drop SEQUENCE SEQ_buyer_wangxin;
CREATE SEQUENCE SEQ_buyer_wangxin;
insert into buyer_wangxin (id, name, pwd) values (SEQ_buyer_wangxin.nextval,'张三','123');
insert into buyer_wangxin (id, name, pwd) values (SEQ_buyer_wangxin.nextval,'李四','abc');
select * from buyer_wangxin;
................................................................................
--卖家用户表
create table seller_wangxin(
id  number(20),
name varchar2(50),
pwd varchar2(50),
PRIMARY KEY (id),
constraint name1_unique unique(name)
)select * from seller_wangxin
CREATE SEQUENCE SEQ_seller_wangxin;
insert into seller_wangxin (id, name, pwd) values (SEQ_seller_wangxin.nextval,'张三','123');
.................................................................................
--卖家商品表
create table sellergoods_wangxin(
goodid number(38),
goodname varchar2(50),
price number(38),
types  varchar2(50),
states varchar2(50),
PRIMARY KEY (goodid),
constraint name2_unique unique(goodname)
)
select * from sellergoods_wangxin;
CREATE SEQUENCE SEQ_goods_wangxin;
insert into sellergoods_wangxin (goodid,goodname,price,types,states) 
values (SEQ_goods_wangxin.nextval,'1101房',388,'标准间','可预订');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1102房',488,'单人间','可预订');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1103房',588,'双人间','可预订');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1104房',688,'三人间','可预订');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1105房',788,'商务间','可预订');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1106房',1088,'豪华间','可预订');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1107房',1888,'总统间','已预订');
update sellergoods_wangxin set states='已预订' where goodname='1107房'
...............................................................................
--订单表
create table list_wangxin(
listid number(38),
goodname varchar2(50),
numbers number(20),
prices number(38),
name varchar2(50),
phone  varchar2(50),
date1  varchar2(50),
date2  varchar2(50),
states varchar2(50),
PRIMARY KEY (listid)
)
drop table list_wangxin
select * from list_wangxin;
CREATE SEQUENCE SEQ_list_wangxin;
insert into list_wangxin (listid, goodname,numbers, prices,name,phone,date1,date2,states) 
values (SEQ_list_wangxin.nextval,'1107房',10,18880,'张三','13888888888','2015年7月1日','2015年7月10日','已预订');
....................................................................
--购物车表单
create table cart_wangxin(
cartid number(20),
name varchar2(50),
goodname varchar2(50),
numbers number(20),
price number(38),
PRIMARY KEY (cartid)
)
select * from cart_wangxin  drop table cart_wangxin
CREATE SEQUENCE SEQ_cart_wangxin;
insert into cart_wangxin (cartid, name,goodname, numbers,price) 
values(SEQ_cart_wangxin.nextval,'张三','1106房',10,1088);
