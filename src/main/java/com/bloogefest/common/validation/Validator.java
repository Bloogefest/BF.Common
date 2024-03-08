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
 * Валидатор — это класс-утилита. Предназначен для валидации экземпляров.
 *
 * @since 1.0.0
 */
public final class Validator {

    /**
     * Генерирует {@linkplain UtilityException исключение создания экземпляра валидатора}.
     *
     * @throws UtilityException исключение создания экземпляра валидатора.
     * @since 1.0.0
     */
    @Contract(value = "-> fail", impact = Contract.Impact.INTERNAL)
    private Validator() throws UtilityException {
        throw new UtilityException(UtilityException.TEMPLATE_MESSAGE.formatted("the Validator"));
    }

    /**
     * Возвращает переданный экземпляр, если он нулевой.
     *
     * @param instance экземпляр.
     *
     * @return Переданный нулевой экземпляр.
     *
     * @throws NotNullException исключение валидации переданного ненулевого экземпляра.
     * @since 1.0.0
     */
    @Contract(value = "null -> null; !null -> fail", impact = Contract.Impact.NONE)
    public static <T> @Nullable T isNull(final @Nullable T instance) throws NotNullException {
        if (instance != null)
            throw new NotNullException(NotNullException.TEMPLATE_MESSAGE.formatted("The passed instance"));
        return null;
    }

    /**
     * Возвращает переданный экземпляр, если он нулевой.
     *
     * @param instance экземпляр.
     * @param name имя экземпляра.
     *
     * @return Переданный нулевой экземпляр.
     *
     * @throws NotNullException исключение валидации переданного ненулевого экземпляра.
     * @throws NullException исключение валидации переданного нулевого имени экземпляра.
     * @since 1.0.0
     */
    @Contract(value = "null, !null -> null; ?, ? -> fail", impact = Contract.Impact.NONE)
    public static <T> @Nullable T isNull(final @Nullable T instance, final @NonNull String name) throws
                                                                                                 NotNullException,
                                                                                                 NullException {
        Validator.notNull(name, "The passed name of the instance");
        if (instance != null) throw new NotNullException(NotNullException.TEMPLATE_MESSAGE.formatted(name));
        return null;
    }

    /**
     * Возвращает переданный экземпляр, если он ненулевой.
     *
     * @param instance экземпляр.
     *
     * @return Переданный ненулевой экземпляр.
     *
     * @throws NullException исключение валидации переданного нулевого экземпляра.
     * @since 1.0.0
     */
    @Contract(value = "!null -> 1; null -> fail", impact = Contract.Impact.NONE)
    public static <T> @NonNull T notNull(final @Nullable T instance) throws NullException {
        if (instance == null) throw new NullException(NullException.TEMPLATE_MESSAGE.formatted("The passed instance"));
        return instance;
    }

    /**
     * Возвращает переданный экземпляр, если он ненулевой.
     *
     * @param instance экземпляр.
     * @param name имя экземпляра.
     *
     * @return Переданный ненулевой экземпляр.
     *
     * @throws NullException исключение валидации переданного нулевого имени экземпляра или переданного нулевого
     * экземпляра.
     * @since 1.0.0
     */
    @Contract(value = "!null, !null -> 1; ?, ? -> fail", impact = Contract.Impact.NONE)
    public static <T> @NonNull T notNull(final @Nullable T instance, final @NonNull String name) throws NullException {
        if (name == null)
            throw new NullException(NullException.TEMPLATE_MESSAGE.formatted("The passed name of the instance"));
        if (instance == null) throw new NullException(NullException.TEMPLATE_MESSAGE.formatted(name));
        return instance;
    }

    /**
     * Возвращает переданный первичный экземпляр, если он равен переданному вторичному экземпляру.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws NotEqualException исключение валидации равенства переданных первичного и вторичного экземпляров.
     * @since 1.0.0
     */
    @Contract(value = "?, ? -> ?", impact = Contract.Impact.NONE)
    public static <T> @Nullable T equals(final @Nullable T primaryInstance, final @Nullable T secondaryInstance) throws
                                                                                                                 NotEqualException {
        if (primaryInstance != secondaryInstance &&
            (primaryInstance == null || !primaryInstance.equals(secondaryInstance))) throw new NotEqualException(
                NotEqualException.TEMPLATE_MESSAGE.formatted(
                        "The passed primary instance and the passed secondary instance"));
        return primaryInstance;
    }

    /**
     * Возвращает переданный первичный экземпляр, если он равен переданному вторичному экземпляру.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     * @param primaryName имя первичного экземпляра.
     * @param secondaryName имя вторичного экземпляра.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws NotEqualException исключение валидации равенства переданных первичного и вторичного экземпляров.
     * @throws NullException исключение валидации переданного нулевого имени первичного экземпляра или переданного
     * нулевого имени вторичного экземпляра.
     * @since 1.0.0
     */
    @Contract(value = "?, ?, ?, ? -> ?", impact = Contract.Impact.NONE)
    public static <T> @Nullable T equals(final @Nullable T primaryInstance, final @Nullable T secondaryInstance,
                                         final @NonNull String primaryName, final @NonNull String secondaryName) throws
                                                                                                                 NotEqualException,
                                                                                                                 NullException {
        Validator.notNull(primaryName, "The passed name of the primary instance");
        Validator.notNull(secondaryName, "The passed name of the secondary instance");
        if (primaryInstance != secondaryInstance &&
            (primaryInstance == null || !primaryInstance.equals(secondaryInstance))) throw new NotEqualException(
                NotEqualException.TEMPLATE_MESSAGE.formatted("%s and %s").formatted(primaryName, secondaryName));
        return primaryInstance;
    }

    /**
     * Возвращает переданный первичный экземпляр, если он неравен переданному вторичному экземпляру.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws EqualException исключение валидации неравенства переданных первичного и вторичного экземпляров.
     * @since 1.0.0
     */
    @Contract(value = "?, ? -> ?", impact = Contract.Impact.NONE)
    public static <T> @Nullable T notEquals(final @Nullable T primaryInstance,
                                            final @Nullable T secondaryInstance) throws EqualException {
        if (primaryInstance == secondaryInstance ||
            primaryInstance != null && primaryInstance.equals(secondaryInstance)) throw new EqualException(
                EqualException.TEMPLATE_MESSAGE.formatted(
                        "The passed primary instance and the passed secondary instance"));
        return primaryInstance;
    }

    /**
     * Возвращает переданный первичный экземпляр, если он неравен переданному вторичному экземпляру.
     *
     * @param primaryInstance первичный экземпляр.
     * @param secondaryInstance вторичный экземпляр.
     * @param primaryName имя первичного экземпляра.
     * @param secondaryName имя вторичного экземпляра.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws EqualException исключение валидации неравенства переданных первичного и вторичного экземпляров.
     * @throws NullException исключение валидации переданного нулевого имени первичного экземпляра или переданного
     * нулевого имени вторичного экземпляра.
     * @since 1.0.0
     */
    @Contract(value = "?, ?, ?, ? -> ?", impact = Contract.Impact.NONE)
    public static <T> @Nullable T notEquals(final @Nullable T primaryInstance, final @Nullable T secondaryInstance,
                                            final @NonNull String primaryName,
                                            final @NonNull String secondaryName) throws EqualException, NullException {
        Validator.notNull(primaryName, "The passed name of the primary instance");
        Validator.notNull(secondaryName, "The passed name of the secondary instance");
        if (primaryInstance == secondaryInstance ||
            primaryInstance != null && primaryInstance.equals(secondaryInstance)) throw new EqualException(
                EqualException.TEMPLATE_MESSAGE.formatted("%s and %s").formatted(primaryName, secondaryName));
        return primaryInstance;
    }

}
