CREATE TABLE IF NOT EXISTS orders
(
    id           int not null auto_increment,
    order_number varchar(255) default null,
    sky_code     varchar(255),
    price        decimal(19, 2),
    quantity     int(11),
    primary key (`id`)
);

