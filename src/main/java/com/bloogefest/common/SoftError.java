/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common;

import com.bloogefest.annotation.*;

/**
 * Мягкая ошибка.
 *
 * @apiNote Оповещает о критической проблеме, при возникновении которой рекомендуется завершить работу программы.
 * @since 3.0.0
 */
public class SoftError extends Error {

    /**
     * Сообщение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @Nullable String DEFAULT_MESSAGE = null;

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
     * Сообщение по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_MESSAGE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.SoftError.DEFAULT_MESSAGE")
    public static final @NotNls @Nullable String defaultMessage = DEFAULT_MESSAGE;

    /**
     * Причина по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_CAUSE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.SoftError.DEFAULT_CAUSE")
    public static final @Nullable Throwable defaultCause = DEFAULT_CAUSE;

    /**
     * Параметр подавления по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_SUPPRESSION}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.SoftError.DEFAULT_SUPPRESSION")
    public static final boolean defaultSuppression = DEFAULT_SUPPRESSION;

    /**
     * Параметр трассировки стека по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_WRITABLE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.SoftError.DEFAULT_WRITABLE")
    public static final boolean defaultWritable = DEFAULT_WRITABLE;

    /**
     * Создаёт мягкую ошибку на основе {@linkplain #DEFAULT_MESSAGE сообщения}, {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 3.0.0
     */
    @Contract("-> new")
    public SoftError() {
        super(DEFAULT_MESSAGE, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт мягкую ошибку на основе переданного сообщения, {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public SoftError(final @NotNls @Nullable String message) {
        super(message, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт мягкую ошибку на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public SoftError(final @Nullable Throwable cause) {
        super(DEFAULT_MESSAGE, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт мягкую ошибку на основе переданного сообщения и причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public SoftError(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт мягкую ошибку на основе {@linkplain #DEFAULT_MESSAGE сообщения} и
     * {@linkplain #DEFAULT_CAUSE причины по умолчанию}, переданных параметров подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public SoftError(final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт мягкую ошибку на основе переданного сообщения, {@linkplain #DEFAULT_CAUSE причины по умолчанию},
     * переданных параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public SoftError(final @NotNls @Nullable String message, final boolean suppression, final boolean writable) {
        super(message, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт мягкую ошибку на основе {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины,
     * параметров подавления и трассировки стека.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public SoftError(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, cause, suppression, writable);
    }

    /**
     * Создаёт мягкую ошибку на основе переданного сообщения, причины, параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _, _, _ -> new")
    public SoftError(final @NotNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression,
                     final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
