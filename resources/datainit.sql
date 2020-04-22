create table employee
(
    id         bigint       not null auto_increment primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    login      varchar(255) not null,
    password   varchar(255) not null,
    age        varchar(255) not null,
    city       varchar(255) not null,
    constraint loginunique unique (login)
) engine = InnoDB;


create table client
(
    id         bigint       not null auto_increment primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    login      varchar(255) not null,
    password   varchar(255) not null,
    age        varchar(255) not null,
    city       varchar(255) not null,
    constraint loginunique unique (login)
) engine = InnoDB;

create table offer
(
    destination varchar(255) primary key,
    description varchar(255) not null,
    price       varchar(255) not null,
    mustsees    varchar(255) not null,
    activities  varchar(255) not null,
    slots       varchar(255) not null
) engine = InnoDB;

INSERT INTO employee
VALUES (0, 'employee', 'employee', 'employee', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 20,
        'Paris');
-- password : password
INSERT INTO client
VALUES (1, 'client1', 'client1', 'client1', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 30,
        'London');
INSERT INTO client
VALUES (2, 'client2', 'client2', 'client2', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 50,
        'New York City');
-- password : password
INSERT INTO offer
VALUES ('Italy', 'Pizza', 15, 'The coliseum', 'Wrestling', 2);
INSERT INTO offer
VALUES ('France', 'Frites', 60, 'The Eiffel tower', 'Photography', 1);