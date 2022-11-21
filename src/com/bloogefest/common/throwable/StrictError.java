package com.bloogefest.common.throwable;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * Строгая ошибка, не рекомендованная для перехвата.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
public class StrictError extends Error {

    /**
     * Содержит сообщение по умолчанию.
     *
     * @since 0.0.0
     */
    protected static final @NonNls String defaultMessage = "Not specified";

    /**
     * Содержит причину по умолчанию.
     *
     * @since 0.0.0
     */
    protected static final Throwable defaultCause = null;

    /**
     * Содержит параметр подавления по умолчанию.
     *
     * @since 0.0.0
     */
    protected static final boolean defaultSuppression = false;

    /**
     * Содержит параметр записи трассировки стека по умолчанию.
     *
     * @since 0.0.0
     */
    protected static final boolean defaultWritable = true;

    /**
     * Создаёт экземпляр по умолчанию.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
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
    public StrictError(final @NonNls @Nullable String message, final @Nullable Throwable cause) {
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
    protected StrictError(final @NonNls @Nullable String message, final @Nullable Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
