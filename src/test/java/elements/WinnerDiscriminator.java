package elements;

import java.util.ArrayList;
import java.util.List;

public class WinnerDiscriminator {

    public static List<Car> getWinners(List<Car> candidates) {
        return chooseWinners(candidates);
    }

    private static List<Car> chooseWinners(List<Car> candidates) {
        int farthestLocation = Integer.MIN_VALUE;
        List<Car> winners = new ArrayList<>();

        for (Car car : candidates) {
            int currentCarLocation = car.getLocation();

            if (checkIfSameLocationWithCurrentFarthestLocation(currentCarLocation,farthestLocation)){
                winners.add(car);
                continue;
            }

            if (checkIfFartherThanElse(currentCarLocation, farthestLocation)) {
                clearAndMakeNewWinners(winners,car);
                farthestLocation = currentCarLocation;
            }
        }

        return winners;
    }

    private static boolean checkIfSameLocationWithCurrentFarthestLocation(int currentCarLocation, int farthestLocation) {
        return currentCarLocation == farthestLocation;
    }

    private static boolean checkIfFartherThanElse(int currentCarLocation, int farthestLocation) {
        return currentCarLocation > farthestLocation ? true : false;
    }

    private static void clearAndMakeNewWinners(List<Car> winners, Car car) {
        winners.clear();
        winners.add(car);
    }
}
