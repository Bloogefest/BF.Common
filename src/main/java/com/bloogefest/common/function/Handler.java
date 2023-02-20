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
 * Функциональный интерфейс обработчика экземпляра.
 *
 * @param <T> тип обрабатываемого экземпляра.
 * @param <R> тип результирующего экземпляра.
 *
 * @since 3.0
 */
@FunctionalInterface
public interface Handler<T, R> {

    /**
     * Проверяет результирующий экземпляр и, если он ненулевой, инициализирует экземпляр обработчика, который его
     * возвращает, в противном случае генерирует исключение.
     *
     * @param instance результирующий экземпляр.
     *
     * @return Экземпляр обработчика.
     *
     * @throws NullException исключение проверки экземпляра.
     * @since 3.0
     */
    @Contract(value = "!null -> new; _ -> fail", pure = true)
    static <T, R> @NotNull Handler<T, R> constant(final @Nullable R instance) throws NullException {
        Validator.notNull(instance, "instance");
        return ignored -> instance;
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param handler экземпляр обработчика
     *
     * @return Экземпляр обработчика.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод можно использовать для инициализации лямбда-выражений и приведения их к типу
     * функционального интерфейса обработчика экземпляра.
     * @since 3.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static <T, R> @NotNull Handler<T, R> of(final @Nullable Handler<T, R> handler) throws NullException {
        return Validator.notNull(handler, "handler");
    }

    /**
     * Обрабатывает экземпляр.
     *
     * @param instance обрабатываемый экземпляр.
     *
     * @return Результирующий экземпляр.
     *
     * @throws HandlerException исключение обработки экземпляра.
     * @since 3.0
     */
    @Contract(pure = true)
    @NotNull R handle(final @NotNull T instance) throws HandlerException;

    /**
     * Проверяет и соединяет переданный экземпляр с данным, если он ненулевой, в противном случае генерирует
     * исключение.
     *
     * @param handler экземпляр обработчика.
     *
     * @return Экземпляр обработчика.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод соединяет переданный экземпляр с данным последовательно за счёт конструкции try-finally,
     * таким образом, сначала выполняется логика данного экземпляра, а потом логика переданного.
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <R_> @NotNull Handler<T, R_> with(final @Nullable Handler<? super R, R_> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return instance -> handler.handle(handle(instance));
    }

}
