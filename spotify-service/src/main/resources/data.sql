  
drop table if exists artist;

create table artist (
idartist int auto_increment PRIMARY KEY,
name varchar(250),
gender varchar(250),
image varchar(250)
);

drop table if exists album;

create table album (
idalbum int auto_increment PRIMARY KEY,
name varchar(250),
idartist int
);

drop table if exists track;

create table track (
idtrack int auto_increment PRIMARY KEY,
name varchar(250),
reproductions int,
duration varchar(250),
idartist int,
idalbum int
);