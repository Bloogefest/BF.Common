package com.bloogefest.common.environment;

import com.bloogefest.common.other.SoftException;
import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Инструмент-исключение среды выполнения.
 *
 * @author Bloogefest
 * @version 1.0
 * @since 0.3.0
 */
@Experimental
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public class EnvironmentException extends SoftException {

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException() {}

    /**
     * Создаёт экземпляр, используя переданное сообщение возникновения.
     *
     * @param message сообщение возникновения.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException(final @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр, используя переданную причину возникновения.
     *
     * @param cause причина возникновения.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр, используя переданное сообщение и причину возникновения.
     *
     * @param message сообщение возникновения.
     * @param cause   причина возникновения.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    public EnvironmentException(final @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр, используя переданное сообщение и причину возникновения, разрешение на запись подавленных исключений и трассировки стека.
     *
     * @param message     сообщение возникновения.
     * @param cause       причина возникновения.
     * @param suppression разрешение на запись подавленных исключений.
     * @param writable    разрешение на запись трассировки стека.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    protected EnvironmentException(final @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
