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
     * @throws CallbackException исключение выполнения (1).
     * @throws CallbackError ошибка выполнения (1).
     * @apiNote (1) — это описанная функция без экземпляров-параметров и экземпляров-результатов.
     * @since 2.0.0
     */
    @Contract(value = "->", impact = Contract.Impact.UNDEFINED)
    void call() throws CallbackException, CallbackError;

    /**
     * Создаёт и возвращает (3).
     *
     * @param callback функция обратного вызова.
     *
     * @return (3).
     *
     * @throws NullException исключение валидации нулевой (2).
     * @apiNote (1) — это данная функция обратного вызова.
     * <p>
     * (2) — это переданная в этот метод функция обратного вызова.
     * <p>
     * (3) — это функция обратного вызова, которая сначала выполняет (1), а потом выполняет (2).
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
