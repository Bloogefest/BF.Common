package com.bloogefest.common.validation;

/**
 * Мягкое исключение, возникающее при попытке валидации объекта, считая, что он является другим объектом.
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public class NotEqualException extends ValidationException {

    /**
     * Содержит стандартное сообщение.
     *
     * @since 0.0.0
     */
    protected static final String defaultMessage = "The object must be equal to another";

    /**
     * Конструктор, использующий стандартное сообщение.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public NotEqualException() {
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
    public NotEqualException(final String message) {
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
    public NotEqualException(final Throwable cause) {
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
    public NotEqualException(final String message,
                             final Throwable cause) {
        super(message,
              cause);
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
    protected NotEqualException(final String message,
                                final Throwable cause,
                                final boolean suppression,
                                final boolean writable) {
        super(message,
              cause,
              suppression,
              writable);
    }

}
