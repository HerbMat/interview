package exercises.arrayiterator;

import java.util.AbstractMap;

/**
 * Implementation of {@link ArrayIterator} for two dimensional integer array.
 */
public class IntegerArrayIterator implements ArrayIterator<Integer> {

    private final int[][] integerArray;
    private int horizontalIndex = -1;
    private int verticalIndex = 0;

    /**
     * @param integerArray integer array which will be iterated.
     */
    public IntegerArrayIterator(final int[][] integerArray) {
        if (integerArray == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        this.integerArray = integerArray;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        final var newPossibleIndexes = getNewPossibleIndexes();

        return checkIfEntryExists(newPossibleIndexes.getKey(), newPossibleIndexes.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer next() {
        final var newIndexes = getNewPossibleIndexes();
        verticalIndex = newIndexes.getKey();
        horizontalIndex = newIndexes.getValue();
        if (!checkIfEntryExists(verticalIndex, horizontalIndex)) {
            throw new IllegalStateException("Iterator out of bounds");
        }
        if (integerArray[verticalIndex] == null) {
            return null;
        }
        return integerArray[verticalIndex][horizontalIndex];
    }

    private boolean checkIfEntryExists(int newVerticalIndex, int newHorizontalIndex) {
        if (integerArray.length <= newVerticalIndex) {
            return false;
        }
        return ((integerArray[newVerticalIndex] != null && integerArray[newVerticalIndex].length > newHorizontalIndex)
                || newHorizontalIndex == 0);
    }

    private AbstractMap.SimpleEntry<Integer, Integer> getNewPossibleIndexes() {
        int newHorizontalIndex = horizontalIndex + 1;
        if (checkIfEntryExists(verticalIndex, newHorizontalIndex)) {
            return new AbstractMap.SimpleEntry<>(verticalIndex, newHorizontalIndex);
        }
        int newVerticalIndex = verticalIndex + 1;
        newHorizontalIndex = 0;

        return new AbstractMap.SimpleEntry<>(newVerticalIndex, newHorizontalIndex);
    }
}
