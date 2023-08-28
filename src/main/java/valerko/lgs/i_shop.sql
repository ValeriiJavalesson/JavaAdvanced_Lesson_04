drop database if exists i_shop;
create database i_shop;
use i_shop;

create table user(
		id int not null primary key auto_increment,
		firstName varchar(120) not null,
    lastName varchar(120) not null,
    email varchar(120) not null unique,
    password varchar(120) not null,
    accessLevel varchar(50) not null,
		created_at datetime default now(),
    is_deleted boolean default false
);

create table product(
		id int not null primary key auto_increment,
    title varchar(120) not null unique,
    description text,
    price float not null,
    is_deleted boolean default false
);

INSERT INTO product (title, price) values
		("sdsd",77.33),
    ("Rssf",3333.55);

create table bucket(
		id int not null primary key auto_increment,
    user_id int not null,
    product_id int not null,
    purchase_date datetime default now()
);

alter table bucket add foreign key (user_id) references user(id);
alter table bucket add foreign key (product_id) references product(id);

