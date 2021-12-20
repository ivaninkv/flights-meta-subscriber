create table if not exists subscribe_details
(
    subscribe_id integer              not null
        constraint subscribe_details_subscribe_id_fk
            references subscribe
            on update cascade on delete set null,
    id           integer              not null,
    date         date,
    from_country varchar(3)           not null
        constraint subscribe_details_country_code_fk
            references country
            on update cascade on delete set null,
    from_city    varchar(3)           not null,
    from_airport varchar(3),
    to_country   varchar(3)           not null
        constraint subscribe_details_country_code_fk_2
            references country
            on update cascade on delete set null,
    to_city      varchar(3)           not null,
    to_airport   varchar(3),
    is_active    boolean default true not null,
    constraint subscribe_details_pk
        primary key (subscribe_id, id),
    constraint subscribe_details_airport_country_code_city_code_code_fk
        foreign key (from_country, from_city, from_airport) references airport
            on update cascade on delete set null,
    constraint subscribe_details_airport_country_code_city_code_code_fk_2
        foreign key (from_country, from_city, from_airport) references airport
            on update cascade on delete set null,
    constraint subscribe_details_city_country_code_code_fk
        foreign key (from_country, from_city) references city
            on update cascade on delete set null,
    constraint subscribe_details_city_country_code_code_fk_2
        foreign key (from_country, from_city) references city
            on update cascade on delete set null
);
