-- Criar banco de dados

-- Criar Tabela de usuario

-- Criar Tabela de Visitantes

    CREATE TABLE IF NOT EXISTS visitor(
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        code VARCHAR(150),
        faceData TEXT NOT NULL,
        userId INT NOT NULL,
        FOREIGN KEY (userId) REFERENCES user(id)
    );

-- Criar Tabela de Instituto

-- Criar Tabela de Administradores

-- Criar Tabela de Evento

-- Criar Tabela de Projetos

-- Criar Tabela de Votos