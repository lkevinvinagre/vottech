-- Criar banco de dados
-- Criar Tabela de usuario
CREATE TABLE IF NOT EXISTS users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    pass TEXT NOT NULL,
    email VARCHAR(150) NOT NULL,
    status VARCHAR(1) DEFAULT 'A'
);

-- Criar Tabela de Visitantes
CREATE TABLE IF NOT EXISTS visitors(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(150),
    faceData TEXT NOT NULL,
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(id)
);

-- Criar Tabela de Instituto
CREATE TABLE IF NOT EXISTS institutes(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CNPJ VARCHAR(21),
    name VARCHAR(255) NOT NULL
);

-- Criar Tabela de Administradores
CREATE TABLE IF NOT EXISTS admins(
     uId INT NOT NULL,
     iId INT NOT NULL,
     role VARCHAR(255) NOT NULL,
     FOREIGN KEY (uId) REFERENCES users(id),
     FOREIGN KEY (iId) REFERENCES institutes(Id),
     PRIMARY KEY (uId, iId)
);

-- Criar Tabela de Evento
CREATE TABLE IF NOT EXISTS events(
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     description TEXT NOT NULL,
     initDate DATE NOT NULL,
     endDate DATE NOT NULL,
     iId INT NOT NULL,
     FOREIGN KEY (iId) REFERENCES institutes(id)
);

-- Criar Tabela de Projetos  
CREATE TABLE IF NOT EXISTS projects(
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     description TEXT NOT NULL,
     eId INT NOT NULL,
     FOREIGN KEY (eId) REFERENCES events(id)
);

-- Criar Tabela de Votos
CREATE TABLE IF NOT EXISTS votes(
     vId INT NOT NULL,
     pId INT NOT NULL,
     voteDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (vId) REFERENCES visitors(id),
     FOREIGN KEY (pId) REFERENCES projects(id),
     PRIMARY KEY (vId, pId);
);