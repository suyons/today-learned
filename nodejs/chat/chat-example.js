// server.js
const express = require('express');
const sqlite3 = require('sqlite3');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// 데이터베이스 객체
const db = new sqlite3.Database('chat.db');

// 미들웨어 설정
app.use(bodyParser.json()); // JSON 요청 본문 파싱

// 데이터베이스 초기화 함수
function init() {
    db.serialize(() => {
        db.run(`
            CREATE TABLE IF NOT EXISTS chat (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username VARCHAR(50) NOT NULL,
                timestamp BIGINT NOT NULL,
                message TEXT NOT NULL
            )
        `, (err) => {
            if (err) {
                console.error('테이블 생성 오류:', err.message);
            } else {
                console.log('chat 테이블이 생성되었습니다.');
            }
        });
    });
}

// 데이터베이스 초기화
init();

// GET 요청: 모든 채팅 메시지 조회
app.get('/chats', (req, res) => {
    const sql = 'SELECT * FROM chat ORDER BY timestamp DESC';
    db.all(sql, [], (err, rows) => {
        if (err) {
            res.status(500).json({ error: err.message });
            return;
        }
        res.json(rows);
    });
});

// POST 요청: 새 채팅 메시지 추가
app.post('/chats', (req, res) => {
    const { username, message } = req.body;
    const timestamp = Date.now(); // 현재 시각의 UNIX TIMESTAMP (밀리초 단위)
    const sql = 'INSERT INTO chat (username, timestamp, message) VALUES (?, ?, ?)';
    db.run(sql, [username, timestamp, message], function (err) {
        if (err) {
            res.status(500).json({ error: err.message });
            return;
        }
        res.status(201).json({ id: this.lastID });
    });
});

// DELETE 요청: 채팅 메시지 삭제
app.delete('/chats/:id', (req, res) => {
    const id = req.params.id;
    const sql = 'DELETE FROM chat WHERE id = ?';
    db.run(sql, [id], function (err) {
        if (err) {
            res.status(500).json({ error: err.message });
            return;
        }
        if (this.changes === 0) {
            res.status(404).json({ error: '채팅 메시지를 찾을 수 없습니다.' });
            return;
        }
        res.status(204).send(); // 성공적으로 삭제된 경우
    });
});

// 서버 시작
app.listen(port, () => {
    console.log(`서버가 포트 ${port}에서 실행 중입니다.`);
});
