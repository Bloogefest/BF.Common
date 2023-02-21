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
     * Инициализирует экземпляр логического выражения с постоянным результатом вычисления в виде экземпляра примитива
     * логического типа.
     *
     * @param value экземпляр примитива логического типа.
     *
     * @return Экземпляр логического выражения с постоянным результатом вычисления.
     *
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    static @NotNull Condition constant(final boolean value) {
        return () -> value;
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param condition экземпляр логического выражения.
     *
     * @return Экземпляр логического выражения.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод можно использовать для инициализации лямбда-выражений и приведения их к типу
     * функционального интерфейса логического выражения.
     * @since 1.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static @NotNull Condition of(final @Nullable Condition condition) throws NullException {
        return Validator.notNull(condition, "condition");
    }

    /**
     * Вычисляет экземпляр примитива логического типа.
     *
     * @return Экземпляр примитива логического типа.
     *
     * @throws ComputeException исключение вычисления результата логического выражения.
     * @since 3.0
     */
    @Contract(pure = true)
    boolean compute() throws ComputeException;

    /**
     * Инвертирует экземпляр.
     *
     * @return Экземпляр логического выражения.
     *
     * @since 1.0
     */
    @Contract(value = "-> new", pure = true)
    default @NotNull Condition invert() {
        return () -> !compute();
    }

    /**
     * Комбинирует данный экземпляр вычисляемого условного выражения конъюнкцией с переданным.
     *
     * @param condition экземпляр вычисляемого условного выражения.
     *
     * @return Комбинированный экземпляр вычисляемого условного выражения.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра вычисляемого
     * условного выражения.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition and(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() && condition.compute();
    }

    /**
     * Комбинирует данный экземпляр вычисляемого условного выражения строгой дизъюнкцией с переданным.
     *
     * @param condition экземпляр вычисляемого условного выражения.
     *
     * @return Комбинированный экземпляр вычисляемого условного выражения.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра вычисляемого
     * условного выражения.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition xor(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() ^ condition.compute();
    }

    /**
     * Комбинирует данный экземпляр вычисляемого условного выражения мягкой дизъюнкцией с переданным.
     *
     * @param condition экземпляр вычисляемого условного выражения.
     *
     * @return Комбинированный экземпляр вычисляемого условного выражения.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра вычисляемого
     * условного выражения.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition or(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> compute() || condition.compute();
    }

}
