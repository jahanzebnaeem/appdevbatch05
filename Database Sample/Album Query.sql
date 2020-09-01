-- Insert Statement
-- INSERT INTO Singer (Name) VALUES ('Ali Hayder');
-- INSERT INTO Albums (Name, url, SingerID) VALUES ('Taylor Swift', 'https://www.amazon.com/Taylor-Swift/dp/B0014I4KH6', 1);
-- INSERT INTO AlbumImages (imageURL, thumbnailURL, AlbumID) VALUES ('https://images-na.ssl-images-amazon.com/images/I/61McsadO1OL.jpg', 'https://i.imgur.com/K3KJ3w4h.jpg', 1);

-- Read Statement
-- SELECT * FROM Singer;
-- SELECT * FROM Albums;
-- SELECT * FROM AlbumImages;

/*
SELECT S.Name Singer, A.Name AlbumName, A.url ALink 
	FROM Singer S INNER JOIN Albums A 
		ON S.id = A.SingerID;
*/

-- SELECT S.Name title, A.Name artist, A.url url, AI.imageURL image, AI.thumbnailURL thumbnail_image
-- 	FROM Singer S INNER JOIN Albums A
-- 		ON S.id = A.SingerID
-- 	INNER JOIN AlbumImages AI
-- 		ON A.id = AI.AlbumID
-- 	WHERE S.isDeleted = 0;

-- SELECT S.Name title, A.Name artist, A.url url
-- 	FROM Singer S LEFT JOIN Albums A
-- 		ON S.id = A.SingerID
-- 	WHERE S.isDeleted = 0
-- 	ORDER BY title ASC;
	
-- SELECT COUNT(*) FROM Singer;

SELECT * FROM albumInfo;

-- Update Statement
-- UPDATE AlbumImages SET imageURL='https://images-na.ssl-images-amazon.com/images/I/61McsadO1OL.jpg' 
-- 	WHERE id = 1;


-- Delete Statement
-- DELETE FROM AlbumImages WHERE id = 1;

-- Create View
-- CREATE VIEW albumInfo
-- AS
-- SELECT S.Name title, A.Name artist, A.url url, AI.imageURL image, AI.thumbnailURL thumbnail_image
-- 	FROM Singer S INNER JOIN Albums A
-- 		ON S.id = A.SingerID
-- 	INNER JOIN AlbumImages AI
-- 		ON A.id = AI.AlbumID
-- 	WHERE S.isDeleted = 0;
