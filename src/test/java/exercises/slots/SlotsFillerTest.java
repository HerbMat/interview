package exercises.slots;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class SlotsFillerTest {

    private SlotsFiller slotsFiller = new SlotsFiller();

    @DisplayName("It should print all possible variations for values {1,2} and 4 slots")
    @Test
    public void permutationsOfTwoValuesAndFourSlots() {
        Set<Integer> values = Set.of(1,2);
        final var result = slotsFiller.permutationsOfFilledSlots(values, 4);
        printSlots(result);
    }

    @DisplayName("It should print all possible variations for values {1,2,3} and 3 slots")
    @Test
    public void permutationsOfThreeValuesAndThreeSlots() {
        Set<Integer> set = Set.of(1,2,3);
        final var result = slotsFiller.permutationsOfFilledSlots(set, 3);
        printSlots(result);
    }

    private void printSlots(List<List<Integer>> result) {
        for (List<Integer> slot : result ) {
            System.out.println(slot.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }

}