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
import com.bloogefest.common.validation.ValidationException;
import com.bloogefest.common.validation.Validator;

/**
 * Одинарная функция — это функциональный интерфейс. Позволяет описать функцию с одним экземпляром-параметром и
 * экземпляром-результатом.
 *
 * @param <A> класс экземпляра-параметра.
 * @param <R> класс экземпляра-результата.
 *
 * @since 4.0.0-RC3
 */
@Experimental(from = "4.0.0-RC3", to = "4.0.0-RC5")
@FunctionalInterface
public interface Function<A, R> {

    /**
     * Создаёт и возвращает (1).
     *
     * @param result экземпляр-результат.
     *
     * @return (1).
     *
     * @apiNote (1) — это одинарная функция с постоянным экземпляром-результатом, переданным в этот метод.
     * @since 4.0.0-RC3
     */
    @Contract(value = "? -> new", impact = Contract.Impact.NONE)
    static <A, R> @NonNull Function<A, R> constant(final @Nullable R result) {
        return ignored -> result;
    }

    /**
     * Возвращает (1).
     *
     * @param function одинарная функция.
     *
     * @return (1).
     *
     * @apiNote (1) — это переданная в этот метод одинарная функция.
     * @since 4.0.0-RC3
     */
    @Contract(value = "? -> 1", impact = Contract.Impact.NONE)
    static <A, R> @NonNull Function<A, R> lambda(final @Nullable Function<A, R> function) {
        return function;
    }

    /**
     * Выполняет (1).
     *
     * @param argument экземпляр-параметр.
     *
     * @return Экземпляр-результат (1).
     *
     * @throws ValidationException исключение валидации переданного в этот метод экземпляра-параметра.
     * @throws FunctionException исключение выполнения (1).
     * @throws FunctionError ошибка выполнения (1).
     * @apiNote (1) — это описанная функция с одним экземпляром-параметром и экземпляром-результатом.
     * @since 4.0.0-RC3
     */
    @Contract(value = "? -> ?", impact = Contract.Impact.UNDEFINED)
    @Nullable R execute(final @Nullable A argument) throws ValidationException, FunctionException, FunctionError;

    /**
     * Создаёт и возвращает (3).
     *
     * @param function одинарная функция.
     *
     * @return (3).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная одинарная функция.
     * <p>
     * (2) — это переданная в этот метод одинарная функция.
     * <p>
     * (3) — это одинарная функция, которая сначала выполняет (1), а потом выполняет (2), передавая ей
     * экземпляр-результат (1). Возвращает экземпляр-результат (2).
     * @since 4.0.0-RC3
     */
    @Contract(value = "!null -> new; null -> fail", impact = Contract.Impact.NONE)
    default <R2> @NonNull Function<A, R2> with(final @NonNull Function<? super R, R2> function) throws NullException {
        Validator.notNull(function, "The passed function");
        return argument -> function.execute(execute(argument));
    }

    /**
     * Создаёт и возвращает (1).
     *
     * @param predicate одинарная функция-предикат.
     * @param function одинарная функция.
     *
     * @return (1).
     *
     * @throws NullException исключение валидации нулевой (2) или нулевой (3).
     * @apiNote (1) — это данная одинарная функция.
     * <p>
     * (2) — это переданная в этот метод одинарная функция-предикат.
     * <p>
     * (3) — это переданная в этот метод одинарная функция.
     * <p>
     * (4) — это одинарная функция, которая сначала выполняет (1), а потом выполняет (2), передавая ей
     * экземпляр-результат (1). Если экземпляр-результат (2) является истиной, то возвращает экземпляр-результат (1), в
     * противном случае выполняет (3) и возвращает её экземпляр-результат.
     * @since 4.0.0-RC3
     */
    @Contract(value = "!null, !null -> new; ?, ? -> fail", impact = Contract.Impact.NONE)
    default @NonNull Function<A, R> when(final @NonNull Predicate<? super R> predicate,
                                         final @NonNull Function<? super R, ? extends R> function) throws
                                                                                                   NullException {
        Validator.notNull(predicate, "The passed predicate");
        Validator.notNull(function, "The passed function");
        return argument -> {
            final @Nullable var result = execute(argument);
            try {
                return predicate.evaluate(result) ? result : function.execute(result);
            } catch (final @NonNull RuntimeException exception) {
                throw new FunctionException(exception);
            } catch (final @NonNull Error error) {
                throw new FunctionError(error);
            }
        };
    }

    /**
     * Создаёт и возвращает (1).
     *
     * @param predicate одинарная функция-предикат.
     * @param callback одинарная функция обратного вызова.
     *
     * @return (1).
     *
     * @throws NullException исключение валидации нулевой (2) или нулевой (3).
     * @apiNote (1) — это данная одинарная функция.
     * <p>
     * (2) — это переданная в этот метод одинарная функция-предикат.
     * <p>
     * (3) — это переданная в этот метод одинарная функция обратного вызова.
     * <p>
     * (4) — это одинарная функция, которая сначала выполняет (1), а потом выполняет (2), передавая ей
     * экземпляр-результат (1). Если экземпляр-результат (2) является истиной, то выполняет (3). Возвращает
     * экземпляр-результат (1).
     * @since 4.0.0-RC3
     */
    @Contract(value = "!null, !null -> new; ?, ? -> fail", impact = Contract.Impact.NONE)
    default @NonNull Function<A, R> when(final @NonNull Predicate<? super R> predicate,
                                         final @NonNull Callback callback) throws NullException {
        Validator.notNull(predicate, "The passed predicate");
        Validator.notNull(callback, "The passed callback");
        return argument -> {
            final @Nullable var result = execute(argument);
            try {
                if (predicate.evaluate(result)) callback.call();
                return result;
            } catch (final @NonNull RuntimeException exception) {
                throw new FunctionException(exception);
            } catch (final @NonNull Error error) {
                throw new FunctionError(error);
            }
        };
    }

    /**
     * Создаёт и возвращает (1).
     *
     * @param predicate одинарная функция-предикат.
     * @param handler одинарная функция-обработчик.
     *
     * @return (1).
     *
     * @throws NullException исключение валидации нулевой (2) или нулевой (3).
     * @apiNote (1) — это данная одинарная функция.
     * <p>
     * (2) — это переданная в этот метод одинарная функция-предикат.
     * <p>
     * (3) — это переданная в этот метод одинарная функция-обработчик.
     * <p>
     * (4) — это одинарная функция, которая сначала выполняет (1), а потом выполняет (2), передавая ей
     * экземпляр-результат (1). Если экземпляр-результат (2) является истиной, то выполняет (3), передавая ей
     * экземпляр-результат (1). Возвращает экземпляр-результат (1).
     * @since 4.0.0-RC3
     */
    @Contract(value = "!null, !null -> new; ?, ? -> fail", impact = Contract.Impact.NONE)
    default @NonNull Function<A, R> when(final @NonNull Predicate<? super R> predicate,
                                         final @NonNull Handler<? super R> handler) throws NullException {
        Validator.notNull(predicate, "The passed predicate");
        Validator.notNull(handler, "The passed handler");
        return argument -> {
            final @Nullable var result = execute(argument);
            try {
                if (predicate.evaluate(result)) handler.handle(result);
                return result;
            } catch (final @NonNull RuntimeException exception) {
                throw new FunctionException(exception);
            } catch (final @NonNull Error error) {
                throw new FunctionError(error);
            }
        };
    }

    /**
     * Создаёт и возвращает (1).
     *
     * @param condition одинарная функция алгебры логики.
     * @param function одинарная функция.
     *
     * @return (1).
     *
     * @throws NullException исключение валидации нулевой (2) или нулевой (3).
     * @apiNote (1) — это данная одинарная функция.
     * <p>
     * (2) — это переданная в этот метод одинарная функция алгебры логики.
     * <p>
     * (3) — это переданная в этот метод одинарная функция.
     * <p>
     * (4) — это одинарная функция, которая сначала выполняет (1), а потом выполняет (2). Если экземпляр-результат (2)
     * является истиной, то возвращает экземпляр-результат (1), в противном случае выполняет (3) и возвращает её
     * экземпляр-результат.
     * @since 4.0.0-RC3
     */
    @Contract(value = "!null, !null -> new; ?, ? -> fail", impact = Contract.Impact.NONE)
    default @Nullable Function<A, R> when(final @NonNull Condition condition,
                                          final @NonNull Function<? super R, ? extends R> function) throws
                                                                                                    NullException {
        Validator.notNull(condition, "The passed condition");
        Validator.notNull(function, "The passed function");
        return argument -> {
            final @Nullable var result = execute(argument);
            try {
                return condition.compute() ? result : function.execute(result);
            } catch (final @NonNull RuntimeException exception) {
                throw new FunctionException(exception);
            } catch (final @NonNull Error error) {
                throw new FunctionError(error);
            }
        };
    }

    /**
     * Создаёт и возвращает (1).
     *
     * @param condition одинарная функция алгебры логики.
     * @param callback одинарная функция обратного вызова.
     *
     * @return (1).
     *
     * @throws NullException исключение валидации нулевой (2) или нулевой (3).
     * @apiNote (1) — это данная одинарная функция.
     * <p>
     * (2) — это переданная в этот метод одинарная функция алгебры логики.
     * <p>
     * (3) — это переданная в этот метод одинарная функция обратного вызова.
     * <p>
     * (4) — это одинарная функция, которая сначала выполняет (1), а потом выполняет (2). Если экземпляр-результат (2)
     * является истиной, то выполняет (3). Возвращает экземпляр-результат (1).
     * @since 4.0.0-RC3
     */
    @Contract(value = "!null, !null -> new; ?, ? -> fail", impact = Contract.Impact.NONE)
    default @Nullable Function<A, R> when(final @NonNull Condition condition, final @NonNull Callback callback) throws
                                                                                                                NullException {
        Validator.notNull(condition, "The passed condition");
        Validator.notNull(callback, "The passed callback");
        return argument -> {
            final @Nullable var result = execute(argument);
            try {
                if (condition.compute()) callback.call();
                return result;
            } catch (final @NonNull RuntimeException exception) {
                throw new FunctionException(exception);
            } catch (final @NonNull Error error) {
                throw new FunctionError(error);
            }
        };
    }

    /**
     * Создаёт и возвращает (1).
     *
     * @param condition одинарная функция алгебры логики.
     * @param handler одинарная функция-обработчик.
     *
     * @return (1).
     *
     * @throws NullException исключение валидации нулевой (2) или нулевой (3).
     * @apiNote (1) — это данная одинарная функция.
     * <p>
     * (2) — это переданная в этот метод одинарная функция алгебры логики.
     * <p>
     * (3) — это переданная в этот метод одинарная функция-обработчик.
     * <p>
     * (4) — это одинарная функция, которая сначала выполняет (1), а потом выполняет (2). Если экземпляр-результат (2)
     * является истиной, то выполняет (3), передавая ей экземпляр-результат (1). Возвращает экземпляр-результат (1).
     * @since 4.0.0-RC3
     */
    @Contract(value = "!null, !null -> new; ?, ? -> fail", impact = Contract.Impact.NONE)
    default @Nullable Function<A, R> when(final @NonNull Condition condition,
                                          final @NonNull Handler<? super R> handler) throws NullException {
        Validator.notNull(condition, "The passed condition");
        Validator.notNull(handler, "The passed handler");
        return argument -> {
            final @Nullable var result = execute(argument);
            try {
                if (condition.compute()) handler.handle(result);
                return result;
            } catch (final @NonNull RuntimeException exception) {
                throw new FunctionException(exception);
            } catch (final @NonNull Error error) {
                throw new FunctionError(error);
            }
        };
    }

}
