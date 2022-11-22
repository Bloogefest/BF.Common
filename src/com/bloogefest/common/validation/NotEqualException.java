package com.bloogefest.common.validation;

import com.bloogefest.common.function.Supplier;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Мягкое исключение валидации явления равенства первичного объекта со вторичным объектом.
 *
 * @author Bloogefest
 * @version 0.3
 * @see ValidationException
 * @see Validator#equals(Object, Object)
 * @see Validator#equals(Object, Object, String, String)
 * @see Validator#equals(Object, Object, Supplier)
 * @since 0.0.0
 */
@SuppressWarnings("unused")
public class NotEqualException extends ValidationException {

    /**
     * Содержит сообщение по умолчанию.
     *
     * @since 0.0.0
     */
    protected static final String defaultMessage = "The object must be equal to object_";

    /**
     * Содержит сообщение для значений по умолчанию.
     *
     * @since 0.2.0
     */
    protected static final String defaultValuedMessage = "The value must be equal to value_";

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public NotEqualException() {
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
    public NotEqualException(final @NonNls @Nullable String message) {
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
    public NotEqualException(final @Nullable Throwable cause) {
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
    public NotEqualException(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
        super(message, cause);
    }

    /**
     * Создаёт экземпляр, используя переопределённое сообщение, причину, параметр подавления и записи трассировки стека по умолчанию.
     *
     * @param message     сообщение.
     * @param cause       причина.
     * @param suppression параметр подавления.
     * @param writable    параметр записи трассировки стека.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    protected NotEqualException(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
