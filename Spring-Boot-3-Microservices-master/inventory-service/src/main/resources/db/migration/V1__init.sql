create table inventory
(
    id       bigint auto_increment
        primary key,
    sku_code varchar(255) null,
    quantity int null
);
