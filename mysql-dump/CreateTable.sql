CREATE DATABASE IF NOT EXISTS db_simple_banking;
USE db_simple_banking;

DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS transaction;

CREATE TABLE account (
  id INT NOT NULL AUTO_INCREMENT,
  owner VARCHAR(45) NOT NULL,
  account_number VARCHAR(45) UNIQUE NOT NULL,
  balance DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE transaction (
  id INT NOT NULL AUTO_INCREMENT,
  date DATETIME NOT NULL,
  amount DOUBLE NOT NULL,
  approval_code VARCHAR(45) NOT NULL,
  account_id INT,
  transaction_type VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES account(id)

);

CREATE TABLE deposit_transaction (
  transaction_id INT NOT NULL,
  PRIMARY KEY (transaction_id),
  CONSTRAINT fk_deposit_trx_id FOREIGN KEY (transaction_id) REFERENCES transaction(id)
);

CREATE TABLE withdrawal_transaction (
  transaction_id INT NOT NULL,
  PRIMARY KEY (transaction_id),
  CONSTRAINT fk_withdrawal_trx_id FOREIGN KEY (transaction_id) REFERENCES transaction(id)
);

CREATE TABLE bill_payment_transaction (
  transaction_id INT NOT NULL,
  payee VARCHAR(45) NOT NULL,
  PRIMARY KEY (transaction_id),
  CONSTRAINT fk_bill_payment_trx_id FOREIGN KEY (transaction_id) REFERENCES transaction(id)
);

CREATE TABLE phone_bill_payment_transaction (
  transaction_id INT NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  PRIMARY KEY (transaction_id),
  CONSTRAINT fk_phone_bill_payment_trx_id FOREIGN KEY (transaction_id) REFERENCES transaction(id)
);

INSERT INTO account(owner, account_number, balance) VALUES('Kerem Karaca','17892',100);
INSERT INTO account(owner, account_number, balance)  VALUES('Demet Demircan','9834',100);
INSERT INTO account(owner, account_number, balance)  VALUES('Canan Kaya','1234',100);

