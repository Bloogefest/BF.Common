package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * @param <T> Not specified
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public interface Predicate<T> {

    /**
     * @param <V>    Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Predicate<V> strict(final boolean object) {
        return __ -> object;
    }

    /**
     * @param <V>       Not specified
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    static <V> Predicate<V> as(final Predicate<V> predicate) throws NullException {
        return Validator.notNull(predicate, "predicate");
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
    boolean evaluate(final T object) throws FunctionException;

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> invert() {
        return object -> !evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> and(final Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) && predicate.evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> or(final Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) || predicate.evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> xor(final Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) ^ predicate.evaluate(object);
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> suppress(final boolean object) {
        return __ -> object;
    }

}
