CREATE TABLE protocolo (
	id serial PRIMARY KEY,
	oficio VARCHAR(255) NOT NULL UNIQUE,
	origem VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	solicitante VARCHAR(255) NOT NULL,
	create_at DATE
);

insert into protocolo (oficio, origem, descricao, solicitante, create_at)
values (
	'001/2021',
	'Prefeitura Municipal de fortaleza',
	'Demandas ambientais do município',
	'Jon Snow',
	'2021-02-07 21:31:50'
);