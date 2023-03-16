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
 * Функциональный интерфейс функции обратного вызова.
 *
 * @since 2.0.0
 */
@FunctionalInterface
public interface Callback {

    /**
     * Инициализирует обратный вызов без логики.
     *
     * @return Обратный вызов без логики.
     *
     * @since 2.0.0
     */
    @Contract(value = "-> new", pure = true)
    static @NotNull Callback empty() {
        return () -> {};
    }

    /**
     * Проверяет обратный вызов и, если он ненулевой, возвращает его, в противном случае инициализирует и бросает
     * исключение.
     *
     * @param callback обратный вызов.
     *
     * @return Переданный обратный вызов.
     *
     * @throws NullException исключение валидации нулевого обратного вызова.
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу обратного вызова.
     * @since 2.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static @NotNull Callback of(final @NotNull Callback callback) throws NullException {
        return Validator.notNull(callback, "callback");
    }

    /**
     * Проверяет обратный вызов и, если он ненулевой, возвращает его, в противном случае инициализирует и возвращает
     * другой обратный вызов без логики.
     *
     * @param callback обратный вызов.
     *
     * @return Переданный либо другой ненулевой обратный вызов.
     *
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу обратного вызова.
     * @since 3.0.0
     */
    @Contract(value = "!null -> param1; _ -> new", pure = true)
    static @NotNull Callback auto(final @Nullable Callback callback) {
        return callback != null ? callback : empty();
    }

    /**
     * Вызывает функцию.
     *
     * @throws CallException исключение вызова функции.
     * @since 2.0.0
     */
    @Contract
    void call() throws CallException;

    /**
     * Проверяет переданный обратный вызов и, если он ненулевой, инициализирует другой обратный вызов, метод вызова
     * которого последовательно соединяет метод вызова этого и переданного обратного вызова, используя конструкцию
     * try-finally, в противном случае инициализирует и бросает исключение.
     *
     * @param callback обратный вызов.
     *
     * @return Обратный вызов с комбинированной логикой этого и переданного анализатора.
     *
     * @throws NullException исключение валидации нулевого обратного вызова.
     * @since 2.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Callback with(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return () -> {
            try {
                call();
            } finally {
                callback.call();
            }
        };
    }

}
