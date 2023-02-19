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
 * Интерфейс мягкой обёртки примитива 8-ми битного целочисленного типа.
 *
 * @since 0.3.0
 */
@Experimental
public interface SoftByte extends SoftNumber<Byte> {

    /**
     * Выполняет запаковку экземпляра родной обёртки примитива 8-ми битного целочисленного типа.
     *
     * @param value экземпляр примитива 8-ми битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    static @NotNull SoftByte of(final @NotNull Byte value) {
        return new Default(value);
    }

    /**
     * Выполняет запаковку экземпляра примитива 8-ми битного целочисленного типа.
     *
     * @param value экземпляр примитива 8-ми битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    static @NotNull SoftByte of(final byte value) {
        return new Default(value);
    }

    /**
     * Выполняет инверсию данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte invert();

    /**
     * Выполняет инкремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte increment();

    /**
     * Выполняет декремент данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte decrement();

    /**
     * Выполняет сложение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull SoftByte divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Override
    @NotNull Byte toJava();

    /**
     * @return Экземпляр примитива 8-ми битного целочисленного типа.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    byte toNative();

    /**
     * Тип мягкой обёртки примитива 8-ми битного целочисленного типа по умолчанию.
     *
     * @since 0.3.0
     */
    class Default implements SoftByte {

        /**
         * Экземпляр примитива 8-ми битного целочисленного типа.
         *
         * @since 0.3.0
         */
        protected final byte value;

        /**
         * Инициализирует экземпляр с переопределённым экземпляром примитива 8-ми битного целочисленного типа.
         *
         * @param value экземпляр примитива 8-ми битного целочисленного типа.
         *
         * @since 0.3.0
         */
        @Contract(pure = true)
        protected Default(final byte value) {
            this.value = value;
        }

        @Override
        public @NotNull SoftByte invert() {
            return SoftByte.of((byte) -toNative());
        }

        @Override
        public @NotNull SoftByte increment() {
            return SoftByte.of((byte) (toNative() + 1));
        }

        @Override
        public @NotNull SoftByte decrement() {
            return SoftByte.of((byte) (toNative() - 1));
        }

        @Override
        public @NotNull SoftByte add(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftByte.of((byte) (toNative() + operand.toJava().byteValue()));
        }

        @Override
        public @NotNull SoftByte subtract(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftByte.of((byte) (toNative() - operand.toJava().byteValue()));
        }

        @Override
        public @NotNull SoftByte multiply(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftByte.of((byte) (toNative() * operand.toJava().byteValue()));
        }

        @Override
        public @NotNull SoftByte divide(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftByte.of((byte) (toNative() / operand.toJava().byteValue()));
        }

        @Override
        public @NotNull SoftByte divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand) {
            final var current = toNative();
            final var operand_ = operand.toJava().byteValue();
            return SoftByte.of((byte) (current / operand_ - current % operand_));
        }

        @Override
        public @NotNull SoftByte divideByModule(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftByte.of((byte) (toNative() % operand.toJava().byteValue()));
        }

        @Override
        public @NotNull Byte toJava() {
            return value;
        }

        @Override
        public byte toNative() {
            return value;
        }

    }

}
