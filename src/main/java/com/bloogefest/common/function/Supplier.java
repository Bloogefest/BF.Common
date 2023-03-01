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
 * Функциональный интерфейс поставщика объекта.
 *
 * @param <T> тип поставляемого объекта.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Проверяет поставляемый объект и, если он ненулевой, инициализирует объект его поставщика, в противном случае
     * генерирует исключение.
     *
     * @param object поставляемый объект.
     *
     * @return Экземпляр поставщика с постоянным поставляемым объектом.
     *
     * @throws NullException исключение проверки объекта.
     * @since 1.0
     */
    @Contract(value = "!null -> new; _ -> fail", pure = true)
    static <T> @NotNull Supplier<T> constant(final @Nullable T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

    /**
     * Проверяет и возвращает объект, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param supplier объект поставщика.
     *
     * @return Экземпляр поставщика.
     *
     * @throws NullException исключение проверки объекта.
     * @apiNote Данный метод можно использовать для инициализации лямбда-выражений и приведения их к типу
     * функционального интерфейса поставщика объекта.
     * @since 1.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static <T> @NotNull Supplier<T> of(final @Nullable Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Поставляет объект.
     *
     * @return Поставляемый объект.
     *
     * @throws SupplyException исключение поставки объекта.
     * @since 1.0
     */
    @Contract(pure = true)
    @NotNull T supply() throws SupplyException;

}
