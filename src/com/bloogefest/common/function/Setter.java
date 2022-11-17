package com.bloogefest.common.function;

import com.bloogefest.common.NullException;
import com.bloogefest.common.Validator;

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
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> Setter<T> as(final Setter<T> setter) throws NullException {
        return Validator.notNull(setter, "setter");
    }

    /**
     * @param value Not specified
     *
     * @throws FunctionException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    void set(final T value) throws FunctionException;

    /**
     * @param setter Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Setter<T> with(final Setter<T> setter) throws NullException {
        Validator.notNull(setter, "setter");
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
