import utils.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {
    @RepeatedTest(100)
    @DisplayName("생성된 난수는 0~9 사이의 숫자다")
    void randomNumberBetweenZeroToNine() {
        int randomNumber = RandomUtil.createRandom();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber).isLessThanOrEqualTo(9);
    }
}
