/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.environment;

import com.bloogefest.common.base.SoftException;
import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Инструмент-исключение среды выполнения.
 *
 * @version 1.0
 * @since 0.3.0
 */
@Experimental
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public class EnvironmentException extends SoftException {

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException() {
    }

    /**
     * Создаёт экземпляр, используя переданное сообщение возникновения.
     *
     * @param message сообщение возникновения.
     *
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException(final @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр, используя переданную причину возникновения.
     *
     * @param cause причина возникновения.
     *
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр, используя переданное сообщение и причину возникновения.
     *
     * @param message сообщение возникновения.
     * @param cause причина возникновения.
     *
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException(final @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр, используя переданное сообщение и причину возникновения, разрешение на запись подавленных исключений и трассировки стека.
     *
     * @param message сообщение возникновения.
     * @param cause причина возникновения.
     * @param suppression разрешение на запись подавленных исключений.
     * @param writable разрешение на запись трассировки стека.
     *
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    protected EnvironmentException(final @Nullable String message, final @Nullable Throwable cause,
                                   final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
