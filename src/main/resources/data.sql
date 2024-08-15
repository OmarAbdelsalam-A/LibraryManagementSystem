INSERT INTO book (title, author, publication_year, isbn) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 1925, '9780743273565'),
('1984', 'George Orwell', 1949, '9780451524935'),
('To Kill a Mockingbird', 'Harper Lee', 1960, '9780061120084'),
('Moby-Dick', 'Herman Melville', 1851, '9781503280786');

INSERT INTO patron (name, contact_info) VALUES
('John Doe', 'johndoe@example.com'),
('Jane Smith', 'janesmith@example.com'),
('Emily Johnson', 'emilyjohnson@example.com');

INSERT INTO borrowing_record (book_id, patron_id, borrow_date, return_date) VALUES
(1, 1, '2024-08-01', NULL),
(2, 2, '2024-08-05', '2024-08-12'),
(3, 3, '2024-08-07', NULL);