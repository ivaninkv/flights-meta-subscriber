create table if not exists airport
(
    country_code varchar(3)
        constraint airport_country_code_fk
            references country
            on update cascade on delete set null,
    city_code    varchar(3),
    code         varchar(3),
    name         varchar(50) not null,
    en_name      varchar(50),
    ru_name      varchar(50),
    is_active    boolean,
    constraint airport_pk
        primary key (country_code, city_code, code),
    constraint airport_city_country_code_code_fk
        foreign key (country_code, city_code) references city
            on update cascade on delete set null
);

create index if not exists airport_en_name_index
    on airport (en_name);

create index if not exists airport_name_index
    on airport (name);

create index if not exists airport_ru_name_index
    on airport (ru_name);
