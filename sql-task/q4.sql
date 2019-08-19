-- INSERT INTO book (title) VALUES ('The Pragmatic Programmer');
-- INSERT INTO member (name) VALUES ('JiaXuan Hon');
-- INSERT INTO checkout_item (member_id, book_id) VALUES ((SELECT id FROM member WHERE name='JiaXuan Hon'), (SELECT id FROM book WHERE title='The Pragmatic Programmer'));

SELECT name FROM member WHERE id=(SELECT member_id FROM checkout_item WHERE book_id=(SELECT id FROM book WHERE title='The Pragmatic Programmer'));