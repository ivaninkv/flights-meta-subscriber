create table if not exists country
(
    code      varchar(3)
        constraint country_pk
            primary key,
    currency  varchar(3),
    name      varchar(50) not null,
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
