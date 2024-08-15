-- schema.sql: Creates the tables explicitly

CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publication_year INT,
    isbn VARCHAR(13)
);

CREATE TABLE patron (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    contact_info VARCHAR(255)
);

CREATE TABLE borrowing_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT,
    patron_id BIGINT,
    borrow_date DATE,
    return_date DATE,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book(id),
    CONSTRAINT fk_patron FOREIGN KEY (patron_id) REFERENCES patron(id)
);
