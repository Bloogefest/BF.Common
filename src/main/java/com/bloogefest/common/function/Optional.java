/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

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
     * Проверяет переданный объект. Если он ненулевой, то создаёт и возвращает его обёртку, в противном случае
     * генерирует исключение с его именем.
     *
     * @param object обнуляемый объект.
     *
     * @return Обёртка переданного объекта.
     *
     * @throws NullException исключение проверки нулевого объекта.
     * @since 4.0.0
     */
    @Contract("_ -> new")
    static <T> @NotNull Optional<T> of(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

    /**
     * Создаёт и возвращает обёртку переданного объекта.
     *
     * @param object обнуляемый объект.
     *
     * @return Обёртка переданного объекта.
     *
     * @since 4.0.0
     */
    @Contract("_ -> new")
    static <T> @NotNull Optional<T> nullable(final @Nullable T object) {
        return () -> object;
    }

    /**
     * Проверяет переданную обёртку. Если она ненулевая, то возвращает её, в противном случае генерирует исключение с её
     * именем.
     *
     * @param optional обёртка обнуляемого объекта.
     *
     * @return Переданная обёртка.
     *
     * @throws NullException исключение проверки нулевой обёртки.
     * @apiNote Используйте для проверки обёртки обнуляемого объекта перед её использованием.
     * @since 4.0.0
     */
    @Contract("!null -> 1; _ -> failure")
    static <T> @NotNull Optional<T> check(final @Nullable Optional<T> optional) throws NullException {
        return Validator.notNull(optional, "optional");
    }

    /**
     * Проверяет переданную обёртку. Если она ненулевая, то возвращает её, в противном случае создаёт и возвращает
     * пустую обёртку.
     *
     * @param optional обёртка обнуляемого объекта.
     *
     * @return Переданная либо пустая обёртка.
     *
     * @apiNote Используйте для гарантии безопасного использования обёртки обнуляемого объекта или приведения
     * лямбда-выражений к типу обёртки обнуляемого объекта.
     * @since 4.0.0
     */
    @Contract("!null -> 1; _ -> new")
    static <T> @NotNull Optional<T> auto(final @Nullable Optional<T> optional) {
        return optional != null ? optional : empty();
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
    @Contract
    @Nullable T nullable();

    /**
     * Если обнуляемый объект из-под этой обёртки ненулевой, то возвращает его, иначе генерирует исключение с его
     * именем.
     *
     * @return Ненулевой объект из-под этой обёртки.
     *
     * @since 4.0.0
     */
    @Contract
    default @NotNull T get() throws GetException {
        final var object = nullable();
        if (object == null) throw new GetException();
        return object;
    }

}
