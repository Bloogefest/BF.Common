/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.NonNull;
import com.bloogefest.annotation.Nullable;
import com.bloogefest.common.creation.UtilityException;

/**
 * Утилитарный класс валидатора объектов.
 *
 * @since 1.0.0
 */
public final class Validator {

    /**
     * Генерирует исключение создания объекта утилитарного типа (утилитарного класса валидатора объектов).
     *
     * @throws UtilityException исключение создания объекта утилитарного типа (утилитарного класса валидатора
     * объектов).
     * @since 1.0.0
     */
    @Contract(value = "-> fail")
    private Validator() throws UtilityException {
        throw new UtilityException();
    }

    /**
     * Проверяет переданный объект и, если тот ненулевой, генерирует исключение валидации ненулевого объекта
     * (переданного объекта), в противном случае возвращает его.
     *
     * @param object объект.
     *
     * @return Переданный объект.
     *
     * @throws NotNullException исключение валидации ненулевого объекта (переданного объекта).
     * @since 1.0.0
     */
    @Contract(value = "!null -> fail; _ -> null")
    public static <T> @Nullable T isNull(final @Nullable T object) throws NotNullException {
        if (object != null) throw new NotNullException();
        return null;
    }

    /**
     * Проверяет переданный объект и, если тот ненулевой, генерирует исключение валидации ненулевого объекта
     * (переданного объекта) с переопределённым сообщением (отформатированным переданным именем объекта шаблонным
     * сообщением), в противном случае возвращает его.
     *
     * @param object объект.
     * @param name имя объекта.
     *
     * @return Переданный объект.
     *
     * @throws NotNullException исключение валидации ненулевого объекта (переданного объекта).
     * @since 1.0.0
     */
    @Contract(value = "!null, _ -> fail; _, _ -> null")
    public static <T> @Nullable T isNull(final @Nullable T object, final @NonNull String name) throws NotNullException {
        if (object != null) throw new NotNullException(NotNullException.TEMPLATE_MESSAGE.formatted(name));
        return null;
    }

    /**
     * Проверяет переданный объект и, если тот нулевой, генерирует исключение валидации ненулевого объекта (переданного
     * объекта), в противном случае возвращает его.
     *
     * @param object объект.
     *
     * @return Переданный объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного объекта).
     * @since 1.0.0
     */
    @Contract(value = "!null -> param1; null -> fail")
    public static <T> @NonNull T notNull(final @Nullable T object) throws NullException {
        if (object == null) throw new NullException();
        return object;
    }

    /**
     * Проверяет переданный объект и, если тот нулевой, генерирует исключение валидации ненулевого объекта (переданного
     * объекта) с переопределённым сообщением (отформатированным переданным именем объекта шаблонным сообщением), в
     * противном случае возвращает его.
     *
     * @param object объект.
     * @param name имя объекта.
     *
     * @return Переданный объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного объекта).
     * @since 1.0.0
     */
    @Contract(value = "!null, _ -> param1; null, _ -> fail")
    public static <T> @NonNull T notNull(final @Nullable T object, final @NonNull String name) throws NullException {
        if (object == null) throw new NullException(NullException.TEMPLATE_MESSAGE.formatted(name));
        return object;
    }

    /**
     * Проверяет равенство переданного первичного и вторичного объекта и, если те неравны, генерирует исключение
     * валидации равенства первичного и вторичного объекта (переданного первичного и вторичного объекта), в противном
     * случае возвращает переданный первичный объект.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     *
     * @return Переданный первичный объект.
     *
     * @throws NotEqualException исключение валидации равенства первичного и вторичного объекта (переданного первичного
     * и вторичного объекта).
     * @since 1.0.0
     */
    @Contract
    public static <T> @Nullable T equals(final @Nullable T primaryObject,
                                         final @Nullable T secondaryObject) throws NotEqualException {
        if (primaryObject != secondaryObject && (primaryObject == null || !primaryObject.equals(secondaryObject)))
            throw new NotEqualException();
        return primaryObject;
    }

    /**
     * Проверяет равенство переданного первичного и вторичного объекта и, если те неравны, генерирует исключение
     * валидации равенства первичного и вторичного объекта (переданного первичного и вторичного объекта) с
     * переопределённым сообщением (отформатированным переданным именем первичного и вторичного объекта шаблонным
     * сообщением), в противном случае возвращает переданный первичный объект.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     * @param primaryName имя первичного объекта.
     * @param secondaryName имя вторичного объекта.
     *
     * @return Переданный первичный объект.
     *
     * @throws NotEqualException исключение валидации равенства первичного и вторичного объекта (переданного первичного
     * и вторичного объекта).
     * @since 1.0.0
     */
    @Contract
    public static <T> @Nullable T equals(final @Nullable T primaryObject, final @Nullable T secondaryObject,
                                         final @NonNull String primaryName,
                                         final @NonNull String secondaryName) throws NotEqualException {
        if (primaryObject != secondaryObject && (primaryObject == null || !primaryObject.equals(secondaryObject)))
            throw new NotEqualException(NotEqualException.TEMPLATE_MESSAGE.formatted(primaryName, secondaryName));
        return primaryObject;
    }

    /**
     * Проверяет равенство переданного первичного и вторичного объекта и, если те равны, генерирует исключение валидации
     * неравенства первичного и вторичного объекта (переданного первичного и вторичного объекта), в противном случае
     * возвращает переданный первичный объект.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     *
     * @return Переданный первичный объект.
     *
     * @throws EqualException исключение валидации неравенства первичного и вторичного объекта (переданного первичного и
     * вторичного объекта).
     * @since 1.0.0
     */
    @Contract
    public static <T> @Nullable T notEquals(final @Nullable T primaryObject,
                                            final @Nullable T secondaryObject) throws EqualException {
        if (primaryObject == secondaryObject || primaryObject != null && primaryObject.equals(secondaryObject))
            throw new EqualException();
        return primaryObject;
    }

    /**
     * Проверяет равенство переданного первичного и вторичного объекта и, если те равны, генерирует исключение валидации
     * неравенства первичного и вторичного объекта (переданного первичного и вторичного объекта) с переопределённым
     * сообщением (отформатированным переданным именем первичного и вторичного объекта шаблонным сообщением), в
     * противном случае возвращает переданный первичный объект.
     *
     * @param primaryObject первичный объект.
     * @param secondaryObject вторичный объект.
     * @param primaryName имя первичного объекта.
     * @param secondaryName имя вторичного объекта.
     *
     * @return Переданный первичный объект.
     *
     * @throws EqualException исключение валидации неравенства первичного и вторичного объекта (переданного первичного и
     * вторичного объекта).
     * @since 1.0.0
     */
    @Contract
    public static <T> @Nullable T notEquals(final @Nullable T primaryObject, final @Nullable T secondaryObject,
                                            final @NonNull String primaryName,
                                            final @NonNull String secondaryName) throws EqualException {
        if (primaryObject == secondaryObject || primaryObject != null && primaryObject.equals(secondaryObject))
            throw new EqualException(EqualException.TEMPLATE_MESSAGE.formatted(primaryName, secondaryName));
        return primaryObject;
    }

}
