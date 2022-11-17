package com.bloogefest.common.function;

import com.bloogefest.common.throwable.SoftException;

/**
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public class FunctionException extends SoftException {

    /**
     * @author Bloogefest
     * @since 0.0.0
     */
    public FunctionException() {
        super();
    }

    /**
     * @param message     Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public FunctionException(final String message) {
        super(message);
    }

    /**
     * @param cause       Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public FunctionException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message     Not specified
     * @param cause       Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public FunctionException(final String message,
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
    protected FunctionException(final String message,
                                final Throwable cause,
                                final boolean suppression,
                                final boolean writable) {
        super(message,
              cause,
              suppression,
              writable);
    }

}
