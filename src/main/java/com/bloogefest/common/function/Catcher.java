/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

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
public interface Catcher<A, R, F extends Throwable> {

    /**
     * @since 4.0.0-RC3
     */
    static <A, R, F extends Throwable> Catcher<A, R, F> empty() {
        return argument -> BiOptional.without();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> typed(final @NonNull Analyzer<? super A, R> analyzer,
                                                                       final @NonNull Class<F> type) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.withFirst(analyzer.analyze(argument));
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.withSecond((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> typed(final @NonNull Callback callback,
                                                                       final @NonNull Class<F> type) throws NullException {
        Validator.notNull(callback, "callback");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                callback.call();
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.withSecond((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, F extends Throwable> @NonNull Catcher<A, Boolean, F> typed(final @NonNull Condition condition,
                                                                          final @NonNull Class<F> type) throws NullException {
        Validator.notNull(condition, "condition");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.withFirst(condition.compute());
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.withSecond((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> typed(final @NonNull Conveyor<? super A, R> conveyor,
                                                                       final @NonNull Class<F> type) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.withFirst(conveyor.convey(argument));
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.withSecond((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> typed(final @NonNull Handler<? super A> handler,
                                                                       final @NonNull Class<F> type) throws NullException {
        Validator.notNull(handler, "handler");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                handler.handle(argument);
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.withSecond((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, F extends Throwable> @NonNull Catcher<A, Boolean, F> typed(final @NonNull Predicate<? super A> predicate,
                                                                          final @NonNull Class<F> type) throws NullException {
        Validator.notNull(predicate, "predicate");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.withFirst(predicate.evaluate(argument));
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.withSecond((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> typed(final @NonNull Supplier<R> supplier,
                                                                       final @NonNull Class<F> type) throws NullException {
        Validator.notNull(supplier, "supplier");
        Validator.notNull(type, "type");
        return argument -> {
            try {
                return BiOptional.withFirst(supplier.get());
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return BiOptional.withSecond((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> analyzed(
            final @NonNull Analyzer<? super A, R> analyzer, final @NonNull Class<F> type,
            final @NonNull Analyzer<? super F, BiOptional<R, F>> analyzer_) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        Validator.notNull(analyzer_, "analyzer_");
        return argument -> {
            try {
                return BiOptional.withFirst(analyzer.analyze(argument));
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return analyzer_.analyze((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> analyzed(final @NonNull Callback callback,
                                                                          final @NonNull Class<F> type,
                                                                          final @NonNull Analyzer<? super F, BiOptional<R, F>> analyzer) throws NullException {
        Validator.notNull(callback, "callback");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                callback.call();
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return analyzer.analyze((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, F extends Throwable> @NonNull Catcher<A, Boolean, F> analyzed(final @NonNull Condition condition,
                                                                             final @NonNull Class<F> type,
                                                                             final @NonNull Analyzer<? super F, BiOptional<Boolean, F>> analyzer) throws NullException {
        Validator.notNull(condition, "condition");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(condition.compute());
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return analyzer.analyze((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> analyzed(
            final @NonNull Conveyor<? super A, R> conveyor, final @NonNull Class<F> type,
            final @NonNull Analyzer<? super F, BiOptional<R, F>> analyzer) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(conveyor.convey(argument));
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return analyzer.analyze((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> analyzed(final @NonNull Handler<? super A> handler,
                                                                          final @NonNull Class<F> type,
                                                                          final @NonNull Analyzer<? super F, BiOptional<R, F>> analyzer) throws NullException {
        Validator.notNull(handler, "handler");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                handler.handle(argument);
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return analyzer.analyze((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, F extends Throwable> @NonNull Catcher<A, Boolean, F> analyzed(
            final @NonNull Predicate<? super A> predicate, final @NonNull Class<F> type,
            final @NonNull Analyzer<? super F, BiOptional<Boolean, F>> analyzer) throws NullException {
        Validator.notNull(predicate, "predicate");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(predicate.evaluate(argument));
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return analyzer.analyze((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    @SuppressWarnings("unchecked")
    static <A, R, F extends Throwable> @NonNull Catcher<A, R, F> analyzed(final @NonNull Supplier<R> supplier,
                                                                          final @NonNull Class<F> type,
                                                                          final @NonNull Analyzer<? super F, BiOptional<R, F>> analyzer) throws NullException {
        Validator.notNull(supplier, "supplier");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(supplier.get());
            } catch (final @NonNull Throwable failure) {
                if (type.isInstance(failure)) return analyzer.analyze((F) failure);
                throw new UncaughtException(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> untyped(
            final @NonNull Analyzer<? super A, R> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(analyzer.analyze(argument));
            } catch (final @NonNull Throwable failure) {
                return BiOptional.withSecond(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> untyped(final @NonNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return argument -> {
            try {
                callback.call();
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                return BiOptional.withSecond(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A> @NonNull Catcher<A, Boolean, Throwable> untyped(
            final @NonNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return argument -> {
            try {
                return BiOptional.withFirst(condition.compute());
            } catch (final @NonNull Throwable failure) {
                return BiOptional.withSecond(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> untyped(
            final @NonNull Conveyor<? super A, R> conveyor) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        return argument -> {
            try {
                return BiOptional.withFirst(conveyor.convey(argument));
            } catch (final @NonNull Throwable failure) {
                return BiOptional.withSecond(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> untyped(
            final @NonNull Handler<? super A> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return argument -> {
            try {
                handler.handle(argument);
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                return BiOptional.withSecond(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A> @NonNull Catcher<A, Boolean, Throwable> untyped(
            final @NonNull Predicate<? super A> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return argument -> {
            try {
                return BiOptional.withFirst(predicate.evaluate(argument));
            } catch (final @NonNull Throwable failure) {
                return BiOptional.withSecond(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> untyped(final @NonNull Supplier<R> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return argument -> {
            try {
                return BiOptional.withFirst(supplier.get());
            } catch (final @NonNull Throwable failure) {
                return BiOptional.withSecond(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> analyzed(final @NonNull Analyzer<? super A, R> analyzer,
                                                             final @NonNull Analyzer<Throwable, BiOptional<R, Throwable>> analyzer_) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        Validator.notNull(analyzer_, "analyzer_");
        return argument -> {
            try {
                return BiOptional.withFirst(analyzer.analyze(argument));
            } catch (final @NonNull Throwable failure) {
                return analyzer_.analyze(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> analyzed(final @NonNull Callback callback,
                                                             final @NonNull Analyzer<Throwable, BiOptional<R, Throwable>> analyzer) throws NullException {
        Validator.notNull(callback, "callback");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                callback.call();
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                return analyzer.analyze(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A> @NonNull Catcher<A, Boolean, Throwable> analyzed(final @NonNull Condition condition,
                                                                final @NonNull Analyzer<Throwable, BiOptional<Boolean, Throwable>> analyzer) throws NullException {
        Validator.notNull(condition, "condition");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(condition.compute());
            } catch (final @NonNull Throwable failure) {
                return analyzer.analyze(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> analyzed(final @NonNull Conveyor<? super A, R> conveyor,
                                                             final @NonNull Analyzer<Throwable, BiOptional<R, Throwable>> analyzer) throws NullException {
        Validator.notNull(conveyor, "conveyor");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(conveyor.convey(argument));
            } catch (final @NonNull Throwable failure) {
                return analyzer.analyze(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> analyzed(final @NonNull Handler<? super A> handler,
                                                             final @NonNull Analyzer<Throwable, BiOptional<R, Throwable>> analyzer) throws NullException {
        Validator.notNull(handler, "handler");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                handler.handle(argument);
                return BiOptional.without();
            } catch (final @NonNull Throwable failure) {
                return analyzer.analyze(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A> @NonNull Catcher<A, Boolean, Throwable> analyzed(final @NonNull Predicate<? super A> predicate,
                                                                final @NonNull Analyzer<Throwable, BiOptional<Boolean, Throwable>> analyzer) throws NullException {
        Validator.notNull(predicate, "predicate");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(predicate.evaluate(argument));
            } catch (final @NonNull Throwable failure) {
                return analyzer.analyze(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    static <A, R> @NonNull Catcher<A, R, Throwable> analyzed(final @NonNull Supplier<R> supplier,
                                                             final @NonNull Analyzer<Throwable, BiOptional<R, Throwable>> analyzer) throws NullException {
        Validator.notNull(supplier, "supplier");
        Validator.notNull(analyzer, "analyzer");
        return argument -> {
            try {
                return BiOptional.withFirst(supplier.get());
            } catch (final @NonNull Throwable failure) {
                return analyzer.analyze(failure);
            }
        };
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental @NonNull BiOptional<R, F> execute(final @NonNull A argument) throws UncaughtException;

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @Nullable R result(final @NonNull A argument) throws UncaughtException {
        return execute(argument).first().get();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @Nullable F failure(final @NonNull A argument) throws UncaughtException {
        return execute(argument).second().get();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NonNull R toResult(final @NonNull A argument) throws UncaughtException {
        return execute(argument).first().get();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NonNull F toFailure(final @NonNull A argument) throws UncaughtException {
        return execute(argument).second().get();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NonNull Optional<R> asResult(final @NonNull A argument) throws UncaughtException {
        return execute(argument).first();
    }

    /**
     * @since 4.0.0-RC3
     */
    @Experimental
    default @NonNull Optional<F> asFailure(final @NonNull A argument) throws UncaughtException {
        return execute(argument).second();
    }

}
