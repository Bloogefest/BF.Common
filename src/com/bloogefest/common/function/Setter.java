package com.bloogefest.common.function;

/**
 * @param <V> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Setter<V> {

    /**
     * @param <V> Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Setter<V> empty() {
        return __ -> {
        };
    }

    /**
     * @param <V>    Not specified
     * @param setter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Setter<V> as(final Setter<V> setter) {
        assert setter != null : "The setter mustn't be null";
        return setter;
    }

    /**
     * @param value Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    void set(final V value);

    /**
     * @param setter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Setter<V> and(final Setter<V> setter) {
        assert setter != null : "The setter mustn't be null";
        return value -> {
            set(value);
            setter.set(value);
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
    default Setter<V> suppress(final V value) {
        return __ -> set(value);
    }

}
