create table if not exists Pizza(
    id identity,
    dateOfOrder timestamp not null ,
    ingredients varchar(50) not null
);