create table if not exists city
(
    country_code varchar(3)
        constraint city_country_code_fk
            references country
            on update cascade on delete set null,
    code         varchar(3),
    name         varchar(50) not null,
    en_name      varchar(50),
    ru_name      varchar(50),
    is_active    boolean     not null default true,
    constraint city_pk
        primary key (country_code, code)
);

create index if not exists city_en_name_index
    on city (en_name);

create index if not exists city_name_index
    on city (name);

create index if not exists city_ru_name_index
    on city (ru_name);
