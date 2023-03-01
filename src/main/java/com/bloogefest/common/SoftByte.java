/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common;

import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Интерфейс мягкой обёртки примитива 8-ми битного целочисленного типа.
 *
 * @since 3.0
 */
@Experimental
public interface SoftByte extends SoftNumber<Byte> {

    /**
     * Выполняет запаковку объекта родной обёртки примитива 8-ми битного целочисленного типа.
     *
     * @param value объект примитива 8-ми битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftByte of(final @NotNull Byte value) {
        return new Default(value);
    }

    /**
     * Выполняет запаковку объекта примитива 8-ми битного целочисленного типа.
     *
     * @param value объект примитива 8-ми битного целочисленного типа.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftByte of(final byte value) {
        return new Default(value);
    }

    /**
     * Выполняет инверсию данного объекта.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte invert();

    /**
     * Выполняет инкремент данного объекта.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte increment();

    /**
     * Выполняет декремент данного объекта.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte decrement();

    /**
     * Выполняет сложение данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftByte divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Override
    @NotNull Byte toJava();

    /**
     * @return Экземпляр примитива 8-ми битного целочисленного типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    byte toNative();

    /**
     * Класс мягкой обёртки примитива 8-ми битного целочисленного типа по умолчанию.
     *
     * @since 3.0
     */
    class Default implements SoftByte {

        /**
         * Экземпляр примитива 8-ми битного целочисленного типа.
         *
         * @since 3.0
         */
        protected final byte value;

        /**
         * Инициализирует объект с переопределённым объектом примитива 8-ми битного целочисленного типа.
         *
         * @param value объект примитива 8-ми битного целочисленного типа.
         *
         * @since 3.0
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
