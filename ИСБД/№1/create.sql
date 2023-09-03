CREATE TYPE "specialist_status" AS ENUM (
  'blocked',
  'working'
);

CREATE TYPE "order_status" AS ENUM (
  'in_search',
  'communication',
  'in_work',
  'conflict',
  'done'
);

CREATE TYPE "client_status" AS ENUM (
  'blocked',
  'default'
);

CREATE TABLE "specialization" (
  "id" SERIAL NOT NULL ,
  "specialist_id" int NOT NULL,
  "service_id" int NOT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "payout" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "auth_id" int NOT NULL,
  "amount" int NOT NULL,
  "date" date NOT NULL,
  "comment" text
);

CREATE TABLE "service" (
  "id" SERIAL NOT NULL PRIMARY KEY,
  "category_id" int NOT NULL,
  "title" varchar NOT NULL,
  "price" int NOT NULL,
  "slug" varchar NOT NULL
);

CREATE TABLE "report" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "order_id" int NOT NULL,
  "creation_time" date NOT NULL,
  "text" text NOT NULL
);

CREATE TABLE "review" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "order_id" int NOT NULL,
  "creation_time" date NOT NULL,
  "text" text NOT NULL,
  "rating" int NOT NULL
);

CREATE TABLE "specialist" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "auth_id" int NOT NULL UNIQUE,
  "name" varchar NOT NULL,
  "surname" varchar NOT NULL,
  "patronymic" varchar NOT NULL,
  "status" "specialist_status" NOT NULL,
  "rating" int NOT NULL,
  "phone" varchar NOT NULL UNIQUE,
);

CREATE TABLE "client" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "auth_id" int NOT NULL UNIQUE,
  "name" varchar NOT NULL,
  "string" varchar,
  "status" "client_status" NOT NULL,
  "phone" varchar NOT NULL unique,
);

CREATE TABLE "auth" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "username" varchar NOT NULL UNIQUE,
  "password" varchar NOT NULL,
  "email" varchar UNIQUE
);

CREATE TABLE "category" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "name" varchar NOT NULL,
  "slug" varchar NOT NULL
);

CREATE TABLE "documents" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "order_id" int NOT NULL,
  "url" text NOT NULL
);

CREATE TABLE "order" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "service_id" int NOT NULL,
  "specialist_id" int,
  "client_id" int NOT NULL,
  "creation_time" date,
  "status" "order_status" NOT NULL,
  "comment" text,
  "address" text NOT NULL,
  "deadline" date NOT NULL
);

ALTER TABLE "specialization" ADD FOREIGN KEY ("specialist_id") REFERENCES "specialist" ("id");

ALTER TABLE "specialization" ADD FOREIGN KEY ("service_id") REFERENCES "service" ("id");

ALTER TABLE "payout" ADD FOREIGN KEY ("auth_id") REFERENCES "auth" ("id");

ALTER TABLE "service" ADD FOREIGN KEY ("category_id") REFERENCES "category" ("id");

ALTER TABLE "report" ADD FOREIGN KEY ("order_id") REFERENCES "order" ("id");

ALTER TABLE "review" ADD FOREIGN KEY ("order_id") REFERENCES "order" ("id");

ALTER TABLE "specialist" ADD FOREIGN KEY ("auth_id") REFERENCES "auth" ("id");

ALTER TABLE "client" ADD FOREIGN KEY ("auth_id") REFERENCES "auth" ("id");

ALTER TABLE "documents" ADD FOREIGN KEY ("order_id") REFERENCES "order" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("service_id") REFERENCES "service" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("specialist_id") REFERENCES "specialist" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("client_id") REFERENCES "client" ("id");

