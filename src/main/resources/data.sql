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

--------------------------------------------------------------------

INSERT INTO PRODUCER (ID, PRODUCER)
VALUES
    (1, 'Frank Darabont'),
    (2, 'Christopher Nolan'),
    (3, 'Wendy Finerman'),
    (4, 'Art Linson'),
    (5, 'Peter Jackson'),
    (6, 'Albert S. Ruddy'),
    (7, 'Steven Spielberg');

INSERT INTO PRODUCTION_COMPANY (ID, PRODUCTION_COMPANY)
VALUES
    (1, 'Castle Rock Entertainment'),
    (2, 'Warner Bros. Pictures'),
    (3, 'Paramount Pictures'),
    (4, '20th Century Fox'),
    (5, 'New Line Cinema'),
    (6, 'Paramount Pictures'),
    (7, 'Universal Pictures');

--------------------------------------------------------------------

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

--------------------------------------------------------------------
INSERT INTO AUTHOR (ID, NAME)
VALUES
    (1, 'Harper Lee'),
    (2, 'George Orwell'),
    (3, 'F. Scott Fitzgerald'),
    (4, 'Jane Austen'),
    (5, 'J.D. Salinger'),
    (6, 'J.R.R. Tolkien'),
    (7, 'Gabriel García Márquez'),
    (8, 'Aldous Huxley'),
    (9, 'Virginia Woolf');


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
