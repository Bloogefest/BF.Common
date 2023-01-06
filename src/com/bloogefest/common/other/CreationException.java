package com.bloogefest.common.other;

import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Тип исключения создания, экземпляр которого не требует обработки.
 */
@AvailableSince("0.0.0")
@SuppressWarnings("unused")
public class CreationException extends SoftException {

    /**
     * Содержит сообщение по умолчанию.
     */
    @AvailableSince("0.0.0")
    protected static final @NonNls @NotNull String defaultMessage = "The instance should not be created";

    /**
     * Создаёт экземпляр по умолчанию.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    public CreationException() {
    }

    /**
     * Создаёт экземпляр с переопределённым сообщением.
     *
     * @param message сообщение.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    public CreationException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр с переопределённой причиной.
     *
     * @param cause причина.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    public CreationException(final @Nullable Throwable cause) {
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
    public CreationException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
    protected CreationException(final @NonNls @Nullable String message, final @Nullable Throwable cause,
                                final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
