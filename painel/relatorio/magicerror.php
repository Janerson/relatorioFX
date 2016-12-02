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
$epidemiologia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 41 AND data between '$dataini' and '$datafim'");
$consultorio02elina = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 81 AND data between '$dataini' and '$datafim'");
$consultorio03luciano = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 82 AND data between '$dataini' and '$datafim'");
$consultorio04rogerio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 86 AND data between '$dataini' and '$datafim'");
$consultorio05marina = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 80 AND data between '$dataini' and '$datafim'");
$consultorio05rudney= mysqli_query($con,"SELECT count(*) from senha where usuario_id = 79 AND data between '$dataini' and '$datafim'");
$consultorio06luciana= mysqli_query($con,"SELECT count(*) from senha where usuario_id = 85 AND data between '$dataini' and '$datafim'");
$consultorio07medicotrabalho = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 84 AND data between '$dataini' and '$datafim'");
$consultorio09anamelia= mysqli_query($con,"SELECT count(*) from senha where usuario_id = 19 AND data between '$dataini' and '$datafim'");
$consultorio10douglas = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 74 AND data between '$dataini' and '$datafim'");
$consultorio10fernando = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 20 AND data between '$dataini' and '$datafim'");
$consultorio11harley = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 76 AND data between '$dataini' and '$datafim'");
$consultorio12fabio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 78 AND data between '$dataini' and '$datafim'");
$consultorio12valvenarques = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 77 AND data between '$dataini' and '$datafim'");
$consultorio13anamelia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 93 AND data between '$dataini' and '$datafim'");
$consultorio13isaura = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 40 AND data between '$dataini' and '$datafim'");
$psicologia14testepezinho = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 42 AND data between '$dataini' and '$datafim'");
$nutricaoraquel= mysqli_query($con,"SELECT count(*) from senha where usuario_id = 37 AND data between '$dataini' and '$datafim'");
$psicologia01citorlogia= mysqli_query($con,"SELECT count(*) from senha where usuario_id = 88 AND data between '$dataini' and '$datafim'");
$psicologia02doriane = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 87 AND data between '$dataini' and '$datafim'");
$psicologia02marcia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 26 AND data between '$dataini' and '$datafim'");
$enfermagem = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 25 AND data between '$dataini' and '$datafim'");
$servicosocial = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 35 AND data between '$dataini' and '$datafim'");
$vacina = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 36 AND data between '$dataini' and '$datafim'");
$pequenacirurgiadouglas = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 89 AND data between '$dataini' and '$datafim'");
$pequenacirurgiafabricio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 83 AND data between '$dataini' and '$datafim'");
$pequenacirurgiarudney = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 38 AND data between '$dataini' and '$datafim'");
$preparoleilamar= mysqli_query($con,"SELECT count(*) from senha where usuario_id = 94 AND data between '$dataini' and '$datafim'");
$epidemiologia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 41 AND data between '$dataini' and '$datafim'");
$odonto01francine = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 59 AND data between '$dataini' and '$datafim'");
$odonto01ivanete = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 46 AND data between '$dataini' and '$datafim'");
$odonto01marcos = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 55 AND data between '$dataini' and '$datafim'");
$odonto01roberto = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 48 AND data between '$dataini' and '$datafim'");
$odonto01sergio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 45 AND data between '$dataini' and '$datafim'");
$odonto01thereza = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 47 AND data between '$dataini' and '$datafim'");
$odonto02clayton = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 61 AND data between '$dataini' and '$datafim'");
$odonto02flaviane = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 67 AND data between '$dataini' and '$datafim'");
$odonto02sidney = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 66 AND data between '$dataini' and '$datafim'");
$odonto02tatiana = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 60 AND data between '$dataini' and '$datafim'");
$odonto03camila = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 62 AND data between '$dataini' and '$datafim'");
$odonto04anselmo = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 71 AND data between '$dataini' and '$datafim'");
$odonto04claudia = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 64 AND data between '$dataini' and '$datafim'");
$odonto04ludmilla = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 68 AND data between '$dataini' and '$datafim'");
$odonto04marcio = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 69 AND data between '$dataini' and '$datafim'");
$odonto04silene = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 70 AND data between '$dataini' and '$datafim'");
$odonto05renata = mysqli_query($con,"SELECT count(*) from senha where usuario_id = 90 AND data between '$dataini' and '$datafim'");


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
while($row = mysqli_fetch_array($eletrocardiograma)) {
  echo "<tr>";
  echo "<td>" ."Eletrocardiograma". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio02elina)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 02 - Elina". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio03luciano)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 03 - luciano". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio04rogerio)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 04 - Rogério". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio05marina)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 04 -Marina"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio05rudney)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 05 - Rudney"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio06luciana)){
  echo "<tr>";
  echo "<td>" ."Consultorio 06 - Luciana"."</td>";
    echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio07medicotrabalho)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 07 - Medico do Trabalho"."</td>";
    echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio09anamelia)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 09 - Anamelia"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio10douglas)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 10 - Douglas"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio10fernando)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 10 - Fernando"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio11harley)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 11 - Harley "."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio12fabio)) {
  echo "<tr>";
  echo "<td>" ."Consultorio 12 - Fabio"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio12valvenarques)){
  echo "<tr>";
  echo "<td>" ."Consultorio 12 - Valvenarques"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio13anamelia)){
  echo "<tr>";
  echo "<td>" ."Consultorio 1 - Anamelia"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
 while($row = mysqli_fetch_array($consultorio13isaura)){
  echo "<tr>";
  echo "<td>" ."Consultorio 13 - Isaura"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($consultorio14testepezinho)){
  echo "<tr>";
  echo "<td>" ."Consultorio 14 - Teste do Pezinho". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($nutricaoraquel)){
  echo "<tr>";
  echo "<td>" ."Nutrição - Raquel". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($psicologia01citorlogia)){
  echo "<tr>";
  echo "<td>" ."Psicologia 01 - Citologia". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($psicologia02doriane)) {
  echo "<tr>";
  echo "<td>" ."Psicologia 02 - Doriane". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($psicologia02marcia)){
  echo "<tr>";
  echo "<td>" ."Psicologia 02 - Márcia". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($enfermagem)){
  echo "<tr>";
  echo "<td>" ."Enfermagem". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($servicosocial)){
  echo "<tr>";
  echo "<td>" ."Serviço Social". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}

while($row = mysqli_fetch_array($vacina)) {
  echo "<tr>";
  echo "<td>" ."Vacina". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($pequenacirurgiadouglas)){
  echo "<tr>";
  echo "<td>" ."Pequenas Cirurgias - Douglas". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($pequenacirurgiafabricio)){
  echo "<tr>";
  echo "<td>" ."Pequena Cirurgia - Fabricio". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($pequenacirurgiarudney)){
  echo "<tr>";
  echo "<td>" ."Pequena Cirurgia - Rudney". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($preparoleilamar)){
  echo "<tr>";
  echo "<td>" ."Preparo - Leilamar". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($epidemiologia)){
  echo "<tr>";
  echo "<td>" ."Epidemiologia". "</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}


while($row = mysqli_fetch_array($odonto01francine)){
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Francine"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";

}
while($row = mysqli_fetch_array($odonto01ivanete)){
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Ivanete"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";
}
while($row = mysqli_fetch_array($odonto01marcos)){
  echo "<tr>";
  echo "<td>" ."Odonto 01 - Marcos"."</td>";
  echo "<td><center>" . $row['count(*)'] . "</center></td>";
  echo "</tr>";


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