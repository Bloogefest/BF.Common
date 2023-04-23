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
     * Возвращает объект из-под этой обёртки.
     *
     * @return Обнуляемый объект из-под этой обёртки.
     *
     * @since 4.0.0
     */
    @Contract
    @Nullable T nullable();

    /**
     * Если объект из-под этой обёртки ненулевой, то возвращает его, в противном случае генерирует исключение с его
     * именем.
     *
     * @return Ненулевой объект из-под этой обёртки.
     *
     * @throws NullException исключение проверки нулевого объекта.
     * @since 4.0.0
     */
    @Contract
    default @NotNull T get() throws NullException {
        return Validator.notNull(nullable(), "object");
    }

    /**
     * Если объект из-под этой обёртки ненулевой, то возвращает истину, в противном случае возвращает ложь.
     *
     * @return Является ли объект из-под этой обёртки ненулевым.
     *
     * @since 4.0.0
     */
    @Contract
    default boolean has() {
        return nullable() != null;
    }

    /**
     * Если объект из-под этой обёртки нулевой, то возвращает истину, в противном случае возвращает ложь.
     *
     * @return Является ли объект из-под этой обёртки нулевым.
     *
     * @since 4.0.0
     */
    @Contract
    default boolean hasNot() {
        return !has();
    }

    /**
     * Если объект из-под этой обёртки ненулевой, то возвращает его, в противном случае возвращает переданный объект.
     *
     * @param object обнуляемый объект.
     *
     * @return Ненулевой объект из-под этой обёртки либо переданный объект.
     *
     * @throws NullException исключение проверки нулевого объекта.
     * @since 4.0.0
     */
    @Contract("!null -> !null; _ -> _")
    default @NotNull T otherwise(final @Nullable T object) throws NullException {
        Validator.notNull(object, "object");
        final @Nullable var nullable = nullable();
        return nullable != null ? nullable : object;
    }

    /**
     * Если объект из-под этой обёртки ненулевой, то возвращает его, в противном случае получает и бросает исключение
     * поставщика.
     *
     * @param supplier поставщик исключения.
     *
     * @return Ненулевой объект из-под этой обёртки.
     *
     * @throws NullException исключение проверки нулевого объекта либо нулевого исключения поставщика.
     * @throws E исключение поставщика.
     * @since 4.0.0
     */
    @Contract("!null -> !null; _ -> _")
    default <E extends Throwable> @NotNull T otherwise(final @NotNull Supplier<E> supplier) throws NullException, E {
        Validator.notNull(supplier, "supplier");
        final @Nullable var nullable = nullable();
        if (nullable == null) throw Validator.notNull(supplier.supply(), "failure");
        return nullable;
    }

}
