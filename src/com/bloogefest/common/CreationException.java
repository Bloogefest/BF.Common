package com.bloogefest.common;

import com.bloogefest.common.throwable.StrictException;

/**
 * Строгое исключение, возникающее при несанкционированной попытке создания экземпляра.
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public class CreationException extends StrictException {

    /**
     * Содержит стандартное сообщение.
     *
     * @since 0.0.0
     */
    protected static final String defaultMessage = "The instance mustn't be created";

    /**
     * Конструктор, использующий стандартное сообщение.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException() {
        this(defaultMessage);
    }

    /**
     * Конструктор, использующий сообщение, переданное параметром.
     *
     * @param message Сообщение, используемое вместо стандартного.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException(final String message) {
        super(message);
    }

    /**
     * Конструктор, использующий причину, переданную параметром.
     *
     * @param cause Причина возникновения исключения.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException(final Throwable cause) {
        super(cause);
    }

    /**
     * Конструктор, использующий сообщение и причину, переданные параметрами.
     *
     * @param message Сообщение, используемое вместо стандартного.
     * @param cause   Причина возникновения исключения.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Конструктор, использующий сообщение, причину, разрешение об упоминании подавленных исключений и разрешение для записи трассировки стека, переданные параметрами.
     *
     * @param message     Сообщение, используемое вместо стандартного.
     * @param cause       Причина возникновения исключения.
     * @param suppression Позволяет упоминать подавленные исключения.
     * @param writable    Позволяет трассировке стека записываться.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    protected CreationException(final String message, final Throwable cause, final boolean suppression, final boolean writable) {
        super(message, cause, suppression, writable);
    }

}
