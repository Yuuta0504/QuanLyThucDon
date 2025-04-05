Create Database QLNH;

Use QLNH;

Create table users (
  id      int primary key auto_increament,
  email   varchar(100) not null,
  password varchar(11) not null
);
