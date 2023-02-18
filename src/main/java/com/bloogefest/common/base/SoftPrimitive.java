/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Мягкий тип обёртки примитива.
 *
 * @since 0.3.0
 */
public interface SoftPrimitive<J> {

    /**
     * @return Экземпляр родной обёртки примитива.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    @NotNull J toJava();

}
