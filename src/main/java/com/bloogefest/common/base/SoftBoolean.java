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
 * Интерфейс мягкой обёртки примитива логического типа.
 *
 * @since 3.0
 */
@Experimental
public interface SoftBoolean extends SoftPrimitive<Boolean> {

    /**
     * Выполняет запаковку экземпляра родной обёртки примитива логического типа.
     *
     * @param value экземпляр примитива логического типа.
     *
     * @return Экземпляр мягкой обёртки примитива логического типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftBoolean of(final @NotNull Boolean value) {
        return value == Boolean.TRUE ? True.INSTANCE : False.INSTANCE;
    }

    /**
     * Выполняет запаковку экземпляра примитива логического типа.
     *
     * @param value экземпляр примитива логического типа.
     *
     * @return Экземпляр мягкой обёртки примитива логического типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull SoftBoolean of(final boolean value) {
        return value ? True.INSTANCE : False.INSTANCE;
    }

    /**
     * Выполняет инверсию данного экземпляра.
     *
     * @return Экземпляр мягкой обёртки примитива логического типа.
     *
     * @since 3.0
     */
    @Contract(value = "-> new", pure = true)
    @NotNull SoftBoolean invert();

    /**
     * Выполняет конъюнкцию данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива логического типа.
     *
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftBoolean and(final @NotNull SoftBoolean operand);

    /**
     * Выполняет строгую дизъюнкцию данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива логического типа.
     *
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftBoolean xor(final @NotNull SoftBoolean operand);

    /**
     * Выполняет нестрогую дизъюнкцию данного экземпляра и второго операнда.
     *
     * @param operand второй операнд.
     *
     * @return Экземпляр мягкой обёртки примитива логического типа.
     *
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull SoftBoolean or(final @NotNull SoftBoolean operand);

    /**
     * @return Экземпляр родной обёртки примитива логического типа.
     *
     * @since 3.0
     */
    @Override
    @Contract(pure = true)
    @NotNull Boolean toJava();

    /**
     * @return Экземпляр примитива логического типа.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    boolean toNative();

    /**
     * Интерфейс параметров мягкой обёртки примитива логического типа с ложным значением.
     *
     * @since 3.0
     */
    interface True {

        /**
         * Экземпляр мягкой обёртки примитива логического типа с истинным значением.
         *
         * @since 3.0
         */
        SoftBoolean INSTANCE = new Default(true);

        /**
         * Экземпляр примитива целочисленного типа со значением хеш-кода истинного значения примитива логического типа.
         *
         * @since 3.0
         */
        int HASHCODE = 1231;

        /**
         * Экземпляр строки истинного значения примитива логического типа.
         *
         * @since 3.0
         */
        String STRING = "true";

    }

    /**
     * Интерфейс параметров мягкой обёртки примитива логического типа с ложным значением.
     *
     * @since 3.0
     */
    interface False {

        /**
         * Экземпляр обёртки примитива логического типа с ложным значением.
         *
         * @since 3.0
         */
        SoftBoolean INSTANCE = new Default(false);

        /**
         * Экземпляр примитива целочисленного типа со значением хеш-кода ложного значения примитива логического типа.
         *
         * @since 3.0
         */
        int HASHCODE = 1237;

        /**
         * Экземпляр строки ложного значения примитива логического типа.
         *
         * @since 3.0
         */
        String STRING = "false";

    }

    /**
     * Класс мягкой обёртки примитива логического типа по умолчанию.
     *
     * @since 3.0
     */
    class Default implements SoftBoolean {

        /**
         * Экземпляр примитива логического типа.
         *
         * @since 3.0
         */
        protected final boolean value;

        /**
         * Инициализирует экземпляр с переопределённым экземпляром примитива логического типа.
         *
         * @param value экземпляр примитива логического типа.
         *
         * @since 3.0
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
            return toNative() ? True.HASHCODE : False.HASHCODE;
        }

        @Override
        public String toString() {
            return toNative() ? True.STRING : False.STRING;
        }

    }

}
