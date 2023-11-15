/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.Nullable;

/**
 * Строгое исключение.
 *
 * @apiNote Оповещает о несерьёзной проблеме, которую рекомендуется обработать для дальнейшего корректного выполнения
 * программы.
 * @since 3.0.0
 */
public class StrictException extends Exception {

    /**
     * Сообщение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @Nullable String DEFAULT_MESSAGE = null;

    /**
     * Причина по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @Nullable Throwable DEFAULT_CAUSE = null;

    /**
     * Параметр подавления по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final boolean DEFAULT_SUPPRESSION = false;

    /**
     * Параметр трассировки стека по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final boolean DEFAULT_WRITABLE = true;

    /**
     * Создаёт строгое исключение на основе {@linkplain #DEFAULT_MESSAGE сообщения},
     * {@linkplain #DEFAULT_CAUSE причины}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 3.0.0
     */
    @Contract("-> new")
    public StrictException() {
        super(DEFAULT_MESSAGE, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт строгое исключение на основе переданного сообщения, {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public StrictException(final @Nullable String message) {
        super(message, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт строгое исключение на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public StrictException(final @Nullable Throwable cause) {
        super(DEFAULT_MESSAGE, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт строгое исключение на основе переданного сообщения и причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public StrictException(final @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт строгое исключение на основе {@linkplain #DEFAULT_MESSAGE сообщения} и
     * {@linkplain #DEFAULT_CAUSE причины по умолчанию}, переданных параметров подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public StrictException(final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт строгое исключение на основе переданного сообщения, {@linkplain #DEFAULT_CAUSE причины по умолчанию},
     * переданных параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public StrictException(final @Nullable String message, final boolean suppression, final boolean writable) {
        super(message, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт строгое исключение на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины,
     * параметров подавления и трассировки стека.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public StrictException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, cause, suppression, writable);
    }

    /**
     * Создаёт строгое исключение на основе переданного сообщения, причины, параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _, _, _ -> new")
    public StrictException(final @Nullable String message, final @Nullable Throwable cause, final boolean suppression,
                           final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
