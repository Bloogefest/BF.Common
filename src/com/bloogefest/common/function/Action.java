package com.bloogefest.common.function;

import com.bloogefest.common.NullException;
import com.bloogefest.common.Validator;

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
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    static Action as(final Action action) throws NullException {
        return Validator.notNull(action, "action");
    }

    /**
     * @throws FunctionException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    void perform() throws FunctionException;

    /**
     * @param action Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Action with(final Action action) throws NullException {
        Validator.notNull(action, "action");
        return () -> {
            perform();
            action.perform();
        };
    }

}
