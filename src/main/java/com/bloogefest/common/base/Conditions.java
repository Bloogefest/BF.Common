/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import com.bloogefest.common.creation.CreationException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Является утилитарным инструментом для работы с экземплярами и значениями.
 *
 * @since 0.2.0
 */
@Deprecated(since = "0.2.0", forRemoval = true)
public final class Conditions {

    /**
     * Не позволяет создать экземпляр.
     *
     * @throws CreationException невозможность создания экземпляра.
     * @since 0.2.0
     */
        @Contract(value = "-> fail", pure = true)
    private Conditions() throws CreationException {
        throw new CreationException();
    }

    /**
     * Проверяет переданный типизированный экземпляр на нулевое явление.
     *
     * @param <TYPE> тип экземпляра.
     * @param instance типизированный экземпляр.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(value = "null -> true; !null -> false", pure = true)
    public static <TYPE> boolean isNull(final @Nullable TYPE instance) {
        return instance == null;
    }

    /**
     * Проверяет переданный типизированный экземпляр на ненулевое явление.
     *
     * @param <TYPE> тип экземпляра.
     * @param instance типизированный экземпляр.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(value = "null -> false; !null -> true", pure = true)
    public static <TYPE> boolean notNull(final @Nullable TYPE instance) {
        return instance != null;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final boolean value, final boolean value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final char value, final char value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final char value, final byte value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final char value, final short value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final char value, final int value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final char value, final long value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final char value, final float value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final char value, final double value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final byte value, final char value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final byte value, final byte value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final byte value, final short value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final byte value, final int value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final byte value, final long value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final byte value, final float value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final byte value, final double value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final short value, final char value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final short value, final byte value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final short value, final short value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final short value, final int value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final short value, final long value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final short value, final float value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final short value, final double value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final int value, final char value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final int value, final byte value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final int value, final short value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final int value, final int value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final int value, final long value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final int value, final float value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final int value, final double value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final long value, final char value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final long value, final byte value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final long value, final short value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final long value, final int value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final long value, final long value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final long value, final float value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final long value, final double value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final float value, final char value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final float value, final byte value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final float value, final short value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final float value, final int value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final float value, final long value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final float value, final float value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final float value, final double value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final double value, final char value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final double value, final byte value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final double value, final short value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final double value, final int value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final double value, final long value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final double value, final float value_) {
        return value == value_;
    }

    /**
     * Проверяет переданное первичное значение на явление равенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean equals(final double value, final double value_) {
        return value == value_;
    }

    /**
     * Проверяет первичный типизированный экземпляр на явление равенства со вторичным.
     *
     * @param <TYPE> тип первичного экземпляра.
     * @param <TYPE_> тип вторичного экземпляра.
     * @param instance первичный типизированный экземпляр.
     * @param instance_ вторичный типизированный экземпляр.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static <TYPE, TYPE_> boolean equals(final @Nullable TYPE instance, final @Nullable TYPE_ instance_) {
        return instance == instance_ || notNull(instance) && instance.equals(instance_);
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final boolean value, final boolean value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final char value, final char value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final char value, final byte value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final char value, final short value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final char value, final int value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final char value, final long value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final char value, final float value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final char value, final double value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final byte value, final char value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final byte value, final byte value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final byte value, final short value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final byte value, final int value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final byte value, final long value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final byte value, final float value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final byte value, final double value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final short value, final char value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final short value, final byte value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final short value, final short value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final short value, final int value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final short value, final long value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final short value, final float value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final short value, final double value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final int value, final char value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final int value, final byte value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final int value, final short value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final int value, final int value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final int value, final long value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final int value, final float value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final int value, final double value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final long value, final char value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final long value, final byte value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final long value, final short value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final long value, final int value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final long value, final long value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final long value, final float value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final long value, final double value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final float value, final char value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final float value, final byte value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final float value, final short value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final float value, final int value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final float value, final long value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final float value, final float value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final float value, final double value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final double value, final char value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final double value, final byte value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final double value, final short value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final double value, final int value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final double value, final long value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final double value, final float value_) {
        return value != value_;
    }

    /**
     * Проверяет переданное первичное значение на явление неравенства со вторичным.
     *
     * @param value первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static boolean notEquals(final double value, final double value_) {
        return value != value_;
    }

    /**
     * Проверяет переданный первичный типизированный экземпляр на явление неравенства со вторичным.
     *
     * @param <TYPE> тип первичного экземпляра.
     * @param <TYPE_> тип вторичного экземпляра.
     * @param instance первичный типизированный экземпляр.
     * @param instance_ вторичный типизированный экземпляр.
     *
     * @return Результат проверки.
     *
     * @since 0.2.0
     */
        @Contract(pure = true)
    public static <TYPE, TYPE_> boolean notEquals(final @Nullable TYPE instance, final @Nullable TYPE_ instance_) {
        return instance != instance_ && notNull(instance) && instance.equals(instance_);
    }

}
