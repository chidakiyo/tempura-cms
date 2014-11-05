create table members (
    id serial not null primary key, 
    name varchar(64), 
    created_at timestamp not null
)