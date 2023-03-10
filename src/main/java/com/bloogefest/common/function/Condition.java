/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс логического выражения.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Condition {

    /**
     * Инициализирует логическое выражение, метод вычисления которого всегда возвращает переданный результат
     * вычисления.
     *
     * @param result результат вычисления.
     *
     * @return Логическое выражение с постоянным результатом вычисления.
     *
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    static @NotNull Condition constant(final boolean result) {
        return () -> result;
    }

    /**
     * Проверяет логическое выражение и, если оно ненулевое, возвращает его, в противном случае инициализирует и бросает
     * исключение.
     *
     * @param condition логическое выражение.
     *
     * @return Ненулевое логическое выражение.
     *
     * @throws NullException исключение валидации нулевого логического выражения.
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу логического выражения.
     * @since 1.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static @NotNull Condition of(final @NotNull Condition condition) throws NullException {
        return Validator.notNull(condition, "condition");
    }

    /**
     * Вычисляет логическое выражение, инициализирует результат вычисления и возвращает его.
     *
     * @return Результат вычисления.
     *
     * @throws ComputeException исключение вычисления логического выражения.
     * @since 3.0
     */
    @Contract
    boolean compute() throws ComputeException;

    /**
     * Инициализирует логическое выражение, метод вычисления которого вызывает метод вычисления этого логического
     * выражения, инвертирует результат вычисления и возвращает его.
     *
     * @return Логическое выражение с инвертированным результатом вычисления.
     *
     * @since 1.0
     */
    @Contract(value = "-> new", pure = true)
    default @NotNull Condition invert() {
        return () -> !compute();
    }

    /**
     * Проверяет вторичное логическое выражение и, если оно ненулевое, инициализирует другое логическое выражение, метод
     * вычисления которого последовательно соединяет метод вычисления этого и вторичного логического выражения
     * конъюнкцией, используя конструкцию try-finally, в противном случае инициализирует и бросает исключение.
     *
     * @param condition вторичное логическое выражение.
     *
     * @return Логическое выражение с комбинированным конъюнкцией результатом вычисления этого и переданного логического
     * выражения.
     *
     * @throws NullException исключение валидации нулевого вторичного логического выражения.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition and(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() && condition.compute();
    }

    /**
     * Проверяет вторичное логическое выражение и, если оно ненулевое, инициализирует другое логическое выражение, метод
     * вычисления которого последовательно соединяет метод вычисления этого и вторичного логического выражения строгой
     * дизъюнкцией, используя конструкцию try-finally, в противном случае инициализирует и бросает исключение.
     *
     * @param condition вторичное логическое выражение.
     *
     * @return Логическое выражение с комбинированным строгой дизъюнкцией результатом вычисления этого и переданного
     * логического выражения.
     *
     * @throws NullException исключение валидации нулевого вторичного логического выражения.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition xor(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() ^ condition.compute();
    }

    /**
     * Проверяет вторичное логическое выражение и, если оно ненулевое, инициализирует другое логическое выражение, метод
     * вычисления которого последовательно соединяет метод вычисления этого и вторичного логического выражения мягкой
     * дизъюнкцией, используя конструкцию try-finally, в противном случае инициализирует и бросает исключение.
     *
     * @param condition вторичное логическое выражение.
     *
     * @return Логическое выражение с комбинированным мягкой дизъюнкцией результатом вычисления этого и переданного
     * логического выражения.
     *
     * @throws NullException исключение валидации нулевого вторичного логического выражения.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition or(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() || condition.compute();
    }

    /**
     * Проверяет обратный вызов и, если он ненулевой, инициализирует логическое выражение, метод вычисления которого
     * проверяет результат вычисления этого логического выражения и, если он истинный, вызывает функцию обратного
     * вызова, а после возвращает результат вычисления этого логического выражения.
     *
     * @param callback обратный вызов.
     *
     * @return Логическое выражение с результатом вычисления этого логического выражения, истинность которого
     * обрабатывается функцией обратного вызова.
     *
     * @throws NullException исключение валидации нулевого обратного вызова.
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition then(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return () -> {
            final var result = compute();
            if (result) callback.call();
            return result;
        };
    }

    /**
     * Проверяет обратный вызов и, если он ненулевой, инициализирует логическое выражение, метод вычисления которого
     * проверяет результат вычисления этого логического выражения и, если он истинный, получает исключение либо ошибку
     * от поставщика и бросает его либо её.
     *
     * @param supplier поставщик исключения либо ошибки.
     *
     * @return Логическое выражение с результатом вычисления этого логического выражения, при истинности которого
     * получается исключение либо ошибка от поставщика и бросается.
     *
     * @throws NullException исключение валидации нулевого поставщика.
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition then(final @NotNull Supplier<? extends Throwable> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return () -> {
            if (compute()) throw new ComputeException(supplier.supply());
            return false;
        };
    }

    /**
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition otherwise(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return () -> {
            final var result = compute();
            if (!result) callback.call();
            return result;
        };
    }

    /**
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition otherwise(final @NotNull Supplier<? extends Throwable> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return () -> {
            if (!compute()) throw new ComputeException(supplier.supply());
            return true;
        };
    }

}
