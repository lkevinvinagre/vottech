-- População da tabela de usuarios
INSERT INTO user (username, pass, email) VALUES 
    ('Alberto',MD5('123'),'email@email.com'),
    ('Bianca',MD5('231'),'email@email.com'),
    ('Carlos',MD5('173'),'email@email.com'),
    ('Eduardo',MD5('183'),'email@email.com');

--População da tabela de institutos
INSERT INTO institute (CNPJ, name) VALUES 
    ('12345678901234','FUCAPI');

-- População da tabela de administradores
INSERT INTO admin (uId, iId, role) VALUES 
    (1,1,'Coordenador Curso Informatica');

-- População da tabela de eventos
INSERT INTO event (name, description, initDate, endDate, iId) VALUES 
    ('Feira Tecnologica','Feira de apresentação de trabalhos tecnologicos', '2024-12-15', '2024-12-18', 1);

-- População da tabela de projetos
INSERT INTO project (name, description, eId) VALUES 
    ('ecoX9','Site de denuncia contra crimes ambientais', 1),
    ('Barricade','Sistema de limpeza de iguarapes', 1);

-- População da tabela de visitantes
INSERT INTO visitor (code, faceData, userId) VALUES 
    ('1234567890','FaceData', 2),
    ('1234567890','FaceData', 3),
    ('1234567890','FaceData', 4);

-- População da tabela de votos
INSERT INTO vote (vId, pId) VALUES 
    (1,1),
    (2,2),
    (3,1);