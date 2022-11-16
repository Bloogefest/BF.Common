package com.ketlet.common.function;

/**
 * @param <T> Not specified
 * @param <R> Not specified
 *
 * @author Ketlet
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Function<T, R> {

    /**
     * @param <V> Not specified
     * @param <R> Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V, R> Function<V, R> nullable() {
        return __ -> null;
    }

    /**
     * @param <V>    Not specified
     * @param <R>    Not specified
     * @param result Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V, R> Function<V, R> strict(final R result) {
        return __ -> result;
    }

    /**
     * @param <V>     Not specified
     * @param <R>     Not specified
     * @param handler Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V, R> Function<V, R> as(final Function<V, R> handler) {
        assert handler != null : "The handler mustn't be null";
        return handler;
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    R execute(final T object);

    /**
     * @param function Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    default Function<T, R> and(final Function<T, R> function) {
        assert function != null : "The function mustn't be null";
        return object -> {
            execute(object);
            return function.execute(object);
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
    default Function<T, R> suppress(final T object) {
        return __ -> execute(object);
    }

}
