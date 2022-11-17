package com.bloogefest.common;

/**
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
public final class Conditions {

    /**
     * @throws CreationException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    private Conditions() throws CreationException {
        throw new CreationException();
    }

    /**
     * @param <T>    Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T> boolean notNull(final T object) {
        return object != null;
    }

    /**
     * @param <T1>    Not specified
     * @param <T2>    Not specified
     * @param object  Not specified
     * @param another Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> boolean equals(final T1 object,
                                          final T2 another) {
        return object == another || notNull(object) && object.equals(another);
    }

    /**
     * @param <T1>    Not specified
     * @param <T2>    Not specified
     * @param object  Not specified
     * @param another Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> boolean notEquals(final T1 object,
                                             final T2 another) {
        return object != another && notNull(object) && object.equals(another);
    }

}
