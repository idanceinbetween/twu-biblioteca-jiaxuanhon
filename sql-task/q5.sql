SELECT DISTINCT name FROM member INNER JOIN checkout_item ON member.id=(SELECT member_id FROM checkout_item GROUP BY member_id HAVING COUNT(movie_id)>1);
SELECT DISTINCT name FROM member INNER JOIN checkout_item ON member.id=(SELECT member_id FROM checkout_item GROUP BY member_id HAVING COUNT(book_id)>1);
