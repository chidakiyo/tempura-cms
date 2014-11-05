# Articles schema

# --- !Ups

CREATE TABLE Article (
    id bigserial NOT NULL,
    create_date timestamp without time zone NOT NULL,
    modify_date timestamp without time zone,
    CONSTRAINT article_pk PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Article;