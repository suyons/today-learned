const fs = require("fs");

// 파일 쓰기
fs.writeFileSync("hello.txt", "hello world!");

// 파일 읽기
const data = fs.readFileSync("hello.txt", "utf8");
console.log(data);
