package domain;

import exceptions.NotValidNumberException;
import exceptions.NotValidTryCountInputException;

public class TryCount {
    private int count;

    public TryCount(String tryCountInput) {
        this.count = tryCountInputToNumber(tryCountInput);
    }

    private int tryCountInputToNumber(String tryCountInput) {
        checkIfIsEmptyTryCountInput(tryCountInput);
        int toNumber = checkIfIsInvalidRange(tryCountInput);
        checkIfIsMinus(toNumber);
        return toNumber;
    }

    private void checkIfIsMinus(int toNumber) {
        if (toNumber <0){
            throw new NotValidNumberException();
        }
    }


    private void checkIfIsEmptyTryCountInput(String tryCountInput) {
        if (tryCountInput.isEmpty() || tryCountInput == null) {
            throw new NotValidTryCountInputException();
        }
    }

    private int checkIfIsInvalidRange(String tryCountInput) {
        int value;
        try {
            value = Integer.parseInt(tryCountInput);
        }catch (NumberFormatException e){
            throw new NotValidNumberException();
        }
        return value;
    }

}
