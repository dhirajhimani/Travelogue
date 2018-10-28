# --- !Ups

CREATE TABLE users (
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL,
  email varchar(100) UNIQUE NOT NULL,
  password varchar(100) NOT NULL,
  "type" smallint NOT NULL DEFAULT 0,
  isactive smallint NOT NULL DEFAULT 1,
  creationTime bigint NULL,
  modifiedTime bigint NULL
);

CREATE TABLE trips (
  id serial PRIMARY KEY,
  userid int NOT NULL,
  destination varchar(45) NOT NULL,
  startDate bigint NOT NULL,
  endDate bigint NOT NULL,
  isactive smallint NOT NULL DEFAULT 1,
  description varchar(500) DEFAULT NULL,
  creationTime bigint NULL,
  modifiedTime bigint NULL
);


CREATE INDEX id ON trips(id);

# --- !Downs

drop table users;
drop table trips;