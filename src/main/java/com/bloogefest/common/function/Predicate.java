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
 * Функциональный интерфейс предиката.
 *
 * @param <T> оцениваемый тип.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Инициализирует предикат с постоянным результатом вычисления.
     *
     * @param result постоянный результат вычисления.
     *
     * @return Предикат с постоянным результатом вычисления.
     *
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Predicate<T> constant(final boolean result) {
        return object -> result;
    }

    /**
     * Проверяет и возвращает предикат, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param predicate предикат.
     *
     * @return Ненулевой предикат.
     *
     * @throws NullException предикат не должен быть нулевым.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Predicate<T> of(final @NotNull Predicate<T> predicate) throws NullException {
        return Validator.notNull(predicate, "predicate");
    }

    /**
     * Оценивает объект.
     *
     * @param object объект.
     *
     * @return Результат оценки.
     *
     * @throws NullException объект не должен быть нулевым.
     * @throws EvaluateException исключение оценивания объекта.
     * @since 1.0
     */
    @Contract(pure = true)
    boolean evaluate(final @NotNull T object) throws NullException, EvaluateException;

    /**
     * Инвертирует предикат.
     *
     * @return Инвертированный предикат.
     *
     * @since 1.0
     */
    @Contract(value = "-> new", pure = true)
    default @NotNull Predicate<T> invert() {
        return object -> !evaluate(object);
    }

    /**
     * Соединяет конъюнкцией этот и вторичный предикат.
     *
     * @param predicate вторичный предикат.
     *
     * @return Соединённый конъюнкцией этот и вторичный предикат.
     *
     * @throws NullException вторичный предикат не должен быть нулевым.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> and(final @NotNull Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) && predicate.evaluate(object);
    }

    /**
     * Соединяет строгой дизъюнкцией этот и вторичный предикат.
     *
     * @param predicate вторичный предикат.
     *
     * @return Соединённый строгой дизъюнкцией этот и вторичный предикат.
     *
     * @throws NullException вторичный предикат не должен быть нулевым.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> xor(final @NotNull Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) ^ predicate.evaluate(object);
    }

    /**
     * Соединяет мягкой дизъюнкцией этот и вторичный предикат.
     *
     * @param predicate вторичный предикат.
     *
     * @return Соединённый мягкой дизъюнкцией этот и вторичный предикат.
     *
     * @throws NullException вторичный предикат не должен быть нулевым.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> or(final @NotNull Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) || predicate.evaluate(object);
    }

}
