/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.NonNull;
import com.bloogefest.annotation.Nullable;

/**
 * Исключение валидации нулевого экземпляра класса. Возникает при попытке валидации нулевого экземпляра класса.
 *
 * @since 1.0.0
 */
public class NullException extends ValidationException {

    /**
     * Содержит сообщение этого исключения по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String DEFAULT_MESSAGE = "The instance of the class mustn't be null";

    /**
     * Содержит шаблонное сообщение этого исключения.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String TEMPLATE_MESSAGE = "%s mustn't be null";

    /**
     * Создаёт экземпляр этого исключения на основе {@linkplain #DEFAULT_MESSAGE сообщения},
     * {@linkplain #DEFAULT_CAUSE причины}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 1.0.0
     */
    @Contract(value = "-> new", impact = Contract.Impact.INTERNAL)
    public NullException() {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданного сообщения, а также {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 1.0.0
     */
    @Contract(value = "? -> new", impact = Contract.Impact.INTERNAL)
    public NullException(final @Nullable String message) {
        this(message, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданной причины, а также {@linkplain #DEFAULT_MESSAGE сообщения},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract(value = "? -> new", impact = Contract.Impact.INTERNAL)
    public NullException(final @Nullable Throwable cause) {
        this(DEFAULT_MESSAGE, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт экземпляр этого исключения на основе переданных сообщения и причины, а также
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract(value = "?, ? -> new", impact = Contract.Impact.INTERNAL)
    public NullException(final @Nullable String message, final @Nullable Throwable cause) {
        this(message, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
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
    public NullException(final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, suppression, writable);
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
    public NullException(final @Nullable String message, final boolean suppression, final boolean writable) {
        this(message, DEFAULT_CAUSE, suppression, writable);
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
    public NullException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, cause, suppression, writable);
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
     * @since 1.0.0
     */
    @Contract(value = "?, ?, ?, ? -> new", impact = Contract.Impact.INTERNAL)
    public NullException(final @Nullable String message, final @Nullable Throwable cause, final boolean suppression,
                         final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
