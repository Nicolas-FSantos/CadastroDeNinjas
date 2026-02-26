-- V2: Migration para adicionar a coluna de rank na tabela de cadastros

ALTER TABLE tb_cadastros
ADD COLUMN rank VARCHAR(255);