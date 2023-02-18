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
 * Является функциональным интерфейсом поставщика типизированного экземпляра.
 *
 * @param <TYPE> тип поставляемого экземпляра.
 *
 * @version 1.0
 * @see SupplierException
 * @since 0.0.0
 */
@FunctionalInterface
public interface Supplier<TYPE> {

    /**
     * Подтверждает ненулевое явление переданного поставляемого типизированного экземпляра. Производит константный
     * экземпляр поставщика типизированного экземпляра.
     *
     * @param <TYPE> тип поставляемого экземпляра.
     * @param instance поставляемый типизированный экземпляр.
     *
     * @return Константный экземпляр поставщика типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного поставляемого типизированного
     * экземпляра.
     * @since 0.1.0
     */
        @Contract(value = "_ -> new", pure = true)
    static <TYPE> @NotNull Supplier<TYPE> constant(final @NotNull TYPE instance) throws NullException {
        Validator.notNull(instance, "instance");
        return () -> instance;
    }

    /**
     * Подтверждает ненулевое явление переданного экземпляра поставщика типизированного экземпляра.
     *
     * @param supplier экземпляр поставщика типизированного экземпляра.
     *
     * @return Подтверждённый переданный экземпляр поставщика типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра поставщика
     * типизированного экземпляра.
     * @since 0.0.0
     */
        @Contract(value = "_ -> param1", pure = true)
    static <TYPE> @NotNull Supplier<TYPE> of(final @NotNull Supplier<TYPE> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Выполняет поставку типизированного экземпляра.
     *
     * @return Поставляемый типизированный экземпляр.
     *
     * @throws SupplierException невозможность выполнения поставки типизированного экземпляра.
     * @since 0.0.0
     */
        @Contract(pure = true)
    @NotNull TYPE supply() throws SupplierException;

}
