package inheritance;

public class OverridingTest3 {
    public static void main(String[] args) {
        Customer customerLee = new Customer(10010, "이순신");
        VIPCustomer customerKim = new VIPCustomer(10020, "김유신", 12345);
        Customer customerNa = new VIPCustomer(10030, "나몰라", 2000);

        int price = 10000;
        System.out.println(customerLee.getCustomerName() + "님의 지불액: " + customerLee.calcPrice(price));
        System.out.println(customerKim.getCustomerName() + "님의 지불액: " + customerKim.calcPrice(price));
        System.out.println(customerNa.getCustomerName() + "님의 지불액: " + customerNa.calcPrice(price));
    }    
}
