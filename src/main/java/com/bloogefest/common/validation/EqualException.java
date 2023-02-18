/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import org.jetbrains.annotations.*;

/**
 * Является мягким исключением валидации явления неравенства первичного типизированного экземпляра со вторичным.
 *
 * @version 1.0
 * @apiNote Не рекомендуется для обязательного перехвата и обработки.
 * @see Validator#notEquals(Object instance, Object instance_)
 * @see Validator#notEquals(Object instance, Object instance_, String name, String name_)
 * @since 0.1.0
 */
@ApiStatus.AvailableSince("0.1.0")
@SuppressWarnings("unused")
public class EqualException extends ValidationException {

    /**
     * Содержит сообщение по умолчанию.
     *
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    protected static final @NonNls @NotNull String defaultMessage = "The primary instance should not be equal to the secondary";

    /**
     * Содержит шаблонное сообщение.
     *
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    protected static final @NonNls @NotNull String templateMessage = "The %s should not be equal to the %s";

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public EqualException() {
        this(defaultMessage);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение.
     *
     * @param message сообщение.
     *
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public EqualException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр, используя переопределённую причину.
     *
     * @param cause причина.
     *
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public EqualException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение и причину.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public EqualException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение, причину, параметр подавления и записи трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр записи трассировки стека.
     *
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    protected EqualException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                             final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}