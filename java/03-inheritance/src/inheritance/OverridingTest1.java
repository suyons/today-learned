package inheritance;

public class OverridingTest1 {
    public static void main(String[] args) {
        Customer customerLee = new Customer(10010, "이순신");
        customerLee.bonusPoint = 1000;

        VIPCustomer customerKim = new VIPCustomer(10020, "김유신", 12345);
        customerKim.bonusPoint = 10000;

        int price = 10000;
        System.out.println(customerLee.getCustomerName() + "님의 지불액: " + customerLee.calcPrice(price));
        System.out.println(customerKim.getCustomerName() + "님의 지불액: " + customerKim.calcPrice(price));
    }
}
