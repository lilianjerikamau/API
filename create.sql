CREATE DATABASE jadle;
\c jadle;
CREATE TABLE news(id SERIAL PRIMARY KEY, data VARCHAR, type VARCHAR, userId INTEGER , departmentId INTEGER );
CREATE TABLE departments(id SERIAL PRIMARY KEY, name VARCHAR, description VARCHAR );
CREATE TABLE users(id SERIAL PRIMARY KEY, name VARCHAR, position VARCHAR, role VARCHAR, departmentId INTEGER);
CREATE DATABASE jadle_test WITH TEMPLATE jadle;