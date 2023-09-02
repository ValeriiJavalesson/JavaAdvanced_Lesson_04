drop database if exists magazinesShop;
create database magazinesShop;
use magazinesShop;

create table user(
	id int not null primary key auto_increment,
		firstName varchar(120) not null,
    lastName varchar(120) not null,
    email varchar(120) not null unique,
    password varchar(120) not null,
    accesLevel varchar(20) not null,
		created_at timestamp default now(),
    is_deleted boolean default false
);

create table magazine(
		id int not null primary key auto_increment,
    title varchar(120) not null unique,
    description text,
    is_deleted boolean default false
);

create table subscribe(
		id int not null primary key auto_increment,
    user_id int not null,
    magazine_id int not null,
    subscribe_status boolean default false
);

alter table subscribe add foreign key (user_id) references user(id);
alter table subscribe add foreign key (magazine_id) references magazine(id);