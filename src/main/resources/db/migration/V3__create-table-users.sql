create table users(
    id int primary key auto_increment not null,
    name varchar(50) not null,
    password varchar(50) not null,
    role varchar(50) not null
)