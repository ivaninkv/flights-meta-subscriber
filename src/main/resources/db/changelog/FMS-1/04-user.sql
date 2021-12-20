create table if not exists "user"
(
    id        serial
        constraint user_pk
            primary key,
    name      varchar(50),
    is_active boolean
);
