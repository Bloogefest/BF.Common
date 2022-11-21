package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс условного выражения.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Condition {

    /**
     * Создаёт условное выражение с постоянным результатом вычисления.
     *
     * @param result результат вычисления.
     *
     * @return Постоянное логическое выражение.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static @NotNull Condition constant(final boolean result) {
        return () -> result;
    }

    /**
     * Проверяет условное выражение и возвращает его.
     *
     * @param condition условное выражение.
     *
     * @return Проверенное условное выражение.
     *
     * @throws NullException условное выражение не должно быть нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static @NotNull Condition of(final @NotNull Condition condition) throws NullException {
        return Validator.notNull(condition, "condition");
    }

    /**
     * Вычисляет результат.
     *
     * @return Результат вычисления.
     *
     * @throws CalculateException невозможно вычислить результат.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    boolean calculate() throws CalculateException;

    /**
     * Инвертирует условное выражение.
     *
     * @return Инвертированное условное выражение.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    default @NotNull Condition invert() {
        return () -> !calculate();
    }

    /**
     * Комбинирует данное условное выражение конъюнкцией с переданным.
     *
     * @param condition условное выражение.
     *
     * @return Комбинированное условное выражение.
     *
     * @throws NullException условное выражение не должно быть нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition and(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() && condition.calculate();
    }

    /**
     * Комбинирует данное условное выражение мягкой дизъюнкцией с переданным.
     *
     * @param condition условное выражение.
     *
     * @return Комбинированное условное выражение.
     *
     * @throws NullException условное выражение не должно быть нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition or(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() || condition.calculate();
    }

    /**
     * Комбинирует данное условное выражение строгой дизъюнкцией с переданным.
     *
     * @param condition условное выражение.
     *
     * @return Комбинированное условное выражение.
     *
     * @throws NullException условное выражение не должно быть нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition xor(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() ^ condition.calculate();
    }

}
