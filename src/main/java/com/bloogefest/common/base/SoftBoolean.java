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
     * Экземпляр обёртки логического примитива истинного значения.
     *
     * @since 0.3.0
     */
    SoftBoolean TRUE = new Default(true);

    /**
     * Экземпляр обёртки логического примитива ложного значения.
     *
     * @since 0.3.0
     */
    SoftBoolean FALSE = new Default(false);

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

    }

}
