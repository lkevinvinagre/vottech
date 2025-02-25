-- Criar banco de dados

-- Criar Tabela de usuario

    CREATE TABLE IF NOT EXISTS user(
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(150) NOT NULL,
        pass TEXT NOT NULL,
        email VARCHAR(150) NOT NULL,
        status CHAR(1) DEFAULT 'A'
    );

-- Criar Tabela de Visitantes

-- Criar Tabela de Instituto

-- Criar Tabela de Administradores

-- Criar Tabela de Evento

-- Criar Tabela de Projetos

-- Criar Tabela de Votos