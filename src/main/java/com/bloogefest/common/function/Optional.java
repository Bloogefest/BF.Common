/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Обёртка обнуляемого объекта.
 *
 * @param <T> тип объекта.
 *
 * @apiNote Эта обёртка позволяет безопасно работать с обнуляемыми объектами.
 * @since 4.0.0
 */
@FunctionalInterface
public interface Optional<T> {

    /**
     * Возвращает обнуляемый объект из-под этой обёртки.
     *
     * @return Обнуляемый объект из-под этой обёртки.
     *
     * @since 4.0.0
     */
    @Contract
    @Nullable T nullable();

}
