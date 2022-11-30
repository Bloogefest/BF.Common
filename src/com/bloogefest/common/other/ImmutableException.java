package com.bloogefest.common.other;

import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Исключение неизменяемого.
 *
 * @author Bloogefest
 * @version 1.0
 * @see Immutable
 * @since 0.3.0
 */
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public class ImmutableException extends SoftException {

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public ImmutableException() {}

    /**
     * Создаёт экземпляр, используя переопределённое сообщение.
     *
     * @param message сообщение.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public ImmutableException(final @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр, используя переопределённую причину.
     *
     * @param cause причина.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public ImmutableException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение и причину.
     *
     * @param message сообщение.
     * @param cause   причина.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public ImmutableException(final @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение, причину, параметр подавления и записи трассировки стека.
     *
     * @param message     сообщение.
     * @param cause       причина.
     * @param suppression параметр подавления.
     * @param writable    параметр записи трассировки стека.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    protected ImmutableException(final @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
