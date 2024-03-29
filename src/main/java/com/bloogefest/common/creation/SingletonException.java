/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.creation;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.NonNull;
import com.bloogefest.annotation.Nullable;

/**
 * Исключение создания экземпляра класса-одиночки. Возникает при попытке создания второго экземпляра класса-одиночки.
 *
 * @since 3.0.0
 */
public class SingletonException extends CreationException {

    /**
     * Содержит сообщение этого исключения по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String DEFAULT_MESSAGE = "Only one instance of the singleton class can be created";

    /**
     * Содержит шаблонное сообщение этого исключения.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String TEMPLATE_MESSAGE = "Only one instance of %s can be created";

    /**
     * Создаёт экземпляр этого исключения на основе {@linkplain #DEFAULT_MESSAGE сообщения},
     * {@linkplain #DEFAULT_CAUSE причины}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 3.0.0
     */
    @Contract(value = "-> new", impact = Contract.Impact.INTERNAL)
    public SingletonException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданного сообщения, а также {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract(value = "? -> new", impact = Contract.Impact.INTERNAL)
    public SingletonException(final @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданной причины, а также {@linkplain #DEFAULT_MESSAGE сообщения},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract(value = "? -> new", impact = Contract.Impact.INTERNAL)
    public SingletonException(final @Nullable Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданных сообщения и причины, а также
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract(value = "?, ? -> new", impact = Contract.Impact.INTERNAL)
    public SingletonException(final @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданных параметров подавления и трассировки стека, а также
     * {@linkplain #DEFAULT_MESSAGE сообщения} и {@linkplain #DEFAULT_CAUSE причины по умолчанию}.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract(value = "?, ? -> new", impact = Contract.Impact.INTERNAL)
    public SingletonException(final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, suppression, writable);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданных сообщения, параметров подавления и трассировки стека, а
     * также {@linkplain #DEFAULT_CAUSE причины по умолчанию}.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract(value = "?, ?, ? -> new", impact = Contract.Impact.INTERNAL)
    public SingletonException(final @Nullable String message, final boolean suppression, final boolean writable) {
        super(message, suppression, writable);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданных причины, параметров подавления и трассировки стека, а
     * также {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract(value = "?, ?, ? -> new", impact = Contract.Impact.INTERNAL)
    public SingletonException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, cause, suppression, writable);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданных сообщения, причины, параметров подавления и трассировки
     * стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract(value = "?, ?, ?, ? -> new", impact = Contract.Impact.INTERNAL)
    public SingletonException(final @Nullable String message, final @Nullable Throwable cause,
                              final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
