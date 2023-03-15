/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Исключение валидации неравенства первичного и вторичного объекта.
 *
 * @since 1.0.0
 */
public class EqualException extends ValidationException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 1.0.0
     */
    public static final @NonNls @NotNull String defaultMessage = "The primary object must not be equal to the secondary object";

    /**
     * Шаблонное сообщение.
     *
     * @since 2.0.0
     */
    public static final @NonNls @NotNull String templateMessage = "The %s must not be equal to the %s";

    /**
     * Инициализирует исключение по умолчанию.
     *
     * @since 1.0.0
     */
    @Contract(pure = true)
    public EqualException() {
        super(defaultMessage);
    }

    /**
     * Инициализирует исключение с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 1.0.0
     */
    @Contract(pure = true)
    public EqualException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Инициализирует исключение с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract(pure = true)
    public EqualException(final @Nullable Throwable cause) {
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
    @Contract(pure = true)
    public EqualException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
    @Contract(pure = true)
    public EqualException(final boolean suppression, final boolean writable) {
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
    @Contract(pure = true)
    protected EqualException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                             final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
