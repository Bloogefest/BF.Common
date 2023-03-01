/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.common.creation.UtilityException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Утилитарный класс валидатора объектов.
 *
 * @since 1.0
 */
public final class Validator {

    /**
     * Генерирует исключение.
     *
     * @throws UtilityException исключение создания объекта утилитарного типа.
     * @since 1.0
     */
    @Contract(value = "-> fail", pure = true)
    private Validator() throws UtilityException {
        throw new UtilityException();
    }

    /**
     * Проверяет и возвращает объект, если он нулевой, в противном случае генерирует исключение.
     *
     * @param object объект.
     *
     * @return Нулевой объект.
     *
     * @throws NotNullException исключение валидации ненулевого объекта.
     * @since 1.0
     */
    @Contract(value = "!null -> fail; _ -> null", pure = true)
    public static <T> @Nullable T isNull(final @Nullable T object) throws NotNullException {
        if (object != null) throw new NotNullException();
        return null;
    }

    /**
     * Проверяет и возвращает объект, если он нулевой, в противном случае генерирует исключение.
     *
     * @param object объект.
     * @param name имя объекта.
     *
     * @return Нулевой объект.
     *
     * @throws NotNullException исключение валидации ненулевого объекта.
     * @since 1.0
     */
    @Contract(value = "!null, _ -> fail; _, _ -> null", pure = true)
    public static <T> @Nullable T isNull(final @Nullable T object,
                                         final @NonNls @NotNull String name) throws NotNullException {
        if (object != null) throw new NotNullException(NotNullException.templateMessage.formatted(name));
        return null;
    }

    /**
     * Проверяет и возвращает объект, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param object объект.
     *
     * @return Ненулевой объект.
     *
     * @throws NullException исключение валидации нулевого объекта.
     * @since 1.0
     */
    @Contract(value = "!null -> param1; null -> fail", pure = true)
    public static <T> @NotNull T notNull(final @Nullable T object) throws NullException {
        if (object == null) throw new NullException();
        return object;
    }

    /**
     * Проверяет и возвращает объект, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param object объект.
     * @param name имя объекта.
     *
     * @return Ненулевой объект.
     *
     * @throws NullException исключение валидации нулевого объекта.
     * @since 1.0
     */
    @Contract(value = "!null, _ -> param1; null, _ -> fail", pure = true)
    public static <T> @NotNull T notNull(final @Nullable T object,
                                         final @NonNls @NotNull String name) throws NullException {
        if (object == null) throw new NullException(NullException.templateMessage.formatted(name));
        return object;
    }

    /**
     * Проверяет равенство первичного и вторичного объекта и, если он равны, возвращает первичный объект, в противном
     * случае генерирует исключение.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     *
     * @return Первичный объект.
     *
     * @throws NotEqualException исключение валидации равенства первичного и вторичного объекта.
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T equals(final @Nullable T primaryObject,
                                         final @Nullable T secondaryObject) throws NotEqualException {
        if (primaryObject != secondaryObject && (primaryObject == null || primaryObject.equals(secondaryObject)))
            throw new NotEqualException();
        return primaryObject;
    }

    /**
     * Проверяет равенство первичного и вторичного объекта и, если он равны, возвращает первичный объект, в противном
     * случае генерирует исключение.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     * @param primaryName имя первичного объект.
     * @param secondaryName имя вторичного объект.
     *
     * @return Первичный объект.
     *
     * @throws NotEqualException исключение валидации равенства первичного и вторичного объекта.
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T equals(final @Nullable T primaryObject, final @Nullable T secondaryObject,
                                         final @NonNls @NotNull String primaryName,
                                         final @NonNls @NotNull String secondaryName) throws NotEqualException {
        if (primaryObject != secondaryObject && (primaryObject == null || primaryObject.equals(secondaryObject)))
            throw new NotEqualException(NotEqualException.templateMessage.formatted(primaryName, secondaryName));
        return primaryObject;
    }

    /**
     * Проверяет неравенство первичного и вторичного объекта и, если он неравны, возвращает первичный объект, в
     * противном случае генерирует исключение.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     *
     * @return Первичный объект.
     *
     * @throws EqualException исключение валидации неравенства первичного и вторичного объекта.
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T notEquals(final @Nullable T primaryObject,
                                            final @Nullable T secondaryObject) throws EqualException {
        if (primaryObject == secondaryObject || primaryObject != null && primaryObject.equals(secondaryObject))
            throw new EqualException();
        return primaryObject;
    }

    /**
     * Проверяет неравенство первичного и вторичного объекта и, если он неравны, возвращает первичный объект, в
     * противном случае генерирует исключение.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     * @param primaryName имя первичного объект.
     * @param secondaryName имя вторичного объект.
     *
     * @return Первичный объект.
     *
     * @throws EqualException исключение валидации неравенства первичного и вторичного объекта.
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T notEquals(final @Nullable T primaryObject, final @Nullable T secondaryObject,
                                            final @NonNls @NotNull String primaryName,
                                            final @NonNls @NotNull String secondaryName) throws EqualException {
        if (primaryObject == secondaryObject || primaryObject != null && primaryObject.equals(secondaryObject))
            throw new EqualException(EqualException.templateMessage.formatted(primaryName, secondaryName));
        return primaryObject;
    }

}
