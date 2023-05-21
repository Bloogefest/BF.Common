/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.Experimental;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * @since 4.0.0-RC3
 */
@Experimental
@FunctionalInterface
public interface Conveyor<I, O> {

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("-> new")
    static <I> @NotNull Conveyor<I, I> through() {
        return input -> input;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    static <I, O> @NotNull Conveyor<I, O> constant(final @NotNull O output) throws NullException {
        Validator.notNull(output, "output");
        return input -> output;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    static <I, O> @NotNull Conveyor<I, O> check(final @NotNull Conveyor<I, O> conveyor) throws NullException {
        return Validator.notNull(conveyor, "conveyor");
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> 1")
    static <I, O> @NotNull Conveyor<I, O> lambda(final @NotNull Conveyor<I, O> conveyor) {
        return conveyor;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("? -> ?")
    @NotNull O convey(final @NotNull I input) throws NullException;

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("-> new")
    default @NotNull Conveyor<I, Optional<O>> optional() {
        return input -> Optional.nullable(convey(input));
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NotNull Conveyor<I, O> callback(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return input -> {
            callback.call();
            return convey(input);
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NotNull Conveyor<I, O> handler(final @NotNull Handler<? super O> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return input -> {
            final @NotNull var output = convey(input);
            handler.handle(output);
            return output;
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <E> @NotNull Conveyor<I, E> supplier(final @NotNull Supplier<E> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return input -> supplier.supply();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <E> @NotNull Conveyor<I, E> analyzer(final @NotNull Analyzer<? super O, E> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return input -> analyzer.analyze(convey(input));
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <E> @NotNull Conveyor<I, E> conveyor(final @NotNull Conveyor<? super O, E> conveyor) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        return input -> conveyor.convey(convey(input));
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NotNull Conveyor<I, O> predicate(final @NotNull Predicate<? super O> predicate) {
        Validator.notNull(predicate, "predicate");
        return input -> {
            final @NotNull var output = convey(input);
            return predicate.evaluate(output) ? output : null;
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_, _ -> new")
    default <F extends Throwable> @NotNull Conveyor<I, BiOptional<O, F>> failure(
            final @NotNull Class<F> type) throws NullException {
        Validator.notNull(type, "type");
        return Catcher.typed(this, type)::execute;
    }

}
