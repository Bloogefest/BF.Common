package com.bloogefest.common.other;

import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;

/**
 * Неизменяемое.
 *
 * @author Bloogefest
 * @version 1.0
 * @see ImmutableException
 * @since 0.3.0
 */
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public interface Immutable {

    /**
     * @return Является ли изменяемым.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    default boolean mutable() {
        return false;
    }

}
