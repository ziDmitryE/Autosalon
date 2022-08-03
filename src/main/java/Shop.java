import java.util.ArrayList;
import java.util.List;

public class Shop {

    Maker maker = new Maker(this);
    List<Car> cars = new ArrayList<>();

    public void sellCar() {
        maker.sellCar();
    }

    public void makeCar() {
        maker.makeCar();
    }

    List<Car> getCars() {
        return cars;
    }
}
