CREATE TABLE IF NOT EXISTS POST (
id serial primary key,
title varchar(255),
description text,
link text unique,
created timestamp
);
