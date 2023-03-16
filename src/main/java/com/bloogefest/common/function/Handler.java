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
 *
 * @since 3.0.0
 */
@FunctionalInterface
public interface Handler<T> {

    /**
     * Инициализирует и возвращает обработчик, метод обработки которого не содержит логику.
     *
     * @return Новый обработчик, метод обработки которого не содержит логику.
     *
     * @since 3.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Handler<T> empty() {
        return ignored -> {};
    }

    /**
     * Проверяет переданный обработчик и обрабатываемый объект и, если они ненулевые, инициализирует другой обработчик,
     * метод обработки которого всегда вызывает метод обработки переданного обработчика, используя переданный
     * обрабатываемый объект, в противном случае инициализирует и бросает исключение.
     *
     * @param handler обработчик.
     * @param object обрабатываемый объект.
     *
     * @return Обработчик с постоянным обрабатываемым объектом.
     *
     * @throws NullException исключение валидации нулевого обработчика либо нулевого обрабатываемого объекта.
     * @since 3.0.0
     */
    @Contract(value = "_, _ -> new", pure = true)
    static <T> @NotNull Handler<T> constant(final @NotNull Handler<T> handler,
                                            final @NotNull T object) throws NullException {
        Validator.notNull(handler, "handler");
        Validator.notNull(object, "object");
        return ignored -> handler.handle(object);
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
     * @since 3.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Handler<T> of(final @NotNull Handler<T> handler) throws NullException {
        return Validator.notNull(handler, "handler");
    }

    /**
     * Проверяет обработчик и, если он ненулевой, возвращает его, в противном случае инициализирует и возвращает другой
     * обработчик без логики.
     *
     * @param handler обработчик.
     *
     * @return Переданный либо другой ненулевой обработчик.
     *
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу обработчика.
     * @since 3.0.0
     */
    @Contract(value = "!null -> param1; _ -> new", pure = true)
    static <T> @NotNull Handler<T> auto(final @Nullable Handler<T> handler) {
        return handler != null ? handler : empty();
    }

    /**
     * Обрабатывает объект.
     *
     * @param object обрабатываемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта.
     * @throws HandleException исключение обработки объекта.
     * @since 3.0.0
     */
    @Contract
    void handle(final @NotNull T object) throws NullException, HandleException;

    /**
     * Проверяет переданный обработчик и, если он ненулевой, инициализирует другой обработчик, метод обработки которого
     * последовательно соединяет метод обработки этого и переданного обработчика, используя конструкцию try-finally, в
     * противном случае инициализирует и бросает исключение.
     *
     * @param handler обработчик.
     *
     * @return Обработчик с комбинированной логикой этого и переданного обработчика.
     *
     * @throws NullException исключение валидации нулевого обработчика.
     * @since 3.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Handler<T> with(final @NotNull Handler<? super T> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return object -> {
            try {
                handle(object);
            } finally {
                handler.handle(object);
            }
        };
    }

}
