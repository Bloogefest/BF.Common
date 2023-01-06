package com.bloogefest.common.other;

import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Тип исключения, экземпляр которого требует обработки.
 */
@AvailableSince("0.0.0")
@SuppressWarnings("unused")
public class StrictException extends Exception {

    /**
     * Содержит сообщение по умолчанию.
     */
    @AvailableSince("0.0.0")
    protected static final @NonNls @NotNull String defaultMessage = "Not specified";

    /**
     * Содержит причину по умолчанию.
     */
    @AvailableSince("0.0.0")
    protected static final @Nullable Throwable defaultCause = null;

    /**
     * Содержит параметр подавления по умолчанию.
     */
    @AvailableSince("0.0.0")
    protected static final boolean defaultSuppression = false;

    /**
     * Содержит параметр трассировки стека по умолчанию.
     */
    @AvailableSince("0.0.0")
    protected static final boolean defaultWritable = true;

    /**
     * Создаёт экземпляр по умолчанию.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    public StrictException() {
        super(defaultMessage);
    }

    /**
     * Создаёт экземпляр с переопределённым сообщением.
     *
     * @param message сообщение.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    public StrictException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр с переопределённой причиной.
     *
     * @param cause причина.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    public StrictException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр с переопределённым сообщением и причиной.
     *
     * @param message сообщение.
     * @param cause   причина.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    public StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр с переопределённым сообщением, причиной, параметром подавления и трассировки стека.
     *
     * @param message     сообщение.
     * @param cause       причина.
     * @param suppression параметр подавления.
     * @param writable    параметр трассировки стека.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    protected StrictException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                              final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
