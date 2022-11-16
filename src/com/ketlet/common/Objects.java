package com.ketlet.common;

/**
 * @author Ketlet
 * @version 0.0
 * @since 0.0.0
 */
public final class Objects {

    private Objects() {}

    /**
     * @param <T> Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public static <T> boolean isNull(final T object) {
        return object == null;
    }

    /**
     * @param <T> Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public static <T> boolean notNull(final T object) {
        return object != null;
    }

    /**
     * @param <T1> Not specified
     * @param <T2> Not specified
     * @param base Not specified
     * @param common Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    @SuppressWarnings("EqualsReplaceableByObjectsCall")
    public static <T1, T2> boolean equals(final T1 base,
                                          final T2 common) {
        return base == common || base != null && base.equals(common);
    }

    /**
     * @param <T1> Not specified
     * @param <T2> Not specified
     * @param base Not specified
     * @param common Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    public static <T1, T2> boolean notEquals(final T1 base,
                                             final T2 common) {
        return base != common && base == null || base != null && !base.equals(common);
    }

}
