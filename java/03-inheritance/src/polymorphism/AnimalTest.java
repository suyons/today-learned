package polymorphism;

import java.util.ArrayList;

class Animal {
    public void move() {
        System.out.println("동물이 움직입니다");
    }
}

class Human extends Animal {
    public void move() {
        System.out.println("사람이 걷습니다");
    }

    public void readBook() {
        System.out.println("사람이 책을 읽습니다");
    }
}

class Tiger extends Animal {
    public void move() {
        System.out.println("호랑이가 뜁니다");
    }

    public void hunt() {
        System.out.println("호랑이가 사냥합니다");
    }
}

class Eagle extends Animal {
    public void move() {
        System.out.println("독수리가 납니다");
    }

    public void fly() {
        System.out.println("독수리가 더 높이 납니다");
    }
}

public class AnimalTest {
    ArrayList<Animal> aniList = new ArrayList<Animal>();

    public static void main(String[] args) {
        AnimalTest aTest = new AnimalTest();
        aTest.addAnimal();
        System.out.println("=== 다운캐스팅 ===");
        aTest.testCasting();
    }

    public void addAnimal() {
        aniList.add(new Human());
        aniList.add(new Tiger());
        aniList.add(new Eagle());

        for (Animal ani : aniList) {
            ani.move();
        }
    }

    public void testCasting() {
        for (int i = 0; i < aniList.size(); i++) {
            Animal ani = aniList.get(i);
            if (ani instanceof Human) {
                Human h = (Human) ani;
                h.readBook();
            } else if (ani instanceof Tiger) {
                Tiger t = (Tiger) ani;
                t.hunt();
            } else if (ani instanceof Eagle) {
                Eagle e = (Eagle) ani;
                e.fly();
            } else {
                System.out.println("지원되지 않는 타입입니다");
            }
        }
    }
}
