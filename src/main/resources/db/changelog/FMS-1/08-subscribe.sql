create table if not exists subscribe
(
    id                   serial
        constraint subscribe_pk
            primary key,
    user_id              integer
        constraint subscribe_user_id_fk
            references "user"
            on update cascade on delete set null,
    schedule_interval_id integer
        constraint subscribe_schedule_interval_id_fk
            references schedule_interval
            on update cascade on delete set null,
    name                 varchar(50)         not null,
    date_from            date,
    date_to              date,
    delta_amount         integer default 100 not null,
    from_location        json,
    to_location          json,
    is_active            boolean default true
);
