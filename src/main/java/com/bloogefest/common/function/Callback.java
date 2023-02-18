/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Представление обратно вызываемого.
 */
@AvailableSince("0.2.0")
@FunctionalInterface
@SuppressWarnings("unused")
public interface Callback {

    /**
     * Создаёт пустой экземпляр.
     *
     * @return Пустой экземпляр.
     */
    @Contract(value = "-> new", pure = true)
    @AvailableSince("0.2.0")
    static @NotNull Callback empty() {
        return () -> {
        };
    }

    /**
     * Возвращает ненулевой экземпляр.
     *
     * @param callback экземпляр.
     *
     * @return Ненулевой экземпляр.
     *
     * @throws NullException нулевой экземпляр.
     */
    @Contract(value = "_ -> param1", pure = true)
    @AvailableSince("0.2.0")
    static @NotNull Callback of(final @NotNull Callback callback) throws NullException {
        return Validator.notNull(callback, "callback");
    }

    /**
     * Возвращает ненулевой экземпляр.
     *
     * @param callback экземпляр.
     *
     * @return Ненулевой экземпляр.
     */
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    static @NotNull Callback auto(final @Nullable Callback callback) {
        return callback != null ? callback : empty();
    }

    /**
     * Совершает обратный вызов.
     *
     * @throws CallbackException исключение обратного вызова.
     * @since 0.2.0
     */
    @Contract(pure = true)
    @AvailableSince("0.2.0")
    void call() throws CallException;

    /**
     * Последовательно комбинирует данный экземпляр с переданным.
     *
     * @param callback экземпляр.
     *
     * @return Комбинированный экземпляр.
     *
     * @throws NullException нулевой экземпляр.
     * @since 0.2.0
     */
    @Contract(value = "_ -> new", pure = true)
    @AvailableSince("0.2.0")
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
