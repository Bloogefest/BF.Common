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
 * Тип мягкой ошибки, экземпляр которой не требует обязательной обработки.
 */
public class SoftError extends Error {

    /**
     * Содержит сообщение по умолчанию.
     */
    protected static final @NonNls @Nullable String defaultMessage = null;

    /**
     * Содержит причину по умолчанию.
     */
    protected static final @Nullable Throwable defaultCause = null;

    /**
     * Содержит параметр подавления по умолчанию.
     */
    protected static final boolean defaultSuppression = false;

    /**
     * Содержит параметр трассировки стека по умолчанию.
     */
    protected static final boolean defaultWritable = true;

    /**
     * Инициализирует экземпляр по умолчанию.
     */
    @Contract(pure = true)
    public SoftError() {
        super();
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением.
     *
     * @param message сообщение.
     */
    @Contract(pure = true)
    public SoftError(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Инициализирует экземпляр с переопределённой причиной.
     *
     * @param cause причина.
     */
    @Contract(pure = true)
    public SoftError(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     */
    @Contract(pure = true)
    public SoftError(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Инициализирует экземпляр с переопределённым сообщением, причиной, параметром подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     */
    @Contract(pure = true)
    protected SoftError(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                        final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
