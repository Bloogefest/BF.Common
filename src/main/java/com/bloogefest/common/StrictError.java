/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNls;
import com.bloogefest.annotation.analysis.Nullable;

/**
 * Строгая ошибка.
 *
 * @apiNote Оповещает о критической проблеме, при возникновении которой следует немедленно завершить работу программы.
 * @since 3.0.0
 */
public class StrictError extends Error {

    /**
     * Сообщение по умолчанию.
     *
     * @since 3.0.0
     */
    public static final @NotNls @Nullable String defaultMessage = null;

    /**
     * Причина по умолчанию.
     *
     * @since 3.0.0
     */
    public static final @Nullable Throwable defaultCause = null;

    /**
     * Параметр подавления по умолчанию.
     *
     * @since 3.0.0
     */
    public static final boolean defaultSuppression = false;

    /**
     * Параметр трассировки стека по умолчанию.
     *
     * @since 3.0.0
     */
    public static final boolean defaultWritable = true;

    /**
     * Инициализирует ошибку по умолчанию.
     *
     * @since 3.0.0
     */
    @Contract
    public StrictError() {
        super(defaultMessage, defaultCause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует ошибку с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract
    public StrictError(final @NotNls @Nullable String message) {
        super(message, defaultCause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует ошибку с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract
    public StrictError(final @Nullable Throwable cause) {
        super(defaultMessage, cause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует ошибку с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract
    public StrictError(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause, defaultSuppression, defaultWritable);
    }

    /**
     * Инициализирует ошибку с переопределённым параметром подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract
    public StrictError(final boolean suppression, final boolean writable) {
        super(defaultMessage, defaultCause, suppression, writable);
    }

    /**
     * Инициализирует ошибку с переопределённым сообщением, причиной, параметром подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract
    protected StrictError(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                          final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
