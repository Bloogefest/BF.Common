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
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс логического выражения.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Condition {

    /**
     * Инициализирует логическое выражение с постоянным результатом вычисления.
     *
     * @param result постоянный результат вычисления.
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
     * Проверяет и возвращает логическое выражение, если оно ненулевое, в противном случае генерирует исключение.
     *
     * @param condition логическое выражение.
     *
     * @return Ненулевое логическое выражение.
     *
     * @throws NullException логическое выражение не должно быть нулевым.
     * @apiNote Данный метод можно использовать для инициализации лямбда-выражений и приведения их к этому типу.
     * @since 1.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static @NotNull Condition of(final @Nullable Condition condition) throws NullException {
        return Validator.notNull(condition, "condition");
    }

    /**
     * Вычисляет логическое выражение.
     *
     * @return Результат вычисления.
     *
     * @throws ComputeException исключение вычисления логического выражения.
     * @since 3.0
     */
    @Contract(pure = true)
    boolean compute() throws ComputeException;

    /**
     * Инвертирует логическое выражение.
     *
     * @return Инвертированное логическое выражение.
     *
     * @since 1.0
     */
    @Contract(value = "-> new", pure = true)
    default @NotNull Condition invert() {
        return () -> !compute();
    }

    /**
     * Соединяет конъюнкцией это и вторичное логическое выражение.
     *
     * @param condition вторичное логическое выражение.
     *
     * @return Соединённое конъюнкцией это и вторичное логическое выражение.
     *
     * @throws NullException вторичное логическое выражение не должно быть нулевым.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition and(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() && condition.compute();
    }

    /**
     * Соединяет строгой дизъюнкцией это и вторичное логическое выражение.
     *
     * @param condition вторичное логическое выражение.
     *
     * @return Соединённое строгой дизъюнкцией это и вторичное логическое выражение.
     *
     * @throws NullException вторичное логическое выражение не должно быть нулевым.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition xor(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() ^ condition.compute();
    }

    /**
     * Соединяет мягкой дизъюнкцией это и вторичное логическое выражение.
     *
     * @param condition вторичное логическое выражение.
     *
     * @return Соединённое мягкой дизъюнкцией это и вторичное логическое выражение.
     *
     * @throws NullException вторичное логическое выражение не должно быть нулевым.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition or(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() || condition.compute();
    }

}
