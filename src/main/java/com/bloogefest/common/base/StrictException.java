/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Тип строгого исключения.
 *
 * @apiNote Данный тип исключения оповещает о серьёзной проблеме, без решения которой корректное выполнение кода
 * невозможно.
 * @since 0.3.0
 */
public class StrictException extends Exception {

    /**
     * Содержит сообщение по умолчанию.
     *
     * @since 0.3.0
     */
    protected static final @NonNls @Nullable String defaultMessage = null;

    /**
     * Причина по умолчанию.
     *
     * @since 0.3.0
     */
    protected static final @Nullable Throwable defaultCause = null;

    /**
     * Параметр подавления по умолчанию.
     *
     * @since 0.3.0
     */
    protected static final boolean defaultSuppression = false;

    /**
     * Параметр трассировки стека по умолчанию.
     *
     * @since 0.3.0
     */
    protected static final boolean defaultWritable = true;

    /**
     * Инициализирует экземпляр по умолчанию.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    public StrictException() {
        super(defaultMessage, defaultCause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    public StrictException(final @NonNls @Nullable String message) {
        super(message, defaultCause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует экземпляр с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    public StrictException(final @Nullable Throwable cause) {
        super(defaultMessage, cause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    public StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует экземпляр с переопределённым параметром подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    public StrictException(final boolean suppression, final boolean writable) {
        super(defaultMessage, defaultCause, suppression, writable);
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением, причиной, параметром подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    protected StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                              final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
