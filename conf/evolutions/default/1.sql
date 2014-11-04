# Articles schema

# --- !Ups

CREATE TABLE Article (
    id bigserial NOT NULL,
    content text,
    create_date timestamp without time zone NOT NULL,
    modify_date timestamp without time zone,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Article;