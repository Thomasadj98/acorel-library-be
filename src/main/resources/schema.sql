create table if not exists book (
    id bigint auto_increment primary key,
    title varchar(255),
    author varchar(255),
    book_cover VARCHAR(2083),
    recommended_by_name varchar(255),
    is_available BOOLEAN
);


ALTER TABLE book
ALTER COLUMN book_cover SET DATA TYPE VARCHAR(255);


