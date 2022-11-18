package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * @param <T> Not specified
 * @param <R> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Handler<T, R> {

    /**
     * @param <T> Not specified
     * @param <R> Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T, R> Handler<T, R> nullable() {
        return __ -> null;
    }

    /**
     * @param <T>    Not specified
     * @param <R>    Not specified
     * @param result Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T, R> Handler<T, R> strict(final R result) {
        return __ -> result;
    }

    /**
     * @param <T>     Not specified
     * @param <R>     Not specified
     * @param handler Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T, R> Handler<T, R> as(final Handler<T, R> handler) throws NullException {
        assert handler != null : "The handler mustn't be null";
        return Validator.notNull(handler, "handler");
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @throws FunctionException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    R handle(final T object) throws FunctionException;

    /**
     * @param handler Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Handler<T, R> with(final Handler<T, R> handler) {
        Validator.notNull(handler, "handler");
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
     * @author Bloogefest
     * @since 0.0.0
     */
    default Handler<T, R> suppress(final T object) {
        return __ -> handle(object);
    }

}
