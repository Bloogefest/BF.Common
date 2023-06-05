/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common;

import com.bloogefest.annotation.analysis.*;

/**
 * Мягкое исключение.
 *
 * @apiNote Оповещает о несерьёзной проблеме, которую рекомендуется обработать для дальнейшего корректного выполнения
 * программы.
 * @since 3.0.0
 */
public class SoftException extends RuntimeException {

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
    @Obsolete("com.bloogefest.common.SoftException.DEFAULT_CAUSE")
    public static final @Nullable Throwable defaultCause = DEFAULT_CAUSE;

    /**
     * Параметр подавления по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_SUPPRESSION}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.SoftException.DEFAULT_SUPPRESSION")
    public static final boolean defaultSuppression = DEFAULT_SUPPRESSION;

    /**
     * Параметр трассировки стека по умолчанию.
     *
     * @since 3.0.0
     * @deprecated Используйте {@linkplain #DEFAULT_WRITABLE}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.SoftException.DEFAULT_WRITABLE")
    public static final boolean defaultWritable = DEFAULT_WRITABLE;

    /**
     * Создаёт исключение по умолчанию.
     *
     * @since 3.0.0
     */
    @Contract("-> new")
    public SoftException() {
        super(DEFAULT_MESSAGE, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение на основе сообщения.
     *
     * @param message сообщение.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public SoftException(final @NotNls @Nullable String message) {
        super(message, DEFAULT_CAUSE, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
    }

    /**
     * Создаёт исключение на основе причины.
     *
     * @param cause причина.
     *
     * @since 3.0.0
     */
    @Contract("_ -> new")
    public SoftException(final @Nullable Throwable cause) {
        super(DEFAULT_MESSAGE, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
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
    public SoftException(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause, DEFAULT_SUPPRESSION, DEFAULT_WRITABLE);
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
    public SoftException(final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, DEFAULT_CAUSE, suppression, writable);
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
    @Contract("_, _, _ -> new")
    public SoftException(final @NotNls @Nullable String message, final boolean suppression, final boolean writable) {
        super(message, DEFAULT_CAUSE, suppression, writable);
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
    @Contract("_, _, _ -> new")
    public SoftException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, cause, suppression, writable);
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
    protected SoftException(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                            final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
