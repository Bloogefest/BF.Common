package com.ketlet.common;

import com.ketlet.common.Objects;

/**
 * @author Ketlet
 * @version 0.0
 * @since 0.0.0
 */
public class SoftError extends Error {

    protected static final String DEFAULT_MESSAGE = null;

    protected static final Throwable DEFAULT_CAUSE = null;

    protected static final boolean DEFAULT_SUPPRESSION = false;

    protected static final boolean DEFAULT_WRITABLE = true;

    protected static final Throwable[] DEFAULT_SUPPRESSED = null;

    /**
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError() {
        this(DEFAULT_MESSAGE,
             DEFAULT_CAUSE,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             DEFAULT_SUPPRESSED);
    }

    /**
     * @param suppressed Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError(final Throwable... suppressed) {
        this(DEFAULT_MESSAGE,
             DEFAULT_CAUSE,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             suppressed);
    }

    /**
     * @param message Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError(final String message) {
        this(message,
             DEFAULT_CAUSE,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             DEFAULT_SUPPRESSED);
    }

    /**
     * @param message Not specified
     * @param suppressed Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError(final String message,
                     final Throwable... suppressed) {
        this(message,
             DEFAULT_CAUSE,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             suppressed);
    }

    /**
     * @param cause Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError(final Throwable cause) {
        this(DEFAULT_MESSAGE,
             cause,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             DEFAULT_SUPPRESSED);
    }

    /**
     * @param cause Not specified
     * @param suppressed Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError(final Throwable cause,
                     final Throwable... suppressed) {
        this(DEFAULT_MESSAGE,
             cause,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             suppressed);
    }

    /**
     * @param message Not specified
     * @param cause Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError(final String message,
                     final Throwable cause) {
        this(message,
             cause,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             DEFAULT_SUPPRESSED);
    }

    /**
     * @param message Not specified
     * @param cause Not specified
     * @param suppressed Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public SoftError(final String message,
                     final Throwable cause,
                     final Throwable suppressed) {
        this(message,
             cause,
             DEFAULT_SUPPRESSION,
             DEFAULT_WRITABLE,
             suppressed);
    }

    /**
     * @param message Not specified
     * @param cause Not specified
     * @param suppression Not specified
     * @param writable Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    protected SoftError(final String message,
                        final Throwable cause,
                        final boolean suppression,
                        final boolean writable) {
        this(message,
             cause,
             suppression,
             writable,
             DEFAULT_SUPPRESSED);
    }

    /**
     * @param message Not specified
     * @param cause Not specified
     * @param suppression Not specified
     * @param writable Not specified
     * @param suppressed Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    protected SoftError(final String message,
                        final Throwable cause,
                        final boolean suppression,
                        final boolean writable,
                        final Throwable... suppressed) {
        super(message,
              cause,
              suppression,
              writable);
        if (suppression && Objects.notNull(suppressed)) suppress(suppressed);
    }

    /**
     * @param suppressed Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public final synchronized void suppress(Throwable... suppressed) {
        assert suppressed != null : "The suppressed mustn't be null";
        for (final var e : suppressed) addSuppressed(e);
    }

}
