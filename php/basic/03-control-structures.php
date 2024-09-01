<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Control Structures</title>
</head>

<body>
  <h2>Conditional Statements</h2>
  <?php
  $number = 120;

  echo "$number is ";
  if ($number > 100) {
    echo "greater than 100";
  } elseif ($number == 100) {
    echo "same with 100";
  } else {
    echo "less then 100";
  }
  ?>
  <h2>Switch Statement</h2>
  <?php
  $day = 3;

  echo "Today is ";
  switch ($day) {
    case 1:
      echo "Monday";
      break;
    case 2:
      echo "Tuesday";
      break;
    case 3:
      echo "Wednesday";
      break;
    case 4:
      echo "Thursday";
      break;
    case 5:
      echo "Friday";
      break;
    case 6:
      echo "Saturday";
      break;
    case 7:
      echo "Sunday";
      break;
    default:
      echo "Invalid day";
  }
  ?>
  <h2>Loops</h2>
  <h3>for</h3>
  <?php
  for ($i = 0; $i < 5; $i++) {
    echo "The number is $i<br>";
  }
  ?>
  <h3>while</h3>
  <?php
  $i = 0;
  while ($i < 5) {
    echo "The number is $i<br>";
    $i++;
  }
  ?>
  <h3>do-while</h3>
  <?php
  $i = 0;
  do {
    echo "The number is $i<br>";
    $i++;
  } while ($i < 5);
  ?>
  <h3>foreach</h3>
  <?php
  $fruits = array("Apple", "Banana", "Cherry");
  foreach ($fruits as $fruit) {
    echo "$fruit is so sweet<br>";
  }
  ?>
  <h4>Associative Array</h4>
  <?php
  // 연관 배열 = Python의 dict 자료형
  $person = array("name" => "John", "age" => 30);

  foreach ($person as $key => $value) {
    echo "$key : $value<br>";
  }
  ?>
</body>

</html>