package com.bloogefest.common.base;

import com.bloogefest.common.function.Predicate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Утилитарный класс предиката объекта.
 *
 * @author Bloogefest
 * @version 0.2
 * @see Predicate
 * @since 0.1.0
 */
@SuppressWarnings("unused")
public final class Predicates {

    /**
     * Бросает мягкое исключение.
     *
     * @throws CreationException невозможно создать объект.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "-> fail", pure = true)
    private Predicates() throws CreationException {
        throw new CreationException();
    }

    /**
     * Оценивает объект на нулевое явление.
     *
     * @param object объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null -> true; !null -> false", pure = true)
    public static <T> boolean isNull(final @Nullable T object) {
        return object == null;
    }

    /**
     * Оценивает объект на ненулевое явление.
     *
     * @param object объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null -> false; !null -> true", pure = true)
    public static <T> boolean notNull(final @Nullable T object) {
        return object != null;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final boolean value, final boolean value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final char value, final char value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final char value, final byte value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final char value, final short value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final char value, final int value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final char value, final long value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final char value, final float value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final char value, final double value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final byte value, final char value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final byte value, final byte value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final byte value, final short value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final byte value, final int value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final byte value, final long value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final byte value, final float value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final byte value, final double value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final short value, final char value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final short value, final byte value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final short value, final short value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final short value, final int value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final short value, final long value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final short value, final float value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final short value, final double value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final int value, final char value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final int value, final byte value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final int value, final short value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final int value, final int value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final int value, final long value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final int value, final float value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final int value, final double value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final long value, final char value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final long value, final byte value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final long value, final short value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final long value, final int value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final long value, final long value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final long value, final float value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final long value, final double value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final float value, final char value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final float value, final byte value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final float value, final short value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final float value, final int value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final float value, final long value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final float value, final float value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final float value, final double value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final double value, final char value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final double value, final byte value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final double value, final short value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final double value, final int value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final double value, final long value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final double value, final float value_) {
        return value == value_;
    }

    /**
     * Оценивает первичное значение на явление равенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean equals(final double value, final double value_) {
        return value == value_;
    }

    /**
     * Оценивает первичный объект на явление равенства со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null -> true; _, _ -> _", pure = true)
    public static <T, T_> boolean equals(final @Nullable T object, final @Nullable T_ object_) {
        return object == object_ || notNull(object) && object.equals(object_);
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final boolean value, final boolean value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final char value, final char value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final char value, final byte value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final char value, final short value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final char value, final int value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final char value, final long value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final char value, final float value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final char value, final double value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final byte value, final char value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final byte value, final byte value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final byte value, final short value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final byte value, final int value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final byte value, final long value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final byte value, final float value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final byte value, final double value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final short value, final char value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final short value, final byte value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final short value, final short value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final short value, final int value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final short value, final long value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final short value, final float value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final short value, final double value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final int value, final char value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final int value, final byte value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final int value, final short value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final int value, final int value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final int value, final long value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final int value, final float value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final int value, final double value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final long value, final char value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final long value, final byte value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final long value, final short value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final long value, final int value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final long value, final long value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final long value, final float value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final long value, final double value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final float value, final char value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final float value, final byte value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final float value, final short value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final float value, final int value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final float value, final long value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final float value, final float value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final float value, final double value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final double value, final char value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final double value, final byte value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final double value, final short value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final double value, final int value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final double value, final long value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final double value, final float value_) {
        return value != value_;
    }

    /**
     * Оценивает первичное значение на явление неравенства со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @Contract(value = "_, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final double value, final double value_) {
        return value != value_;
    }

    /**
     * Оценивает первичный объект на явление неравенства со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null -> false; _, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final @Nullable T object, final @Nullable T_ object_) {
        return object != object_ && notNull(object) && object.equals(object_);
    }

}
