/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.NonNull;
import com.bloogefest.annotation.Nullable;

/**
 * Исключение вычисления функции.
 *
 * @since 3.0.0
 */
public class ComputeException extends FunctionException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String DEFAULT_MESSAGE = "Failed to compute the function";

    /**
     * Шаблонное сообщение.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String TEMPLATE_MESSAGE = "Failed to compute %s";

    /**
     * Создаёт исключение вычисления функции на основе {@linkplain #DEFAULT_MESSAGE сообщения},
     * {@linkplain #DEFAULT_CAUSE причины}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 3.0.0
     */
    @Contract("-> new")
    public ComputeException() {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение вычисления функции на основе переданного сообщения, {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public ComputeException(final @Nullable String message) {
        this(message, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение вычисления функции на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной
     * причины, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public ComputeException(final @Nullable Throwable cause) {
        this(DEFAULT_MESSAGE, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение вычисления функции на основе переданного сообщения и причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public ComputeException(final @Nullable String message, final @Nullable Throwable cause) {
        this(message, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение вычисления функции на основе {@linkplain #DEFAULT_MESSAGE сообщения} и
     * {@linkplain #DEFAULT_CAUSE причины по умолчанию}, переданных параметров подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public ComputeException(final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт исключение вычисления функции на основе переданного сообщения,
     * {@linkplain #DEFAULT_CAUSE причины по умолчанию}, переданных параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public ComputeException(final @Nullable String message, final boolean suppression, final boolean writable) {
        this(message, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт исключение вычисления функции на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной
     * причины, параметров подавления и трассировки стека.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public ComputeException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, cause, suppression, writable);
    }

    /**
     * Создаёт исключение вычисления функции на основе переданного сообщения, причины, параметров подавления и
     * трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _, _, _ -> new")
    public ComputeException(final @Nullable String message, final @Nullable Throwable cause, final boolean suppression,
                            final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
