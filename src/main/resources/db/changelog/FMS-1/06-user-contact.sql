create table if not exists user_contact
(
    user_id              integer     not null
        constraint user_contact_user_id_fk
            references "user"
            on update cascade on delete set null,
    user_contact_type_id integer     not null
        constraint user_contact_user_contact_type_id_fk
            references user_contact_type
            on update cascade on delete set null,
    name                 varchar(50) not null,
    is_active            boolean     not null default true,
    constraint user_contact_pk
        primary key (user_id, user_contact_type_id)
);
