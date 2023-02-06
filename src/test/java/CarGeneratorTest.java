import domain.Car;
import domain.CarGenerator;
import exceptions.CarNameLengthException;
import exceptions.CarNamesCanNotBeEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarGeneratorTest {
    @Test
    @DisplayName("자동차 이름 입력은 빈 값일 수 없습니다.")
    void carNamesCanNotBeEmpty() {
        String carNames = "";
        Assertions.assertThrows(CarNamesCanNotBeEmptyException.class, () -> {
            List<Car> cars = CarGenerator.generate(carNames);
        });
    }

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분했을때 각 이름은 빈 값일 수 없다.")
    void eachCarCanNotBeEmpty() {
        String carNames = ",";
        Assertions.assertThrows(CarNamesCanNotBeEmptyException.class, () -> {
            List<Car> cars = CarGenerator.generate(carNames);
        });
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하여야한다.")
    void carNameShorterThanFive(){
        String carNames = "123456,123445678";
        Assertions.assertThrows(CarNameLengthException.class, () -> {
            List<Car> cars = CarGenerator.generate(carNames);
        });
    }

    @Test
    @DisplayName("자동차 생성")
    void generateCars() {
        String targetCarNames = "benz,bmw,audi";
        List<Car> cars = CarGenerator.generate(targetCarNames);
        List<String> carNames = cars.stream().map(car -> car.getCarName()).collect(Collectors.toList());

        assertThat(carNames.containsAll(List.of("benz", "bmw", "audi"))).isTrue();
        for (Car car : cars) {
            assertThat(car.getLocation() == 1);
        }
    }
}
