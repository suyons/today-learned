package com.packt.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.Product;
import com.packt.cardatabase.domain.ProductRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository orepository;

    @Autowired
    private UserRepository urepository;

    @Autowired
    private ProductRepository prepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add owner objects and save these to db
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        orepository.saveAll(Arrays.asList(owner1, owner2));

        // Add car object and link to owners and save these to db
        Car car1 = new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2021, 59000, owner1);
        Car car2 = new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2019, 29000, owner2);
        Car car3 = new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2020, 39000, owner2);
        repository.saveAll(Arrays.asList(car1, car2, car3));

        Product product1 = new Product("스타벅스 기프티콘", "교환유효기간은 93일 입니다. (시즌성 상품, 기업경품(B2B), 할인상품의 경우 유효기간이 상이 할 수 있습니다.)",
                "thumbnails/1687084981889-56574460.jpeg", 10000L, 0L);
        Product product2 = new Product("젤다의 전설", "교환/반품 안내\\n" + //
                "ㆍ교환/반품에 관한 일반적인 사항은 판매자가 제시사항보다 관계법령이 우선합니다.", "thumbnails/1687085300556-748499999.jpeg", 74800L, 0L);
        Product product3 = new Product("Nintendo 닌텐도 스위치 OLED", "풍부한 OLED 색감과 커진 화면으로 휴대시 향상된 게임 환경",
                "thumbnails/1687085429089-174930884.jpeg", 373500L, 0L);
        Product product4 = new Product("PS5 디지털 에디션",
                "PS5 / 본체 / 지원해상도: 4K / 기본 저장용량: 825GB / GPU:10.28 TFLOPS, AMD 라데온 / GDDR6(16G) / 825GB NVME 커스텀 SSD / 4K UHD 블루레이 / 듀얼센스 패드포함 / ※ 22년 8월 25일부로 권장 소비자 가격 인상 628,000원→688,000원 / 출시가: 628,000원",
                "thumbnails/1687085655921-835615668.jpeg", 529540L, 0L);
        Product product5 = new Product("Good Luck To You, Girl Scout!",
                "안녕하세요 대한민국, 검정치마가 선사하는...\n‘Good Luck To You, Girl Scout!’\n",
                "thumbnails/1687085809154-566548873.jpeg", 11900L, 0L);
        Product product6 = new Product("난 자꾸 말을 더듬고 잠드는 법도 잊었네 ", "YGK0672 (Cat.No)Disc : 1장250g",
                "thumbnails/1687086050951-583445112.jpeg", 13100L, 0L);
        prepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6));

        for (Car car : repository.findAll()) {
            logger.info(car.getBrand() + " " + car.getModel());
        }

        urepository.save(new User("user",
                "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));
        urepository.save(new User("admin",
                "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
    }
}
