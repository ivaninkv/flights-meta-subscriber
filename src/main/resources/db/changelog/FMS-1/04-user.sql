create table if not exists "user"
(
    id        serial
        constraint user_pk
            primary key,
    name      varchar(50) not null,
    is_active boolean     not null default true
);
