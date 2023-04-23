/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;

/**
 * Обёртка обнуляемого объекта.
 *
 * @param <T> тип объекта.
 *
 * @apiNote Позволяет безопасно работать с обнуляемыми объектами.
 * @since 4.0.0
 */
@FunctionalInterface
public interface Optional<T> {

    /**
     * Создаёт и возвращает пустую обёртку.
     *
     * @return Пустая обёртка.
     *
     * @since 4.0.0
     */
    @Contract("-> new")
    static <T> @NotNull Optional<T> empty() {
        return () -> null;
    }

    /**
     * Возвращает переданную обёртку.
     *
     * @param optional обёртка обнуляемого объекта.
     *
     * @return Переданная обёртка.
     *
     * @apiNote Используйте для приведения лямбда-выражений к типу обёртки обнуляемого объекта.
     * @since 4.0.0
     */
    @Contract("_ -> 1")
    static <T> @NotNull Optional<T> lambda(final @NotNull Optional<T> optional) {
        return optional;
    }

    /**
     * Возвращает обнуляемый объект из-под этой обёртки.
     *
     * @return Обнуляемый объект из-под этой обёртки.
     *
     * @since 4.0.0
     */
    @Contract(pure = false)
    @Nullable T nullable();

    /**
     * Если обнуляемый объект из-под этой обёртки ненулевой, то возвращает его, иначе генерирует исключение с его
     * именем.
     *
     * @return Ненулевой объект из-под этой обёртки.
     *
     * @since 4.0.0
     */
    @Contract(pure = false)
    default @NotNull T get() throws GetException {
        final var object = nullable();
        if (object == null) throw new GetException();
        return object;
    }

}
