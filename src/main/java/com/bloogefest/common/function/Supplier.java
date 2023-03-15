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

/**
 * Функциональный интерфейс поставщика объекта.
 *
 * @param <T> тип поставляемого объекта.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Проверяет поставляемый объект и, если он ненулевой, инициализирует обработчик, метод обработки которого всегда
     * возвращает его, в противном случае инициализирует и бросает исключение.
     *
     * @param object поставляемый объект.
     *
     * @return Поставщик с постоянным поставляемым объектом.
     *
     * @throws NullException исключение валидации нулевого поставляемого объекта.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Supplier<T> constant(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

    /**
     * Проверяет поставщик и, если он ненулевой, возвращает его, в противном случае инициализирует и бросает
     * исключение.
     *
     * @param supplier поставщик.
     *
     * @return Переданный поставщик.
     *
     * @throws NullException исключение валидации нулевого поставщика.
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу поставщика.
     * @since 1.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Supplier<T> of(final @NotNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Поставляет объект.
     *
     * @return Поставляемый объект.
     *
     * @throws SupplyException исключение поставки объекта.
     * @since 1.0.0
     */
    @Contract(pure = true)
    @NotNull T supply() throws SupplyException;

}
