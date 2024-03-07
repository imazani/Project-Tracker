-- profile
create table Profile
(
    id int auto_increment primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(255) not null
);

-- project
create table Project
(
    id int auto_increment primary key ,
    status varchar(255) not null,
    stage varchar(255) not null,
    created_on timestamp not null,
    updated_on timestamp,
    assigned_to int,
    foreign key (assigned_to) references Profile(id)
);

-- note
create table Note
(
    project int not null,
    user_name varchar(100) not null,
    content text not null,
    published_on timestamp not null,
    updated_on timestamp,
    foreign key (project) references Project(id)
);