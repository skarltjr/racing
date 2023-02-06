package domain;

public class Car {
    private static final int START_LOCATION = 1;
    private int location;
    private String carName;

    public Car(String carName) {
        this.location = START_LOCATION;
        this.carName = carName;
    }

    public int getLocation() {
        return location;
    }

    public String getCarName() {
        return carName;
    }

    public void moveForward() {
        location++;
    }
}
