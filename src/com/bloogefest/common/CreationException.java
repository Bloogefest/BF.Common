package com.bloogefest.common;

import com.bloogefest.common.throwable.StrictException;

/**
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public class CreationException extends StrictException {

    /**
     * @since 0.0.0
     */
    protected static final String defaultMessage = "The instance mustn't be created";

    /**
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException() {
        this(defaultMessage);
    }

    /**
     * @param message     Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException(final String message) {
        super(message);
    }

    /**
     * @param cause       Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message     Not specified
     * @param cause       Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public CreationException(final String message,
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
    protected CreationException(final String message,
                                final Throwable cause,
                                final boolean suppression,
                                final boolean writable) {
        super(message,
              cause,
              suppression,
              writable);
    }

}
