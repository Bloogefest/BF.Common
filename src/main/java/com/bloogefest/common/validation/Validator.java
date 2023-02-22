/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.common.creation.UtilityException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Утилитарный класс валидатора экземпляров.
 *
 * @since 1.0
 */
public final class Validator {

    /**
     * Генерирует исключение.
     *
     * @throws UtilityException исключение создания экземпляра утилитарного типа.
     * @since 1.0
     */
    @Contract(value = "-> fail", pure = true)
    private Validator() throws UtilityException {
        throw new UtilityException();
    }

    /**
     * @since 1.0
     */
    public static <T, E> @NotNull T notNull(@Nullable T o, @NotNull Object... ignored) {
        if (o == null) throw new NullException();
        return o;
    }

}
