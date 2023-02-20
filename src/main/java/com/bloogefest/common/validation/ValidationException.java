/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.common.base.SoftException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Класс исключения валидации экземпляра.
 *
 * @since 0.0
 */
public class ValidationException extends SoftException {

    /**
     * Инициализирует экземпляр по умолчанию.
     *
     * @since 0.0
     */
    @Contract(pure = true)
    public ValidationException() {
        super();
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением.
     *
     * @param message сообщение.
     *
     * @since 0.0
     */
    @Contract(pure = true)
    public ValidationException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Инициализирует экземпляр с переопределённой причиной.
     *
     * @param cause причина.
     *
     * @since 0.0
     */
    @Contract(pure = true)
    public ValidationException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 0.0
     */
    @Contract(pure = true)
    public ValidationException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Инициализирует экземпляр с переопределённым параметром подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0
     */
    @Contract(pure = true)
    public ValidationException(final boolean suppression, final boolean writable) {
        super(suppression, writable);
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением, причиной, параметром подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 0.0
     */
    @Contract(pure = true)
    protected ValidationException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                                  final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
