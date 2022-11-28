package com.bloogefest.common.other;

import org.jetbrains.annotations.*;

/**
 * Является строгим исключением.
 *
 * @author Bloogefest
 * @version 1.0
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@ApiStatus.AvailableSince("0.0.0")
public class StrictException extends Exception {

    /**
     * Содержит сообщение по умолчанию.
     *
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    protected static final @NonNls @NotNull String defaultMessage = "Not specified";

    /**
     * Содержит причину по умолчанию.
     *
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    protected static final @Nullable Throwable defaultCause = null;

    /**
     * Содержит параметр подавления по умолчанию.
     *
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    protected static final boolean defaultSuppression = false;

    /**
     * Содержит параметр записи трассировки стека по умолчанию.
     *
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    protected static final boolean defaultWritable = true;

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.0.0")
    public StrictException() {
        super(defaultMessage);
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
    public StrictException(final @NonNls @Nullable String message) {
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
    public StrictException(final @Nullable Throwable cause) {
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
    public StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
    protected StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
