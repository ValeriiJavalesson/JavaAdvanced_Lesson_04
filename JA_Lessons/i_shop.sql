drop database if exists i_shop;
create database i_shop char set utf16;
use i_shop;

create table user(
		id int not null primary key auto_increment,
		firstName varchar(120) not null,
    lastName varchar(120) not null,
    email varchar(120) not null unique,
    password varchar(120) not null,
    role varchar(50) not null default 'USER',
		created_at datetime default now(),
    is_deleted boolean default false
);

create table product(
		id int not null primary key auto_increment,
    title varchar(120) not null,
    description text,
    price float not null,
    created_at datetime default now(),
    is_deleted boolean default false
);

create table bucket(
		id int not null primary key auto_increment,
    user_id int not null,
    product_id int not null,
    purchase_date datetime default now()
);

alter table bucket add foreign key (user_id) references user(id);
alter table bucket add foreign key (product_id) references product(id);
