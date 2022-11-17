package com.bloogefest.common.function;

/**
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Condition {

    /**
     * @param value Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static Condition strict(final boolean value) {
        return () -> value;
    }

    /**
     * @param condition Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static Condition as(final Condition condition) {
        assert condition != null : "The condition mustn't be null";
        return condition;
    }

    /**
     * @return Not specified
     *
     * @throws FunctionException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    boolean calculate() throws FunctionException;

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Condition invert() {
        return () -> !calculate();
    }

    /**
     * @param condition Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Condition and(final Condition condition) {
        assert condition != null : "The condition mustn't be null";
        return () -> calculate() && condition.calculate();
    }

    /**
     * @param condition Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Condition or(final Condition condition) {
        assert condition != null : "The condition mustn't be null";
        return () -> calculate() && condition.calculate();
    }

    /**
     * @param condition Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Condition xor(final Condition condition) {
        assert condition != null : "The condition mustn't be null";
        return () -> calculate() ^ condition.calculate();
    }

    /**
     * @param value Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Condition suppress(final boolean value) {
        return () -> value;
    }

}
