import elements.Car;
import elements.WinnerDiscriminator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerDiscriminatorTest {
    @Test
    @DisplayName("가장 멀리 도달한 자동차가 우승한다.")
    void getWinner() {
        Car benz = new Car("benz");
        Car bmw = new Car("bmw");
        Car audi = new Car("audi");

        benz.moveForward();
        benz.moveForward();
        bmw.moveForward();

        List<Car> cars = List.of(benz, bmw, audi);
        List<Car> winners = WinnerDiscriminator.getWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getCarName()).isEqualTo("benz");
    }

    @Test
    @DisplayName("공동 우승자가 존재할 수 있다.")
    void winnerCanBeMultiple() {
        Car benz = new Car("benz");
        Car bmw = new Car("bmw");
        Car audi = new Car("audi");

        benz.moveForward();
        benz.moveForward();
        bmw.moveForward();
        bmw.moveForward();

        List<Car> cars = List.of(benz, bmw, audi);
        List<Car> winners = WinnerDiscriminator.getWinners(cars);

        assertThat(winners).hasSize(2);
    }
}
