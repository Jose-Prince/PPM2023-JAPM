<?php

$hostname = "localhost";
$username = "loginexample_user";
$password = "test1234";
$database = "loginexample_user";

$conexion = new mysqli($hostname, $username, $password, $database);

if ($conexion -> connect_error) {
    die("Error de conexión: " . $conexion -> connect_error);
}

?>