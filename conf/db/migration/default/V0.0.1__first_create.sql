-- articles
create table articles (
	name varchar(255) not null primary key,
	article text,
	created_at timestamp not null
);

-- members
create table members (
    id serial not null primary key, 
    name varchar(64), 
    created_at timestamp not null
);