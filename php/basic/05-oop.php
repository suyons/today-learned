<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OOP in PHP</title>
</head>

<body>
  <h2>Classes and Objects</h2>
  <?php
  class User {
    public $name;

    public function __construct($name) {
      $this->name = $name;
    }

    public function greet() {
      return "Hello {$this->name}!";
    }
  }

  $user = new User("Alice");
  echo $user->greet();
  ?>
  <h2>Inheritance</h2>
  <?php
  class Animal {
    public function speak() {
      return "Animal sound<br>";
    }
  }

  class Dog extends Animal {
    public function speak2() {
      return "Woof!<br>";
    }
  }

  $dog = new Dog();
  echo $dog->speak();
  echo $dog->speak2();
  ?>
  <h2>Polymorphism</h2>
  <?php
  // 메서드 오버라이딩
  class Cat extends Animal {
    public function speak() {
      return "Meow!<br>";
    }
  }

  class Duck extends Animal {
    public function speak() {
      return "Quack!<br>";
    }
  }

  function makeAnimalSpeak(Animal $animal) {
    echo $animal->speak();
  }

  $cat = new Cat();
  $duck = new Duck();

  makeAnimalSpeak($cat);
  makeAnimalSpeak($duck);
  ?>
  <h2>Access Modifiers</h2>
  <?php
  class Example {
    // public: 어디에서나 접근 가능
    public $publicProp = "I am public<br>";
    // protected: 자기 자신과 자식 클래스에서 접근 가능
    protected $protectedProp = "I am protected<br>";
    // private: 자기 자신 내에서만 접근 가능
    private $privateProp = "I am private<br>";

    public function getPrivateProp() {
      return $this->privateProp;
    }
  }

  class DescendantExample extends Example {
    public function getProtectedProp() {
      return $this->protectedProp;
    }
  }

  $example = new Example();
  $descrendantexample = new DescendantExample();
  echo $example->publicProp;
  echo $descrendantexample->getProtectedProp();
  echo $example->getPrivateProp();
  ?>
  <h2>Static Properties and Methods</h2>
  <?php
  class Math {
    public static $pi = 3.14;
    public static function square($number) {
      return $number * $number;
    }
  }

  echo Math::$pi . "<br>";
  echo Math::square(4);
  ?>
  <h2>Interfaces and Abstract Classes</h2>
  <?php
  interface AnimalInterface {
    public function speak();
  }

  class Pig implements AnimalInterface {
    public function speak() {
      return "Oink!<br>";
    }
  }

  class Sheep implements AnimalInterface {
    public function speak() {
      return "Baa!<br>";
    }
  }

  function makeAnimalInterfaceSpeak(AnimalInterface $animal) {
    echo $animal->speak();
  }

  $pig = new Pig();
  $sheep = new Sheep();

  makeAnimalInterfaceSpeak($pig);
  makeAnimalInterfaceSpeak($sheep);
  ?>
  <br>
  <?php
  abstract class Shape {
    abstract public function area();
    public function description() {
      return "I am a shape.";
    }
  }

  class Rectangle extends Shape {
    private $width;
    private $height;
    public function __construct($width, $height) {
      $this->width = $width;
      $this->height = $height;
    }
    public function area() {
      return $this->width * $this->height;
    }
  }

  $rectangle = new Rectangle(5, 10);
  echo $rectangle->area() . "<br>";
  echo $rectangle->description();
  ?>
</body>

</html>