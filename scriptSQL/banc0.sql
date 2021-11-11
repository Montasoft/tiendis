-- This script only contains the table creation statements and does not fully represent the table in database. It's still missing: indices, triggers. Do not use it as backup.

-- Squences
CREATE SEQUENCE IF NOT EXISTS banc0_id_banco_seq

-- Table Definition
CREATE TABLE "public"."banc0" (
    "id_banco" int4 NOT NULL DEFAULT nextval('banc0_id_banco_seq'::regclass),
    "nombre" varchar,
    PRIMARY KEY ("id_banco")
);



-- alterar la column a para que sea autoincremental

CREATE SEQUENCE carrit0_id_carrito_seq START WITH 1;
ALTER TABLE carrit0 ALTER COLUMN id_carrito SET DEFAULT nextval('carrit0_id_carrito_seq');


CREATE SEQUENCE carrito_detalle_id_carrito_detalle_seq START WITH 1;
ALTER TABLE carrito_detalle ALTER COLUMN id_carrito_detalle SET DEFAULT nextval('carrito_detalle_id_carrito_detalle_seq');


CREATE SEQUENCE categori4_id_cat_seq START WITH 1;
ALTER TABLE categori4 ALTER COLUMN id_cat SET DEFAULT nextval('categori4_id_cat_seq');


