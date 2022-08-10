import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Maker {

    final private Shop shop;

    public Maker(Shop shop) {
        this.shop = shop;
    }

    public static int carCount = 0;
    public static int carSold = 0;
    private static final int WAIT_CAR_REGISTRATION = 1000;

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void makeCar() {
        lock.lock();
        carCount++;
        System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто\n" +
                "всего произведено " + carCount + " авто");
        shop.getCars().add(new Car());
        condition.signal();
        lock.unlock();
    }

    public void sellCar() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println("Машин нет");
                condition.await();
            }
            Thread.sleep(WAIT_CAR_REGISTRATION);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            carSold++;
            System.out.println("Кол-во проданных машин = " + carSold);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        shop.getCars().remove(0);
    }
}
