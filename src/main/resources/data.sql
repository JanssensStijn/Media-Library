INSERT INTO MOVIE (IMDB, TITLE, YEAR_OF_RELEASE, TRAILER_LINK)
VALUES
    ('tt0111161', 'The Shawshank Redemption', 1994, '6hB3S9bIaco'),
    ('tt0468569', 'The Dark Knight', 2008, 'EXeTwQWrcwY'),
    ('tt1375666', 'Inception', 2010, '8hP9D6kZseM'),
    ('tt0109830', 'Forrest Gump', 1994, 'bLvqoHBptjg'),
    ('tt0137523', 'Fight Club', 1999, 'SUXWAEX2jlg'),
    ('tt0167261', 'The Lord of the Rings - The Two Towers', 2002, 'LbfMDwc4azU'),
    ('tt0068646', 'The Godfather', 1972, '2neD0MYBaL4'),
    ('tt0120737', 'The Lord of the Rings - The Fellowship of the Ring', 2001, '_e8QGuG50ro'),
    ('tt0108052', 'Schindler`s List', 1993, 'JdRGC-w9syA'),
    ('tt0088763', 'Back to the Future', 1985, 'qvsgGtivCgs');


--------------------------------------------------------------------

INSERT INTO PRODUCER (NAME)
VALUES
    ('Frank Darabont'),
    ('Christopher Nolan'),
    ('Wendy Finerman'),
    ('Art Linson'),
    ('Peter Jackson'),
    ('Albert S. Ruddy'),
    ('Steven Spielberg');

--------------------------------------------------------------------

INSERT INTO PRODUCTION_COMPANY (NAME)
VALUES
    ('Castle Rock Entertainment'),
    ('Warner Bros. Pictures'),
    ('Paramount Pictures'),
    ('20th Century Fox'),
    ('New Line Cinema'),
    ('Universal Pictures');

--------------------------------------------------------------------

INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Shawshank Redemption', select id from production_company where name =  'Castle Rock Entertainment');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Dark Knight', select id from production_company where name = 'Warner Bros. Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Inception', select id from production_company where name =  'Warner Bros. Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Forrest Gump', select id from production_company where name =  'Paramount Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Fight Club', select id from production_company where name =  '20th Century Fox');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Two Towers', select id from production_company where name =  'New Line Cinema');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Godfather', select id from production_company where name =  'Paramount Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Fellowship of the Ring', select id from production_company where name =  'New Line Cinema');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Schindler`s List', select id from production_company where name =  'Universal Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Back to the Future', select id from production_company where name =  'Universal Pictures');

--------------------------------------------------------------------

INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Shawshank Redemption', select id from producer where name = 'Frank Darabont');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Dark Knight', select id from producer where name = 'Christopher Nolan');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Inception', select id from producer where name = 'Christopher Nolan');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Forrest Gump', select id from producer where name = 'Wendy Finerman');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Fight Club', select id from producer where name = 'Art Linson');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Two Towers', select id from producer where name = 'Peter Jackson');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Godfather', select id from producer where name = 'Albert S. Ruddy');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Fellowship of the Ring', select id from producer where name = 'Peter Jackson');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Schindler`s List', select id from producer where name = 'Steven Spielberg');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Back to the Future', select id from producer where name = 'Steven Spielberg');

--------------------------------------------------------------------

INSERT INTO BOOK (TITLE, YEAR_OF_RELEASE)
VALUES
    ('To Kill a Mockingbird', 1960),
    ('1984', 1949),
    ('The Great Gatsby', 1925),
    ('Pride and Prejudice', 1813),
    ('The Catcher in the Rye', 1951),
    ('The Hobbit', 1937),
    ('One Hundred Years of Solitude', 1967),
    ('Brave New World', 1932),
    ('To the Lighthouse', 1927),
    ('The Lord of the Rings', 1954);

--------------------------------------------------------------------
INSERT INTO AUTHOR (NAME)
VALUES
    ('Harper Lee'),
    ('George Orwell'),
    ('F. Scott Fitzgerald'),
    ('Jane Austen'),
    ('J.D. Salinger'),
    ('J.R.R. Tolkien'),
    ('Gabriel García Márquez'),
    ('Aldous Huxley'),
    ('Virginia Woolf');


--------------------------------------------------------------------

INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'To Kill a Mockingbird', select id from author where name = 'Harper Lee');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = '1984', select id from author where name = 'George Orwell');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Great Gatsby', select id from author where name = 'F. Scott Fitzgerald');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'Pride and Prejudice', select id from author where name = 'Jane Austen');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Catcher in the Rye', select id from author where name = 'J.D. Salinger');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Hobbit', select id from author where name = 'J.R.R. Tolkien');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'One Hundred Years of Solitude', select id from author where name = 'Gabriel García Márquez');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'Brave New World', select id from author where name = 'Aldous Huxley');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'To the Lighthouse', select id from author where name = 'Virginia Woolf');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Lord of the Rings', select id from author where name = 'J.R.R. Tolkien');
