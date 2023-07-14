/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.annotation.*;

/**
 * Исключение валидации равенства первичного и вторичного объекта.
 *
 * @since 1.0.0
 */
public class NotEqualException extends ValidationException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @NotNull String DEFAULT_MESSAGE = "The primary object must be equal to the secondary object";

    /**
     * Шаблонное сообщение.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @NotNull String TEMPLATE_MESSAGE = "%s must be equal to the %s";

    /**
     * Сообщение по умолчанию.
     *
     * @since 1.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_MESSAGE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.validation.NotEqualException.DEFAULT_MESSAGE")
    public static final @NotNls @NotNull String defaultMessage = DEFAULT_MESSAGE;

    /**
     * Шаблонное сообщение.
     *
     * @since 2.0.0
     * @deprecated Используйте {@linkplain #TEMPLATE_MESSAGE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.validation.NotEqualException.TEMPLATE_MESSAGE")
    public static final @NotNls @NotNull String templateMessage = TEMPLATE_MESSAGE;

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе
     * {@linkplain #DEFAULT_MESSAGE сообщения}, {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 1.0.0
     */
    @Contract("-> new")
    public NotEqualException() {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе переданного сообщения,
     * {@linkplain #DEFAULT_CAUSE причины}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 1.0.0
     */
    @Contract("_ -> new")
    public NotEqualException(final @NotNls @Nullable String message) {
        this(message, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе
     * {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract("_ -> new")
    public NotEqualException(final @Nullable Throwable cause) {
        this(DEFAULT_MESSAGE, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе переданного сообщения и причины,
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 1.0.0
     */
    @Contract("_, _ -> new")
    public NotEqualException(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        this(message, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе
     * {@linkplain #DEFAULT_MESSAGE сообщения} и {@linkplain #DEFAULT_CAUSE причины по умолчанию}, переданных параметров
     * подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0
     */
    @Contract("_, _ -> new")
    public NotEqualException(final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе переданного сообщения,
     * {@linkplain #DEFAULT_CAUSE причины по умолчанию}, переданных параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public NotEqualException(final @NotNls @Nullable String message, final boolean suppression,
                             final boolean writable) {
        this(message, DEFAULT_CAUSE, suppression, writable);
    }

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе
     * {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}, переданной причины, параметров подавления и трассировки
     * стека.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    public NotEqualException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        this(DEFAULT_MESSAGE, cause, suppression, writable);
    }

    /**
     * Создаёт исключение валидации равенства первичного и вторичного объекта на основе переданного сообщения, причины,
     * параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 1.0.0
     */
    @Contract("_, _, _, _ -> new")
    public NotEqualException(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                             final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
