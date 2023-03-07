/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Исключение поставки объекта.
 *
 * @since 3.0
 */
public class SupplyException extends FunctionException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 3.0
     */
    public static final @NonNls @NotNull String defaultMessage = "The object could not be supplied";

    /**
     * Шаблонное сообщение.
     *
     * @since 3.0
     */
    public static final @NonNls @NotNull String templateMessage = "The %s could not be supplied";

    /**
     * Инициализирует исключение по умолчанию.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public SupplyException() {
        super(defaultMessage);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public SupplyException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Инициализирует исключение с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public SupplyException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public SupplyException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Инициализирует исключение с переопределённым параметром подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public SupplyException(final boolean suppression, final boolean writable) {
        super(suppression, writable);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением, причиной, параметром подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    protected SupplyException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                              final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
