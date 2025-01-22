drop table if exists book;

create table if not exists book (
    id bigint auto_increment primary key,
    title varchar(255),
    author varchar(255),
    book_cover VARCHAR(2083),
    recommended_by_name varchar(255),
    is_available BOOLEAN
);


-- ALTER TABLE book
-- ALTER COLUMN book_cover SET DATA TYPE VARCHAR(255);

drop table if exists reservation;

create table if not exists reservation (
    id bigint auto_increment primary key,
    book_id bigint not null,
    reserved_by_name varchar(255) not null,
    reserved_by_email varchar(255),
    reserved_date varchar(255) not null,
    foreign key (book_id) references book(id)
);