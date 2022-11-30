package com.bloogefest.common.environment;

import com.bloogefest.common.other.SoftException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Исключение среды выполнения.
 *
 * @author Bloogefest
 * @version 1.0
 * @since 0.3.0
 */
@ApiStatus.Experimental
@SuppressWarnings("unused")
@ApiStatus.AvailableSince("0.3.0")
public class EnvironmentException extends SoftException {

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @ApiStatus.Experimental
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.3.0")
    public EnvironmentException() {}

    /**
     * Создаёт экземпляр, используя переопределённое сообщение.
     *
     * @param message сообщение.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @ApiStatus.Experimental
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.3.0")
    public EnvironmentException(final @Nullable String message) {
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
    @ApiStatus.Experimental
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.3.0")
    public EnvironmentException(final @Nullable Throwable cause) {
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
    @ApiStatus.Experimental
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.3.0")
    public EnvironmentException(final @Nullable String message, final @Nullable Throwable cause) {
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
    @ApiStatus.Experimental
    @Contract(pure = true)
    @ApiStatus.AvailableSince("0.3.0")
    protected EnvironmentException(final @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
