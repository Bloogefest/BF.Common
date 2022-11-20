package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс логического выражения.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Condition {

    /**
     * Создаёт логическое выражение с постоянным результатом вычисления.
     *
     * @param result постоянный результат вычисления.
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
     * Проверяет логическое выражение и возвращает его.
     *
     * @param condition логическое выражение.
     *
     * @return Проверенное логическое выражение.
     *
     * @throws NullException логическое выражение не должно являться нулём.
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
     * Инвертирует логическое выражение.
     *
     * @return Инвертированное логическое выражение.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    default @NotNull Condition invert() {
        return () -> !calculate();
    }

    /**
     * Комбинирует данное логическое выражение конъюнкцией с переданным.
     *
     * @param condition логическое выражение.
     *
     * @return Комбинированное логическое выражение.
     *
     * @throws NullException логическое выражение не должно являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition and(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() && condition.calculate();
    }

    /**
     * Комбинирует данное логическое выражение мягкой дизъюнкцией с переданным.
     *
     * @param condition логическое выражение.
     *
     * @return Комбинированное логическое выражение.
     *
     * @throws NullException логическое выражение не должно являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition or(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() || condition.calculate();
    }

    /**
     * Комбинирует данное логическое выражение строгой дизъюнкцией с переданным.
     *
     * @param condition логическое выражение.
     *
     * @return Комбинированное логическое выражение.
     *
     * @throws NullException логическое выражение не должно являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition xor(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() ^ condition.calculate();
    }

}
