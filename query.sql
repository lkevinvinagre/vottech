-- [RF001]Login administrativo
SELECT * FROM user u WHERE u.username = 'ALBERTO' and u.pass = MD5('123');
SELECT * FROM admin a WHERE a.uId = 1;

--[RF06]Listar Eventos da Instituição
SELECT * FROM event e WHERE e.iId = 1;

--[RF07]Listar Projetos do Evento
SELECT * FROM project p WHERE p.eId = 1;

--[RF08]Listar Visitantes que votaram nos projetos
SELECT vId FROM vote v WHERE v.pId = 1;
SELECT uId FROM visitor v WHERE v.id = 1;
SELECT username FROM user u WHERE u.id = 1;
