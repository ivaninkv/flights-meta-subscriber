-- country table
create table if not exists country
(
    code      varchar(3)
        constraint country_pk
            primary key,
    currency  varchar(3),
    name      varchar(50),
    en_name   varchar(50),
    ru_name   varchar(50),
    is_active boolean
);

create index if not exists country_en_name_index
    on country (en_name);

create index if not exists country_name_index
    on country (name);

create index if not exists country_ru_name_index
    on country (ru_name);

-- city table
create table if not exists city
(
    country_code varchar(3)
        constraint city_country_code_fk
            references country,
    code         varchar(3),
    name         varchar(50),
    en_name      varchar(50),
    ru_name      varchar(50),
    is_active    boolean,
    constraint city_pk
        primary key (country_code, code)
);

create index if not exists city_en_name_index
    on city (en_name);

create index if not exists city_name_index
    on city (name);

create index if not exists city_ru_name_index
    on city (ru_name);

-- airport table
create table if not exists airport
(
    country_code varchar(3)
        constraint airport_country_code_fk
            references country
            on update cascade on delete set null,
    city_code    varchar(3),
    code         varchar(3),
    name         varchar(50),
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

-- user table
create table if not exists "user"
(
    id        serial
        constraint user_pk
            primary key,
    name      varchar(50),
    is_active boolean
);

-- user_contact_type table
create table if not exists user_contact_type
(
    id        serial
        constraint user_contact_type_pk
            primary key,
    name      varchar(50),
    is_active boolean
);
