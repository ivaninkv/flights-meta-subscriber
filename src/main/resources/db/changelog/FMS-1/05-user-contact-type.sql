create table if not exists user_contact_type
(
    id        serial
        constraint user_contact_type_pk
            primary key,
    name      varchar(50),
    is_active boolean
);
