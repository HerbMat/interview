package exercises.arrayiterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class IntegerArrayIteratorTest {

    @DisplayName("It should successfully iterate over array with null.")
    @Test
    public void nextWithNull() {
        int[][] testArray = {{1,2},{3},null, {4,5,6}};
        ArrayIterator<Integer> testIterator = new IntegerArrayIterator(testArray);
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(1));
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(2));
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(3));
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(null));
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(4));
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(5));
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(6));
        assertThat(testIterator.hasNext(), is(false));
    }

    @DisplayName("It should successfully iterate over array without null.")
    @Test
    public void nextWithoutNull() {
        int[][] testArray = {{1},{2}};
        ArrayIterator<Integer> testIterator = new IntegerArrayIterator(testArray);
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(1));
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(2));
        assertThat(testIterator.hasNext(), is(false));
    }

    @DisplayName("It should successfully iterate over array with only null elements.")
    @Test
    public void nextWithOnlyNull() {
        int[][] testArray = {null};
        ArrayIterator<Integer> testIterator = new IntegerArrayIterator(testArray);
        assertThat(testIterator.hasNext(), is(true));
        assertThat(testIterator.next(), equalTo(null));
        assertThat(testIterator.hasNext(), is(false));
    }
}