package com.bloogefest.common.function;

/**
 * @param <T> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public interface Predicate<T> {

    /**
     * @param <V>    Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Predicate<V> strict(final boolean object) {
        return __ -> object;
    }

    /**
     * @param <V>       Not specified
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Predicate<V> as(final Predicate<V> predicate) {
        assert predicate != null : "The predicate mustn't be null";
        return predicate;
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    boolean evaluate(final T object);

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> invert() {
        return object -> !evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> and(final Predicate<T> predicate) {
        assert predicate != null : "The predicate mustn't be null";
        return object -> evaluate(object) && predicate.evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> or(final Predicate<T> predicate) {
        assert predicate != null : "The predicate mustn't be null";
        return object -> evaluate(object) || predicate.evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> xor(final Predicate<T> predicate) {
        assert predicate != null : "The predicate mustn't be null";
        return object -> evaluate(object) ^ predicate.evaluate(object);
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> suppress(final boolean object) {
        return __ -> object;
    }

}
