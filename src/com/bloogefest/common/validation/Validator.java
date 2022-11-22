package com.bloogefest.common.validation;

import com.bloogefest.common.base.CreationException;
import com.bloogefest.common.base.Predicates;
import com.bloogefest.common.function.Supplier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Утилитарный класс валидации объектов.
 *
 * @author Bloogefest
 * @version 0.2
 * @see ValidationException
 * @see EqualException
 * @see NotEqualException
 * @see NotNullException
 * @see NullException
 * @since 0.0.0
 */
@SuppressWarnings("unused")
public final class Validator {

    /**
     * Бросает мягкое исключение.
     *
     * @throws CreationException невозможно создать объект.
     * @author Bloogefest
     * @since 0.0.0
     */
    private Validator() throws CreationException {
        throw new CreationException();
    }

    /**
     * Подтверждает нулевое явление объекта.
     *
     * @param object объект.
     *
     * @return Объект.
     *
     * @throws NotNullException объект должен быть нулевым.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null -> null; !null -> fail", pure = true)
    public static <T> @Nullable T isNull(final @Nullable T object) throws NotNullException {
        if (Predicates.isNull(object)) return null;
        throw new NotNullException();
    }

    /**
     * Подтверждает нулевое явление объекта.
     *
     * @param object объект.
     * @param name   имя объекта.
     *
     * @return Объект.
     *
     * @throws NotNullException объект должен быть нулевым.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, _ -> null; !null, _ -> fail", pure = true)
    public static <T> @Nullable T isNull(final @Nullable T object, final @NonNls @NotNull String name) throws NotNullException {
        if (Predicates.isNull(object)) return null;
        throw new NotNullException("The %s must be null".formatted(name));
    }

    /**
     * Подтверждает нулевое явление объекта.
     *
     * @param object   объект.
     * @param supplier поставщик исключения.
     *
     * @return Объект.
     *
     * @throws NullException исключение не должно быть нулевым.
     * @throws E             параметризованное исключение.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, _ -> null; !null, _ -> fail", pure = true)
    public static <T, E extends Throwable> @Nullable T isNull(final @Nullable T object, final @NonNls @NotNull Supplier<E> supplier) throws NullException, E {
        if (Predicates.isNull(object)) return null;
        throw notNull(supplier.supply(), "exception");
    }

    /**
     * Подтверждает ненулевое явление объекта.
     *
     * @param object объект.
     *
     * @return Объект.
     *
     * @throws NullException объект не должен быть нулевым.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null -> fail; !null -> param1", pure = true)
    public static <T> @NotNull T notNull(final @Nullable T object) throws NullException {
        if (Predicates.notNull(object)) return object;
        throw new NullException();
    }

    /**
     * Подтверждает ненулевое явление объекта.
     *
     * @param object объект.
     * @param name   имя объекта.
     *
     * @return Объект.
     *
     * @throws NullException объект не должен быть нулевым.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, _ -> fail; !null, _ -> param1", pure = true)
    public static <T> @NotNull T notNull(final @Nullable T object, final @NonNls @NotNull String name) throws NullException {
        if (Predicates.notNull(object)) return object;
        throw new NullException("The %s mustn't be null".formatted(name));
    }

    /**
     * Подтверждает ненулевое явление объекта.
     *
     * @param object   объект.
     * @param supplier поставщик исключения.
     *
     * @return Объект.
     *
     * @throws NullException исключение не должно быть нулевым.
     * @throws E             параметризованное исключение.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, _ -> fail; !null, _ -> param1", pure = true)
    public static <T, E extends Throwable> @NotNull T notNull(final @Nullable T object, final @NonNls @NotNull Supplier<E> supplier) throws NullException, E {
        if (Predicates.notNull(object)) return object;
        throw notNull(supplier.supply(), "throwable");
    }

    /**
     * Подтверждает явление равенства первичного объекта со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     *
     * @return Первичный объект.
     *
     * @throws NotEqualException первичный объект должен быть равен вторичному.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null -> null; _, _ -> _", pure = true)
    public static <T, T_> @Nullable T equals(final @Nullable T object, final @Nullable T_ object_) throws NotEqualException {
        if (Predicates.equals(object, object_)) return null;
        throw new NotEqualException();
    }

    /**
     * Подтверждает явление равенства первичного объекта со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     * @param name    имя первичного объекта.
     * @param name_   имя вторичного объекта.
     *
     * @return Первичный объект.
     *
     * @throws NotEqualException первичный объект должен быть равен вторичному.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null, _, _ -> null; _, _, _, _ -> _", pure = true)
    public static <T, T_> @Nullable T equals(final @Nullable T object, final @Nullable T_ object_, final @NonNls @NotNull String name,
                                             final @NonNls @NotNull String name_) throws NotEqualException {
        if (Predicates.equals(object, object_)) return null;
        throw new NotEqualException("The %s must be equal to %s".formatted(name, name_));
    }

    /**
     * Подтверждает явление равенства первичного объекта со вторичным.
     *
     * @param object   первичный объект.
     * @param object_  вторичный объект.
     * @param supplier поставщик исключения.
     *
     * @return Первичный объект.
     *
     * @throws NullException исключение не должно быть нулевым.
     * @throws E             параметризованное исключение.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null, _ -> null; _, _, _ -> _", pure = true)
    public static <T, T_, E extends Throwable> @Nullable T equals(final @Nullable T object, final @Nullable T_ object_,
                                                                  final @NonNls @NotNull Supplier<E> supplier) throws NullException, E {
        if (Predicates.equals(object, object_)) return object;
        throw notNull(supplier.supply(), "exception");
    }

    /**
     * Подтверждает явление неравенства первичного объекта со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     *
     * @return Первичный объект.
     *
     * @throws EqualException первичный объект не должен быть равен вторичному.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null -> fail; _, _ -> _", pure = true)
    public static <T, T_> @Nullable T notEquals(final @Nullable T object, final @Nullable T_ object_) throws EqualException {
        if (Predicates.notEquals(object, object_)) return null;
        throw new EqualException();
    }

    /**
     * Подтверждает явление неравенства первичного объекта со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     * @param name    имя первичного объекта.
     * @param name_   имя вторичного объекта.
     *
     * @return Первичный объект.
     *
     * @throws EqualException первичный объект не должен быть равен вторичному.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null, _, _ -> fail; _, _, _, _ -> _", pure = true)
    public static <T, T_> @Nullable T notEquals(final @Nullable T object, final @Nullable T_ object_, final @NonNls @NotNull String name,
                                                final @NonNls @NotNull String name_) throws EqualException {
        if (Predicates.notEquals(object, object_)) return null;
        throw new EqualException("The %s mustn't be equal to %s".formatted(name, name_));
    }

    /**
     * Подтверждает явление неравенства первичного объекта со вторичным.
     *
     * @param object   первичный объект.
     * @param object_  вторичный объект.
     * @param supplier поставщик исключения.
     *
     * @return Первичный объект.
     *
     * @throws NullException исключение не должно быть нулевым.
     * @throws E             параметризованное исключение.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null, _ -> fail; _, _, _ -> _", pure = true)
    public static <T, T_, E extends Throwable> @Nullable T notEquals(final @Nullable T object, final @Nullable T_ object_,
                                                                     final @NonNls @NotNull Supplier<E> supplier) throws NullException, E {
        if (Predicates.notEquals(object, object_)) return object;
        throw notNull(supplier.supply(), "exception");
    }

}
