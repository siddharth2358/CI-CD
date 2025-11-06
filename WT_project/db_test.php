<?php
$host = '127.0.0.1';
$user = 'root';
$pass = '';
$db   = 'login_register';

$conn = @mysqli_connect($host, $user, $pass);
if (!$conn) {
    echo "MySQL connection failed: " . mysqli_connect_error();
    exit;
}

if (!mysqli_select_db($conn, $db)) {
    echo "DB '$db' not found (or no access).";
} else {
    echo "Connected to DB '$db' successfully.";
}
mysqli_close($conn);
?>