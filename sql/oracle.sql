-- Create Schema By Sys as DBA
-- USER SQL
-- CREATE USER openlab IDENTIFIED BY open123 ;
-- ROLES
-- GRANT "CONNECT" TO openlab ;
-- GRANT "RESOURCE" TO openlab ;
-- drop table users;
--����û���
select goodid,goodname,price,types,states from sellergoods_wangxin where states='��Ԥ��'
create table buyer_wangxin
(
id number(20),
name varchar2(50),
pwd varchar2(50),
PRIMARY KEY (id),
--��½�û���Ψһ��Լ��
constraint name_unique unique(name)
)
-- drop SEQUENCE SEQ_buyer_wangxin;
CREATE SEQUENCE SEQ_buyer_wangxin;
insert into buyer_wangxin (id, name, pwd) values (SEQ_buyer_wangxin.nextval,'����','123');
insert into buyer_wangxin (id, name, pwd) values (SEQ_buyer_wangxin.nextval,'����','abc');
select * from buyer_wangxin;
................................................................................
--�����û���
create table seller_wangxin(
id  number(20),
name varchar2(50),
pwd varchar2(50),
PRIMARY KEY (id),
constraint name1_unique unique(name)
)select * from seller_wangxin
CREATE SEQUENCE SEQ_seller_wangxin;
insert into seller_wangxin (id, name, pwd) values (SEQ_seller_wangxin.nextval,'����','123');
.................................................................................
--������Ʒ��
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
values (SEQ_goods_wangxin.nextval,'1101��',388,'��׼��','��Ԥ��');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1102��',488,'���˼�','��Ԥ��');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1103��',588,'˫�˼�','��Ԥ��');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1104��',688,'���˼�','��Ԥ��');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1105��',788,'�����','��Ԥ��');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1106��',1088,'������','��Ԥ��');
insert into sellergoods_wangxin (goodid, goodname, price,types,states) 
values (SEQ_goods_wangxin.nextval,'1107��',1888,'��ͳ��','��Ԥ��');
update sellergoods_wangxin set states='��Ԥ��' where goodname='1107��'
...............................................................................
--������
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
values (SEQ_list_wangxin.nextval,'1107��',10,18880,'����','13888888888','2015��7��1��','2015��7��10��','��Ԥ��');
....................................................................
--���ﳵ��
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
values(SEQ_cart_wangxin.nextval,'����','1106��',10,1088);
