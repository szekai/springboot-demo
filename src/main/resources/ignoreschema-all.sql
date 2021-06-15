DROP TABLE people IF EXISTS;

CREATE TABLE cust_trx  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    acc_number VARCHAR(255),
        trx_amount VARCHAR(255),
        description VARCHAR(500),
        trx_date VARCHAR(255),
        trx_time VARCHAR(255),
        cust_id VARCHAR(255)
);

