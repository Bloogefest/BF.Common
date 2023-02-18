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
 * Является функциональным интерфейсом процессора типизированного экземпляра.
 *
 * @param <TYPE> тип обрабатываемого экземпляра.
 * @param <RESULT> тип вычисляемого экземпляра.
 *
 * @version 1.0
 * @see ProcessorException
 * @since 0.2.0
 */
@FunctionalInterface
public interface Processor<TYPE, RESULT> {

    /**
     * Подтверждает ненулевое явление переданного вычисляемого типизированного экземпляра. Производит константный
     * экземпляр процессора типизированного экземпляра.
     *
     * @param <TYPE> тип вычисляемого экземпляра.
     * @param instance вычисляемый типизированный экземпляр.
     *
     * @return Константный экземпляр процессора типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного вычисляемого типизированного
     * экземпляра.
     * @since 0.2.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <TYPE, RESULT> @NotNull Processor<TYPE, RESULT> constant(
            final @NotNull RESULT instance) throws NullException {
        Validator.notNull(instance, "instance");
        return instance_ -> instance;
    }

    /**
     * Подтверждает ненулевое явление переданного экземпляра процессора типизированного экземпляра.
     *
     * @param processor экземпляр процессора типизированного экземпляра.
     *
     * @return Подтверждённый переданный экземпляр процессора типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления экземпляра процессора типизированного
     * экземпляра.
     * @since 0.2.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <TYPE, RESULT> @NotNull Processor<TYPE, RESULT> of(
            final @NotNull Processor<TYPE, RESULT> processor) throws NullException {
        return Validator.notNull(processor, "processor");
    }

    /**
     * Выполняет обработку переданного типизированного экземпляра и вычисляет типизированный экземпляр.
     *
     * @param instance обрабатываемый типизированный экземпляр.
     *
     * @return Вычисляемый типизированный экземпляр.
     *
     * @throws ProcessorException невозможность выполнения обработки переданного типизированного экземпляра и вычисления
     * типизированного экземпляра.
     * @since 0.2.0
     */
    @Contract(pure = true)
    @NotNull RESULT process(final @NotNull TYPE instance) throws WorkerException;

    /**
     * Подтверждает ненулевое явление переданного экземпляра процессора типизированного экземпляра. Комбинирует данный
     * экземпляр процессора типизированного экземпляра с переданным.
     *
     * @param <RESULT_> тип вычисляемого экземпляра.
     * @param processor экземпляр процессора типизированного экземпляра.
     *
     * @return Комбинированный экземпляр процессора типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра процессора
     * типизированного экземпляра.
     * @since 0.2.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <RESULT_> @NotNull Processor<TYPE, RESULT_> with(
            final @NotNull Processor<? super RESULT, ? extends RESULT_> processor) throws NullException {
        Validator.notNull(processor, "processor");
        return instance -> processor.process(process(instance));
    }

}
