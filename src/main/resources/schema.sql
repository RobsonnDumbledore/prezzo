CREATE TABLE IF NOT EXISTS produto (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS empresa (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS usuario (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  senha varchar(50) NOT NULL,
  empresa_id bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_usuario_empresa (empresa_id),
  CONSTRAINT FK_usuario_empresa FOREIGN KEY (empresa_id) REFERENCES empresa (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS cotacao (
  id bigint NOT NULL AUTO_INCREMENT,
  empresa_id bigint NOT NULL,
  produto_id bigint NOT NULL,
  preco float NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  KEY FK_produto (produto_id),
  KEY FK_empresa (empresa_id),
  CONSTRAINT FK_empresa FOREIGN KEY (empresa_id) REFERENCES empresa (id),
  CONSTRAINT FK_produto FOREIGN KEY (produto_id) REFERENCES produto (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;