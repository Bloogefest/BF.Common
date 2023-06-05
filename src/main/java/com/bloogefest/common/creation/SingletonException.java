/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.creation;

import com.bloogefest.annotation.analysis.*;

/**
 * Исключение создания объекта одиночного типа.
 *
 * @since 3.0.0
 */
public class SingletonException extends CreationException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @NotNull String DEFAULT_MESSAGE = "The singleton object has already been created";

    /**
     * Шаблонное сообщение.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @NotNull String TEMPLATE_MESSAGE = "The %s has already been created";

    /**
     * Сообщение по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_MESSAGE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.CreationException.DEFAULT_MESSAGE")
    public static final @NotNls @NotNull String defaultMessage = DEFAULT_MESSAGE;

    /**
     * Шаблонное сообщение.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #TEMPLATE_MESSAGE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.CreationException.TEMPLATE_MESSAGE")
    public static final @NotNls @NotNull String templateMessage = TEMPLATE_MESSAGE;

    /**
     * Создаёт исключение по умолчанию.
     *
     * @since 3.0.0
     */
    @Contract("-> new")
    public SingletonException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Создаёт исключение на основе сообщения.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public SingletonException(final @NotNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт исключение на основе причины.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public SingletonException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт исключение на основе сообщения и причины.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public SingletonException(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт исключение на основе параметров подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public SingletonException(final boolean suppression, final boolean writable) {
        super(suppression, writable);
    }

    /**
     * Создаёт исключение на основе сообщения, параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    public SingletonException(final String message, final boolean suppression, final boolean writable) {
        super(message, suppression, writable);
    }

    /**
     * Создаёт исключение на основе причины, параметров подавления и трассировки стека.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    public SingletonException(final Throwable cause, final boolean suppression, final boolean writable) {
        super(cause, suppression, writable);
    }

    /**
     * Создаёт исключение на основе сообщения, причины, параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _, _, _ -> new")
    protected SingletonException(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                                 final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
