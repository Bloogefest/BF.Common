/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNls;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;

/**
 * Исключение валидации нулевого объекта.
 *
 * @since 1.0.0
 */
public class NullException extends ValidationException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 1.0.0
     */
    public static final @NotNls @NotNull String defaultMessage = "The object must not be null";

    /**
     * Шаблонное сообщение.
     *
     * @since 2.0.0
     */
    public static final @NotNls @NotNull String templateMessage = "%s must not be null";

    /**
     * Инициализирует исключение по умолчанию.
     *
     * @since 1.0.0
     */
    @Contract
    public NullException() {
        super(defaultMessage);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 1.0.0
     */
    @Contract
    public NullException(final @NotNls @Nullable String message) {
        super(message);
    }

    /**
     * Инициализирует исключение с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract
    public NullException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract
    public NullException(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Инициализирует исключение с переопределённым параметром подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract
    public NullException(final boolean suppression, final boolean writable) {
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
     * @since 1.0.0
     */
    @Contract
    protected NullException(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                            final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
