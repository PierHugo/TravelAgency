create table admin
(
    id         bigint       not null primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    login      varchar(255) not null,
    password   varchar(255) not null,
    constraint UK_d3uev2cex85xal91gucifjk81 unique (login)
) engine = InnoDB;


create table client
(
    id         bigint       not null primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    login      varchar(255) not null,
    password   varchar(255) not null,
    constraint UK_qvo8w4n0xm1ry7rphrnsefwjd unique (login)
) engine = InnoDB;

create table offer
(
    destination varchar(255) primary key,
    description varchar(255) not null,
    price       varchar(255) not null,
    mustsees    varchar(255) not null,
    activities  varchar(255) not null

) engine = InnoDB;

INSERT INTO admin(id, first_name, last_name, Login, Password)
VALUES (1, 'admin', 'admin', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');
-- password : admin
INSERT INTO client(id, first_name, last_name, Login, Password)
VALUES (2, 'client1', 'client1', 'client1', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8');
INSERT INTO client(id, first_name, last_name, Login, Password)
VALUES (3, 'client2', 'client2', 'client2', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8');
-- password : password
INSERT INTO offer(destination, description, price)
VALUES ('Italy', 'Pizza', 15, 'The coliseum', 'Wrestling');
INSERT INTO offer(destination, description, price)
VALUES ('France', 'Frites', 60, 'The Eiffel tower', 'Photography');