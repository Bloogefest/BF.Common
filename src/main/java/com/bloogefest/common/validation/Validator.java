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
 * Утилитарный класс валидатора экземпляров.
 *
 * @since 1.0
 */
public final class Validator {

    /**
     * Генерирует исключение.
     *
     * @throws UtilityException исключение создания экземпляра утилитарного типа.
     * @since 1.0
     */
    @Contract(value = "-> fail", pure = true)
    private Validator() throws UtilityException {
        throw new UtilityException();
    }

    /**
     * Проверяет и возвращает экземпляр, если он нулевой, в противном случае генерирует исключение.
     *
     * @param instance экземпляр.
     *
     * @return Нулевой экземпляр.
     *
     * @throws NotNullException исключение валидации ненулевого экземпляра.
     *
     * @since 1.0
     */
    @Contract(value = "!null -> fail; _ -> null", pure = true)
    public static <T> @Nullable T isNull(final @Nullable T instance) throws NotNullException {
        if (instance != null) throw new NotNullException();
        return null;
    }

    /**
     * Проверяет и возвращает экземпляр, если он нулевой, в противном случае генерирует исключение.
     *
     * @param instance экземпляр.
     * @param name имя экземпляра.
     *
     * @return Нулевой экземпляр.
     *
     * @throws NotNullException исключение валидации ненулевого экземпляра.
     *
     * @since 1.0
     */
    @Contract(value = "!null, _ -> fail; _, _ -> null", pure = true)
    public static <T> @Nullable T isNull(final @Nullable T instance, final @NonNls @NotNull String name) throws NotNullException {
        if (instance != null) throw new NotNullException(NotNullException.templateMessage.formatted(name));
        return null;
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param instance экземпляр.
     *
     * @return Ненулевой экземпляр.
     *
     * @throws NullException исключение валидации нулевого экземпляра.
     *
     * @since 1.0
     */
    @Contract(value = "!null -> param1; null -> fail", pure = true)
    public static <T> @NotNull T notNull(final @Nullable T instance) throws NullException {
        if (instance == null) throw new NullException();
        return instance;
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param instance экземпляр.
     * @param name имя экземпляра.
     *
     * @return Ненулевой экземпляр.
     *
     * @throws NullException исключение валидации нулевого экземпляра.
     *
     * @since 1.0
     */
    @Contract(value = "!null, _ -> param1; null, _ -> fail", pure = true)
    public static <T> @NotNull T notNull(final @Nullable T instance, final @NonNls @NotNull String name) throws NullException {
        if (instance == null) throw new NullException(NullException.templateMessage.formatted(name));
        return instance;
    }

    /**
     * Проверяет равенство первичного и вторичного экземпляра и, если он равны, возвращает первичный экземпляр, в противном случае генерирует исключение.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     *
     * @return Первичный экземпляр.
     *
     * @throws NotEqualException исключение валидации равенства первичного и вторичного экземпляра.
     *
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T equals(final @Nullable T primaryInstance, final @Nullable T secondaryInstance) throws NotEqualException {
        if (primaryInstance != secondaryInstance && (primaryInstance == null || primaryInstance.equals(secondaryInstance))) throw new NotEqualException();
        return primaryInstance;
    }

    /**
     * Проверяет равенство первичного и вторичного экземпляра и, если он равны, возвращает первичный экземпляр, в противном случае генерирует исключение.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     * @param primaryName имя первичного экземпляр.
     * @param secondaryName имя вторичного экземпляр.
     *
     * @return Первичный экземпляр.
     *
     * @throws NotEqualException исключение валидации равенства первичного и вторичного экземпляра.
     *
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T equals(final @Nullable T primaryInstance, final @Nullable T secondaryInstance, final @NonNls @NotNull String primaryName, final @NonNls @NotNull String secondaryName) throws NotEqualException {
        if (primaryInstance != secondaryInstance && (primaryInstance == null || primaryInstance.equals(secondaryInstance))) throw new NotEqualException(NotEqualException.templateMessage.formatted(primaryName, secondaryName));
        return primaryInstance;
    }

    /**
     * Проверяет неравенство первичного и вторичного экземпляра и, если он неравны, возвращает первичный экземпляр, в противном случае генерирует исключение.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     *
     * @return Первичный экземпляр.
     *
     * @throws EqualException исключение валидации неравенства первичного и вторичного экземпляра.
     *
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T notEquals(final @Nullable T primaryInstance, final @Nullable T secondaryInstance) throws EqualException {
        if (primaryInstance == secondaryInstance || primaryInstance != null && primaryInstance.equals(secondaryInstance)) throw new EqualException();
        return primaryInstance;
    }

    /**
     * Проверяет неравенство первичного и вторичного экземпляра и, если он неравны, возвращает первичный экземпляр, в противном случае генерирует исключение.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     * @param primaryName имя первичного экземпляр.
     * @param secondaryName имя вторичного экземпляр.
     *
     * @return Первичный экземпляр.
     *
     * @throws EqualException исключение валидации неравенства первичного и вторичного экземпляра.
     *
     * @since 1.0
     */
    @Contract(pure = true)
    public static <T> @Nullable T notEquals(final @Nullable T primaryInstance, final @Nullable T secondaryInstance, final @NonNls @NotNull String primaryName, final @NonNls @NotNull String secondaryName) throws EqualException {
        if (primaryInstance == secondaryInstance || primaryInstance != null && primaryInstance.equals(secondaryInstance)) throw new EqualException(EqualException.templateMessage.formatted(primaryName, secondaryName));
        return primaryInstance;
    }

}
