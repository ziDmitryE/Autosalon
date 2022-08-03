public class Maker {

    final private Shop shop;

    public Maker(Shop shop) {
        this.shop = shop;
    }

    private int carCount = 0;
    private int carSold = 0;
    private int WAIT = 1000;

    public synchronized void makeCar() {
        try {
            carCount++;
            System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто\n"+
                    "всего произведено " + carCount + " авто");
            Thread.sleep(WAIT);
            shop.getCars().add(new Car());
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sellCar() {

        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(WAIT);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            carSold++;
            System.out.println("Кол-во проданных машин = " + carSold);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shop.getCars().remove(0);
    }
}
