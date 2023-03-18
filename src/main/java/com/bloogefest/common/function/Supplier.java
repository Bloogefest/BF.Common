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
     * Проверяет переданный поставляемый объект и, если тот ненулевой, инициализирует и возвращает поставщик, метод
     * поставки которого поставляет переданный в этот метод поставляемый объект, в противном случае инициализирует и
     * бросает исключение валидации нулевого объекта (переданного поставляемого объекта) с переопределённым сообщением
     * (отформатированным именем переданного поставляемого объекта шаблонным сообщением).
     *
     * @param object поставляемый объект.
     *
     * @return Новый поставщик, метод поставки которого поставляет переданный в этот метод поставляемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставляемого объекта).
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Supplier<T> constant(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

    /**
     * Проверяет переданный поставщик и, если тот ненулевой, возвращает его, в противном случае инициализирует и бросает
     * исключение валидации нулевого объекта (переданного поставщика) с переопределённым сообщением (отформатированным
     * именем переданного поставщика шаблонным сообщением).
     *
     * @param supplier поставщик объекта.
     *
     * @return Переданный поставщик.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставщика).
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу поставщика объекта.
     * @since 1.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Supplier<T> of(final @NotNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Поставляет поставляемый объект.
     *
     * @return Поставляемый объект.
     *
     * @throws SupplyException исключение поставки объекта (поставляемого объекта).
     * @since 1.0.0
     */
    @Contract
    @NotNull T supply() throws SupplyException;

}
