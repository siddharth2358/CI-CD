<?php

$hostName   = "localhost";
$dbUser     = "root";
$dbPassword = "";
$dbName     = "login_register";

// connect to MySQL server first (no database)
$conn = mysqli_connect($hostName, $dbUser, $dbPassword);
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// create database if it doesn't exist
$createDbSql = "CREATE DATABASE IF NOT EXISTS `$dbName` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci";
if (!mysqli_query($conn, $createDbSql)) {
    die("Failed to create database: " . mysqli_error($conn));
}

// select the database
mysqli_select_db($conn, $dbName);

// set charset
mysqli_set_charset($conn, 'utf8mb4');

// optional: check final connection
if (!$conn) {
    die("Something went wrong: " . mysqli_connect_error());
}

?>