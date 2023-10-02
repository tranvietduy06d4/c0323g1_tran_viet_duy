create database an_nhien_organic;
use an_nhien_organic;

CREATE TABLE app_role (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL
);
CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    flag_deleted BIT NULL,
    flag_online BIT NULL,
    password VARCHAR(255) NULL,
    user_name VARCHAR(255) NULL
);
CREATE TABLE user_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    app_role_id BIGINT NULL,
    app_user_id BIGINT NULL,
    FOREIGN KEY (app_role_id)
        REFERENCES app_role (id),
    FOREIGN KEY (app_user_id)
        REFERENCES app_user (id)
);

CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255) NULL,
    birth_day DATE NULL,
    code VARCHAR(20) NULL,
    email VARCHAR(100) NULL,
    flag_deleted BIT NULL,
    name VARCHAR(100) NULL,
    phone_number VARCHAR(20) NULL,
    app_user_id BIGINT NULL,
    FOREIGN KEY (app_user_id)
        REFERENCES app_user (id)
);


CREATE TABLE product_type (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255) NULL,
    flag_deleted BIT NULL,
    name VARCHAR(255) NULL
);

CREATE TABLE product (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255) NULL,
    flag_deleted BIT NULL,
    name VARCHAR(255) NULL,
    note LONGTEXT NULL,
    origin VARCHAR(255) NULL,
    price DOUBLE NULL,
    quantity BIGINT NULL,
    product_type_id BIGINT NULL,
    FOREIGN KEY (product_type_id)
        REFERENCES product_type (id)
);


CREATE TABLE cart_detail (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NULL,
    app_user_id BIGINT NULL UNIQUE,
    product_id BIGINT NULL UNIQUE,
    FOREIGN KEY (product_id)
        REFERENCES product (id),
    FOREIGN KEY (app_user_id)
        REFERENCES app_user (id)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255) NULL,
    date_time DATE NULL,
    flag_deleted BIT NULL,
     app_user_id BIGINT NULL unique,
    note VARCHAR(255) NULL,
    FOREIGN KEY (app_user_id)
        REFERENCES app_user (id)
);

CREATE TABLE order_detail (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    current_price DOUBLE NULL,
    quantity INT NULL,
    product_id BIGINT NULL,
    order_id BIGINT NULL,
    FOREIGN KEY (order_id)
        REFERENCES orders (id),
    FOREIGN KEY (product_id)
        REFERENCES product (id)
);