<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Variables and Data Types</title>
</head>

<body>
  <?php
  $string1 = "Hello";
  $number2 = 123;
  $boolean3 = true;

  $juggling = $string1 . $number2;
  $casting = (string) $number2;

  $heredoc = <<<EOT
  string1 is $string1!<br>
  and number2 is $number2<br>
  finally boolean3 is $boolean3<br>
  thank you!
  EOT;

  $nowdoc = <<<'EOT'
  string1 is $string1!<br>
  and number2 is $number2<br>
  finally boolean3 is $boolean3<br>
  thank you!
  EOT;

  // 아래 3가지 모두 같은 표현
  echo "string1: " . $string1 . "<br>";
  echo "number2: $number2<br>";
  echo "boolean3: {$boolean3}<br>";
  echo "boolean3: " . ($boolean3 ? "true" : "false") . "<br>";

  echo "juggling: " . $juggling . "<br>";
  echo "casting: " . $casting . "<br>";

  echo $heredoc . "<br>";
  echo $nowdoc . "<br>";
  ?>
</body>

</html>