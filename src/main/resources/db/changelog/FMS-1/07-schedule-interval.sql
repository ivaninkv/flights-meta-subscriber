create table if not exists schedule_interval
(
    id        serial
        constraint schedule_interval_pk
            primary key,
    day       integer not null default 0,
    hour      integer not null default 0,
    minute    integer not null default 0,
    is_active boolean not null default true
);
