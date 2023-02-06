package elements;

import exceptions.NotValidNumberException;
import exceptions.NotValidTryCountInputException;

public class TryCount {
    private int count;

    public TryCount(String tryCountInput) {
        this.count = tryCountInputToNumber(tryCountInput);
    }

    private int tryCountInputToNumber(String tryCountInput) {
        checkIfIsEmptyTryCountInput(tryCountInput);
        checkIfIsInvalidRange(tryCountInput);
        int toNumber = Integer.parseInt(tryCountInput);
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

    private void checkIfIsInvalidRange(String tryCountInput) {
        try {
            Integer.parseInt(tryCountInput);
        }catch (NumberFormatException e){
            throw new NotValidNumberException();
        }
    }

}
