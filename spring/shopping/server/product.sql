CREATE DATABASE shopping;

USE shopping;

CREATE TABLE `product` (
    `id` varchar(255) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `thumbnail` varchar(255) DEFAULT NULL,
    `explanation` varchar(255) DEFAULT NULL,
    `price` bigint DEFAULT NULL,
    `discount` bigint DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO product (id, name, thumbnail, explanation, price)
VALUES (
        'de8a0304-ea0a-42f5-b908-986869a49e6d',
        '스타벅스 기프티콘',
        'thumbnails/1687084981889-56574460.jpeg',
        '교환유효기간은 93일 입니다. (시즌성 상품, 기업경품(B2B), 할인상품의 경우 유효기간이 상이 할 수 있습니다.)',
        10000
    ),
    (
        '0200a6e6-4ee8-4463-a7a4-91539a9834e2',
        '젤다의 전설',
        'thumbnails/1687085300556-748499999.jpeg',
        '교환/반품 안내\nㆍ교환/반품에 관한 일반적인 사항은 판매자가 제시사항보다 관계법령이 우선합니다.',
        74800
    ),
    (
        '83a7e17f-637c-447b-a89b-cb0c8edc932a',
        'Nintendo 닌텐도 스위치 OLED',
        'thumbnails/1687085429089-174930884.jpeg',
        '풍부한 OLED 색감과 커진 화면으로 휴대시 향상된 게임 환경',
        373500
    ),
    (
        '032a8cfb-05f2-421d-a418-ed6e2b0d0522',
        'PS5 디지털 에디션 ',
        'thumbnails/1687085655921-835615668.jpeg',
        'PS5 / 본체 / 지원해상도: 4K / 기본 저장용량: 825GB / GPU:10.28 TFLOPS, AMD 라데온 / GDDR6(16G) / 825GB NVME 커스텀 SSD / 4K UHD 블루레이 / 듀얼센스 패드포함 / ※ 22년 8월 25일부로 권장 소비자 가격 인상 628,000원→688,000원 / 출시가: 628,000원',
        529540
    ),
    (
        'a404f88f-f7be-4000-911e-23ffcad7ffb5',
        'Good Luck To You, Girl Scout!',
        'thumbnails/1687085809154-566548873.jpeg',
        '안녕하세요 대한민국, 검정치마가 선사하는...\n‘Good Luck To You, Girl Scout!’\n',
        11900
    ),
    (
        'c1a5f6e5-1e3f-4d7c-aef8-ac47bc82b2ff',
        '난 자꾸 말을 더듬고 잠드는 법도 잊었네 ',
        'thumbnails/1687085973557-720290342.jpeg',
        'Cat.No HRC1060\nDisc 1장\n250g',
        14900
    ),
    (
        'f4bf010c-1310-4f2c-87b2-ce3a1b08f067',
        '201 Special Edition [재발매]',
        'thumbnails/1687086050951-583445112.jpeg',
        'YGK0672 (Cat.No)Disc : 1장250g',
        13100
    ),
    (
        '8a8a1b2b-200a-44cb-9c60-9375d82dd8bb',
        'Unlock My World',
        'thumbnails/1687086233462-768920531.jpeg',
        'fromis_9 1st Full Album ''Unlock My World''',
        19300
    );