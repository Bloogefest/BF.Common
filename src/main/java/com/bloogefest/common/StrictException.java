/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Строгое исключение.
 *
 * @apiNote Оповещает о серьёзной проблеме, которую следует обработать для дальнейшего корректного выполнения
 * программы.
 * @since 3.0
 */
public class StrictException extends Exception {

    /**
     * Сообщение по умолчанию.
     *
     * @since 3.0
     */
    public static final @NonNls @Nullable String defaultMessage = null;

    /**
     * Причина по умолчанию.
     *
     * @since 3.0
     */
    public static final @Nullable Throwable defaultCause = null;

    /**
     * Параметр подавления по умолчанию.
     *
     * @since 3.0
     */
    public static final boolean defaultSuppression = false;

    /**
     * Параметр трассировки стека по умолчанию.
     *
     * @since 3.0
     */
    public static final boolean defaultWritable = true;

    /**
     * Инициализирует исключение по умолчанию.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public StrictException() {
        super(defaultMessage, defaultCause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public StrictException(final @NonNls @Nullable String message) {
        super(message, defaultCause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует исключение с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public StrictException(final @Nullable Throwable cause) {
        super(defaultMessage, cause, defaultSuppression, defaultWritable);
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
    public StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause, defaultSuppression, defaultWritable);
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
    public StrictException(final boolean suppression, final boolean writable) {
        super(defaultMessage, defaultCause, suppression, writable);
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
    protected StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                              final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
