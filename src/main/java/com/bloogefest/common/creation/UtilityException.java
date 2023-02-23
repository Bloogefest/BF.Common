/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.creation;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Исключение создания объекта утилитарного типа.
 *
 * @since 3.0
 */
public class UtilityException extends CreationException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 3.0
     */
    protected static final @NonNls @Nullable String defaultMessage = "The utility object must not be created";

    /**
     * Шаблонное сообщение.
     *
     * @since 3.0
     */
    protected static final @NonNls @Nullable String templateMessage = "The %s must not be created";

    /**
     * Инициализирует исключение по умолчанию.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public UtilityException() {
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
    public UtilityException(final @NonNls @Nullable String message) {
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
    public UtilityException(final @Nullable Throwable cause) {
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
    public UtilityException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
    public UtilityException(final boolean suppression, final boolean writable) {
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
    protected UtilityException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                               final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
