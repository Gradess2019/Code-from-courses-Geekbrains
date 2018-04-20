package Homework.LevelTwo.LessonTwo;

public class LessonTwo {

    private static class MatrixException extends RuntimeException {
        MatrixException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(getHalfSumOfMatrixElements("1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"));
        } catch (MatrixException runtimeException) {
            System.out.println("The matrix does not have a size of 4x4!");
        } catch (NumberFormatException numberFormatException) {
            System.out.println("The matrix has a char or word!");
        }
    }

    //1
    private static float getHalfSumOfMatrixElements(String string) throws MatrixException, NumberFormatException {
        String[] splitedString = string.split("\n");
        final int NUM_OF_CHARS_IN_LINE = 4;
        for (int i = 0; i < splitedString.length; i++)
            if (splitedString[i].split(" ").length != NUM_OF_CHARS_IN_LINE)
                throw new MatrixException("Matrix does not have a size of 4x4");

        String[][] stringMatrix = new String[splitedString.length][splitedString.length];

        for (int i = 0; i < splitedString.length; i++) {
            String[] temp = splitedString[i].split(" ");
            System.arraycopy(temp, 0, stringMatrix[i], 0, splitedString.length);
        }

        int sum = 0;
        for (int y = 0; y < splitedString.length; y++)
            for (int x = 0; x < splitedString.length; x++) {
                //Выбросит NumberFormatException если элемент матрицы не число
                sum += Integer.parseInt(stringMatrix[y][x]);
            }
        return (float) sum / 2;
    }

}
