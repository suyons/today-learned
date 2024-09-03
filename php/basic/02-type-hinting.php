<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Type Hinting</title>
</head>

<body>
  <h2>원시 자료형</h2>
  <?php
  function addNumbers(int $a, int $b): int {
    return $a + $b;
  }

  function greetUser(string $name): string {
    return "Hello, " . $name;
  }

  /* 정상적인 호출 */
  echo "int: " . addNumbers(5, 10) . "<br>";
  echo "string: " . greetUser("Alice") . "<br>";

  /* Uncaught TypeError */
  // echo "int: " . addNumbers("five", "ten") . "<br>";
  // echo "string: " . greetUser(123) . "<br>";
  ?>
  <h2>참조 자료형</h2>
  <?php
  class Product {
    private string $name;
    private int $price;

    public function __construct(string $name, int $price) {
      $this->name = $name;
      $this->price = $price;
    }

    public function getName(): string {
      return $this->name;
    }

    public function getPrice(): int {
      return $this->price;
    }
  }

  class Factory {
    private array $products = [];

    public function addProduct(Product $product): void {
      $this->products[] = $product;
    }

    public function getProducts(): array {
      return $this->products;
    }

    public function displayProducts(): void {
      foreach ($this->products as $product) {
        echo "Product Name: " . $product->getName() . "<br>";
        echo "Product Price: " . $product->getPrice() . "<br><br>";
      }
    }
  }

  // Factory 클래스 사용 예시
  $factory = new Factory();

  $product1 = new Product("Laptop", 999);
  $product2 = new Product("Smartphone", 499);

  $factory->addProduct($product1);
  $factory->addProduct($product2);

  /* Uncaught TypeError */
  // $factory->addProduct("Invalid Product");
  // $factory->addProduct(new stdClass());

  $factory->displayProducts();
  ?>
</body>

</html>