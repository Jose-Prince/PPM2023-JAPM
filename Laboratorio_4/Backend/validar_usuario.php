<?php

include 'connection.php';
$usu_usuario=$_POST['usuario'];
$usu_password=$_POST['password'];

$sentencia = $connection -> prepare("SELECT * FROM usuario WHERE usu_usuario=? AND usu_password=?");
$sentencia->bind_param('ss',$usu_usuario,$usu_password);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
    echo json_encode($fila,JSON_UNESCAPED_UNICODE);
}
$sentencia->close();
$connection->close()

?>