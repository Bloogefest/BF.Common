/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс поставщика экземпляра.
 *
 * @param <T> тип поставляемого экземпляра.
 *
 * @since 0.0
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Проверяет поставляемый экземпляр и, если он ненулевой, создаёт экземпляр его поставщика, в противном случае
     * генерирует исключение.
     *
     * @param instance поставляемый экземпляр.
     *
     * @return Экземпляр поставщика с постоянным поставляемым экземпляром.
     *
     * @throws NullException исключение проверки экземпляра.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Supplier<T> constant(final @NotNull T instance) throws NullException {
        Validator.notNull(instance, "instance");
        return () -> instance;
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param supplier экземпляр поставщика.
     *
     * @return Экземпляр поставщика.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод можно использовать для инициализации лямбда-выражений и приведения их к типу
     * функционального интерфейса поставщика экземпляра.
     * @since 0.0
     */
    @Contract(value = "!null -> param1; null -> fail", pure = true)
    static <T> @NotNull Supplier<T> of(final @Nullable Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Поставляет экземпляр.
     *
     * @return Поставляемый экземпляр.
     *
     * @throws SupplyException исключение поставки экземпляра.
     * @since 0.0
     */
    @Contract(pure = true)
    @NotNull T supply() throws SupplyException;

}
