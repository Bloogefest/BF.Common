/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Интерфейс мягкой обёртки примитива числового типа.
 *
 * @since 0.3.0
 */
@Experimental
public interface SoftNumber<J extends Number> extends SoftPrimitive<J> {

    /**
     * Выполняет инверсию данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftNumber<J> invert();

    /**
     * Выполняет инкремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftNumber<J> increment();

    /**
     * Выполняет декремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftNumber<J> decrement();

    /**
     * Выполняет сложение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление c остатком данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива числового типа.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива.
     *
     * @since 0.3.0
     */
    @Override
    @Contract(pure = true)
    @NotNull J toJava();

}
