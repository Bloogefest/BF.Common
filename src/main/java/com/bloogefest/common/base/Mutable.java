/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.base;

import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;

/**
 * Представление изменяемого.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public interface Mutable {

    /**
     * @return Параметр изменяемости.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    default boolean mutable() {
        return true;
    }

}
