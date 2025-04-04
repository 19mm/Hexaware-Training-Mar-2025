create database virtual_art_gallery;

use virtual_art_gallery;

create table artist (
    artist_id int primary key auto_increment,
    name varchar(255) not null,
    biography text,
    birth_date date,
    nationality varchar(100),
    website varchar(255),
    contact_information varchar(255)
);

create table artwork (
    artwork_id int primary key auto_increment,
    title varchar(255) not null,
    description text,
    creation_date date,
    medium varchar(255),
    image_url varchar(255),
    artist_id int,
    foreign key (artist_id) references artist(artist_id)
);

create table user (
    user_id int primary key auto_increment,
    username varchar(100) unique not null,
    password varchar(255) not null,
    email varchar(255) unique not null,
    first_name varchar(100),
    last_name varchar(100),
    date_of_birth date,
    profile_picture varchar(255)
);

create table gallery (
    gallery_id int primary key auto_increment,
    name varchar(255) not null,
    description text,
    location varchar(255),
    curator_id int,
    opening_hours varchar(255),
    foreign key (curator_id) references artist(artist_id)
);

create table user_favorite_artwork (
    user_id int,
    artwork_id int,
    primary key (user_id, artwork_id),
    foreign key (user_id) references user(user_id),
    foreign key (artwork_id) references artwork(artwork_id)
);

create table artwork_gallery (
    artwork_id int,
    gallery_id int,
    primary key (artwork_id, gallery_id),
    foreign key (artwork_id) references artwork(artwork_id),
    foreign key (gallery_id) references gallery(gallery_id)
);

