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
 * Интерфейс мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
 *
 * @since 3.0
 */
@Experimental
public interface SoftDouble extends SoftNumber<Double> {

    /**
     * Выполняет запаковку экземпляра родной обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @param value экземпляр примитива 64-х битного числового типа с плавающей точкой.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftDouble of(final @NotNull Double value) {
        return new Default(value);
    }

    /**
     * Выполняет запаковку экземпляра примитива 64-х битного числового типа с плавающей точкой.
     *
     * @param value экземпляр примитива 64-х битного числового типа с плавающей точкой.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftDouble of(final double value) {
        return new Default(value);
    }

    /**
     * Выполняет инверсию данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble invert();

    /**
     * Выполняет инкремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble increment();

    /**
     * Выполняет декремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble decrement();

    /**
     * Выполняет сложение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftDouble divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull Double toJava();

    /**
     * @return Экземпляр примитива 64-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    double toNative();

    /**
     * Класс мягкой обёртки примитива 64-х битного числового типа с плавающей точкой по умолчанию.
     *
     * @since 3.0
     */
    class Default implements SoftDouble {

        /**
         * Экземпляр примитива 64-х битного числового типа с плавающей точкой.
         *
         * @since 3.0
         */
        protected final double value;

        /**
         * Инициализирует экземпляр с переопределённым экземпляром примитива 64-х битного числового типа с плавающей
         * точкой.
         *
         * @param value экземпляр примитива 64-х битного числового типа с плавающей точкой.
         *
         * @since 3.0
         */
        @Contract(pure = true)
        protected Default(final double value) {
            this.value = value;
        }

        @Override
        public @NotNull SoftDouble invert() {
            return SoftDouble.of(-toNative());
        }

        @Override
        public @NotNull SoftDouble increment() {
            return SoftDouble.of(toNative() + 1);
        }

        @Override
        public @NotNull SoftDouble decrement() {
            return SoftDouble.of(toNative() - 1);
        }

        @Override
        public @NotNull SoftDouble add(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftDouble.of(toNative() + operand.toJava().doubleValue());
        }

        @Override
        public @NotNull SoftDouble subtract(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftDouble.of(toNative() - operand.toJava().doubleValue());
        }

        @Override
        public @NotNull SoftDouble multiply(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftDouble.of(toNative() * operand.toJava().doubleValue());
        }

        @Override
        public @NotNull SoftDouble divide(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftDouble.of(toNative() / operand.toJava().doubleValue());
        }

        @Override
        public @NotNull SoftDouble divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand) {
            final var current = toNative();
            final var operand_ = operand.toJava().doubleValue();
            return SoftDouble.of(current / operand_ - current % operand_);
        }

        @Override
        public @NotNull SoftDouble divideByModule(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftDouble.of(toNative() % operand.toJava().doubleValue());
        }

        @Override
        public @NotNull Double toJava() {
            return value;
        }

        @Override
        public double toNative() {
            return value;
        }

    }

}
