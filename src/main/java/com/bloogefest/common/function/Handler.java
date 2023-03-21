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
     * Инициализирует и возвращает обработчик, метод обработки которого ничего не делает.
     *
     * @return Новый обработчик, метод обработки которого ничего не делает.
     *
     * @since 3.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Handler<T> empty() {
        return ignored -> {};
    }

    /**
     * Проверяет переданный обработчик и обрабатываемый объект и, если те нулевые, инициализирует и бросает исключение
     * валидации нулевого объекта (переданного обработчика либо обрабатываемого объекта) с переопределённым сообщением
     * (отформатированным именем переданного обработчика либо обрабатываемого объекта шаблонным сообщением), в противном
     * случае инициализирует другой обработчик, метод обработки которого вызывает метод обработки переданного в этот
     * метод обработчика, используя переданный в этот метод обрабатываемый объект.
     *
     * @param handler обработчик объекта.
     * @param object обрабатываемый объект.
     *
     * @return Новый обработчик, метод обработки которого вызывает метод обработки переданного в этот метод обработчика,
     * используя переданный в этот метод обрабатываемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного обработчика либо обрабатываемого
     * объекта).
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
     * Проверяет переданный обработчик и, если тот нулевой, инициализирует и бросает исключение валидации нулевого
     * объекта (переданного обработчика) с переопределённым сообщением (отформатированным именем переданного обработчика
     * шаблонным сообщением), в противном случае возвращает его.
     *
     * @param handler обработчик объекта.
     *
     * @return Переданный обработчик.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного обработчика).
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу обработчика объекта.
     * @since 3.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Handler<T> of(final @NotNull Handler<T> handler) throws NullException {
        return Validator.notNull(handler, "handler");
    }

    /**
     * Проверяет переданный обработчик и, если тот ненулевой, возвращает его, в противном случае вызывает метод
     * инициализации обработчика, метод обработки которого ничего не делает, а после возвращает его результирующий
     * объект (требуемый обработчик).
     *
     * @param handler обработчик объекта.
     *
     * @return Переданный либо новый обработчик, метод обработки которого ничего не делает.
     *
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу обработчика объекта.
     * @since 3.0.0
     */
    @Contract(value = "!null -> param1; _ -> new", pure = true)
    static <T> @NotNull Handler<T> auto(final @Nullable Handler<T> handler) {
        return handler != null ? handler : empty();
    }

    /**
     * Обрабатывает переданный обрабатываемый объект.
     *
     * @param object обрабатываемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного обрабатываемого объекта).
     * @throws HandleException исключение обработки объекта (переданного обрабатываемого объекта).
     * @since 3.0.0
     */
    @Contract
    void handle(final @NotNull T object) throws NullException, HandleException;

    /**
     * Проверяет переданный обработчик и, если тот нулевой, инициализирует и бросает исключение валидации нулевого
     * объекта (переданного обработчика) с переопределённым сообщением (отформатированным именем переданного обработчика
     * шаблонным сообщением), в противном случае инициализирует и возвращает другой обработчик, метод обработки которого
     * сначала вызывает метод обработки этого обработчика, используя передаваемый в него обрабатываемый объект, а после
     * вызывает метод обработки переданного в этот метод обработчика, вновь используя передаваемый в него обрабатываемый
     * объект.
     *
     * @param handler обработчик объекта.
     *
     * @return Новый обработчик, метод обработки которого сначала вызывает метод обработки этого обработчика, используя
     * передаваемый в него обрабатываемый объект, а после вызывает метод обработки переданного в этот метод обработчика,
     * вновь используя передаваемый в него обрабатываемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного обработчика).
     * @since 3.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Handler<T> with(final @NotNull Handler<? super T> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return object -> {
            handle(object);
            handler.handle(object);
        };
    }

}
