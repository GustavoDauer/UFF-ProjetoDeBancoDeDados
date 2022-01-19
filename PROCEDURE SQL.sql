WITH
	Livros AS (	SELECT *
		FROM MATERIAL T1
		INNER JOIN Exemplar T2 on T1.codigo = T2.material_codigo
		INNER JOIN Livro T3 on T1.codigo = T3.material_codigo
		)
	Revistas AS (	SELECT *
		FROM MATERIAL T1
		INNER JOIN Exemplar T2 on T1.codigo = T2.material_codigo
		INNER JOIN Revista T3 on T1.codigo = T3.material_codigo
		)
	Cds AS (	SELECT *
		FROM MATERIAL T1
		INNER JOIN Exemplar T2 on T1.codigo = T2.material_codigo
		INNER JOIN Cd T3 on T1.codigo = T3.material_codigo
		)
	Reservas as (SELECT T1.MATERIAL_CODIGO, COUNT(*) AS CNT
			FROM LIVRO T4
			INNER JOIN RESERVA T5 ON T4.MATERIAL_CODIGO = T5.LIVRO_MATERIAL_CODIGO
			INNER JOIN OPERACAO T6 ON T6.NUMERO = T5.OPERACAO_NUMERO
			WHERE (T6."DATA"=SYSDATE) < 3
			GROUP BY T1.MATERIAL_CODIGO)

SELECT 'Livro' as tipo, NVL(T2.CNT, 0) FROM Livros T1
LEFT JOIN RESERVAS T2 ON T1.CODIGO = T2.LIVRO_MATERIAL_CODIGO
