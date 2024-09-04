<?php
class DatabaseConfig {
  private string $host;
  private string $dbname;
  private string $username;
  private string $password;
  private string $charset;

  public function __construct(
    string $host,
    string $dbname,
    string $username,
    string $password,
    string $charset
  ) {
    $this->host = $host;
    $this->dbname = $dbname;
    $this->username = $username;
    $this->password = $password;
    $this->charset = $charset;
  }

  public function getConnection(): \PDO {
    $dsn = "mysql:host={$this->host};dbname={$this->dbname};charset={$this->charset}";
    $options = [
      PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
      PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
      PDO::ATTR_EMULATE_PREPARES => false
    ];

    try {
      return new \PDO($dsn, $this->username, $this->password, $options);
    } catch (\PDOException $e) {
      throw new \RuntimeException('Database connection failed: ' . $e->getMessage());
    }
  }
}
