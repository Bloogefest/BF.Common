/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Мягкий логический тип обёртки примитива.
 *
 * @since 0.3.0
 */
public interface SoftBoolean extends SoftPrimitive<Boolean> {

    /**
     * Экземпляр обёртки логического примитива с истинным значением.
     *
     * @since 0.3.0
     */
    SoftBoolean TRUE = new Default(true);

    /**
     * Экземпляр целочисленного примитива со значением хеш-кода истинного значения логического примитива.
     *
     * @since 0.3.0
     */
    int TRUE_HASHCODE = 1231;

    /**
     * Экземпляр строки истинного значения логического примитива.
     *
     * @since 0.3.0
     */
    String TRUE_STRING = "true";

    /**
     * Экземпляр обёртки логического примитива с ложным значением.
     *
     * @since 0.3.0
     */
    SoftBoolean FALSE = new Default(false);

    /**
     * Экземпляр целочисленного примитива со значением хеш-кода ложного значения логического примитива.
     *
     * @since 0.3.0
     */
    int FALSE_HASHCODE = 1237;

    /**
     * Экземпляр строки ложного значения логического примитива.
     *
     * @since 0.3.0
     */
    String FALSE_STRING = "false";

    /**
     * Выполняет запаковку экземпляра родной обёртки логического примитива.
     *
     * @param value экземпляр логического примитива.
     *
     * @return Экземпляр обёртки логического примитива.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    static @NotNull SoftBoolean of(final @NotNull Boolean value) {
        return value ? TRUE : FALSE;
    }

    /**
     * Выполняет запаковку экземпляра логического примитива.
     *
     * @param value экземпляр логического примитива.
     *
     * @return Экземпляр обёртки логического примитива.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    static @NotNull SoftBoolean of(final boolean value) {
        return value ? TRUE : FALSE;
    }

    /**
     * Выполняет инверсию этого экземпляра.
     *
     * @return Экземпляр результата инверсии.
     *
     * @since 0.3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftBoolean invert();

    /**
     * Выполняет конъюнкцию этого экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр результата конъюнкции.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftBoolean and(final @NotNull SoftBoolean operand);

    /**
     * Выполняет строгую дизъюнкцию этого экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр результата строгой дизъюнкции.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftBoolean xor(final @NotNull SoftBoolean operand);

    /**
     * Выполняет нестрогую дизъюнкцию этого экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр результата нестрогой дизъюнкции.
     *
     * @since 0.3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftBoolean or(final @NotNull SoftBoolean operand);

    /**
     * @return Экземпляр родной обёртки логического примитива.
     *
     * @since 0.3.0
     */
    @Override
    @Contract(pure = true)
    @NotNull Boolean toJava();

    /**
     * @return Экземпляр логического примитива.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    boolean toNative();

    /**
     * Реализация по умолчанию.
     *
     * @since 0.3.0
     */
    class Default implements SoftBoolean {

        /**
         * Экземпляр логического примитива.
         *
         * @since 0.3.0
         */
        protected final boolean value;

        /**
         * Инициализирует экземпляр с переопределённым экземпляром логического примитива.
         *
         * @param value экземпляр логического примитива.
         *
         * @since 0.3.0
         */
        @Contract(pure = true)
        protected Default(final boolean value) {
            this.value = value;
        }

        @Override
        @Contract(pure = true)
        public @NotNull SoftBoolean invert() {
            return SoftBoolean.of(!toNative());
        }

        @Override
        @Contract(pure = true)
        public @NotNull SoftBoolean and(final @NotNull SoftBoolean operand) {
            return SoftBoolean.of(toNative() && operand.toNative());
        }

        @Override
        @Contract(pure = true)
        public @NotNull SoftBoolean xor(final @NotNull SoftBoolean operand) {
            return SoftBoolean.of(toNative() ^ operand.toNative());
        }

        @Override
        @Contract(pure = true)
        public @NotNull SoftBoolean or(final @NotNull SoftBoolean operand) {
            return SoftBoolean.of(toNative() || operand.toNative());
        }

        @Override
        @Contract(pure = true)
        public @NotNull Boolean toJava() {
            return value;
        }

        @Override
        @Contract(pure = true)
        public boolean toNative() {
            return value;
        }

        @Override
        public boolean equals(final Object object) {
            return this == object || object instanceof SoftBoolean wrapper && toNative() == wrapper.toNative();
        }

        @Override
        public int hashCode() {
            return toNative() ? TRUE_HASHCODE : FALSE_HASHCODE;
        }

        @Override
        public String toString() {
            return toNative() ? TRUE_STRING : FALSE_STRING;
        }

    }

}
