package com.bloogefest.common.function;

/**
 * @param <T> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Setter<T> {

    /**
     * @param <T> Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Setter<T> empty() {
        return __ -> {};
    }

    /**
     * @param <T>    Not specified
     * @param setter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Setter<T> as(final Setter<T> setter) {
        assert setter != null : "The setter mustn't be null";
        return setter;
    }

    /**
     * @param value Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    void set(final T value);

    /**
     * @param setter Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Setter<T> with(final Setter<T> setter) {
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
    default Setter<T> suppress(final T value) {
        return __ -> set(value);
    }

}
