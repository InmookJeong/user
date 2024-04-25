/* CREATE DATABASE */
CREATE DATABASE MOOKSTORY;

/* CREATE USER */
CREATE USER 'user account'@'localhost' IDENTIFIED BY 'user password';
CREATE USER 'user account'@'%' IDENTIFIED BY 'user password';

/* GRANT */
GRANT ALL PRIVILEGES ON MOOKSTORY.* TO 'user account'@'user password';
FLUSH PRIVILEGES;