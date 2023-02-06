import elements.TryCount;
import exceptions.NotValidNumberException;
import exceptions.NotValidTryCountInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    @DisplayName("시도 횟수는 빈 값일 수 없다.")
    void tryCountNotBeNullOrEmpty() {
        String testInput = "";
        Assertions.assertThrows(NotValidTryCountInputException.class,()->{
            new TryCount(testInput);
        });
    }
    
    @Test
    @DisplayName("시도 횟수는 음수일 수 없다.")
    void tryCountCanNotBeMinus() {
        String testInput = "-1";
        Assertions.assertThrows(NotValidNumberException.class,()->{
            new TryCount(testInput);
        });
    }

    @Test
    @DisplayName("시도 횟수는 정수여야한다.")
    void tryCountMustBeInt() {
        String testInput = "1.1";
        Assertions.assertThrows(NotValidNumberException.class,()->{
            new TryCount(testInput);
        });
    }
}
