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
public interface Handler<T, R> {

    /**
     * @param <V> Not specified
     * @param <R> Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static <V, R> Handler<V, R> nullable() {
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
    static <V, R> Handler<V, R> strict(final R result) {
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
    static <V, R> Handler<V, R> as(final Handler<V, R> handler) {
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
    R handle(final T object);

    /**
     * @param handler Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    default Handler<T, R> and(final Handler<T, R> handler) {
        assert handler != null : "The handler mustn't be null";
        return object -> {
            handle(object);
            return handler.handle(object);
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
    default Handler<T, R> suppress(final T object) {
        return __ -> handle(object);
    }

}
