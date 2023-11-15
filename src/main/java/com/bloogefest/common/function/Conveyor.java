/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.Experimental;
import com.bloogefest.annotation.NonNull;
import com.bloogefest.annotation.Nullable;
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
    static <I> @NonNull Conveyor<I, I> checked() {
        return input -> Validator.notNull(input, "input");
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("-> new")
    static <I> @NonNull Conveyor<I, I> unchecked() {
        return input -> input;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    static <I, O> @NonNull Conveyor<I, O> checked(final @NonNull O output) throws NullException {
        Validator.notNull(output, "output");
        return input -> output;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    static <I, O> @NonNull Conveyor<I, O> unchecked(final @Nullable O output) throws NullException {
        return input -> output;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> 1")
    static <I, O> @NonNull Conveyor<I, O> lambda(final @NonNull Conveyor<I, O> conveyor) {
        return conveyor;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("? -> ?")
    @NonNull O convey(final @NonNull I input) throws NullException, ConveyException;

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <O_> @NonNull Conveyor<I, O_> analyzer(
            final @NonNull Analyzer<? super O, O_> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return input -> analyzer.analyze(convey(input));
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NonNull Conveyor<I, O> callback(final @NonNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return input -> {
            final var output = convey(input);
            callback.call();
            return output;
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("-> new")
    default <O_, F extends Throwable> @NonNull Conveyor<I, BiOptional<O_, F>> catcher(
            final @NonNull Catcher<? super O, O_, F> catcher) throws NullException {
        Validator.notNull(catcher, "catcher");
        return input -> catcher.execute(convey(input));
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("-> new")
    default @NonNull Conveyor<I, BiOptional<O, Boolean>> condition(
            final @NonNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return input -> BiOptional.auto(convey(input), condition.compute());
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <O_> @NonNull Conveyor<I, O_> conveyor(
            final @NonNull Conveyor<? super O, O_> conveyor) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        return input -> conveyor.convey(convey(input));
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NonNull Conveyor<I, O> handler(final @NonNull Handler<? super O> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return input -> {
            final var output = convey(input);
            handler.handle(output);
            return output;
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("-> new")
    default @NonNull Conveyor<I, Optional<O>> optional() {
        return input -> Optional.auto(convey(input));
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NonNull Conveyor<I, BiOptional<O, Boolean>> predicate(final @NonNull Predicate<? super O> predicate) {
        Validator.notNull(predicate, "predicate");
        return input -> {
            final var output = convey(input);
            return BiOptional.auto(output, predicate.evaluate(output));
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <O_> @NonNull Conveyor<I, BiOptional<O, O_>> supplier(
            final @NonNull Supplier<O_> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return input -> BiOptional.auto(convey(input), supplier.get());
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NonNull Conveyor<I, BiOptional<O, Throwable>> failure() throws NullException {
        return Catcher.untyped(this)::execute;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <F extends Throwable> @NonNull Conveyor<I, BiOptional<O, F>> failure(
            final @NonNull Class<F> type) throws NullException {
        Validator.notNull(type, "type");
        return Catcher.typed(this, type)::execute;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default <F extends Throwable> @NonNull Conveyor<I, BiOptional<O, F>> failure(final @NonNull Class<F> type,
                                                                                 final @NonNull Analyzer<? super F, BiOptional<O, F>> analyzer) throws NullException {
        Validator.notNull(type, "type");
        Validator.notNull(analyzer, "analyzer");
        return Catcher.analyzed(this, type, analyzer)::execute;
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @Contract("_ -> new")
    default @NonNull Conveyor<I, BiOptional<O, Throwable>> failure(
            final @NonNull Analyzer<Throwable, BiOptional<O, Throwable>> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return Catcher.analyzed(this, analyzer)::execute;
    }

}
