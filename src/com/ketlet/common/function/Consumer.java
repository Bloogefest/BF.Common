package com.ketlet.common.function;

/**
 * @param <T> Not specified
 *
 * @author Ketlet
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Consumer<T> {

    /**
     * @param <V> Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V> Consumer<V> empty() {
        return __ -> {
        };
    }

    /**
     * @param <V>      Not specified
     * @param consumer Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V> Consumer<V> as(final Consumer<V> consumer) {
        assert consumer != null : "The consumer mustn't be null";
        return consumer;
    }

    /**
     * @param object Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    void consume(final T object);

    /**
     * @param consumer Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    default Consumer<T> and(final Consumer<T> consumer) {
        assert consumer != null : "The consumer mustn't be null";
        return object -> {
            consume(object);
            consumer.consume(object);
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
    default Consumer<T> suppress(final T object) {
        return __ -> consume(object);
    }

}
