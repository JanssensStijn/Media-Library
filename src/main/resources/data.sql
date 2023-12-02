INSERT INTO MOVIE (ID, IMDB, TITLE, YEAR_OF_RELEASE, PRODUCER, PRODUCTION_COMPANY)
VALUES
    (1, 'tt0111161', 'The Shawshank Redemption',  1994, 'Frank Darabont', 'Castle Rock Entertainment'),
    (2, 'tt0468569', 'The Dark Knight', 2008, 'Christopher Nolan', 'Warner Bros. Pictures'),
    (3, 'tt1375666', 'Inception', 2010, 'Christopher Nolan', 'Warner Bros. Pictures'),
    (4, 'tt0109830', 'Forrest Gump', 1994, 'Wendy Finerman', 'Paramount Pictures'),
    (5, 'tt0137523', 'Fight Club', 1999, 'Art Linson', '20th Century Fox'),
    (6, 'tt0167261', 'The Lord of the Rings - The Two Towers', 2002, 'Peter Jackson', 'New Line Cinema'),
    (7, 'tt0068646', 'The Godfather', 1972, 'Albert S. Ruddy', 'Paramount Pictures'),
    (8, 'tt0120737', 'The Lord of the Rings - The Fellowship of the Ring', 2001, 'Peter Jackson', 'New Line Cinema'),
    (9, 'tt0108052', 'Schindler`s List', 1993, 'Steven Spielberg', 'Universal Pictures'),
    (10, 'tt0088763', 'Back to the Future', 1985, 'Steven Spielberg', 'Universal Pictures');


INSERT INTO BOOK (ID, TITLE, YEAR_OF_RELEASE)
VALUES
    (1, 'To Kill a Mockingbird', 1960),
    (2, '1984', 1949),
    (3, 'The Great Gatsby', 1925),
    (4, 'Pride and Prejudice', 1813),
    (5, 'The Catcher in the Rye', 1951),
    (6, 'The Hobbit', 1937),
    (7, 'One Hundred Years of Solitude', 1967),
    (8, 'Brave New World', 1932),
    (9, 'To the Lighthouse', 1927),
    (10, 'The Lord of the Rings', 1954);

INSERT INTO AUTHOR (ID, NAME, BIRTHDAY, PLACE_OF_BIRTH, NATIONALITY, BIO)
VALUES
    (1, 'Harper Lee', '1926-04-28', 'Monroeville, Alabama, USA', 'American', 'American novelist known for "To Kill a Mockingbird."'),
    (2, 'George Orwell', '1903-06-25', 'Motihari, Bihar, India', 'English', 'English novelist and essayist, famous for "1984" and "Animal Farm."'),
    (3, 'F. Scott Fitzgerald', '1896-09-24', 'St. Paul, Minnesota, USA', 'American', 'American novelist known for "The Great Gatsby."'),
    (4, 'Jane Austen', '1775-12-16', 'Steventon, Hampshire, England', 'English', 'English novelist known for works like "Pride and Prejudice."'),
    (5, 'J.D. Salinger', '1919-01-01', 'New York City, New York, USA', 'American', 'American author, best known for "The Catcher in the Rye."'),
    (6, 'J.R.R. Tolkien', '1892-01-03', 'Bloemfontein, Orange Free State (now Free State), South Africa', 'English', 'English writer, philologist, and academic, renowned for "The Lord of the Rings."'),
    (7, 'Gabriel García Márquez', '1927-03-06', 'Aracataca, Magdalena, Colombia', 'Colombian', 'Colombian novelist and Nobel laureate, known for "One Hundred Years of Solitude."'),
    (8, 'Aldous Huxley', '1894-07-26', 'Godalming, Surrey, England', 'English', 'English writer, philosopher, and critic, famous for "Brave New World."'),
    (9, 'Virginia Woolf', '1882-01-25', 'London, England', 'English', 'English writer and modernist, known for "To the Lighthouse" and "Mrs Dalloway."');


--------------------------------------------------------------------
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (1, 1);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (2, 2);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (3, 3);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (4, 4);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (5, 5);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (6, 6);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (10, 6);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (7, 7);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (8, 8);
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (9, 9);
