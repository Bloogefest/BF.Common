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
 * Интерфейс мягкой обёртки примитива 16-ти битного целочисленного типа.
 *
 * @since 0.3.0
 */
@Experimental
public interface SoftShort extends SoftNumber<Short> {

    /**
     * Выполняет запаковку экземпляра родной обёртки примитива 16-ти битного целочисленного типа.
     *
     * @param value экземпляр примитива 16-ти битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    static @NotNull SoftShort of(final @NotNull Short value) {
        return new Default(value);
    }

    /**
     * Выполняет запаковку экземпляра примитива 16-ти битного целочисленного типа.
     *
     * @param value экземпляр примитива 16-ти битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    static @NotNull SoftShort of(final short value) {
        return new Default(value);
    }

    /**
     * Выполняет инверсию данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort invert();

    /**
     * Выполняет инкремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort increment();

    /**
     * Выполняет декремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort decrement();

    /**
     * Выполняет сложение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftShort divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull Short toJava();

    /**
     * @return Экземпляр примитива 16-ти битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    short toNative();

    /**
     * Тип мягкой обёртки примитива 16-ти битного целочисленного типа по умолчанию.
     *
     * @since 0.3.0
     */
    class Default implements SoftShort {

        /**
         * Экземпляр примитива 16-ти битного целочисленного типа.
         *
         * @since 0.3.0
         */
        protected final short value;

        /**
         * Инициализирует экземпляр с переопределённым экземпляром примитива 16-ти битного целочисленного типа.
         *
         * @param value экземпляр примитива 16-ти битного целочисленного типа.
         *
         * @since 0.3.0
         */
        @Contract(pure = true)
        protected Default(final short value) {
            this.value = value;
        }

        @Override
        public @NotNull SoftShort invert() {
            return SoftShort.of((short) -toNative());
        }

        @Override
        public @NotNull SoftShort increment() {
            return SoftShort.of((short) (toNative() + 1));
        }

        @Override
        public @NotNull SoftShort decrement() {
            return SoftShort.of((short) (toNative() - 1));
        }

        @Override
        public @NotNull SoftShort add(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftShort.of((short) (toNative() + operand.toJava().shortValue()));
        }

        @Override
        public @NotNull SoftShort subtract(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftShort.of((short) (toNative() - operand.toJava().shortValue()));
        }

        @Override
        public @NotNull SoftShort multiply(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftShort.of((short) (toNative() * operand.toJava().shortValue()));
        }

        @Override
        public @NotNull SoftShort divide(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftShort.of((short) (toNative() / operand.toJava().shortValue()));
        }

        @Override
        public @NotNull SoftShort divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand) {
            final var current = toNative();
            final var operand_ = operand.toJava().shortValue();
            return SoftShort.of((short) (current / operand_ - current % operand_));
        }

        @Override
        public @NotNull SoftShort divideByModule(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftShort.of((short) (toNative() % operand.toJava().shortValue()));
        }

        @Override
        public @NotNull Short toJava() {
            return value;
        }

        @Override
        public short toNative() {
            return value;
        }

    }

}
