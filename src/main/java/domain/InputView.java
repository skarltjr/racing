package domain;

import java.util.Scanner;

public class InputView {
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도 횟수를 입력해주세요.";
    private static final String CARS_NAME_INPUT_MESSAGE = "자동차 이름들을 입력해주세요. 이름은 쉼표(,)를 기준으로 구분합니다.";
    private static final Scanner scanner = new Scanner(System.in);
    public static TryCount getTryCount(){
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return new TryCount(scanner.next());
    }

}
