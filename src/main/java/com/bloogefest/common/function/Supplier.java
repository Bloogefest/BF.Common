/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

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
     * Проверяет переданный поставляемый объект и, если тот нулевой, генерирует исключение валидации нулевого объекта
     * (переданного поставляемого объекта) с переопределённым сообщением (отформатированным именем переданного
     * поставляемого объекта шаблонным сообщением), в противном случае инициализирует и возвращает поставщик, метод
     * поставки которого возвращает переданный в этот метод поставляемый объект.
     *
     * @param object поставляемый объект.
     *
     * @return Новый поставщик, метод поставки которого возвращает переданный в этот метод поставляемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставляемого объекта).
     * @since 1.0.0
     */
    @Contract(value = "_ -> new")
    static <T> @NotNull Supplier<T> constant(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

    /**
     * Проверяет переданный поставщик и, если тот нулевой, генерирует исключение валидации нулевого объекта (переданного
     * поставщика) с переопределённым сообщением (отформатированным именем переданного поставщика шаблонным сообщением),
     * в противном случае возвращает его.
     *
     * @param supplier поставщик объекта.
     *
     * @return Переданный поставщик.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставщика).
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу поставщика объекта.
     * @since 1.0.0
     */
    @Contract(value = "_ -> param1")
    static <T> @NotNull Supplier<T> of(final @NotNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Возвращает переданный поставщик.
     *
     * @param supplier поставщик объекта.
     *
     * @return Переданный поставщик.
     *
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу поставщика объекта.
     * @since 4.0.0
     */
    @Contract(value = "_ -> param1")
    static <T> @NotNull Supplier<T> as(final @NotNull Supplier<T> supplier) {
        return supplier;
    }

    /**
     * Получает и возвращает объект.
     *
     * @return Объект.
     *
     * @throws GetException исключение получения объекта.
     * @since 4.0.0-RC3
     */
    @Contract("-> _")
    default @Nullable T get() throws GetException {
        try {
            return supply();
        } catch (final @NotNull SupplyException e) {
            throw new GetException(e);
        }
    }

    /**
     * Поставляет поставляемый объект.
     *
     * @return Поставляемый объект этого поставщика.
     *
     * @throws SupplyException исключение поставки объекта (поставляемого объекта этого поставщика).
     * @since 1.0.0
     */
    @Contract(pure = false)
    @NotNull T supply() throws SupplyException;

}
