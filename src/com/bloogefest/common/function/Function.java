package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс, позволяющий реализовать логику возврата внутри контекста.
 *
 * @param <T> тип контекстного экземпляра.
 * @param <R> тип возвращаемого экземпляра.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Создаёт нулевой экземпляр данного интерфейса.
     * Гарантирует возврат только нулевого типизированного экземпляра.
     *
     * @return Нулевой экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T, R> @NotNull Function<T, R> nullable() {
        return __ -> null;
    }

    /**
     * Создаёт строгий экземпляр данного интерфейса.
     * Гарантирует возврат только переданного типизированного экземпляра.
     *
     * @param result возвращаемый экземпляр.
     *
     * @return Строгий экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T, R> @NotNull Function<T, R> strict(final @Nullable R result) {
        return __ -> result;
    }

    /**
     * @param <T>      Not specified
     * @param <R>      Not specified
     * @param function Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T, R> Function<T, R> of(final Function<T, R> function) throws NullException {
        return Validator.notNull(function, "function");
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @throws FunctionException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    @Nullable R execute(final @Nullable T object) throws ExecuteException;

    /**
     * @param function Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Function<T, R> with(final Function<T, R> function) throws NullException {
        Validator.notNull(function, "function");
        return object -> {
            execute(object);
            return function.execute(object);
        };
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Function<T, R> suppress(final T object) {
        return __ -> execute(object);
    }

}
