package com.bloogefest.common.throwable;

/**
 * Мягкая ошибка, не требующая обработки.
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public class SoftError extends Error {

    /**
     * Содержит стандартное сообщение.
     *
     * @since 0.0.0
     */
    protected static final String defaultMessage = "Not specified";

    /**
     * Содержит стандартную причину возникновения ошибки.
     *
     * @since 0.0.0
     */
    protected static final Throwable defaultCause = null;

    /**
     * Содержит стандартное разрешение о упоминании подавленных ошибок.
     *
     * @since 0.0.0
     */
    protected static final boolean defaultSuppression = false;

    /**
     * Содержит стандартное разрешение для записи трассировки стека.
     *
     * @since 0.0.0
     */
    protected static final boolean defaultWritable = true;

    /**
     * Конструктор, использующий стандартное сообщение.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError() {
        super(defaultMessage);
    }

    /**
     * Конструктор, использующий сообщение, переданное параметром.
     *
     * @param message Сообщение, используемое вместо стандартного.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError(final String message) {
        super(message);
    }

    /**
     * Конструктор, использующий причину, переданную параметром.
     *
     * @param cause Причина возникновения ошибки.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError(final Throwable cause) {
        super(cause);
    }

    /**
     * Конструктор, использующий сообщение и причину, переданные параметрами.
     *
     * @param message Сообщение, используемое вместо стандартного.
     * @param cause   Причина возникновения ошибки.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Конструктор, использующий сообщение, причину, разрешение об упоминании подавленных ошибок и разрешение для записи трассировки стека, переданные параметрами.
     *
     * @param message     Сообщение, используемое вместо стандартного.
     * @param cause       Причина возникновения ошибки.
     * @param suppression Позволяет упоминать подавленные ошибки.
     * @param writable    Позволяет трассировке стека записываться.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    protected SoftError(final String message, final Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
