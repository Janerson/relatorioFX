SELECT
  COUNT(senha.senha_id) AS total,
  servicos.descricao AS Servico
FROM senha
  INNER JOIN servicos
    ON senha.servico_id = servicos.servico_id
  WHERE senha.data BETWEEN '2016-11-25' AND '2016-11-27'
GROUP BY servicos.descricao