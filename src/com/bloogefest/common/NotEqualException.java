package com.bloogefest.common;

import com.bloogefest.common.throwable.SoftException;

/**
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public class NotEqualException extends SoftException {

    /**
     * @since 0.0.0
     */
    protected static final String defaultMessage = "The object must be equal to another";

    /**
     * @author Bloogefest
     * @since 0.0.0
     */
    public NotEqualException() {
        this(defaultMessage);
    }

    /**
     * @param message     Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public NotEqualException(final String message) {
        super(message);
    }

    /**
     * @param cause       Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public NotEqualException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message     Not specified
     * @param cause       Not specified
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
     * @param message     Not specified
     * @param cause       Not specified
     * @param suppression Not specified
     * @param writable    Not specified
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
