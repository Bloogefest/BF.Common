package com.bloogefest.common.function;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Является мягким исключением функционального интерфейса обратного вызова.
 *
 * @author Bloogefest
 * @version 1.0
 * @apiNote Не рекомендуется для обязательного перехвата и обработки.
 * @see Callback
 * @since 0.2.0
 */
@ApiStatus.AvailableSince("0.2.0")
@SuppressWarnings("unused")
public class CallbackException extends FunctionException {

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public CallbackException() {}

    /**
     * Создаёт экземпляр, используя переопределённое сообщение.
     *
     * @param message сообщение.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public CallbackException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр, используя переопределённую причину.
     *
     * @param cause причина.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public CallbackException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение и причину.
     *
     * @param message сообщение.
     * @param cause   причина.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    public CallbackException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    protected CallbackException(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
