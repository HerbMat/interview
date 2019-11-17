package exercises.array;

/**
 * It transforms array to another one with the same length.
 */
public class ArrayMultiplyTransformer {

    /**
     * <p>Function transforms array to the of the same length as the input one. </p>
     * <p>Each number in the output array is the product of <b>all numbers from the input except the number at that index.</b></p>
     * @param input input array. It consist Integer values.
     * @return new array with transformed values based on onput.
     */
    public int[] product(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        var multiplicationProduct = 1;
        for (int element : input) {
            multiplicationProduct *= element;
        }
        var inputSize = input.length;
        final var multiplicationArray = new int[inputSize];
        for (int index = 0 ; index < inputSize; ++index) {
            multiplicationArray[index] = multiplicationProduct/input[index];
        }
        return multiplicationArray;
    }
}
