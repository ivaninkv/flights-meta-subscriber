create table if not exists subscribe_result
(
    subscribe_id integer          not null
        constraint subscribe_result_subscribe_id_fk
            references subscribe
            on update cascade on delete set null,
    id           integer          not null,
    result_date  timestamp        not null,
    flight_date  date             not null,
    flight_price double precision not null,
    from_country varchar(3)       not null
        constraint subscribe_result_country_code_fk
            references country
            on update cascade on delete set null,
    from_city    varchar(3)       not null,
    from_airport varchar(3),
    to_country   varchar(3)       not null
        constraint subscribe_result_country_code_fk_2
            references country
            on update cascade on delete set null,
    to_city      varchar(3)       not null,
    to_airport   varchar(3),
    is_active    boolean          not null default true,
    constraint subscribe_result_pk
        primary key (subscribe_id, id),
    constraint subscribe_result_airport_country_code_city_code_code_fk
        foreign key (from_country, from_city, from_airport) references airport
            on update cascade on delete set null,
    constraint subscribe_result_airport_country_code_city_code_code_fk_2
        foreign key (to_country, to_city, to_airport) references airport
            on update cascade on delete set null,
    constraint subscribe_result_city_country_code_code_fk
        foreign key (from_country, from_city) references city
            on update cascade on delete set null,
    constraint subscribe_result_city_country_code_code_fk_2
        foreign key (to_country, to_city) references city
            on update cascade on delete set null
);

create index if not exists subscribe_result_result_date_flight_price_index
    on subscribe_result (result_date) include (flight_price);
