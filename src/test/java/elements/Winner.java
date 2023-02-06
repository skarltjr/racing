package elements;

import java.util.List;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> winners) {
        this.cars = winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
