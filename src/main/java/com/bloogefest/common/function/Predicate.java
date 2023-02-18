/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Является функциональным интерфейсом предиката типизированного экземпляра.
 *
 * @param <TYPE> тип обрабатываемого экземпляра.
 *
 * @version 1.0
 * @see PredicateException
 * @since 0.0.0
 */
@FunctionalInterface
public interface Predicate<TYPE> {

    /**
     * Производит константный экземпляр предиката типизированного экземпляра.
     *
     * @param result вычисляемое значение.
     *
     * @return Константный экземпляр предиката типизированного экземпляра.
     *
     * @since 0.1.0
     */
        @Contract(value = "_ -> new", pure = true)
    static <TYPE> @NotNull Predicate<TYPE> constant(final boolean result) {
        return instance -> result;
    }

    /**
     * Подтверждает ненулевое явление переданного экземпляра предиката типизированного экземпляра.
     *
     * @param predicate экземпляр предиката типизированного экземпляра.
     *
     * @return Подтверждённый переданный экземпляр предиката типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра предиката
     * типизированного экземпляра.
     * @since 0.0.0
     */
        @Contract(value = "_ -> new", pure = true)
    static <TYPE> @NotNull Predicate<TYPE> of(final @NotNull Predicate<TYPE> predicate) throws NullException {
        return Validator.notNull(predicate, "predicate");
    }

    /**
     * Выполняет обработку переданного типизированного экземпляра и вычисляет значение данного экземпляра предиката
     * типизированного экземпляра.
     *
     * @param instance обрабатываемый типизированный экземпляр.
     *
     * @return Вычисляемое значение.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного обрабатываемого типизированного
     * экземпляра.
     * @throws PredicateException невозможность выполнения обработки переданного типизированного экземпляра и вычисления
     * значения данного экземпляра предиката типизированного экземпляра.
     * @since 0.0.0
     */
        @Contract(pure = true)
    boolean evaluate(final @NotNull TYPE instance) throws NullException, PredicateException;

    /**
     * Инвертирует данный экземпляр предиката типизированного экземпляра.
     *
     * @return Инвертированный экземпляр предиката типизированного экземпляра.
     *
     * @since 0.0.0
     */
        @Contract(value = "-> new", pure = true)
    default @NotNull Predicate<TYPE> invert() {
        return instance -> !evaluate(instance);
    }

    /**
     * Комбинирует данный экземпляр предиката типизированного экземпляра конъюнкцией с переданным.
     *
     * @param predicate экземпляр предиката типизированного экземпляра.
     *
     * @return Комбинированный экземпляр предиката типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра предиката
     * типизированного экземпляра.
     * @since 0.0.0
     */
        @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<TYPE> and(final @NotNull Predicate<TYPE> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return instance -> evaluate(instance) && predicate.evaluate(instance);
    }

    /**
     * Комбинирует данный экземпляр предиката типизированного экземпляра мягкой дизъюнкцией с переданным.
     *
     * @param predicate экземпляр предиката типизированного экземпляра.
     *
     * @return Комбинированный экземпляр предиката типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра предиката
     * типизированного экземпляра.
     * @since 0.0.0
     */
        @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<TYPE> or(final @NotNull Predicate<TYPE> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return instance -> evaluate(instance) || predicate.evaluate(instance);
    }

    /**
     * Комбинирует данный экземпляр предиката типизированного экземпляра строгой дизъюнкцией с переданным.
     *
     * @param predicate экземпляр предиката типизированного экземпляра.
     *
     * @return Комбинированный экземпляр предиката типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра предиката
     * типизированного экземпляра.
     * @since 0.0.0
     */
        @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<TYPE> xor(final @NotNull Predicate<TYPE> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return instance -> evaluate(instance) ^ predicate.evaluate(instance);
    }

}
