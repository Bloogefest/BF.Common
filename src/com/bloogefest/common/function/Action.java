package com.bloogefest.common.function;

/**
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Action {

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static Action empty() {
        return () -> {};
    }

    /**
     * @param action Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static Action as(final Action action) {
        assert action != null : "The action mustn't be null";
        return action;
    }

    /**
     * @author Bloogefest
     * @since 0.0.0
     */
    void perform();

    /**
     * @param action Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Action with(final Action action) {
        assert action != null : "The action mustn't be null";
        return () -> {
            perform();
            action.perform();
        };
    }

}
