CREATE TABLE IF NO EXIST POST (
id serial primary key,
name varchar(255),
text text,
link text unique,
created timestamp
);
