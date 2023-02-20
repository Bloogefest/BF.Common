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
 * Функциональный интерфейс обратно вызываемой логики.
 *
 * @since 2.0
 */
@FunctionalInterface
public interface Callback {

    /**
     * Инициализирует экземпляр без логики.
     *
     * @return Экземпляр без обратно вызываемой логики.
     *
     * @since 2.0
     */
    @Contract(value = "-> new", pure = true)
    static @NotNull Callback empty() {
        return () -> {
        };
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param callback экземпляр обратно вызываемой логики.
     *
     * @return Экземпляр обратно вызываемой логики.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод можно использовать для инициализации лямбда-выражений и приведения их к типу
     * функционального интерфейса обратно вызываемой логики.
     * @since 2.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static @NotNull Callback of(final @Nullable Callback callback) throws NullException {
        return Validator.notNull(callback, "callback");
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае инициализирует и возвращает экземпляр без
     * логики.
     *
     * @param callback экземпляр обратно вызываемой логики.
     *
     * @return Экземпляр обратно вызываемой логики.
     *
     * @since 3.0
     */
    @Contract(value = "!null -> param1; _ -> new", pure = true)
    static @NotNull Callback auto(final @Nullable Callback callback) {
        return callback != null ? callback : empty();
    }

    /**
     * Выполняет обратно вызываемую логику.
     *
     * @throws CallException исключение выполнения обратно вызываемой логики.
     * @since 2.0
     */
    @Contract(pure = true)
    void call() throws CallException;

    /**
     * Проверяет и соединяет переданный экземпляр с данным, если он ненулевой, в противном случае генерирует
     * исключение.
     *
     * @param callback экземпляр обратно вызываемой логики.
     *
     * @return Экземпляр обратно вызываемой логики.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод соединяет переданный экземпляр с данным последовательно за счёт конструкции try-finally,
     * таким образом, сначала выполняется логика данного экземпляра, а потом логика переданного.
     * @since 2.0
     */
    @Contract(value = "!null -> new; _ -> fail", pure = true)
    default @NotNull Callback with(final @Nullable Callback callback) throws NullException {
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
