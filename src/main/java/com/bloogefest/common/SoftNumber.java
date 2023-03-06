/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common;

import com.bloogefest.common.validation.NullException;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Интерфейс мягкой обёртки примитива числового типа.
 *
 * @since 3.0
 */
@Experimental
public interface SoftNumber<J extends Number> extends SoftPrimitive<J> {

    /**
     * Инициализирует мягкую обёртку инвертированного примитива числового типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка инвертированного примитива числового типа.
     *
     * @since 3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftNumber<J> invert();

    /**
     * Инициализирует мягкую обёртку инкрементированного примитива числового типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка инкрементированного примитива числового типа.
     *
     * @since 3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftNumber<J> increment();

    /**
     * Инициализирует мягкую обёртку декрементированного примитива числового типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка декрементированного примитива числового типа.
     *
     * @since 3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftNumber<J> decrement();

    /**
     * Инициализирует мягкую обёртку суммы примитивов числового типа этой мягкой обёртки и вторичного операнда.
     *
     * @param operand вторичный операнд.
     *
     * @return Мягкая обёртка суммы примитивов числового типа.
     *
     * @throws NullException исключение валидации нулевого вторичного операнда.
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> add(final @NotNull SoftNumber<? extends Number> operand) throws NullException;

    /**
     * Инициализирует мягкую обёртку разности примитивов числового типа этой мягкой обёртки и вторичного операнда.
     *
     * @param operand вторичный операнд.
     *
     * @return Мягкая обёртка разности примитивов числового типа.
     *
     * @throws NullException исключение валидации нулевого вторичного операнда.
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> subtract(final @NotNull SoftNumber<? extends Number> operand) throws NullException;

    /**
     * Инициализирует мягкую обёртку произведения примитивов числового типа этой мягкой обёртки и вторичного операнда.
     *
     * @param operand вторичный операнд.
     *
     * @return Мягкая обёртка произведения примитивов числового типа.
     *
     * @throws NullException исключение валидации нулевого вторичного операнда.
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> multiply(final @NotNull SoftNumber<? extends Number> operand) throws NullException;

    /**
     * Инициализирует мягкую обёртку деления с остатком примитивов числового типа этой мягкой обёртки и вторичного
     * операнда.
     *
     * @param operand вторичный операнд.
     *
     * @return Мягкая обёртка деления с остатком примитивов числового типа.
     *
     * @throws NullException исключение валидации нулевого вторичного операнда.
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> divide(final @NotNull SoftNumber<? extends Number> operand) throws NullException;

    /**
     * Инициализирует мягкую обёртку деления по модулю примитивов числового типа этой мягкой обёртки и вторичного
     * операнда.
     *
     * @param operand вторичный операнд.
     *
     * @return Мягкая обёртка деления по модулю примитивов числового типа.
     *
     * @throws NullException исключение валидации нулевого вторичного операнда.
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftNumber<J> module(final @NotNull SoftNumber<? extends Number> operand) throws NullException;

    /**
     * Инициализирует и возвращает мягкую обёртку 8-ми битного примитива целочисленного типа над примитивом числового
     * типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка 8-ми битного примитива целочисленного типа над примитивом числового типа этой мягкой
     * обёртки.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    @NotNull SoftByte toByte();

    /**
     * Инициализирует и возвращает мягкую обёртку 16-ти битного примитива целочисленного типа над примитивом числового
     * типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка 16-ти битного примитива целочисленного типа над примитивом числового типа этой мягкой
     * обёртки.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    @NotNull SoftShort toShort();

    /**
     * Инициализирует и возвращает мягкую обёртку 32-х битного примитива целочисленного типа над примитивом числового
     * типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка 32-х битного примитива целочисленного типа над примитивом числового типа этой мягкой
     * обёртки.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    @NotNull SoftInteger toInteger();

    /**
     * Инициализирует и возвращает мягкую обёртку 64-х битного примитива целочисленного типа над примитивом числового
     * типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка 64-х битного примитива целочисленного типа над примитивом числового типа этой мягкой
     * обёртки.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    @NotNull SoftLong toLong();

    /**
     * Инициализирует и возвращает мягкую обёртку 32-х битного примитива нецелочисленного типа с плавающей точкой над
     * примитивом числового типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка 32-х битного примитива нецелочисленного типа с плавающей точкой над примитивом числового
     * типа этой мягкой обёртки.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    @NotNull SoftFloat toFloat();

    /**
     * Инициализирует и возвращает мягкую обёртку 64-х битного примитива нецелочисленного типа с плавающей точкой над
     * примитивом числового типа этой мягкой обёртки.
     *
     * @return Мягкая обёртка 64-х битного примитива нецелочисленного типа с плавающей точкой над примитивом числового
     * типа этой мягкой обёртки.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    @NotNull SoftDouble toDouble();

    /**
     * Возвращает родную обёртку примитива числового типа.
     *
     * @return Родная обёртка примитива числового типа.
     *
     * @since 3.0
     */
    @Override
    @Contract(pure = true)
    @NotNull J toJava();

}
