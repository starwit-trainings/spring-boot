CREATE SEQUENCE IF NOT EXISTS "myuser_id_seq";

CREATE TABLE "myuser"
(
    "firstname" VARCHAR(255) NOT NULL ,
    "lastname" VARCHAR(255) NOT NULL ,
    "gender" VARCHAR(255),
    "isrich" BOOLEAN,
    "title" VARCHAR(255),
    "address_id" BIGINT UNIQUE,
    "id" BIGINT NOT NULL DEFAULT nextval('myuser_id_seq'),
    CONSTRAINT "myuser_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "address_id_seq";

CREATE TABLE "address"
(
    "city" VARCHAR(255),
    "street" VARCHAR(255),
    "streetnr" VARCHAR(255),
    "citycode" VARCHAR(255),
    "id" BIGINT NOT NULL DEFAULT nextval('address_id_seq'),
    CONSTRAINT "address_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "organisation_id_seq";

CREATE TABLE "organisation"
(
    "name" VARCHAR(255) NOT NULL ,
    "longlongnumber" BIGINT,
    "somebigdecimal" DECIMAL(19,2),
    "thedoulbebugfix" DOUBLE PRECISION,
    "address_id" BIGINT UNIQUE,
    "id" BIGINT NOT NULL DEFAULT nextval('organisation_id_seq'),
    CONSTRAINT "organisation_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "passport_id_seq";

CREATE TABLE "passport"
(
    "passportid" INTEGER NOT NULL ,
    "datecreated" DATE,
    "sometime" TIME WITH TIME ZONE,
    "logtime" TIMESTAMP WITH TIME ZONE,
    "myuser_id" BIGINT,
    "id" BIGINT NOT NULL DEFAULT nextval('passport_id_seq'),
    CONSTRAINT "passport_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "cart_id_seq";

CREATE TABLE "cart"
(
    "created" TIMESTAMP WITH TIME ZONE,
    "id" BIGINT NOT NULL DEFAULT nextval('cart_id_seq'),
    CONSTRAINT "cart_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "article_id_seq";

CREATE TABLE "article"
(
    "name" VARCHAR(255),
    "color" VARCHAR(255),
    "price" DOUBLE PRECISION,
    "weight" DOUBLE PRECISION,
    "cart_id" BIGINT,
    "id" BIGINT NOT NULL DEFAULT nextval('article_id_seq'),
    CONSTRAINT "article_pkey" PRIMARY KEY ("id")
);

ALTER TABLE "myuser"
    ADD CONSTRAINT "fk_myuser_address"
    FOREIGN KEY ("address_id")
    REFERENCES "address" ("id");

CREATE TABLE "myuser_organisation" (
    "myuser_id" BIGINT NOT NULL,
    "organisation_id" BIGINT NOT NULL,
    PRIMARY KEY ("myuser_id", "organisation_id")
);

ALTER TABLE "myuser_organisation"
    ADD CONSTRAINT "fk_myuser_organisation"
    FOREIGN KEY ("myuser_id")
    REFERENCES "myuser" ("id");

ALTER TABLE "myuser_organisation"
    ADD CONSTRAINT "fk_organisation_organisation"
    FOREIGN KEY ("organisation_id")
    REFERENCES "organisation" ("id");

ALTER TABLE "organisation"
    ADD CONSTRAINT "fk_organisation_address"
    FOREIGN KEY ("address_id")
    REFERENCES "address" ("id");

ALTER TABLE "passport"
    ADD CONSTRAINT "fk_passport_user"
    FOREIGN KEY ("myuser_id")
    REFERENCES "myuser" ("id");

ALTER TABLE "article"
    ADD CONSTRAINT "fk_article_cart"
    FOREIGN KEY ("cart_id")
    REFERENCES "cart" ("id");