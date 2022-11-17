package com.bloogefest.common;

/**
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public class SoftError extends Error {

    /**
     * @since 0.0.0
     */
    protected static final String defaultMessage = "Not specified";

    /**
     * @since 0.0.0
     */
    protected static final Throwable defaultCause = null;

    /**
     * @since 0.0.0
     */
    protected static final boolean defaultSuppression = false;

    /**
     * @since 0.0.0
     */
    protected static final boolean defaultWritable = true;

    /**
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError() {
        super();
    }

    /**
     * @param message     Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError(final String message) {
        super(message);
    }

    /**
     * @param cause       Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message     Not specified
     * @param cause       Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public SoftError(final String message,
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
    protected SoftError(final String message,
                        final Throwable cause,
                        final boolean suppression,
                        final boolean writable) {
        super(message,
              cause,
              suppression,
              writable);
    }

}
