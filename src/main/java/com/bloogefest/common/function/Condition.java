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
 * Функция алгебры логики — это функциональный интерфейс. Позволяет описать функцию без экземпляров-параметров, но с
 * логическим экземпляром-результатом.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface Condition {

    /**
     * Создаёт и возвращает (1).
     *
     * @param result экземпляр-результат.
     *
     * @return (1).
     *
     * @apiNote (1) — это функция алгебры логики с переданным в этот метод экземпляром-результатом.
     * @since 1.0.0
     */
    @Contract(value = "? -> new", impact = Contract.Impact.NONE)
    static @NonNull Condition constant(final boolean result) {
        return () -> result;
    }

    /**
     * Возвращает (1).
     *
     * @param condition функция алгебры логики.
     *
     * @return (1).
     *
     * @apiNote (1) — это переданная в этот метод функция алгебры логики.
     * @since 4.0.0-RC3
     */
    @Contract(value = "? -> 1", impact = Contract.Impact.NONE)
    static @Nullable Condition lambda(final @Nullable Condition condition) {
        return condition;
    }

    /**
     * Выполняет (1).
     *
     * @return Экземпляр-результат (1).
     *
     * @throws ConditionException исключение выполнения (1).
     * @throws ConditionError ошибка выполнения (1).
     * @apiNote (1) — это описанная функция без экземпляров-параметров, но с логическим экземпляром-результатом.
     * @since 3.0.0
     */
    @Contract(value = "-> ?", impact = Contract.Impact.UNDEFINED)
    boolean compute() throws ConditionException, ConditionError;

    /**
     * Создаёт и возвращает (2).
     *
     * @return (2).
     *
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это функция алгебры логики, которая выполняет (1). Возвращает экземпляр-результат, противоположный
     * экземпляру-результату (1).
     * @since 4.0.0-RC3
     */
    @Contract(value = "-> new", impact = Contract.Impact.NONE)
    default @NonNull Condition not() {
        return () -> !compute();
    }

    /**
     * Создаёт и возвращает (3).
     *
     * @param condition функция алгебры логики.
     *
     * @return (3).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция алгебры логики.
     * <p>
     * (3) — это функция алгебры логики, которая выполняет (1). Если экземпляр-результат (1) является ложью, то
     * возвращает его, в противном случае выполняет (2) и возвращает её экземпляр-результат.
     * @since 1.0.0
     */
    @Contract(value = "!null -> new; null -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition and(final @NonNull Condition condition) throws NullException {
        Validator.notNull(condition, "The passed condition");
        return () -> compute() && condition.compute();
    }

    /**
     * Если (3) является истиной, то создаёт и возвращает (4), в противном случае — (5).
     *
     * @param condition функция алгебры логики.
     * @param both параметр полного выполнения.
     *
     * @return (4) или (5).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция алгебры логики.
     * <p>
     * (3) — это переданный в этот метод параметр полного выполнения.
     * <p>
     * (4) — это функция алгебры логики, которая сначала выполняет (1), а потом выполняет (2). Если
     * экземпляры-результаты (1) и (2) являются истинами, то возвращает истину, в противном случае — ложь.
     * <p>
     * (5) — это функция алгебры логики, которая выполняет (1). Если экземпляр-результат (1) является ложью, то
     * возвращает его, в противном случае выполняет (2) и возвращает её экземпляр-результат.
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC3", to = "4.0.0-RC5")
    @Contract(value = "!null, ? -> new; null, ? -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition and(final @NonNull Condition condition, final boolean both) throws NullException {
        Validator.notNull(condition, "The passed condition");
        return both ? () -> compute() & condition.compute() : () -> compute() && condition.compute();
    }

    /**
     * Создаёт и возвращает (3).
     *
     * @param condition функция алгебры логики.
     *
     * @return (3).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция алгебры логики.
     * <p>
     * (3) — это функция алгебры логики, которая выполняет (1). Если экземпляр-результат (1) является истиной, то
     * возвращает его, в противном случае выполняет (2) и возвращает её экземпляр-результат.
     * @since 1.0.0
     */
    @Contract(value = "!null -> new; null -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition or(final @NonNull Condition condition) throws NullException {
        Validator.notNull(condition, "The passed condition");
        return () -> compute() || condition.compute();
    }

    /**
     * Если (3) является истиной, то создаёт и возвращает (4), в противном случае — (5).
     *
     * @param condition функция алгебры логики.
     * @param both параметр полного выполнения.
     *
     * @return (4) или (5).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция алгебры логики.
     * <p>
     * (3) — это переданный в этот метод параметр полного выполнения.
     * <p>
     * (4) — это функция алгебры логики, которая сначала выполняет (1), а потом выполняет (2). Если хотя бы один из
     * экземпляров-результатов (1) и (2) является истиной, то возвращает истину, в противном случае — ложь.
     * <p>
     * (5) — это функция алгебры логики, которая выполняет (1). Если экземпляр-результат (1) является истиной, то
     * возвращает его, в противном случае выполняет (2) и возвращает её экземпляр-результат.
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC3", to = "4.0.0-RC5")
    @Contract(value = "!null, ? -> new; null, ? -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition or(final @NonNull Condition condition, final boolean both) throws NullException {
        Validator.notNull(condition, "The passed condition");
        return both ? () -> compute() | condition.compute() : () -> compute() || condition.compute();
    }

    /**
     * Создаёт и возвращает (3).
     *
     * @param condition функция алгебры логики.
     *
     * @return (3).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция алгебры логики.
     * <p>
     * (3) — это функция алгебры логики, которая сначала выполняет (1), а потом выполняет (2). Если только один из
     * экземпляров-результатов (1) и (2) является истиной, то возвращает истину, в противном случае — ложь.
     * @since 1.0.0
     */
    @Contract(value = "!null -> new; null -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition xor(final @NonNull Condition condition) throws NullException {
        Validator.notNull(condition, "The passed condition");
        return () -> compute() ^ condition.compute();
    }

    /**
     * Создаёт и возвращает (3).
     *
     * @param callback функция обратного вызова.
     *
     * @return (3).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция обратного вызова.
     * <p>
     * (3) — это функция алгебры логики, которая выполняет (1). Если экземпляр-результат (1) является истиной, то
     * выполняет (2). Возвращает экземпляр-результат (1).
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC3", to = "4.0.0-RC5")
    @Contract(value = "!null -> new; null -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition when(final @NonNull Callback callback) throws NullException {
        Validator.notNull(callback, "The passed callback");
        return () -> {
            final var result = compute();
            if (result) callback.call();
            return result;
        };
    }

    /**
     * Создаёт и возвращает (4).
     *
     * @param supplier функция-поставщик.
     *
     * @return (4).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция-поставщик.
     * <p>
     * (3) — это исключение выполнения функции алгебры логики.
     * <p>
     * (4) — это функция алгебры логики, которая выполняет (1). Если экземпляр-результат (1) является истиной, то
     * возвращает его, в противном случае выполняет (2). Если класс экземпляра-результата (2) можно привести к классу
     * (3), то бросает экземпляр-результат (2), в противном случае генерирует (3) на основе причины, заданной
     * экземпляром-результатом (2).
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC3", to = "4.0.0-RC5")
    @Contract(value = "!null -> new; null -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition exception(final @NonNull Supplier<? extends RuntimeException> supplier) throws
                                                                                                       NullException {
        Validator.notNull(supplier, "The passed supplier");
        return () -> {
            if (compute()) return true;
            final @NonNull var throwable = supplier.get();
            throw throwable instanceof ConditionException ? throwable : new ConditionException(throwable);
        };
    }

    /**
     * Создаёт и возвращает (4).
     *
     * @param supplier функция-поставщик.
     *
     * @return (4).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция алгебры логики.
     * <p>
     * (2) — это переданная в этот метод функция-поставщик.
     * <p>
     * (3) — это ошибка выполнения функции алгебры логики.
     * <p>
     * (4) — это функция алгебры логики, которая выполняет (1). Если экземпляр-результат (1) является истиной, то
     * возвращает его, в противном случае выполняет (2). Если класс экземпляра-результата (2) можно привести к классу
     * (3), то бросает экземпляр-результат (2), в противном случае генерирует (3) на основе причины, заданной
     * экземпляром-результатом (2).
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC3", to = "4.0.0-RC5")
    @Contract(value = "!null -> new; null -> fail", impact = Contract.Impact.NONE)
    default @NonNull Condition error(final @NonNull Supplier<? extends Error> supplier) throws NullException {
        Validator.notNull(supplier, "The passed supplier");
        return () -> {
            if (compute()) return true;
            final @NonNull var error = supplier.get();
            throw error instanceof ConditionError ? error : new ConditionError(error);
        };
    }

}
