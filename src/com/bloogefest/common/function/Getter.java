package com.bloogefest.common.function;

/**
 * @param <T> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Getter<T> {

    /**
     * @param <T> Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Getter<T> nullable() {
        return () -> null;
    }

    /**
     * @param <T>   Not specified
     * @param value Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Getter<T> strict(final T value) {
        assert value != null : "The value mustn't be null";
        return () -> value;
    }

    /**
     * @param <T>    Not specified
     * @param getter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Getter<T> as(final Getter<T> getter) {
        assert getter != null : "The getter mustn't be null";
        return getter;
    }

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    T get();

    /**
     * @param getter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Getter<T> with(final Getter<T> getter) {
        assert getter != null : "The getter mustn't be null";
        return () -> {
            get();
            return getter.get();
        };
    }

    /**
     * @param value Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Getter<T> suppress(final T value) {
        return () -> value;
    }

}
