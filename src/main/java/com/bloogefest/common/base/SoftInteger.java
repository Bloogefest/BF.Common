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
 * Интерфейс мягкой обёртки примитива 32-х битного целочисленного типа.
 *
 * @since 3.0
 */
@Experimental
public interface SoftInteger extends SoftNumber<Integer> {

    /**
     * Выполняет запаковку экземпляра родной обёртки примитива 32-х битного целочисленного типа.
     *
     * @param value экземпляр примитива 32-х битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftInteger of(final @NotNull Integer value) {
        return new Default(value);
    }

    /**
     * Выполняет запаковку экземпляра примитива 32-х битного целочисленного типа.
     *
     * @param value экземпляр примитива 32-х битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftInteger of(final int value) {
        return new Default(value);
    }

    /**
     * Выполняет инверсию данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger invert();

    /**
     * Выполняет инкремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger increment();

    /**
     * Выполняет декремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger decrement();

    /**
     * Выполняет сложение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftInteger divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull Integer toJava();

    /**
     * @return Экземпляр примитива 32-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    int toNative();

    /**
     * Тип мягкой обёртки примитива 32-х битного целочисленного типа по умолчанию.
     *
     * @since 3.0
     */
    class Default implements SoftInteger {

        /**
         * Экземпляр примитива 32-х битного целочисленного типа.
         *
         * @since 3.0
         */
        protected final int value;

        /**
         * Инициализирует экземпляр с переопределённым экземпляром примитива 32-х битного целочисленного типа.
         *
         * @param value экземпляр примитива 32-х битного целочисленного типа.
         *
         * @since 3.0
         */
        @Contract(pure = true)
        protected Default(final int value) {
            this.value = value;
        }

        @Override
        public @NotNull SoftInteger invert() {
            return SoftInteger.of(-toNative());
        }

        @Override
        public @NotNull SoftInteger increment() {
            return SoftInteger.of(toNative() + 1);
        }

        @Override
        public @NotNull SoftInteger decrement() {
            return SoftInteger.of(toNative() - 1);
        }

        @Override
        public @NotNull SoftInteger add(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftInteger.of(toNative() + operand.toJava().intValue());
        }

        @Override
        public @NotNull SoftInteger subtract(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftInteger.of(toNative() - operand.toJava().intValue());
        }

        @Override
        public @NotNull SoftInteger multiply(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftInteger.of(toNative() * operand.toJava().intValue());
        }

        @Override
        public @NotNull SoftInteger divide(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftInteger.of(toNative() / operand.toJava().intValue());
        }

        @Override
        public @NotNull SoftInteger divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand) {
            final var current = toNative();
            final var operand_ = operand.toJava().intValue();
            return SoftInteger.of(current / operand_ - current % operand_);
        }

        @Override
        public @NotNull SoftInteger divideByModule(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftInteger.of(toNative() % operand.toJava().intValue());
        }

        @Override
        public @NotNull Integer toJava() {
            return value;
        }

        @Override
        public int toNative() {
            return value;
        }

    }

}
