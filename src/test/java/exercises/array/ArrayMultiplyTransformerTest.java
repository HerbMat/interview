package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class ArrayMultiplyTransformerTest {
    private final static int[] EXPECTED_ARRAY = {24, 72, 12, 18};

    private final ArrayMultiplyTransformer arrayMultiplyTransformer = new ArrayMultiplyTransformer();

    @DisplayName("It should successfully transform array to new.")
    @Test
    public void product() {
        int[] input = {3, 1, 6, 4};
        int[] result = arrayMultiplyTransformer.product(input);

        assertThat(result, equalTo(EXPECTED_ARRAY));
    }
}