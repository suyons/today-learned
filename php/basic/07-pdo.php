<?php
$host = 'localhost';
$db = 'phpbasic';
$user = 'root';
$password = '1234';
$charset = 'utf8mb4';

$dsn = "mysql:host=$host;dbname=$db;charset=$charset";

$options = [
  PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
  PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
  PDO::ATTR_EMULATE_PREPARES => false
];

try {
  $pdo = new PDO($dsn, $user, $password, $options);
  echo "Connected successfully!<br>";

  $stmt = $pdo->prepare("INSERT INTO member (name, email) VALUES (:name, :email)");
  $stmt->execute(['name' => 'Joe Biden', 'email' => 'joe@example.com']);

  $stmt = $pdo->query("SELECT * FROM member");
  while ($row = $stmt->fetch()) {
    echo "Name: " . $row['name'] . "<br>";
    echo "Email: " . $row['email'] . "<br>";
  }
} catch (PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
}
