<?php
require_once 'DatabaseConfig.php';

class MemberController {
  private \PDO $pdo;

  public function __construct(DatabaseConfig $config) {
    $this->pdo = $config->getConnection();
  }

  public function getMembers(): array {
    $sql = "SELECT * FROM member ORDER BY name ASC";

    try {
      $stmt = $this->pdo->query($sql);
      return $stmt->fetchAll();
    } catch (\PDOException $e) {
      throw new \RuntimeException('Failed to fetch members:' . $e->getMessage());
    }
  }

  public function jsonResponse(array $data, int $statusCode = 200): string {
    $json = json_encode($data);
    http_response_code($statusCode);
    header('Content-Type: application/json');
    return $json;
  }

  public function handleGetMembers(): void {
    try {
      $members = $this->getMembers();
      echo $this->jsonResponse($members);
    } catch (\RuntimeException $e) {
      echo $this->jsonResponse(['error' => $e->getMessage()]);
    }
  }
}
