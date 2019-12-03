-- no allowance for power connectors AND SOCKETS curently in db

CREATE TABLE parts
(
  pId     SERIAL PRIMARY KEY,
  name    VARCHAR(255),
  brand   VARCHAR(255),
  wattage double precision,
  details json,
  CONSTRAINT name_unique UNIQUE (name)
);

CREATE TABLE users
(
  uId SERIAL PRIMARY KEY,
  username VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  premium boolean
);

CREATE TABLE adverts
(
  uId int NOT NULL REFERENCES users,
  pId int NOT NULL REFERENCES parts,
  price DOUBLE PRECISION,
  PRIMARY KEY(uId,pId)
);

CREATE TABLE transactions
(
  tId SERIAL PRIMARY KEY,
  uId1 int NOT NULL REFERENCES users,
  uId2 int NOT NULL REFERENCES users,
  pId int NOT NULL REFERENCES parts,
  price DOUBLE PRECISION
);

CREATE TABLE reviews
(
  tId int NOT NULL REFERENCES transactions,
  rating int,
  buyerComment text
);

CREATE INDEX parts_index ON parts USING BTREE(name);

CREATE INDEX adverts_index ON adverts USING BTREE(pId);
