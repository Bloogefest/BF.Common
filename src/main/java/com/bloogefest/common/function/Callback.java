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
     * Если (1) не является нулевой, то возвращает её, в противном случае создаёт и возвращает (2).
     *
     * @param callback функция обратного вызова.
     *
     * @return (1) или (2).
     *
     * @apiNote (1) — это переданная в этот метод функция обратного вызова.
     * <p>
     * (2) — это пустая функция обратного вызова.
     * @since 3.0.0
     */
    @Contract(value = "!null -> 1; null -> new", impact = Contract.Impact.NONE)
    static @NonNull Callback auto(final @Nullable Callback callback) {
        return callback != null ? callback : empty();
    }

    /**
     * Выполняет (1).
     *
     * @throws FunctionException исключение выполнения (1).
     * @throws FunctionError ошибка выполнения (1).
     * @apiNote (1) — это описанная функция без экземпляров-параметров и экземпляров-результатов.
     * @since 2.0.0
     */
    void call() throws CallbackException, CallbackError;

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
