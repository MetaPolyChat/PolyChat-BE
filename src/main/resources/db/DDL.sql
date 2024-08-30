USE mysql;

CREATE DATABASE polychatdb;

GRANT ALL PRIVILEGES ON polychatdb.* TO 'ohgiraffers'@'%';

SHOW GRANTS FOR 'ohgiraffers'@'%';

USE polychatdb;