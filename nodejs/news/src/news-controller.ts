import express, { Request, Response } from "express";
import NewsScraper from "./news-scraper";

const app = express();
const PORT = 3000;
const JSON_FILE_PATH = "./news-data.json";
const scraper = new NewsScraper(JSON_FILE_PATH);

// 뉴스 데이터를 반환하는 라우트
app.get("/news", (req: Request, res: Response) => {
  res.json(scraper.newsData);
});

// 서버 시작
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
