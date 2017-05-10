package aatwi.dev;

final class FizzBuzz {

    private static final int THREE = 3;
    private static final int FIVE = 5;

    static final String FIZZ = "FIZZ";
    static final String BUZZ = "BUZZ";
    static final String FIZZ_BUZZ = FIZZ + BUZZ;

    static String compute(int number) {
        checkNumberFormat(number);

        if (isModuloThree(number) && isModuloFive(number)) {
            return FIZZ_BUZZ;
        } else if (isModuloThree(number)) {
            return FIZZ;
        } else if (isModuloFive(number)) {
            return BUZZ;
        }
        return String.valueOf(number);
    }

    private static void checkNumberFormat(int number) {
        if (number <= 0) {
            throw new NumberFormatException("Number should be greater than 0");
        }
    }

    private static boolean isModuloThree(int number) {
        return number % THREE == 0;
    }

    private static boolean isModuloFive(int number) {
        return number % FIVE == 0;
    }
}
