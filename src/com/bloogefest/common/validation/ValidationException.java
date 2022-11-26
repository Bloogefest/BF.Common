package com.bloogefest.common.validation;

import com.bloogefest.common.other.SoftException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Является мягким исключением валидации явления типизированного экземпляра.
 *
 * @author Bloogefest
 * @version 1.0
 * @apiNote Не рекомендуется для обязательного перехвата и обработки.
 * @see Validator
 * @see NotNullException
 * @see NullException
 * @see NotEqualException
 * @see EqualException
 * @since 0.0.0
 */
@ApiStatus.AvailableSince("0.1.0")
@SuppressWarnings("unused")
public class ValidationException extends SoftException {

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public ValidationException() {
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
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public ValidationException(final @NonNls @Nullable String message) {
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
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public ValidationException(final @Nullable Throwable cause) {
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
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    public ValidationException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(pure = true)
    protected ValidationException(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
