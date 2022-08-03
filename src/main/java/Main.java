public class Main {
    public static void main(String[] args) {

        final Shop shop = new Shop();

        for (int i = 0; i < 3; i++) {
            new Thread(null, shop::sellCar, "Покупатель 1").start();
            new Thread(null, shop::sellCar, "Покупатель 2").start();
            new Thread(null, shop::sellCar, "Покупатель 3").start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(null, shop::makeCar, "Toyota").start();
        }
    }
}
