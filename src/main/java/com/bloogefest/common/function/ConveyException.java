/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNls;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;

/**
 * Исключение передачи объекта.
 *
 * @since 4.0.0-RC3
 */
public class ConveyException extends FunctionException {

    /**
     * Сообщение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @NotNull String DEFAULT_MESSAGE = "Failed to convey the object";

    /**
     * Шаблонное сообщение.
     *
     * @since 4.0.0-RC3
     */
    public static final @NotNls @NotNull String TEMPLATE_MESSAGE = "Failed to convey the %s";

    /**
     * Создаёт исключение по умолчанию.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    public ConveyException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Создаёт исключение на основе сообщения.
     *
     * @param message сообщение.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    public ConveyException(final @NotNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт исключение на основе причины.
     *
     * @param cause причина.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    public ConveyException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт исключение на основе сообщения и причины.
     *
     * @param message сообщение.
     * @param cause причина.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    public ConveyException(final @NotNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт исключение на основе параметров подавления и трассировки стека.
     *
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    public ConveyException(final boolean suppression, final boolean writable) {
        super(suppression, writable);
    }

    /**
     * Создаёт исключение на основе сообщения, причины, параметров подавления и трассировки стека.
     *
     * @param message сообщение.
     * @param cause причина.
     * @param suppression параметр подавления.
     * @param writable параметр трассировки стека.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    protected ConveyException(final @NotNls @Nullable String message, final @Nullable Throwable cause,
                              final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
