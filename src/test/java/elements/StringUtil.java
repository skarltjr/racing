package elements;


import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static List<String> parseString(String carNames){
        return Arrays.asList(carNames.split(","));
    }
}
