package com.bloogefest.common.other;

import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;

/**
 * Представление изменяемого.
 */
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public interface Mutable {

    /**
     * @return Параметр изменяемости.
     */
    @Contract(pure = true)
    @AvailableSince("0.3.0")
    default boolean mutable() {
        return true;
    }

}
