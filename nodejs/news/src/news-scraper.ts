// newsscraper.ts
import axios from "axios";
import cheerio from "cheerio";
import fs from "fs/promises";
import schedule from "node-schedule";

interface Article {
  title: string;
  content: string;
  date: string;
  thumbnail: string | undefined;
  pressLogo: string | undefined;
}

class NewsScraper {
  private filePath: string;
  public newsData: Article[];

  constructor(filePath: string) {
    this.filePath = filePath;
    this.newsData = [];
    this.loadJsonFile(this.filePath)
      .then((data) => (this.newsData = data))
      .catch((error) => console.error("Error loading JSON data:", error));

    // 매일 자정에 스크래핑 작업 예약
    this.scheduleScraping("검색어");
  }

  // Google 뉴스에서 검색어를 통해 데이터 수집
  public async searchGoogleNews(keyword: string): Promise<void> {
    const url = `https://news.google.com/search?q=${encodeURIComponent(
      keyword
    )}`;
    try {
      const response = await axios.get(url);
      const html = response.data;
      this.newsData = this.fetchDataFromHtml(html);
      await this.saveJsonFile(this.filePath, this.newsData);
    } catch (error) {
      console.error("Error fetching news data:", error);
    }
  }

  // HTML에서 데이터 추출
  private fetchDataFromHtml(html: string): Article[] {
    const $ = cheerio.load(html);
    const articles: Article[] = [];

    // CSS 선택자로 원하는 데이터 추출
    $("article").each((index, element) => {
      const title = $(element).find("h3").text().trim();
      const content = $(element).find("p").text().trim(); // 예시로 p 태그 사용
      const date = new Date().toISOString(); // 실제 뉴스 날짜를 파싱하는 로직 추가 가능
      const thumbnail = $(element).find("img").attr("src");
      const pressLogo = $(element).find(".press-logo-selector").attr("src"); // 예시 클래스 이름

      articles.push({ title, content, date, thumbnail, pressLogo });
    });

    return articles;
  }

  // JSON 파일에 데이터 저장
  private async saveJsonFile(path: string, data: Article[]): Promise<void> {
    try {
      await fs.writeFile(path, JSON.stringify(data, null, 2), "utf-8");
      console.log("Data saved to JSON file");
    } catch (error) {
      console.error("Error saving JSON file:", error);
    }
  }

  // JSON 파일에서 데이터 로드
  private async loadJsonFile(path: string): Promise<Article[]> {
    try {
      const data = await fs.readFile(path, "utf-8");
      return JSON.parse(data);
    } catch (error) {
      console.error("Error reading JSON file:", error);
      return [];
    }
  }

  // 스케줄링 함수: 매일 자정에 스크래핑 실행
  private scheduleScraping(keyword: string): void {
    schedule.scheduleJob("0 0 * * *", () => {
      console.log(`Running scheduled scraping for keyword: ${keyword}`);
      this.searchGoogleNews(keyword);
    });
  }
}

export default NewsScraper;
