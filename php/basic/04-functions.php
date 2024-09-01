<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Functions</title>
</head>

<body>
  <h2>Return Values</h2>
  <?php
  function multiply($a, $b) {
    return $a * $b;
  }
  $product = multiply(4, 5);
  echo $product;
  ?>
  <h2>Default Parameter Values</h2>
  <?php
  function greet($name = "Guest") {
    echo "Hello, $name!<br>";
  }
  greet();
  greet("Alice");
  ?>
  <h2>Variable-Length Argument Lists</h2>
  <?php
  // array_sum() 함수는 기본 제공 API이다.
  function sum(...$numbers) {
    return array_sum($numbers);
  }
  echo sum(1, 2, 3) . "<br>";
  echo sum(1, 2, 3, 4, 5);
  ?>
  <h2>Function Scope and Global Variables</h2>
  <?php
  $globalVar = "I am global";

  function showGlobal() {
    // 함수 외부에서 선언된 변수에 접근하기 위해 global 써야 한다.
    // 함수 외부에서 선언된 함수는 바로 접근할 수 있다.
    global $globalVar;
    echo $globalVar . "<br>";
    greet("Global");
  }
  showGlobal();
  ?>
  <h2>Anonymous Functions</h2>
  <?php
  $square = function ($n) {
    return $n * $n;
  };
  echo $square(4);
  ?>
  <h2>Arrow Functions</h2>
  <?php
  $square_arrow = fn($n) => $n * $n;
  echo $square_arrow(6);
  ?>
  <h2>Functions as First-Class Citizens</h2>
  <?php
  /* - 1급 시민의 조건 -
  1. 변수에 할당할 수 있어야 한다
  2. 객체의 인자로 넘길 수 있어야 한다
  3. return할 수 있어야 한다 */
  $square = function ($n) {
    return $n * $n;
  };

  function applyFunction($func, $value) {
    return $func($value);
  }

  echo applyFunction($square, 5);
  ?>
  <h2>Recursive Functions</h2>
  <?php
  function factorial($n) {
    if ($n <= 1) {
      return 1;
    } else {
      return $n * factorial($n - 1);
    }
  }
  echo factorial(7);
  ?>
</body>

</html>