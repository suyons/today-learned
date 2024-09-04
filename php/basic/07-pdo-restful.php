<?php
// 파일 이름 index.php로 변경 필요
require_once 'MemberController.php';

$config = new DatabaseConfig(
  host: 'localhost',
  dbname: 'phpbasic',
  username: 'root',
  password: '1234',
  charset: 'utf8mb4'
);

$memberController = new MemberController($config);

$requestMethod = $_SERVER['REQUEST_METHOD'];
$requestUri = $_SERVER['REQUEST_URI'];

if ($requestMethod === 'GET' && $requestUri === '/member') {
  $memberController->handleGetMembers();
} else {
  http_response_code(404);
  header('Content-Type: application/json');
  echo json_encode(['error' => 'Endpoint not found']);
}
