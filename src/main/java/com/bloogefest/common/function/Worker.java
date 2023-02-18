/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Является функциональным интерфейсом обработчика типизированного экземпляра.
 *
 * @param <TYPE> тип обрабатываемого экземпляра.
 *
 * @version 1.0
 * @see WorkerException
 * @since 0.2.0
 */
@ApiStatus.AvailableSince("0.2.0")
@SuppressWarnings("unused")
@FunctionalInterface
public interface Worker<TYPE> {

    /**
     * Производит пустой экземпляр поставщика типизированного экземпляра.
     *
     * @param <TYPE> тип обрабатываемого экземпляра.
     *
     * @return Пустой экземпляр обработчика типизированного экземпляра.
     *
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(value = "-> new", pure = true)
    static <TYPE> @NotNull Worker<TYPE> empty() {
        return instance -> {
        };
    }

    /**
     * Подтверждает ненулевое явление переданного экземпляра обработчика типизированного экземпляра.
     *
     * @param worker экземпляр обработчика типизированного экземпляра.
     *
     * @return Подтверждённый переданный экземпляр обработчика типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра обработчика типизированного экземпляра.
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(value = "_ -> param1", pure = true)
    static <TYPE> @NotNull Worker<TYPE> of(final @NotNull Worker<TYPE> worker) throws NullException {
        return Validator.notNull(worker, "worker");
    }

    /**
     * Выполняет обработку переданного типизированного экземпляра.
     *
     * @param instance обрабатываемый типизированный экземпляр.
     *
     * @throws WorkerException невозможность выполнения обработки переданного типизированного экземпляра.
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    void work(final @NotNull TYPE instance) throws WorkerException;

    /**
     * Подтверждает ненулевое явление переданного экземпляра обработчика типизированного экземпляра.
     * Комбинирует данный экземпляр обработчика типизированного экземпляра с переданным,
     * гарантируя последовательное выполнение обработки типизированного экземпляра каждым экземпляром.
     *
     * @param worker экземпляр обработчика типизированного экземпляра.
     *
     * @return Комбинированный экземпляр обработчика типизированного экземпляра.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра обработчика типизированного экземпляра.
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Worker<TYPE> with(final @NotNull Worker<? super TYPE> worker) throws NullException {
        Validator.notNull(worker, "worker");
        return instance -> {
            try {
                work(instance);
            } finally {
                worker.work(instance);
            }
        };
    }

}
