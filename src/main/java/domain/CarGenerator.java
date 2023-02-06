package domain;

import exceptions.CarNameLengthException;
import exceptions.CarNamesCanNotBeEmptyException;
import utils.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
    private static final int MIN_NAME_LENGTH = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static List<Car> generate(String carNameInputs) {
        checkIfCarNamesAreEmpty(carNameInputs);
        List<String> carNames = StringUtil.parseString(carNameInputs);
        checkCarNamesSize(carNames);
        checkNameLength(carNames);
        return carNames.stream().map(carName -> new Car(carName)).collect(Collectors.toList());
    }

    private static void checkIfCarNamesAreEmpty(String carNames) {
        if (carNames.isEmpty() || carNames == null) {
            throw new CarNamesCanNotBeEmptyException();
        }
    }

    private static void checkCarNamesSize(List<String> carNames) {
        if (carNames.size() == 0) {
            throw new CarNamesCanNotBeEmptyException();
        }
    }

    private static void checkNameLength(List<String> carNames) {
        carNames.forEach(carName -> {
            checkNameLengthRange(carName);
        });
    }

    private static void checkNameLengthRange(String carName) {
        if (carName.length() <= MIN_NAME_LENGTH || carName.length() > MAX_NAME_LENGTH) {
            throw new CarNameLengthException();
        }
    }

}
