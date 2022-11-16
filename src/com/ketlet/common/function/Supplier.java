package com.ketlet.common.function;

/**
 * @param <T> Not specified
 *
 * @author Ketlet
 * @version 0.0
 * @since 0.0.0
 */
public interface Supplier<T> {

    /**
     * @param <V> Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V> Supplier<V> nullable() {
        return () -> null;
    }

    /**
     * @param <V>    Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V> Supplier<V> strict(final V object) {
        return () -> object;
    }

    /**
     * @param <V>      Not specified
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V> Supplier<V> as(final Supplier<V> supplier) {
        assert supplier != null : "The supplier mustn't be null";
        return supplier;
    }

    /**
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    T supply();

    /**
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    default Supplier<T> and(final Supplier<T> supplier) {
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
     * @author Ketlet
     * @since 0.0.0
     */
    default Supplier<T> suppress(final T object) {
        return () -> object;
    }

}
