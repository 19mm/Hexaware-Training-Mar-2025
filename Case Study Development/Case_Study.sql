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

-- Sample Data for Artist Table (5 Records)
INSERT INTO artist (name, biography, birth_date, nationality, website, contact_information) VALUES
('Leonardo da Vinci', 'Italian polymath of the High Renaissance.', '1452-04-15', 'Italian', 'http://www.leonardodavinci.net/', 'contact@leonardodavinci.net'),
('Vincent van Gogh', 'Dutch Post-Impressionist painter.', '1853-03-30', 'Dutch', NULL, 'vincent@vangoghfoundation.org'),
('Pablo Picasso', 'Spanish painter, sculptor, printmaker, ceramicist and theatre designer.', '1881-10-25', 'Spanish', 'http://www.picasso.fr/', 'info@picasso.fr'),
('Frida Kahlo', 'Mexican painter known for her many portraits and self-portraits.', '1907-07-06', 'Mexican', 'http://www.fridakahlo.org/', 'contact@fridakahlo.org'),
('Claude Monet', 'Founder of French Impressionist painting.', '1840-11-14', 'French', NULL, 'info@fondation-monet.com');

select * from artist;

-- Sample Data for Artwork Table (5 Records)
-- Assuming the artist_ids generated above are 1, 2, 3, 4, 5 respectively
INSERT INTO artwork (title, description, creation_date, medium, image_url, artist_id) VALUES
('Mona Lisa', 'A half-length portrait painting by Leonardo da Vinci.', '1503-01-01', 'Oil on poplar panel', 'https://upload.wikimedia.org/wikipedia/commons/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg', 1),
('The Starry Night', 'An oil-on-canvas painting by Dutch Post-Impressionist painter Vincent van Gogh.', '1889-06-01', 'Oil on canvas', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/1280px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg', 2),
('Guernica', 'A large 1937 oil painting by Spanish artist Pablo Picasso.', '1937-06-01', 'Oil on canvas', 'https://upload.wikimedia.org/wikipedia/en/7/74/PicassoGuernica.jpg', 3),
('The Two Fridas', 'An oil painting by Mexican artist Frida Kahlo.', '1939-01-01', 'Oil on canvas', 'https://upload.wikimedia.org/wikipedia/en/0/0a/Kahlo-Two-Fridas.jpg', 4),
('Impression, soleil levant', 'Painting by Claude Monet first shown at what would become known as the "Exhibition of the Impressionists".', '1872-01-01', 'Oil on canvas', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Monet_-_Impression%2C_Sunrise.jpg/1280px-Monet_-_Impression%2C_Sunrise.jpg', 5);

select * from artwork;

-- Sample Data for User Table (10 Records)
INSERT INTO user (username, password, email, first_name, last_name, date_of_birth, profile_picture) VALUES
('artlover123', 'pass123', 'artlover123@email.com', 'Alice', 'Smith', '1990-05-15', 'pic1.jpg'),
('galleryfan', 'securepwd', 'galleryfan@email.com', 'Bob', 'Johnson', '1985-08-20', 'pic2.jpg'),
('creativemind', 'password123', 'creativemind@email.com', 'Charlie', 'Brown', '1995-01-10', NULL),
('designguru', 'mypass', 'designguru@email.com', 'Diana', 'Williams', '1988-11-30', 'pic4.jpg'),
('historybuff', 'histpass', 'historybuff@email.com', 'Ethan', 'Davis', '1979-03-25', NULL),
('modernartfan', 'artpass1', 'modernart@email.com', 'Fiona', 'Miller', '1992-07-07', 'pic6.jpg'),
('classicviewer', 'viewpass', 'classicview@email.com', 'George', 'Wilson', '1983-09-12', NULL),
('photofanatic', 'photopass', 'photofan@email.com', 'Hannah', 'Moore', '1998-12-01', 'pic8.jpg'),
('sculpture admirer', 'sculptpass', 'sculpture@email.com', 'Ian', 'Taylor', '1980-06-18', 'pic9.jpg'),
('curatorwannabe', 'curator123', 'curatorwb@email.com', 'Jane', 'Anderson', '1993-04-22', NULL);

select * from user;

-- Sample Data for Gallery Table (3 Records)
-- Assuming artist_ids 3, 5, 1 can be curators
INSERT INTO gallery (name, description, location, curator_id, opening_hours) VALUES
('Modern Masters Gallery', 'Showcasing the best of 20th-century art.', 'New York, USA', 3, 'Tue-Sun: 10 AM - 6 PM'),
('Impressionist Dreams', 'A collection dedicated to the Impressionist movement.', 'Paris, France', 5, 'Mon-Sat: 9 AM - 5 PM'),
('Renaissance Revisited', 'Exploring the masterpieces of the Renaissance.', 'Florence, Italy', 1, 'Wed-Mon: 10 AM - 7 PM');

select * from gallery;

-- Sample Data for User Favorite Artwork Table (Linking Users and Artworks)
-- Assuming user_ids are 1-10 and artwork_ids are 1-5
INSERT INTO user_favorite_artwork (user_id, artwork_id) VALUES
(1, 1), -- Alice likes Mona Lisa
(1, 2), -- Alice likes The Starry Night
(2, 3), -- Bob likes Guernica
(4, 5), -- Diana likes Impression, soleil levant
(5, 1), -- Ethan likes Mona Lisa
(7, 2), -- George likes The Starry Night
(9, 4); -- Ian likes The Two Fridas

select * from user_favorite_artwork;

-- Sample Data for Artwork Gallery Table (Linking Artworks and Galleries)
-- Assuming artwork_ids are 1-5 and gallery_ids are 1-3
INSERT INTO artwork_gallery (artwork_id, gallery_id) VALUES
(3, 1), -- Guernica in Modern Masters Gallery
(5, 2), -- Impression, soleil levant in Impressionist Dreams
(1, 3), -- Mona Lisa in Renaissance Revisited
(2, 1), -- The Starry Night in Modern Masters Gallery (example of artwork in a relevant gallery)
(4, 1); -- The Two Fridas in Modern Masters Gallery (example of artwork in a relevant gallery)

select * from artwork_gallery;
