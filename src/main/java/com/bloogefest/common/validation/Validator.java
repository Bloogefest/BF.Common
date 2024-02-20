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
 * Валидатор — это класс-утилита, предназначенный для валидации условий, значений и экземпляров классов.
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
        throw new UtilityException(UtilityException.TEMPLATE_MESSAGE.formatted("the Validator class"));
    }

    /**
     * Возвращает переданный экземпляр класса, если он нулевой.
     *
     * @param instance экземпляр класса.
     *
     * @return Переданный нулевой экземпляр класса.
     *
     * @throws NotNullException исключение валидации переданного ненулевого экземпляра класса.
     * @since 1.0.0
     */
    @Contract(value = "null -> null; !null -> fail", impact = Contract.Impact.NONE)
    public static <T> @Nullable T isNull(final @Nullable T instance) throws NotNullException {
        if (instance != null)
            throw new NotNullException(NotNullException.TEMPLATE_MESSAGE.formatted("The passed instance of the class"));
        return null;
    }

    /**
     * Возвращает переданный экземпляр класса, если он нулевой.
     *
     * @param instance экземпляр класса.
     * @param name имя экземпляра класса.
     *
     * @return Переданный нулевой экземпляр класса.
     *
     * @throws NotNullException исключение валидации переданного ненулевого экземпляра класса.
     * @throws NullException исключение валидации переданного нулевого имени экземпляра класса.
     * @since 1.0.0
     */
    @Contract(value = "null, !null -> null; ?, ? -> fail", impact = Contract.Impact.NONE)
    public static <T> @Nullable T isNull(final @Nullable T instance, final @NonNull String name) throws
                                                                                                 NotNullException,
                                                                                                 NullException {
        Validator.notNull(name, "The passed name of the instance of the class");
        if (instance != null) throw new NotNullException(NotNullException.TEMPLATE_MESSAGE.formatted(name));
        return null;
    }

    /**
     * Возвращает переданный экземпляр класса, если он ненулевой.
     *
     * @param instance экземпляр класса.
     *
     * @return Переданный ненулевой экземпляр класса.
     *
     * @throws NullException исключение валидации переданного нулевого экземпляра класса.
     * @since 1.0.0
     */
    @Contract(value = "!null -> 1; null -> fail", impact = Contract.Impact.NONE)
    public static <T> @NonNull T notNull(final @Nullable T instance) throws NullException {
        if (instance == null)
            throw new NullException(NullException.TEMPLATE_MESSAGE.formatted("The passed instance of the class"));
        return instance;
    }

    /**
     * Возвращает переданный экземпляр класса, если он ненулевой.
     *
     * @param instance экземпляр класса.
     * @param name имя экземпляра класса.
     *
     * @return Переданный ненулевой экземпляр класса.
     *
     * @throws NullException исключение валидации переданного нулевого имени экземпляра класса или переданного нулевого
     * экземпляра класса.
     * @since 1.0.0
     */
    @Contract(value = "!null, !null -> 1; ?, ? -> fail", impact = Contract.Impact.NONE)
    public static <T> @NonNull T notNull(final @Nullable T instance, final @NonNull String name) throws NullException {
        if (name == null) throw new NullException(
                NullException.TEMPLATE_MESSAGE.formatted("The passed name of the instance of the class"));
        if (instance == null) throw new NullException(NullException.TEMPLATE_MESSAGE.formatted(name));
        return instance;
    }

    /**
     * Возвращает переданный первичный экземпляр класса, если он равен переданному вторичному экземпляру класса.
     *
     * @param primaryInstance первичный экземпляр класса.
     * @param secondaryInstance вторичный экземпляр класса.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws NotEqualException исключение валидации равенства переданных первичного и вторичного экземпляров класса.
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
     * Возвращает переданный первичный экземпляр класса, если он равен переданному вторичному экземпляру класса.
     *
     * @param primaryInstance первичный экземпляр класса.
     * @param secondaryInstance вторичный экземпляр класса.
     * @param primaryName имя первичного экземпляра класса.
     * @param secondaryName имя вторичного экземпляра класса.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws NotEqualException исключение валидации равенства переданных первичного и вторичного экземпляров класса.
     * @throws NullException исключение валидации переданного нулевого имени первичного экземпляра класса или
     * переданного нулевого имени вторичного экземпляра класса.
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
     * Возвращает переданный первичный экземпляр класса, если он неравен переданному вторичному экземпляру класса.
     *
     * @param primaryInstance первичный экземпляр класса.
     * @param secondaryInstance вторичный экземпляр класса.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws EqualException исключение валидации неравенства переданных первичного и вторичного экземпляров класса.
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
     * Возвращает переданный первичный экземпляр класса, если он неравен переданному вторичному экземпляру класса.
     *
     * @param primaryInstance первичный экземпляр класса.
     * @param secondaryInstance вторичный экземпляр класса.
     * @param primaryName имя первичного экземпляра класса.
     * @param secondaryName имя вторичного экземпляра класса.
     *
     * @return Переданный первичный экземпляр.
     *
     * @throws EqualException исключение валидации неравенства переданных первичного и вторичного экземпляров класса.
     * @throws NullException исключение валидации переданного нулевого имени первичного экземпляра класса или
     * переданного нулевого имени вторичного экземпляра класса.
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
