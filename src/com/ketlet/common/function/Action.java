package com.ketlet.common.function;

/**
 * @author Ketlet
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Action {

    /**
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static Action empty() {
        return () -> {
        };
    }

    /**
     * @param action Not specified
     *
     * @return Not specified
     *
     * @author Ketlet
     * @since 0.0.0
     */
    static Action as(final Action action) {
        assert action != null : "The action mustn't be null";
        return action;
    }

    /**
     * @author Ketlet
     * @since 0.0.0
     */
    void perform();

}
