package com.bloogefest.common.function;

/**
 * @param <T> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public interface Supplier<T> {

    /**
     * @param <T> Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Supplier<T> nullable() {
        return () -> null;
    }

    /**
     * @param <T>    Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Supplier<T> strict(final T object) {
        return () -> object;
    }

    /**
     * @param <T>      Not specified
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Supplier<T> as(final Supplier<T> supplier) {
        assert supplier != null : "The supplier mustn't be null";
        return supplier;
    }

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    T supply();

    /**
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Supplier<T> with(final Supplier<T> supplier) {
        assert supplier != null : "The supplier mustn't be null";
        return () -> {
            supply();
            return supplier.supply();
        };
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Supplier<T> suppress(final T object) {
        return () -> object;
    }

}
