-- [RF001]Login administrativo

SELECT * FROM users u WHERE u.username = 'ALBERTO' and u.pass = MD5('123');
SELECT * FROM admin a WHERE a.uId = 1;