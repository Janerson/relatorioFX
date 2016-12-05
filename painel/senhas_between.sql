/*SELECT * FROM senha */
/*SELECT * FROM servicos s*/
SELECT * FROM senha s
  WHERE s.servico_id = 8
  AND s.data BETWEEN '2016-11-25' AND '2016-11-27'
  