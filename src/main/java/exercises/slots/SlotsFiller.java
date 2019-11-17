package exercises.slots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SlotsFiller {

    /**
     * It creates list of all possible numbers from given set values and number of slots.
     * Every row are ordered ascending. Every bigger number is next.
     *
     * @param values values which will be printed
     * @param numSlots number of slots to print per row.
     *
     * @return collection of rows with each row representing new number in ascending order.
     */
    public List<List<Integer>> permutationsOfFilledSlots(final Set<Integer> values, final int numSlots) {
        final List<List<Integer>> permutationList = new ArrayList<>();
        final List<Integer> valuesList = new ArrayList<>(values);
        Collections.sort(valuesList);
        final int[] slotIndexes = new int[numSlots];
        int valuesSize = values.size();
        do {
            permutationList.add(createRow(valuesList, slotIndexes, numSlots));
            incrementIndexes(valuesSize, slotIndexes);
        } while (slotIndexes[0] < valuesSize);

        return permutationList;
    }

    /**
     * It creates new row of numbers based on given slot indexes from values and for every slot.
     *
     * @param valuesList list of possible values.
     * @param slotIndexes indexes of values for each slot.
     * @param numSlots number of defined elements for row
     *
     * @return new row with values specified from slot indexes and length of number of slots.
     */
    private List<Integer> createRow(final List<Integer> valuesList, int[] slotIndexes, int numSlots) {
        List<Integer> slot = new ArrayList<>();
        for(int index = 0; index< numSlots; ++index) {
            slot.add(valuesList.get(slotIndexes[index]));
        }
        return slot;
    }

    /**
     * It increments values indexes starting from last number. Every value index cannot be lower than predecessor.
     *
     * @param valuesSize number of values.
     * @param slotIndexes array of individual index of each slot.
     */
    private void incrementIndexes(int valuesSize, int[] slotIndexes) {
        int lastValueIndex = valuesSize - 1;
        int slotIndexesSize = slotIndexes.length - 1;
        for (int index = slotIndexesSize; index >= 0; --index) {
            if (slotIndexes[index] < lastValueIndex) {
                ++slotIndexes[index];
                for (int remainingPermutationIndex = slotIndexesSize; remainingPermutationIndex > index; --remainingPermutationIndex) {
                    slotIndexes[remainingPermutationIndex] = slotIndexes[index];
                }
                return;
            }
        }
        slotIndexes[0] = valuesSize;
    }
}
