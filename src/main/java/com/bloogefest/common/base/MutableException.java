/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Тип исключения изменяемого, экземпляр которого не требует обработки.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public class MutableException extends SoftException {

    /**
     * Создаёт экземпляр по умолчанию.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    public MutableException() {
    }

    /**
     * Создаёт экземпляр с переопределённым сообщением.
     *
     * @param message сообщение.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    public MutableException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр с переопределённой причиной.
     *
     * @param cause причина.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    public MutableException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause причина.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    public MutableException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр с переопределённым сообщением, причиной, параметром подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    protected MutableException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                               final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
