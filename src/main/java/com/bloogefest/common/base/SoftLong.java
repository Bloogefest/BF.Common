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
 * Интерфейс мягкой обёртки примитива 64-х битного целочисленного типа.
 *
 * @since 3.0
 */
@Experimental
public interface SoftLong extends SoftNumber<Long> {

    /**
     * Выполняет запаковку экземпляра родной обёртки примитива 64-х битного целочисленного типа.
     *
     * @param value экземпляр примитива 64-х битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftLong of(final @NotNull Long value) {
        return new Default(value);
    }

    /**
     * Выполняет запаковку экземпляра примитива 64-х битного целочисленного типа.
     *
     * @param value экземпляр примитива 64-х битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftLong of(final long value) {
        return new Default(value);
    }

    /**
     * Выполняет инверсию данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong invert();

    /**
     * Выполняет инкремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong increment();

    /**
     * Выполняет декремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong decrement();

    /**
     * Выполняет сложение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftLong divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull Long toJava();

    /**
     * @return Экземпляр примитива 64-х битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    long toNative();

    /**
     * Тип мягкой обёртки примитива 64-х битного целочисленного типа по умолчанию.
     *
     * @since 3.0
     */
    class Default implements SoftLong {

        /**
         * Экземпляр примитива 64-х битного целочисленного типа.
         *
         * @since 3.0
         */
        protected final long value;

        /**
         * Инициализирует экземпляр с переопределённым экземпляром примитива 64-х битного целочисленного типа.
         *
         * @param value экземпляр примитива 64-х битного целочисленного типа.
         *
         * @since 3.0
         */
        @Contract(pure = true)
        protected Default(final long value) {
            this.value = value;
        }

        @Override
        public @NotNull SoftLong invert() {
            return SoftLong.of(-toNative());
        }

        @Override
        public @NotNull SoftLong increment() {
            return SoftLong.of(toNative() + 1);
        }

        @Override
        public @NotNull SoftLong decrement() {
            return SoftLong.of(toNative() - 1);
        }

        @Override
        public @NotNull SoftLong add(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftLong.of(toNative() + operand.toJava().longValue());
        }

        @Override
        public @NotNull SoftLong subtract(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftLong.of(toNative() - operand.toJava().longValue());
        }

        @Override
        public @NotNull SoftLong multiply(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftLong.of(toNative() * operand.toJava().longValue());
        }

        @Override
        public @NotNull SoftLong divide(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftLong.of(toNative() / operand.toJava().longValue());
        }

        @Override
        public @NotNull SoftLong divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand) {
            final var current = toNative();
            final var operand_ = operand.toJava().longValue();
            return SoftLong.of(current / operand_ - current % operand_);
        }

        @Override
        public @NotNull SoftLong divideByModule(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftLong.of(toNative() % operand.toJava().longValue());
        }

        @Override
        public @NotNull Long toJava() {
            return value;
        }

        @Override
        public long toNative() {
            return value;
        }

    }

}
