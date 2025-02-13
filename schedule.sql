create table member
(
    created_at  datetime(6)  null,
    id          bigint auto_increment
        primary key,
    modified_at datetime(6)  null,
    password    varchar(255) not null,
    useremail   varchar(255) not null,
    username    varchar(255) not null,
    constraint UKgc3jmn7c2abyo3wf6syln5t2i
        unique (username)
);

create table schedule
(
    created_at  datetime(6)  null,
    id          bigint auto_increment
        primary key,
    member_id   bigint       null,
    modified_at datetime(6)  null,
    contents    longtext     not null,
    title       varchar(255) not null,
    constraint FKn7js9p799qcts7le20pec9bxr
        foreign key (member_id) references management.member (id)
);

