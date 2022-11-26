package com.bloogefest.common.function;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Является мягким исключением функционального интерфейса предиката типизированного экземпляра.
 *
 * @author Bloogefest
 * @version 1.0
 * @apiNote Не рекомендуется для обязательного перехвата и обработки.
 * @see Predicate
 * @since 0.1.0
 */
@ApiStatus.AvailableSince("0.1.0")
@SuppressWarnings("unused")
public class PredicateException extends FunctionException {

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public PredicateException() {}

    /**
     * Создаёт экземпляр, используя переопределённое сообщение.
     *
     * @param message сообщение.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public PredicateException(final @NonNls @Nullable String message) {
        super(message);
    }

    /**
     * Создаёт экземпляр, используя переопределённую причину.
     *
     * @param cause причина.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public PredicateException(final @Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение и причину.
     *
     * @param message сообщение.
     * @param cause   причина.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public PredicateException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    protected PredicateException(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
