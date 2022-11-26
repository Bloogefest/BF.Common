package com.bloogefest.common.validation;

import com.bloogefest.common.other.Conditions;
import com.bloogefest.common.other.CreationException;
import org.jetbrains.annotations.*;

/**
 * Является утилитарным инструментом валидации экземпляров и значений.
 *
 * @author Bloogefest
 * @version 1.0
 * @see ValidationException
 * @see NotNullException
 * @see NullException
 * @see NotEqualException
 * @see EqualException
 * @since 0.0.0
 */
@ApiStatus.AvailableSince("0.0.0")
@SuppressWarnings("unused")
public final class Validator {

    /**
     * Не позволяет создать экземпляр.
     *
     * @throws CreationException невозможность создания экземпляра.
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(value = "-> fail", pure = true)
    private Validator() throws CreationException {
        throw new CreationException();
    }

    /**
     * Подтверждает нулевое явление переданного типизированного экземпляра.
     *
     * @param <TYPE>   тип экземпляра.
     * @param instance типизированный экземпляр.
     *
     * @return Подтверждённый переданный типизированный экземпляр.
     *
     * @throws NotNullException невозможность подтверждения нулевого явления переданного типизированного экземпляра.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(value = "null -> null; !null -> fail", pure = true)
    public static <TYPE> @Nullable TYPE isNull(final @Nullable TYPE instance) throws NotNullException {
        if (Conditions.isNull(instance)) return null;
        throw new NotNullException();
    }

    /**
     * Подтверждает нулевое явление переданного типизированного экземпляра.
     *
     * @param <TYPE>   тип экземпляра.
     * @param instance типизированный экземпляр.
     * @param name     имя экземпляра.
     *
     * @return Подтверждённый переданный типизированный экземпляр.
     *
     * @throws NotNullException невозможность подтверждения нулевого явления переданного типизированного экземпляра.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(value = "null, _ -> null; !null, _ -> fail", pure = true)
    public static <TYPE> @Nullable TYPE isNull(final @Nullable TYPE instance, final @NonNls @NotNull String name) throws NotNullException {
        if (Conditions.isNull(instance)) return null;
        throw new NotNullException(NotNullException.templateMessage.formatted(notNull(name, "instance name")));
    }

    /**
     * Подтверждает ненулевое явление переданного типизированного экземпляра.
     *
     * @param <TYPE>   тип экземпляра.
     * @param instance типизированный экземпляр.
     *
     * @return Подтверждённый переданный типизированный экземпляр.
     *
     * @throws NotNullException невозможность подтверждения ненулевого явления переданного типизированного экземпляра.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(value = "null -> fail; !null -> param1", pure = true)
    public static <TYPE> @NotNull TYPE notNull(final @Nullable TYPE instance) throws NullException {
        if (Conditions.notNull(instance)) return instance;
        throw new NullException();
    }

    /**
     * Подтверждает ненулевое явление переданного типизированного экземпляра.
     *
     * @param <TYPE>   тип экземпляра.
     * @param instance типизированный экземпляр.
     * @param name     имя экземпляра.
     *
     * @return Подтверждённый переданный типизированный экземпляр.
     *
     * @throws NotNullException невозможность подтверждения ненулевого явления переданного типизированного экземпляра.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(value = "null, _ -> fail; !null, _ -> param1", pure = true)
    public static <TYPE> @NotNull TYPE notNull(final @Nullable TYPE instance, final @NonNls @NotNull String name) throws NullException {
        if (Conditions.notNull(instance)) return instance;
        throw new NullException(NullException.templateMessage.formatted(notNull(name, "instance name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static boolean equals(final boolean value, final boolean value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char equals(final char value, final char value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char equals(final char value, final byte value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char equals(final char value, final short value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char equals(final char value, final int value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char equals(final char value, final long value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char equals(final char value, final float value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char equals(final char value, final double value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final char value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final byte value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final short value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final int value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final long value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final float value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final double value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short equals(final short value, final char value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short equals(final short value, final byte value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short equals(final short value, final short value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short equals(final short value, final int value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short equals(final short value, final long value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short equals(final short value, final float value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short equals(final short value, final double value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int equals(final int value, final char value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int equals(final int value, final byte value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int equals(final int value, final short value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int equals(final int value, final int value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int equals(final int value, final long value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int equals(final int value, final float value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int equals(final int value, final double value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long equals(final long value, final char value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long equals(final long value, final byte value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long equals(final long value, final short value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long equals(final long value, final int value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long equals(final long value, final long value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long equals(final long value, final float value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long equals(final long value, final double value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float equals(final float value, final char value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float equals(final float value, final byte value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float equals(final float value, final short value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float equals(final float value, final int value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float equals(final float value, final long value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float equals(final float value, final float value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float equals(final float value, final double value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double equals(final double value, final char value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double equals(final double value, final byte value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double equals(final double value, final short value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double equals(final double value, final int value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double equals(final double value, final long value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double equals(final double value, final float value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double equals(final double value, final double value_) throws NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного типизированного экземпляра со вторичным.
     *
     * @param <TYPE>    тип первичного экземпляра.
     * @param <TYPE_>   тип вторичного экземпляра.
     * @param instance  первичный типизированный экземпляр.
     * @param instance_ вторичный типизированный экземпляр.
     *
     * @return Переданный первичный типизированный экземпляр.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного типизированного экземпляра со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static <TYPE, TYPE_> @Nullable TYPE equals(final @Nullable TYPE instance, final @Nullable TYPE_ instance_) throws NotEqualException {
        if (Conditions.equals(instance, instance_)) return instance;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static boolean equals(final boolean value, final boolean value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                     NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char equals(final char value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char equals(final char value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char equals(final char value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char equals(final char value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                           NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char equals(final char value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char equals(final char value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char equals(final char value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                           NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte equals(final byte value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short equals(final short value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short equals(final short value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short equals(final short value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short equals(final short value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short equals(final short value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short equals(final short value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short equals(final short value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int equals(final int value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                          NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int equals(final int value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                          NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int equals(final int value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                           NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int equals(final int value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                         NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int equals(final int value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                          NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int equals(final int value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                           NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int equals(final int value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long equals(final long value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long equals(final long value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long equals(final long value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long equals(final long value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                           NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long equals(final long value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long equals(final long value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long equals(final long value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float equals(final float value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float equals(final float value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float equals(final float value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float equals(final float value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float equals(final float value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float equals(final float value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float equals(final float value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double equals(final double value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double equals(final double value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double equals(final double value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double equals(final double value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double equals(final double value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double equals(final double value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double equals(final double value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                  NotEqualException {
        if (Conditions.equals(value, value_)) return value;
        throw new NotEqualException(NotEqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление равенства переданного первичного типизированного экземпляра со вторичным.
     *
     * @param <TYPE>    тип первичного экземпляра.
     * @param <TYPE_>   тип вторичного экземпляра.
     * @param instance  первичный типизированный экземпляр.
     * @param instance_ вторичный типизированный экземпляр.
     * @param name      имя первичного экземпляра.
     * @param name_     имя вторичного экземпляра.
     *
     * @return Переданный первичный типизированный экземпляр.
     *
     * @throws NotEqualException невозможность подтверждения явления равенства переданного первичного типизированного экземпляра со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static <TYPE, TYPE_> @Nullable TYPE equals(final @Nullable TYPE instance, final @Nullable TYPE_ instance_, final @NonNls @NotNull String name,
                                                      final @NonNls @NotNull String name_) throws NotEqualException {
        if (Conditions.equals(instance, instance_)) return instance;
        throw new NotEqualException(
                NotEqualException.templateMessage.formatted(notNull(name, "primary instance name"), notNull(name_, "secondary instance name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static boolean notEquals(final boolean value, final boolean value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final char value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final byte value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final short value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final int value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final long value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final float value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final double value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final char value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final byte value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final short value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final int value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final long value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final float value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final double value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final char value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final byte value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final short value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final int value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final long value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final float value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final double value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final char value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final byte value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final short value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final int value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final long value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final float value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final double value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final char value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final byte value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final short value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final int value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final long value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final float value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final double value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final char value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final byte value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final short value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final int value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final long value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final float value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final double value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final char value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final byte value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final short value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final int value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final long value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final float value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final double value_) throws EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного типизированного экземпляра со вторичным.
     *
     * @param <TYPE>    тип первичного экземпляра.
     * @param <TYPE_>   тип вторичного экземпляра.
     * @param instance  первичный типизированный экземпляр.
     * @param instance_ вторичный типизированный экземпляр.
     *
     * @return Переданный первичный типизированный экземпляр.
     *
     * @throws NotEqualException невозможность подтверждения явления неравенства переданного первичного типизированного экземпляра со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static <TYPE, TYPE_> @Nullable TYPE notEquals(final @Nullable TYPE instance, final @Nullable TYPE_ instance_) throws EqualException {
        if (Conditions.notEquals(instance, instance_)) return instance;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static boolean notEquals(final boolean value, final boolean value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                        EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static char notEquals(final char value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static byte notEquals(final byte value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                  EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                  EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static short notEquals(final short value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                   EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                            EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                             EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static int notEquals(final int value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                              EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                               EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static long notEquals(final long value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                  EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                 EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                  EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static float notEquals(final float value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                   EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final char value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                   EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final byte value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                   EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final short value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                    EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final int value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                  EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final long value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                   EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final float value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                    EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного значения со вторичным.
     *
     * @param value  первичное значение.
     * @param value_ вторичное значение.
     * @param name   имя первичного экземпляра.
     * @param name_  имя вторичного экземпляра.
     *
     * @return Переданное первичное значение.
     *
     * @throws EqualException невозможность подтверждения явления неравенства переданного первичного значения со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static double notEquals(final double value, final double value_, final @NonNls @NotNull String name, final @NonNls @NotNull String name_) throws
                                                                                                                                                     EqualException {
        if (Conditions.notEquals(value, value_)) return value;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary value name"), notNull(name_, "secondary value name")));
    }

    /**
     * Подтверждает явление неравенства переданного первичного типизированного экземпляра со вторичным.
     *
     * @param <TYPE>    тип первичного экземпляра.
     * @param <TYPE_>   тип вторичного экземпляра.
     * @param instance  первичный типизированный экземпляр.
     * @param instance_ вторичный типизированный экземпляр.
     * @param name      имя первичного экземпляра.
     * @param name_     имя вторичного экземпляра.
     *
     * @return Переданный первичный типизированный экземпляр.
     *
     * @throws NotEqualException невозможность подтверждения явления неравенства переданного первичного типизированного экземпляра со вторичным.
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public static <TYPE, TYPE_> @Nullable TYPE notEquals(final @Nullable TYPE instance, final @Nullable TYPE_ instance_, final @NonNls @NotNull String name,
                                                         final @NonNls @NotNull String name_) throws EqualException {
        if (Conditions.notEquals(instance, instance_)) return instance;
        throw new EqualException(EqualException.templateMessage.formatted(notNull(name, "primary instance name"), notNull(name_, "secondary instance name")));
    }

}
