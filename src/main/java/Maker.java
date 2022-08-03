import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Maker {

    final private Shop shop;

    public Maker(Shop shop) {
        this.shop = shop;
    }

    private int carCount = 0;
    private int carSold = 0;
    private final int WAIT = 1000;

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void makeCar() {
        try {
            lock.lock();
            carCount++;
            System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто\n" +
                    "всего произведено " + carCount + " авто");
            Thread.sleep(WAIT);
            shop.getCars().add(new Car());
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sellCar() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println("Машин нет");
                condition.await();
            }
            Thread.sleep(WAIT);
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
