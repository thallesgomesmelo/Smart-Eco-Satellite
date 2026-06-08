-- ============================================================================
-- SCRIPT DE CRIAÇÃO DO BANCO DE DADOS: SMART ECO SATELLITE
-- ============================================================================

CREATE DATABASE smart_eco_satellite;
USE smart_eco_satellite;

CREATE TABLE ambiente (
    id_ambiente INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tipo_ambiente VARCHAR(50) NOT NULL,
    quantidade_funcionarios INT NOT NULL DEFAULT 0,
    area_m2 DECIMAL(10,2) NOT NULL,
    
    PRIMARY KEY (id_ambiente),
    CONSTRAINT chk_quantidade_funcionarios CHECK (quantidade_funcionarios >= 0),
    CONSTRAINT chk_area_m2 CHECK (area_m2 > 0)
);

CREATE TABLE sensor_iot (
    id_sensor INT AUTO_INCREMENT,
    id_ambiente INT NOT NULL,
    consumo_energia DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    consumo_agua DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    temperatura_interna DECIMAL(5,2) NOT NULL,
    ocupacao_ambiente INT NOT NULL DEFAULT 0,
    status_equipamento VARCHAR(20) NOT NULL DEFAULT 'Ativo',
    
    PRIMARY KEY (id_sensor),
    FOREIGN KEY (id_ambiente) REFERENCES ambiente(id_ambiente) ON DELETE CASCADE,
    CONSTRAINT chk_consumo_energia CHECK (consumo_energia >= 0.00),
    CONSTRAINT chk_consumo_agua CHECK (consumo_agua >= 0.00),
    CONSTRAINT chk_ocupacao_ambiente CHECK (ocupacao_ambiente >= 0),
    CONSTRAINT chk_status_equipamento CHECK (status_equipamento IN ('Ativo', 'Inativo', 'Manutenção'))
);

CREATE TABLE dado_satelital (
    id_dado_satelital INT AUTO_INCREMENT,
    id_ambiente INT NOT NULL,
    temperatura_externa DECIMAL(5,2) NOT NULL,
    umidade DECIMAL(5,2) NOT NULL,
    indice_uv DECIMAL(4,1) NOT NULL,
    radiacao_solar DECIMAL(10,2) NOT NULL,
    condicao_climatica VARCHAR(50) NOT NULL,
    data_coleta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id_dado_satelital),
    FOREIGN KEY (id_ambiente) REFERENCES ambiente(id_ambiente) ON DELETE CASCADE,
    CONSTRAINT chk_umidade CHECK (umidade BETWEEN 0.00 AND 100.00),
    CONSTRAINT chk_indice_uv CHECK (indice_uv >= 0.0),
    CONSTRAINT chk_radiacao_solar CHECK (radiacao_solar >= 0.00)
);

CREATE TABLE recomendacao (
    id_recomendacao INT AUTO_INCREMENT,
    id_ambiente INT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    prioridade VARCHAR(10) NOT NULL,
    
    PRIMARY KEY (id_recomendacao),
    FOREIGN KEY (id_ambiente) REFERENCES ambiente(id_ambiente) ON DELETE CASCADE,
    CONSTRAINT chk_prioridade CHECK (prioridade IN ('Baixa', 'Média', 'Alta'))
);

-- ============================================================================
-- INDICES RECOMENDADOS PARA OTIMIZAÇÃO DE CONSULTAS (FOREIGN KEYS)
-- ============================================================================
CREATE INDEX idx_sensor_ambiente ON sensor_iot(id_ambiente);
CREATE INDEX idx_satelital_ambiente ON dado_satelital(id_ambiente);
CREATE INDEX idx_recomendacao_ambiente ON recomendacao(id_ambiente);