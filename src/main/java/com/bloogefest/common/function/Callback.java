/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.NonNull;
import com.bloogefest.annotation.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * Функция обратного вызова — это функциональный интерфейс. Позволяет описать функцию без экземпляров-параметров и
 * экземпляров-результатов.
 *
 * @since 2.0.0
 */
@FunctionalInterface
public interface Callback {

    /**
     * Создаёт и возвращает (1).
     *
     * @return (1).
     *
     * @apiNote (1) — это пустая функция обратного вызова.
     * @since 2.0.0
     */
    @Contract(value = "-> new", impact = Contract.Impact.NONE)
    static @NonNull Callback empty() {
        return () -> {};
    }

    /**
     * Возвращает (1).
     *
     * @param callback функция обратного вызова.
     *
     * @return (1).
     *
     * @apiNote (1) — это переданная в этот метод функция обратного вызова.
     * @since 4.0.0-RC3
     */
    @Contract(value = "? -> 1", impact = Contract.Impact.NONE)
    static @NonNull Callback lambda(final @NonNull Callback callback) {
        return callback;
    }

    /**
     * Проверяет переданную функцию обратного вызова и, если та ненулевая, возвращает её, в противном случае вызывает
     * метод инициализации функции обратного вызова, метод вызова которой ничего не делает, а после возвращает его
     * результирующий объект (требуемую функцию обратного вызова).
     *
     * @param callback функция обратного вызова.
     *
     * @return Переданная либо новая функция обратного вызова, метод вызова которой ничего не делает.
     *
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу функции обратного вызова.
     * @since 3.0.0
     */
    @Contract("!null -> param1; _ -> new")
    static @NonNull Callback auto(final @Nullable Callback callback) {
        return callback != null ? callback : empty();
    }

    /**
     * Вызывает эту функцию обратного вызова.
     *
     * @throws CallException исключение вызова функции (этой функции обратного вызова).
     * @since 2.0.0
     */
    void call() throws CallException;

    /**
     * Проверяет переданную функцию обратного вызова и, если та нулевая, генерирует исключение валидации нулевого
     * объекта (переданной функции обратного вызова) с переопределённым сообщением (отформатированным именем переданной
     * функции обратного вызова шаблонным сообщением), в противном случае инициализирует и возвращает другую функцию
     * обратного вызова, метод вызова которой сначала вызывает метод вызова этой функции обратного вызова, а после
     * вызывает метод вызова переданной в этот метод функции обратного вызова.
     *
     * @param callback функция обратного вызова.
     *
     * @return Новая функция обратного вызова, метод вызова которой сначала вызывает метод вызова этой функции обратного
     * вызова, а после вызывает метод вызова переданной в этот метод функции обратного вызова.
     *
     * @throws NullException исключение валидации нулевого объекта (переданной функции обратного вызова).
     * @since 2.0.0
     */
    @Contract(value = "_ -> new")
    default @NonNull Callback with(final @NonNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return () -> {
            call();
            callback.call();
        };
    }

}
