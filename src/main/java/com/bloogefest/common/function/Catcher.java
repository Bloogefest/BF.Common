/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Experimental;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * @since 4.0.0-RC3
 */
@Experimental
@FunctionalInterface
public interface Catcher<A, R, F extends Throwable> {

    /**
     * @since 4.0.0-RC3
     */
    static <A, R, F extends Throwable> Catcher<A, R, F> empty() {
        return argument -> BiOptional.empty();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NotNull Catcher<A, R, F> typed(final @NotNull Analyzer<? super A, R> analyzer,
                                                                       final @NotNull Class<F> type) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.unchecked(analyzer.analyze(argument), null);
            } catch (final @NotNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.unchecked(null, (F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NotNull Catcher<A, R, F> typed(final @NotNull Callback callback,
                                                                       final @NotNull Class<F> type) throws NullException {
        Validator.notNull(callback, "callback");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                callback.call();
                return BiOptional.empty();
            } catch (final @NotNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.unchecked(null, (F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, F extends Throwable> @NotNull Catcher<A, Boolean, F> typed(final @NotNull Condition condition,
                                                                          final @NotNull Class<F> type) throws NullException {
        Validator.notNull(condition, "condition");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.unchecked(condition.compute(), null);
            } catch (final @NotNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.unchecked(null, (F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NotNull Catcher<A, R, F> typed(final @NotNull Conveyor<? super A, R> conveyor,
                                                                       final @NotNull Class<F> type) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.unchecked(conveyor.convey(argument), null);
            } catch (final @NotNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.unchecked(null, (F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NotNull Catcher<A, R, F> typed(final @NotNull Handler<? super A> handler,
                                                                       final @NotNull Class<F> type) throws NullException {
        Validator.notNull(handler, "handler");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                handler.handle(argument);
                return BiOptional.empty();
            } catch (final @NotNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.unchecked(null, (F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, F extends Throwable> @NotNull Catcher<A, Boolean, F> typed(final @NotNull Predicate<? super A> predicate,
                                                                          final @NotNull Class<F> type) throws NullException {
        Validator.notNull(predicate, "predicate");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.unchecked(predicate.evaluate(argument), null);
            } catch (final @NotNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.unchecked(null, (F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NotNull Catcher<A, R, F> typed(final @NotNull Supplier<R> supplier,
                                                                       final @NotNull Class<F> type) throws NullException {
        Validator.notNull(supplier, "supplier");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.unchecked(supplier.supply(), null);
            } catch (final @NotNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.unchecked(null, (F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NotNull Catcher<A, R, Throwable> untyped(
            final @NotNull Analyzer<? super A, R> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.unchecked(analyzer.analyze(argument), null);
            } catch (final @NotNull Throwable failure) {
                return BiOptional.unchecked(null, failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NotNull Catcher<A, R, Throwable> untyped(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return argument -> {
            try {
                callback.call();
                return BiOptional.empty();
            } catch (final @NotNull Throwable failure) {
                return BiOptional.unchecked(null, failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A> @NotNull Catcher<A, Boolean, Throwable> untyped(
            final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return argument -> {
            try {
                return BiOptional.unchecked(condition.compute(), null);
            } catch (final @NotNull Throwable failure) {
                return BiOptional.unchecked(null, failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NotNull Catcher<A, R, Throwable> untyped(
            final @NotNull Conveyor<? super A, R> conveyor) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        return argument -> {
            try {
                return BiOptional.unchecked(conveyor.convey(argument), null);
            } catch (final @NotNull Throwable failure) {
                return BiOptional.unchecked(null, failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NotNull Catcher<A, R, Throwable> untyped(
            final @NotNull Handler<? super A> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return argument -> {
            try {
                handler.handle(argument);
                return BiOptional.empty();
            } catch (final @NotNull Throwable failure) {
                return BiOptional.unchecked(null, failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A> @NotNull Catcher<A, Boolean, Throwable> untyped(
            final @NotNull Predicate<? super A> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return argument -> {
            try {
                return BiOptional.unchecked(predicate.evaluate(argument), null);
            } catch (final @NotNull Throwable failure) {
                return BiOptional.unchecked(null, failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NotNull Catcher<A, R, Throwable> untyped(final @NotNull Supplier<R> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return argument -> {
            try {
                return BiOptional.unchecked(supplier.supply(), null);
            } catch (final @NotNull Throwable failure) {
                return BiOptional.unchecked(null, failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental @NotNull BiOptional<R, F> execute(final @NotNull A argument) throws UncaughtException;

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @Nullable R result(final @NotNull A argument) throws UncaughtException {
        return execute(argument).first();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @Nullable F failure(final @NotNull A argument) throws UncaughtException {
        return execute(argument).second();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NotNull R toResult(final @NotNull A argument) throws UncaughtException {
        return execute(argument).toFirst();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NotNull F toFailure(final @NotNull A argument) throws UncaughtException {
        return execute(argument).toSecond();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NotNull Optional<R> asResult(final @NotNull A argument) throws UncaughtException {
        return Optional.nullable(execute(argument).first());
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NotNull Optional<F> asFailure(final @NotNull A argument) throws UncaughtException {
        return Optional.nullable(execute(argument).second());
    }

}
