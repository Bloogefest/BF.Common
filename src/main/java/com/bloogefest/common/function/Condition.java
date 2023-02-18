/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Представление условного выражения.
 */
@AvailableSince("0.0.0")
@FunctionalInterface
@SuppressWarnings("unused")
public interface Condition {

    /**
     * Создаёт константный экземпляр вычисляемого условного выражения.
     *
     * @param result значение.
     *
     * @return Константный экземпляр вычисляемого условного выражения.
     */
    @Contract(value = "_ -> new", pure = true)
    @AvailableSince("0.1.0")
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
     */
    @Contract(value = "_ -> new", pure = true)
    @AvailableSince("0.0.0")
    static @NotNull Condition of(final @NotNull Condition condition) throws NullException {
        return Validator.notNull(condition, "condition");
    }

    /**
     * Выполняет вычисление значения данного экземпляра вычисляемого условного выражения.
     *
     * @return Вычисляемое значение.
     *
     * @throws ConditionException невозможность выполнения вычисления значения данного экземпляра вычисляемого условного выражения.
     */
    @Contract(pure = true)
    @AvailableSince("0.0.0")
    boolean calculate() throws ConditionException;

    /**
     * Инвертирует данный экземпляр вычисляемого условного выражения.
     *
     * @return Инвертированный экземпляр вычисляемого условного выражения.
     */
    @Contract(value = "-> new", pure = true)
    @AvailableSince("0.0.0")
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
     */
    @Contract(value = "_ -> new", pure = true)
    @AvailableSince("0.0.0")
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
     */
    @Contract(value = "_ -> new", pure = true)
    @AvailableSince("0.0.0")
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
     */
    @Contract(value = "_ -> new", pure = true)
    @AvailableSince("0.0.0")
    default @NotNull Condition xor(final @NotNull Condition condition) throws NullException {
        Validator.notNull(condition, "condition");
        return () -> calculate() ^ condition.calculate();
    }

}
