Create Database QLNH;

use QLNH;

create table users (
id			int PRIMARY KEY auto_increment,
email		varchar(100) not null,
password 	varchar(110) not null
);
select * from users;
insert into users(email, password) values ("bblaze036@gmail.com", '123456');

CREATE TABLE dishes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category ENUM('MonChinh', 'MonPhu', 'NuocUong') NOT NULL,
    description TEXT
);

CREATE TABLE tables (
    id INT PRIMARY KEY AUTO_INCREMENT,
    table_number VARCHAR(10) NOT NULL UNIQUE,
    status ENUM('Trong', 'DangPhucVu', 'DaThanhToan') DEFAULT 'Trong'
);

CREATE TABLE bills (
    id INT PRIMARY KEY AUTO_INCREMENT,
    table_id INT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_price DECIMAL(10,2),
    status ENUM('ChuaThanhToan', 'DaThanhToan') DEFAULT 'ChuaThanhToan',
    FOREIGN KEY (table_id) REFERENCES tables(id)
);

CREATE TABLE bill_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    bill_id INT,
    dish_id INT,
    quantity INT,
    note TEXT,
    price DECIMAL(10,2), -- giá tại thời điểm đặt
    FOREIGN KEY (bill_id) REFERENCES bills(id),
    FOREIGN KEY (dish_id) REFERENCES dishes(id)
);

CREATE TABLE otp_codes (
    email VARCHAR(100) PRIMARY KEY,
    code VARCHAR(10),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
