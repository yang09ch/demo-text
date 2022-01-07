
create database demo;
use demo;

create table t_product (
  id int primary key  auto_increment,
  name varchar(200) not null,
  price  int ,
  info varchar(200),
  product_date datetime not null,
  status int not null
)engine innodb default charset utf8mb4;