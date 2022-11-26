package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Является функциональным интерфейсом вычисляемого условного выражения.
 *
 * @author Bloogefest
 * @version 1.0
 * @see ConditionException
 * @since 0.0.0
 */
@ApiStatus.AvailableSince("0.0.0")
@SuppressWarnings("unused")
@FunctionalInterface
public interface Condition {

    /**
     * Производит константный экземпляр вычисляемого условного выражения.
     *
     * @param result вычисляемое значение.
     *
     * @return Константный экземпляр вычисляемого условного выражения.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @ApiStatus.AvailableSince("0.1.0")
    @Contract(value = "_ -> new", pure = true)
    static @NotNull Condition constant(final boolean result) {
        return () -> result;
    }

    /**
     * Подтверждает ненулевое явление переданного экземпляра вычисляемого условного выражения.
     *
     * @param condition экземпляр вычисляемого условного выражения.
     *
     * @return Подтверждённый переданный экземпляр вычисляемого условного выражения.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра вычисляемого условного выражения.
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(value = "_ -> new", pure = true)
    static @NotNull Condition of(final @NotNull Condition condition) throws NullException {
        return Validator.notNull(condition, "condition");
    }

    /**
     * Выполняет вычисление значения данного экземпляра вычисляемого условного выражения.
     *
     * @return Вычисляемое значение.
     *
     * @throws ConditionException невозможность выполнения вычисления значения данного экземпляра вычисляемого условного выражения.
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(pure = true)
    boolean calculate() throws ConditionException;

    /**
     * Инвертирует данный экземпляр вычисляемого условного выражения.
     *
     * @return Инвертированный экземпляр вычисляемого условного выражения.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(value = "-> new", pure = true)
    default @NotNull Condition invert() {
        return () -> !calculate();
    }

    /**
     * Комбинирует данный экземпляр вычисляемого условного выражения конъюнкцией с переданным.
     *
     * @param condition экземпляр вычисляемого условного выражения.
     *
     * @return Комбинированный экземпляр вычисляемого условного выражения.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра вычисляемого условного выражения.
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition and(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() && condition.calculate();
    }

    /**
     * Комбинирует данный экземпляр вычисляемого условного выражения мягкой дизъюнкцией с переданным.
     *
     * @param condition экземпляр вычисляемого условного выражения.
     *
     * @return Комбинированный экземпляр вычисляемого условного выражения.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра вычисляемого условного выражения.
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition or(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() || condition.calculate();
    }

    /**
     * Комбинирует данный экземпляр вычисляемого условного выражения строгой дизъюнкцией с переданным.
     *
     * @param condition экземпляр вычисляемого условного выражения.
     *
     * @return Комбинированный экземпляр вычисляемого условного выражения.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра вычисляемого условного выражения.
     * @author Bloogefest
     * @since 0.0.0
     */
    @ApiStatus.AvailableSince("0.0.0")
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Condition xor(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() ^ condition.calculate();
    }

}
