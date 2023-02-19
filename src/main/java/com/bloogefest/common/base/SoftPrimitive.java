/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Интерфейс мягкой обёртки примитива.
 *
 * @since 0.3.0
 */
@Experimental
public interface SoftPrimitive<J> {

    /**
     * @return Экземпляр родной обёртки примитива.
     *
     * @since 0.3.0
     */
    @Contract(pure = true)
    @NotNull J toJava();

}
