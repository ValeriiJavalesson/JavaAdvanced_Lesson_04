drop database if exists myShop;
create database myShop;
use myShop;
create table articles(
		id int not null primary key auto_increment,
    title varchar(120) not null,
    description text,
    price decimal (10,5) not null,
    subcategories_id int not null,
    user_id int not null,
    is_deleted boolean default false
);
create table subcategories(
		id int not null primary key auto_increment,
    title varchar(50) not null unique,
    categories_id int not null,
    is_deleted boolean default false
);
create table categories(
		id int not null primary key auto_increment,
    title varchar(50) not null unique,
    is_deleted boolean default false
);
create table users(
		id int not null primary key auto_increment,
		username varchar(120) not null unique,
    phone_number varchar(20) not null unique,
    is_deleted boolean default false
);

alter table articles add foreign key (user_id) references users(id);
alter table subcategories add foreign key (categories_id) references categories(id);
alter table articles add foreign key (subcategories_id) references subcategories(id);

create index idx_username on users(username);
create index idx_title on articles(title);

INSERT INTO users(username, phone_number) VALUES 
('appleShop','+38099499999'),
('techShop','+380999699999'),
('woodUnits','+380994599999');

INSERT INTO categories (title) VALUES 
('Автотовари'),
('Побутова техніка'),
('Меблі');

INSERT INTO subcategories (title, categories_id)VALUES 
('Шини',1),
('Деталі двигуна',1),
('Гальмівна система',1),
('Техніка для кухні',2),
('Кліматична техніка',2),
('Телевізори',2),
('Дивани',3),
('Столи',3),
('Стільці',3);

INSERT INTO articles (title, description, price, subcategories_id, user_id) VALUES 
('Чайник','Чайник 2000W',1500.00000,4,1),
('Духовка','Духовка електрична 1000W',4500.00000,4,1),
('Кондиціонер','Кондиціонер 700W',2100.00000,5,1),
('Телевізор','Телевізор 150\'',7000.00000,6,1),
('Шина R18','Покришка R18',1100.00000,1,2),
('Радіатор','Радіатор VW',2300.00000,2,2),
('Колодки гальмівні','Колодки гальмівні 4 шт',2100.00000,3,2),
('Рідина гальмівна','Рідина гальмівна DOT4',650.00000,3,2),
('Диван','Диван червоний',1300.00000,7,3),
('Ліжко','Ліжко двоспальне',2650.00000,7,3),
('Столик кавовий','Столик кавовий 105/65',850.00000,8,3),
('Крісло-качалка','Крісло-качалка дерев’яне',1250.00000,9,3);





