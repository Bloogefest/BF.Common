package com.bloogefest.common.function;

/**
 * @param <V> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Getter<V> {

    /**
     * @param <V> Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Getter<V> nullable() {
        return () -> null;
    }

    /**
     * @param <V>   Not specified
     * @param value Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Getter<V> strict(final V value) {
        assert value != null : "The value mustn't be null";
        return () -> value;
    }

    /**
     * @param <V>    Not specified
     * @param getter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Getter<V> as(final Getter<V> getter) {
        assert getter != null : "The getter mustn't be null";
        return getter;
    }

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    V get();

    /**
     * @param getter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Getter<V> and(final Getter<V> getter) {
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
    default Getter<V> suppress(final V value) {
        return () -> value;
    }

}
