package com.bloogefest.common.other;

import org.jetbrains.annotations.*;

/**
 * Является строгой ошибкой.
 *
 * @author Bloogefest
 * @version 1.0
 * @apiNote Не рекомендуется для перехвата и обработки.
 * @since 0.0.0
 */
@ApiStatus.AvailableSince("0.0.0")
@SuppressWarnings("unused")
public class StrictError extends Error {

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
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(pure = true)
    public StrictError() {
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
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(pure = true)
    public StrictError(final @NonNls @Nullable String message) {
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
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(pure = true)
    public StrictError(final @Nullable Throwable cause) {
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
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(pure = true)
    public StrictError(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(pure = true)
    protected StrictError(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
