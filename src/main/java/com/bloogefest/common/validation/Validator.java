/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.validation;

import com.bloogefest.common.creation.UtilityException;
import org.jetbrains.annotations.Contract;

/**
 * Утилитарный тип валидатора условия.
 */
public final class Validator {

    /**
     * Запрещает инициализацию экземпляра.
     *
     * @throws UtilityException экземпляр утилитарного типа не должен быть создан.
     */
    @Contract(value = "-> fail", pure = true)
    private Validator() throws UtilityException {
        throw new UtilityException();
    }

    public static <T, E> T notNull(T o, Object... ignored) {
        return o;
    }

}
