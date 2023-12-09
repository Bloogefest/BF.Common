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
 * Данный класс представляет собой исключение создания объекта класса-утилиты и применяется в некритических ситуациях,
 * не требующих немедленного реагирования. Для этого он расширяет класс исключения создания объекта, а также объявляет и
 * реализует наиболее полезные конструкторы и статические поля.
 *
 * @apiNote Исключение создания объекта класса-утилиты обычно возникает при любой попытке создания объекта
 * класса-утилиты.
 * @since 3.0.0-RC1
 */
public class UtilityException extends CreationException {

    /**
     * Данное неизменяемое статическое поле представляет собой ненулевой объект класса строки и содержит сообщение
     * исключения создания объекта класса-утилиты по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String DEFAULT_MESSAGE = "The utility class object must not be created";

    /**
     * Данное неизменяемое статическое поле представляет собой ненулевой объект класса строки и содержит шаблонное
     * сообщение исключения создания объекта класса-утилиты.
     *
     * @since 4.0.0-RC3
     */
    public static final @NonNull String TEMPLATE_MESSAGE = "%s must not be created";

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе
     * {@linkplain #DEFAULT_MESSAGE сообщения}, {@linkplain #DEFAULT_CAUSE причины},
     * {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @since 3.0.0-RC1
     */
    @Contract(value = "-> new", impact = Contract.Impact.INTERNAL)
    public UtilityException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе переданного сообщения, а также
     * {@linkplain #DEFAULT_CAUSE причины}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     *
     * @since 3.0.0-RC1
     */
    @Contract(value = "? -> new", impact = Contract.Impact.INTERNAL)
    public UtilityException(final @Nullable String message) {
        super(message);
    }

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе переданной причины, а также
     * {@linkplain #DEFAULT_MESSAGE сообщения}, {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param cause причина.
     *
     * @since 3.0.0-RC1
     */
    @Contract(value = "? -> new", impact = Contract.Impact.INTERNAL)
    public UtilityException(final @Nullable Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе переданного сообщения и причины,
     * а также {@linkplain #DEFAULT_SUPPRESSION параметров подавления} и
     * {@linkplain #DEFAULT_WRITABLE трассировки стека по умолчанию}.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 3.0.0-RC1
     */
    @Contract(value = "?, ? -> new", impact = Contract.Impact.INTERNAL)
    public UtilityException(final @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе переданных параметров подавления
     * и трассировки стека, а также {@linkplain #DEFAULT_MESSAGE сообщения} и
     * {@linkplain #DEFAULT_CAUSE причины по умолчанию}.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0-RC1
     */
    @Contract(value = "?, ? -> new", impact = Contract.Impact.INTERNAL)
    public UtilityException(final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, suppression, writable);
    }

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе переданного сообщения, параметров
     * подавления и трассировки стека, а также {@linkplain #DEFAULT_CAUSE причины по умолчанию}.
     *
     * @param message сообщение.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract(value = "?, ?, ? -> new", impact = Contract.Impact.INTERNAL)
    public UtilityException(final @Nullable String message, final boolean suppression, final boolean writable) {
        super(message, suppression, writable);
    }

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе переданной причины, параметров
     * подавления и трассировки стека, а также {@linkplain #DEFAULT_MESSAGE сообщения по умолчанию}.
     *
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract(value = "?, ?, ? -> new", impact = Contract.Impact.INTERNAL)
    public UtilityException(final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(DEFAULT_MESSAGE, cause, suppression, writable);
    }

    /**
     * Данный конструктор создаёт исключение создания объекта класса-утилиты на основе переданного сообщения, причины,
     * параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 3.0.0-RC1
     */
    @Contract(value = "?, ?, ?, ? -> new", impact = Contract.Impact.INTERNAL)
    public UtilityException(final @Nullable String message, final @Nullable Throwable cause, final boolean suppression,
                            final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
