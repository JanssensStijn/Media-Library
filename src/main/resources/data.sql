INSERT INTO MOVIE (IMDB, TITLE, YEAR_OF_RELEASE, TRAILER_LINK, DESCRIPTION)
VALUES
    ('tt0111161', 'The Shawshank Redemption', 1994, '6hB3S9bIaco', 'Frank Darabont''s adaptation of Stephen King''s novella tells the poignant story of hope and redemption within the confines of Shawshank State Penitentiary.'),
    ('tt0468569', 'The Dark Knight', 2008, 'EXeTwQWrcwY', 'Christopher Nolan''s superhero epic features the iconic battle between Batman and the Joker, exploring themes of chaos and morality.'),
    ('tt1375666', 'Inception', 2010, '8hP9D6kZseM', 'Christopher Nolan''s mind-bending thriller explores the concept of dreams within dreams and the power of the mind.'),
    ('tt0109830', 'Forrest Gump', 1994, 'bLvqoHBptjg', 'Robert Zemeckis''s heartwarming film follows Forrest Gump''s extraordinary life journey, intersecting with historical events.'),
    ('tt0137523', 'Fight Club', 1999, 'SUXWAEX2jlg', 'David Fincher''s cult classic explores the impact of consumer culture on identity and the consequences of rebellion.'),
    ('tt0167261', 'The Lord of the Rings - The Two Towers', 2002, 'LbfMDwc4azU', 'Peter Jackson continues the epic fantasy saga, as the fellowship faces new challenges in the quest to destroy the One Ring.'),
    ('tt0068646', 'The Godfather', 1972, '2neD0MYBaL4', 'Francis Ford Coppola''s crime epic follows the Corleone family''s rise and struggles in the world of organized crime.'),
    ('tt0120737', 'The Lord of the Rings - The Fellowship of the Ring', 2001, '_e8QGuG50ro', 'The first installment in Peter Jackson''s trilogy introduces the quest to destroy the One Ring and the formation of the fellowship.'),
    ('tt0108052', 'Schindler''s List', 1993, 'JdRGC-w9syA', 'Steven Spielberg''s powerful film tells the true story of Oskar Schindler, a German businessman who saved over a thousand Jewish lives during the Holocaust.'),
    ('tt0088763', 'Back to the Future', 1985, 'WRrCVyT09ow', 'Robert Zemeckis''s sci-fi comedy follows Marty McFly as he accidentally travels back in time and disrupts the space-time continuum, leading to hilarious and heartwarming adventures');

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
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Schindler''s List', select id from production_company where name =  'Universal Pictures');
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
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Schindler''s List', select id from producer where name = 'Steven Spielberg');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Back to the Future', select id from producer where name = 'Steven Spielberg');

--------------------------------------------------------------------

INSERT INTO BOOK (TITLE, YEAR_OF_RELEASE, DESCRIPTION)
VALUES
    ('To Kill a Mockingbird', 1960, 'Harper Lee’s classic novel explores racial injustice and moral growth in the American South during the 1930s.'),
    ('1984', 1949, 'George Orwell''s dystopian novel depicts a totalitarian future society marked by government surveillance and thought control.'),
    ('The Great Gatsby', 1925, 'F. Scott Fitzgerald''s masterpiece explores themes of wealth, love, and the American Dream during the Roaring Twenties.'),
    ('Pride and Prejudice', 1813, 'Jane Austen''s timeless novel revolves around the themes of love, class, and societal expectations in early 19th-century England.'),
    ('The Catcher in the Rye', 1951, 'J.D. Salinger''s coming-of-age novel follows the adventures of Holden Caulfield, a disenchanted teenager navigating the challenges of adulthood.'),
    ('The Hobbit', 1937, 'J.R.R. Tolkien''s fantasy novel takes readers on a journey with Bilbo Baggins as he joins a quest to reclaim treasure guarded by the dragon Smaug.'),
    ('One Hundred Years of Solitude', 1967, 'Gabriel García Márquez''s magical realist novel chronicles the Buendía family''s history in the fictional town of Macondo.'),
    ('Brave New World', 1932, 'Aldous Huxley''s dystopian novel explores a future society where conformity and consumerism reign supreme.'),
    ('To the Lighthouse', 1927, 'Virginia Woolf''s modernist novel delves into the complexities of human relationships and the passage of time.'),
    ('The Lord of the Rings', 1954, 'J.R.R. Tolkien''s epic fantasy trilogy follows the quest to destroy the One Ring and save Middle-earth from the dark forces of Sauron.');


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

--------------------------------------------------------------------

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('admin', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('admin', 'ADMIN');
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('user', '$2a$10$9TeBFudS7HsgCa4sSvP//O627sMq.KiTFrOr8IzrVlYw5c8aoKzNm', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('user', 'USER');