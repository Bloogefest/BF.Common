/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.*;
import com.bloogefest.common.SoftException;

/**
 * Исключение функции.
 *
 * @since 1.0.0
 */
public class FunctionException extends SoftException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @Null String DEFAULT_MESSAGE = null;

    /**
     * Шаблонное сообщение.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @Null String TEMPLATE_MESSAGE = null;

    /**
     * Сообщение по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_MESSAGE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.FunctionException.DEFAULT_MESSAGE")
    public static final @NotNls @Null String defaultMessage = DEFAULT_MESSAGE;

    /**
     * Шаблонное сообщение.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #TEMPLATE_MESSAGE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.FunctionException.TEMPLATE_MESSAGE")
    public static final @NotNls @Null String templateMessage = TEMPLATE_MESSAGE;

    /**
     * Создаёт исключение функции на основе {@linkplain #DEFAULT_MESSAGE сообщения},
     * {@linkplain #DEFAULT_CAUSE причины}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 1.0.0
     */
    @Contract("-> new")
    public FunctionException() {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение функции на основе переданного сообщения, {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 1.0.0
     */
    @Contract("_ -> new")
    public FunctionException(final @NotNls @Nullable String message) {
        this(message, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение функции на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract("_ -> new")
    public FunctionException(final @Nullable Throwable cause) {
        this(DEFAULT_MESSAGE, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение функции на основе переданного сообщения и причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract("_, _ -> new")
    public FunctionException(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        this(message, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение функции на основе {@linkplain #DEFAULT_MESSAGE сообщения} и
     * {@linkplain #DEFAULT_CAUSE причины по умолчанию}, переданных параметров подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public FunctionException(final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт исключение функции на основе переданного сообщения, {@linkplain #DEFAULT_CAUSE причины по умолчанию},
     * переданных параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public FunctionException(final @NotNls @Nullable String message, final boolean suppression,
                             final boolean writable) {
        this(message, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт исключение функции на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины,
     * параметров подавления и трассировки стека.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public FunctionException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, cause, suppression, writable);
    }

    /**
     * Создаёт исключение функции на основе переданного сообщения, причины, параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 1.0.0
     */
    @Contract("_, _, _, _ -> new")
    public FunctionException(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                             final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
