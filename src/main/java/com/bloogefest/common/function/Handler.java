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
 * Функциональный интерфейс обработчика объекта.
 *
 * @param <T> тип обрабатываемого объекта.
 * @param <R> тип результирующего объекта.
 *
 * @since 3.0
 */
@FunctionalInterface
public interface Handler<T, R> {

    /**
     * Проверяет результирующий объект и, если он ненулевой, инициализирует обработчик, метод обработки которого всегда
     * возвращает его, в противном случае инициализирует и бросает исключение.
     *
     * @param object результирующий объект.
     *
     * @return Обработчик с постоянным результирующим объектом.
     *
     * @throws NullException исключение валидации нулевого результирующего объекта.
     * @since 3.0
     */
    @Contract(value = "!null -> new; _ -> fail", pure = true)
    static <T, R> @NotNull Handler<T, R> constant(final @Nullable R object) throws NullException {
        Validator.notNull(object, "object");
        return ignored -> object;
    }

    /**
     * Проверяет обработчик и, если он ненулевой, возвращает его, в противном случае инициализирует и бросает
     * исключение.
     *
     * @param handler обработчик.
     *
     * @return Переданный обработчик.
     *
     * @throws NullException исключение валидации нулевого обработчика.
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу обработчика.
     * @since 3.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static <T, R> @NotNull Handler<T, R> of(final @Nullable Handler<T, R> handler) throws NullException {
        return Validator.notNull(handler, "handler");
    }

    /**
     * Обрабатывает переданный объект, инициализирует результирующий объект и возвращает его.
     *
     * @param object обрабатываемый объект.
     *
     * @return Результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта.
     * @throws HandleException исключение обработки объекта.
     * @since 3.0
     */
    @Contract
    @NotNull R handle(final @Nullable T object) throws NullException, HandleException;

    /**
     * Проверяет переданный обработчик и, если он ненулевой, инициализирует другой обработчик, метод обработки которого
     * последовательно соединяет метод обработки этого и переданного обработчика, используя конструкцию try-finally, в
     * противном случае инициализирует и бросает исключение.
     *
     * @param handler объект обработчика.
     *
     * @return Обработчик с комбинированной логикой этого и переданного обработчика.
     *
     * @throws NullException исключение валидации нулевого обработчика.
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <R_> @NotNull Handler<T, R_> with(final @Nullable Handler<? super R, R_> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return object -> handler.handle(handle(object));
    }

}
