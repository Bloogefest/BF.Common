package com.bloogefest.common.other;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

/**
 * Является неизменяемым.
 *
 * @author Bloogefest
 * @version 1.0
 * @see ImmutableException
 * @since 0.3.0
 */
@SuppressWarnings("unused")
@ApiStatus.AvailableSince("0.3.0")
public interface Immutable {

    /**
     * @return Является ли изменяемым.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.3.0")
    default boolean mutable() {
        return false;
    }

}
