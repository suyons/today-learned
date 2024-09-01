# Basic

PHP의 기본 문법을 익히고, 데이터베이스 연동 등 기본 기능을 구현했습니다.

## 실행 방법

```sh
cd basic
php -S localhost:80
```



## 학습 순서

강의 또는 도서를 이용하지 않고 ChatGPT를 이용하여 학습했습니다.

아래는 ChatGPT의 답변 내용입니다.

---

### **Morning: PHP Basics**

1. **Introduction to PHP:**
   - **Installation:** Ensure PHP is installed. You can use XAMPP, MAMP, or install PHP directly.
   - **Hello World:** Create a simple PHP script.
     ```php
     <?php
     echo "Hello, PHP!";
     ?>
     ```
   - **Syntax Basics:** Learn about PHP tags, comments, and basic syntax.

2. **Variables and Data Types:**
   - Understand variable declaration, data types, and type juggling.
     ```php
     $string = "Hello";
     $number = 123;
     $boolean = true;
     ```

3. **Control Structures:**
   - Practice `if`, `else`, `switch`, `for`, `while`, and `foreach` loops.
     ```php
     if ($number > 100) {
         echo "Number is greater than 100";
     }
     ```

### **Afternoon: Advanced PHP Concepts**

1. **Functions:**
   - Learn how to define and call functions, including parameter passing and return values.
     ```php
     function add($a, $b) {
         return $a + $b;
     }
     echo add(5, 3); // Outputs: 8
     ```

2. **OOP in PHP:**
   - **Classes and Objects:** Define classes, create objects, and use methods and properties.
     ```php
     class User {
         public $name;

         public function __construct($name) {
             $this->name = $name;
         }

         public function greet() {
             return "Hello, " . $this->name;
         }
     }

     $user = new User("Alice");
     echo $user->greet(); // Outputs: Hello, Alice
     ```

   - **Inheritance and Polymorphism:** Create a base class and extend it.
     ```php
     class Animal {
         public function speak() {
             return "Animal sound";
         }
     }

     class Dog extends Animal {
         public function speak() {
             return "Woof!";
         }
     }

     $dog = new Dog();
     echo $dog->speak(); // Outputs: Woof!
     ```

### **Evening: Web Development Basics with PHP**

1. **Form Handling:**
   - Create a basic HTML form and process it with PHP.
     ```html
     <form method="post" action="process.php">
         Name: <input type="text" name="name">
         <input type="submit">
     </form>
     ```
     ```php
     // process.php
     <?php
     if ($_SERVER["REQUEST_METHOD"] == "POST") {
         $name = $_POST['name'];
         echo "Hello, $name!";
     }
     ?>
     ```

2. **Database Interaction:**
   - **Connecting to a Database:** Use PDO or MySQLi to connect and perform CRUD operations.
     ```php
     $pdo = new PDO('mysql:host=localhost;dbname=testdb', 'username', 'password');
     $stmt = $pdo->query("SELECT * FROM users");
     while ($row = $stmt->fetch()) {
         echo $row['name'];
     }
     ```

3. **Basic CRUD Operations:**
   - Implement simple CRUD operations using forms and database interaction.
     - **Create:** Insert new records.
     - **Read:** Retrieve and display records.
     - **Update:** Modify existing records.
     - **Delete:** Remove records.

### **Wrap-Up:**

1. **Review and Practice:**
   - Review what you’ve learned and practice by building a small project or adding features to your existing projects.

2. **Resources:**
   - Check out PHP documentation, tutorials, and forums for further learning and support.

By the end of the day, you should have a solid grasp of PHP fundamentals and be ready to tackle more complex projects. If you have any questions or need clarification, feel free to ask!

