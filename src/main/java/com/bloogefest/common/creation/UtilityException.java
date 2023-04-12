/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.creation;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNls;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;

/**
 * Исключение создания объекта утилитарного типа.
 *
 * @since 3.0.0
 */
public class UtilityException extends CreationException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 3.0.0
     */
    public static final @NotNls @NotNull String defaultMessage = "The utility object must not be created";

    /**
     * Шаблонное сообщение.
     *
     * @since 3.0.0
     */
    public static final @NotNls @NotNull String templateMessage = "The %s must not be created";

    /**
     * Инициализирует исключение по умолчанию.
     *
     * @since 3.0.0
     */
    @Contract
    public UtilityException() {
        super(defaultMessage);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract
    public UtilityException(final @NotNls @Nullable String message) {
        super(message);
    }

    /**
     * Инициализирует исключение с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract
    public UtilityException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract
    public UtilityException(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
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
     * @since 3.0.0
     */
    @Contract
    protected UtilityException(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                               final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
