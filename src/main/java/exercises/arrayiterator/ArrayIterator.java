package exercises.arrayiterator;

/**
 * It describes iterator for iterating over of different types arrays.
 * @param <K> type of array to iterate over.
 */
interface ArrayIterator<K> {

    /**
     * Check if there is next element in array.
     * @return true if next element exists, otherwise false
     */
    boolean hasNext();

    /**
     * Moves iterator to new element and return it value.
     * @return new element value.
     */
    K next();
}