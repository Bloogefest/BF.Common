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
 * Интерфейс мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
 *
 * @since 3.0
 */
@Experimental
public interface SoftFloat extends SoftNumber<Float> {

    /**
     * Выполняет запаковку объекта родной обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @param value объект примитива 32-х битного числового типа с плавающей точкой.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftFloat of(final @NotNull Float value) {
        return new Default(value);
    }

    /**
     * Выполняет запаковку объекта примитива 32-х битного числового типа с плавающей точкой.
     *
     * @param value объект примитива 32-х битного числового типа с плавающей точкой.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftFloat of(final float value) {
        return new Default(value);
    }

    /**
     * Выполняет инверсию данного объекта.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat invert();

    /**
     * Выполняет инкремент данного объекта.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat increment();

    /**
     * Выполняет декремент данного объекта.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat decrement();

    /**
     * Выполняет сложение данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat add(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет вычитание данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat subtract(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет умножение данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat multiply(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat divide(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление без остатка данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * Выполняет деление по модулю данного объекта и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull SoftFloat divideByModule(final @NotNull SoftNumber<? extends Number> operand);

    /**
     * @return Экземпляр родной обёртки примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Override
    @NotNull Float toJava();

    /**
     * @return Экземпляр примитива 32-х битного числового типа с плавающей точкой.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    float toNative();

    /**
     * Класс мягкой обёртки примитива 32-х битного числового типа с плавающей точкой по умолчанию.
     *
     * @since 3.0
     */
    class Default implements SoftFloat {

        /**
         * Экземпляр примитива 32-х битного числового типа с плавающей точкой.
         *
         * @since 3.0
         */
        protected final float value;

        /**
         * Инициализирует объект с переопределённым объектом примитива 32-х битного числового типа с плавающей точкой.
         *
         * @param value объект примитива 32-х битного числового типа с плавающей точкой.
         *
         * @since 3.0
         */
        @Contract(pure = true)
        protected Default(final float value) {
            this.value = value;
        }

        @Override
        public @NotNull SoftFloat invert() {
            return SoftFloat.of(-toNative());
        }

        @Override
        public @NotNull SoftFloat increment() {
            return SoftFloat.of(toNative() + 1);
        }

        @Override
        public @NotNull SoftFloat decrement() {
            return SoftFloat.of(toNative() - 1);
        }

        @Override
        public @NotNull SoftFloat add(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftFloat.of(toNative() + operand.toJava().floatValue());
        }

        @Override
        public @NotNull SoftFloat subtract(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftFloat.of(toNative() - operand.toJava().floatValue());
        }

        @Override
        public @NotNull SoftFloat multiply(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftFloat.of(toNative() * operand.toJava().floatValue());
        }

        @Override
        public @NotNull SoftFloat divide(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftFloat.of(toNative() / operand.toJava().floatValue());
        }

        @Override
        public @NotNull SoftFloat divideWithoutRemainder(final @NotNull SoftNumber<? extends Number> operand) {
            final var current = toNative();
            final var operand_ = operand.toJava().floatValue();
            return SoftFloat.of(current / operand_ - current % operand_);
        }

        @Override
        public @NotNull SoftFloat divideByModule(final @NotNull SoftNumber<? extends Number> operand) {
            return SoftFloat.of(toNative() % operand.toJava().floatValue());
        }

        @Override
        public @NotNull Float toJava() {
            return value;
        }

        @Override
        public float toNative() {
            return value;
        }

    }

}
