SELECT
  COUNT(senha.senha_id) AS total,
  usuarios.nome
FROM senha
  INNER JOIN usuarios
    ON senha.usuario_id = usuarios.usuario_id
WHERE senha.data BETWEEN '2016-11-25' AND '2016-11-27'
GROUP BY usuarios.nome