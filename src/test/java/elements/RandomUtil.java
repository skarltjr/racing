package elements;

import java.util.Random;

public class RandomUtil {
    public static int createRandom() {
        return new Random().nextInt(10);
    }
}
