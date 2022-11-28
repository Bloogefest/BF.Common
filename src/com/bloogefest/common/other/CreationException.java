package com.bloogefest.common.other;

import org.jetbrains.annotations.*;

/**
 * Является исключением создания.
 *
 * @author Bloogefest
 * @version 1.0
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@ApiStatus.AvailableSince("0.0.0")
public class CreationException extends SoftException {

    /**
     * Содержит сообщение по умолчанию.
     *
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    protected static final @NonNls @NotNull String defaultMessage = "The instance should not be created";

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(pure = true)
    public CreationException() {
        this(defaultMessage);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение.
     *
     * @param message сообщение.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.0.0")
    public CreationException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр, используя переопределённую причину.
     *
     * @param cause причина.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.0.0")
    public CreationException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение и причину.
     *
     * @param message сообщение.
     * @param cause   причина.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.0.0")
    public CreationException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
     * @since 0.0.0
     */
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.0.0")
    protected CreationException(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
