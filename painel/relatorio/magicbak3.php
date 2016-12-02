<?php
$dataini = $_POST['dataini'];
$partes = explode("-", $dataini);
$diaini = $partes[2];
$mesini =
$anoini = $partes[0]; $partes[1];

$datafim = $_POST['datafim'];
$partes = explode("-", $datafim);
$diafim = $partes[2];
$mesfim = $partes[1];
$anofim = $partes[0];


$con=mysqli_connect("10.10.12.250","DISPLAY","DISPLAY","painel2");
// Check connection
if (mysqli_connect_error()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$preferencial = mysqli_query($con,"SELECT count(*) from senha where servico_id = 1 AND data between '$dataini' and '$datafim'");
$normal = mysqli_query($con,"SELECT count(*) from senha where servico_id = 2 AND data between '$dataini' and '$datafim'");
$valeexame = mysqli_query($con,"SELECT count(*) from senha where servico_id = 3 AND data between '$dataini' and '$datafim'");
$farmacia = mysqli_query($con,"SELECT count(*) from senha where servico_id = 4 AND data between '$dataini' and '$datafim'");


echo "<h3> Dados referentes ao periodo de ".$diaini."/".$mesini."/".$anoini." ate ".$diafim."/".$mesfim."/".$anofim."</h3>";
echo "<br/>";
echo "<table border='1'>
<tr>
<th>Servico</th>
<th>Quantidade de senhas atendidas por servico</th>
</tr>";

while($row = mysqli_fetch_array($preferencial)) {
  echo "<tr>";
  echo "<td>" ."Preferencial". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($normal)) {
  echo "<tr>";
  echo "<td>" ."Normal". "</td>";
  echo "<td><center>" . $row['0'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($valeexame)) {
  echo "<tr>";
  echo "<td>" ."Vale Exame". "</td>";
  echo "<td><center>" . $row['0'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($farmacia)) {
  echo "<tr>";
  echo "<td>" ."Farmacia". "</td>";
  echo "<td><center>" . $row['0'] . "</center></td>";
  echo "</tr>";
}
echo "</table>";

$guiche01 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 2 AND data between '$dataini' and '$datafim'");
$guiche02 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 29 AND data between '$dataini' and '$datafim'");
$guiche03 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 32 AND data between '$dataini' and '$datafim'");
$guiche04 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 30 AND data between '$dataini' and '$datafim'");
$valeexame01 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 23 AND data between '$dataini' and '$datafim'");
$valeexame02 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 31 AND data between '$dataini' and '$datafim'");
$valeexame03 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 58 AND data between '$dataini' and '$datafim'");
$farmacia01 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 33 AND data between '$dataini' and '$datafim'");
$farmacia02 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 34 AND data between '$dataini' and '$datafim'");
$consultorio01 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 9 AND data between '$dataini' and '$datafim'");
$consultorio02 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 10 AND data between '$dataini' and '$datafim'");
$consultorio03 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 11 AND data between '$dataini' and '$datafim'");
$consultorio04 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 13 AND data between '$dataini' and '$datafim'");
$consultorio05 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 14 AND data between '$dataini' and '$datafim'");
$consultorio06 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 15 AND data between '$dataini' and '$datafim'");
$consultorio07 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 16 AND data between '$dataini' and '$datafim'");
$consultorio08 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 18 AND data between '$dataini' and '$datafim'");
$consultorio09 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 19 AND data between '$dataini' and '$datafim'");
$consultorio10 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 20 AND data between '$dataini' and '$datafim'");
$consultorio11 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 21 AND data between '$dataini' and '$datafim'");
$consultorio12 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 22 AND data between '$dataini' and '$datafim'");
$consultorio13 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 40 AND data between '$dataini' and '$datafim'");
$consultorio14 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 42 AND data between '$dataini' and '$datafim'");
$nutricao = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 37 AND data between '$dataini' and '$datafim'");
$psicologia01 = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 26 AND data between '$dataini' and '$datafim'");
$enfermagem = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 25 AND data between '$dataini' and '$datafim'");
$servicosocial = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 35 AND data between '$dataini' and '$datafim'");
$vacina = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 36 AND data between '$dataini' and '$datafim'");
$cirurgia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 38 AND data between '$dataini' and '$datafim'");
$preparo = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 39 AND data between '$dataini' and '$datafim'");
$epidemiologia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 41 AND data between '$dataini' and '$datafim'");
$odonto01francine = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 59 AND data between '$dataini' and '$datafim'");
$odonto01ivanete = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 46 AND data between '$dataini' and '$datafim'");
$odonto01marcos = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 55 AND data between '$dataini' and '$datafim'");
$odonto01roberto = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 48 AND data between '$dataini' and '$datafim'");
$odonto01sergio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 45 AND data between '$dataini' and '$datafim'");
$consultorio10rogerio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 75 AND data between '$dataini' and '$datafim'");
$consultorio10douglas = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 74 AND data between '$dataini' and '$datafim'");
$consultorio12valvenarques = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 77 AND data between '$dataini' and '$datafim'");
$consultorio12fabio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 78 AND data between '$dataini' and '$datafim'");
$consultorio05rudney = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 79 AND data between '$dataini' and '$datafim'");
$consultorio05marina = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 80 AND data between '$dataini' and '$datafim'");
$consultorio11harley = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 76 AND data between '$dataini' and '$datafim'");
$odonto01thereza = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 47 AND data between '$dataini' and '$datafim'");
$odonto02clayton = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 61 AND data between '$dataini' and '$datafim'");
$odonto02flaviane = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 67 AND data between '$dataini' and '$datafim'");
$odonto02sidney = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 66 AND data between '$dataini' and '$datafim'");
$odonto02tatiana = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 60 AND data between '$dataini' and '$datafim'");
$odonto03camila = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 62 AND data between '$dataini' and '$datafim'");
$odonto03giovana = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 63 AND data between '$dataini' and '$datafim'");
$odonto04anselmo = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 71 AND data between '$dataini' and '$datafim'");
$odonto04claudia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 64 AND data between '$dataini' and '$datafim'");
$odonto04ludmilla = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 68 AND data between '$dataini' and '$datafim'");
$odonto04marcio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 69 AND data between '$dataini' and '$datafim'");
$odonto04silene = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 70 AND data between '$dataini' and '$datafim'");
$odonto05renata = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 65 AND data between '$dataini' and '$datafim'");


echo "<br/><br/>";
echo "<table border='2'>
<tr>
<th> Atendente </th>
<th>Quantidade de senhas finalizadas por guiche</th>
</tr>";

while($row = mysqli_fetch_array($guiche01)) {
  echo "<tr>";
  echo "<td>" ."Guiche 01". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($guiche02)) {
  echo "<tr>";
  echo "<td>" ."Guiche 02". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}

while($row = mysqli_fetch_array($guiche03)) {
  echo "<tr>";
  echo "<td>" ."Guiche 03". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($guiche04)) {
  echo "<tr>";
  echo "<td>" ."Guiche 04". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($valeexame01)) {
  echo "<tr>";
  echo "<td>" ."Vale Exame 01". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($valeexame02)) {
  echo "<tr>";
  echo "<td>" ."Vale Exame 02". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($valeexame03)) {
  echo "<tr>";
  echo "<td>" ."Vale Exame 03". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($farmacia01)) {
  echo "<tr>";
  echo "<td>" ."Farmacia 01". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($farmacia02)) {
  echo "<tr>";
  echo "<td>" ."Farmacia 02". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio01)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 01". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio02)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 02". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio03)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 03". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio04)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 04". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio05)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 05". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio06)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 06". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio07)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 07". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio08)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 08". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio09)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 09". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio10)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 10". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio11)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 11". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio12)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 12". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio10douglas)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 10 - Douglas". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio10rogerio)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 10 - Rogerio". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
 while($row = mysqli_fetch_array($consultorio05rudney)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 05 - Rudney". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio05marina)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 05 - Marina". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio11harley)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 11 - Harley". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio12valvenarques)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 12 - Valvenarques". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio13)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 13". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio14)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 14". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($nutricao)) {
  echo "<tr>";
  echo "<td>" ."Nutricao". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($psicologia01)) {
  echo "<tr>";
  echo "<td>" ."Psicologia 01". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($enfermagem)) {
  echo "<tr>";
  echo "<td>" ."Enfermagem". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($servicosocial)) {
  echo "<tr>";
  echo "<td>" ."Servico Social". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($vacina)) {
  echo "<tr>";
  echo "<td>" ."Vacina". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($cirurgia)) {
  echo "<tr>";
  echo "<td>" ."Pequenas Cirurgias". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($preparo)) {
  echo "<tr>";
  echo "<td>" ."Preparo". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($epidemiologia)) {
  echo "<tr>";
  echo "<td>" ."Epidemiologia". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto01francine)) {
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Francine". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto01ivanete)) {
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Ivanete". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto01marcos)) {
  echo "<tr>";
  echo "<td>" ."Odonto 01 - marcos". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto01roberto)) {
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Roberto". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto01sergio)) {
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Sergio". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto01thereza)) {
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Thereza". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto02clayton)) {
  echo "<tr>";
  echo "<td>" ."Odonto 02 - Clayton". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto02flaviane)) {
  echo "<tr>";
  echo "<td>" ."Odonto 02 - Flaviane". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto02sidney)) {
  echo "<tr>";
  echo "<td>" ."Odonto 02 - Sidney". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto02tatiana)) {
  echo "<tr>";
  echo "<td>" ."Odonto 02 - Tatiana". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto03camila)) {
  echo "<tr>";
  echo "<td>" ."Odonto 03 - Camila". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto03giovana)) {
  echo "<tr>";
  echo "<td>" ."Odonto 03 - Giovana". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto04anselmo)) {
  echo "<tr>";
  echo "<td>" ."Odonto 04 - Anselmo". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto04claudia)) {
  echo "<tr>";
  echo "<td>" ."Odonto 04 - Claudia". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto04ludmilla)) {
  echo "<tr>";
  echo "<td>" ."Odonto 04 - Ludmilla". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto04marcio)) {
  echo "<tr>";
  echo "<td>" ."Odonto 04 - Marcio". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto04silene)) {
  echo "<tr>";
  echo "<td>" ."Odonto 04 - Silene". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto05renata)) {
  echo "<tr>";
  echo "<td>" ."Odonto 05 - Renata". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
echo "</table>";


mysqli_close($con);
echo "<br/>";
echo "<input type=\"button\" value=\"Voltar\" onClick=\"history.go(-1)\">";


?>
