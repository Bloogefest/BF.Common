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
 * Функциональный интерфейс анализатора объекта.
 *
 * @param <T> тип анализируемого объекта.
 * @param <R> тип результирующего объекта.
 *
 * @since 3.0.0
 */
@FunctionalInterface
public interface Analyzer<T, R> {

    /**
     * Проверяет результирующий объект и, если тот ненулевой, инициализирует анализатор, метод анализа которого всегда
     * возвращает переданный в этот метод результирующий объект, в противном случае инициализирует и бросает исключение
     * валидации нулевого объекта (результирующего объекта).
     *
     * @param object результирующий объект.
     *
     * @return Новый анализатор, метод анализа которого всегда возвращает переданный в этот метод результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта (результирующего объекта).
     * @since 3.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T, R> @NotNull Analyzer<T, R> constant(final @NotNull R object) throws NullException {
        Validator.notNull(object, "object");
        return ignored -> object;
    }

    /**
     * Проверяет анализатор и, если тот ненулевой, возвращает его, в противном случае инициализирует и бросает
     * исключение валидации нулевого объекта (анализатора).
     *
     * @param analyzer анализатор.
     *
     * @return Переданный анализатор.
     *
     * @throws NullException исключение валидации нулевого объекта (анализатора).
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу анализатора.
     * @since 3.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T, R> @NotNull Analyzer<T, R> of(final @NotNull Analyzer<T, R> analyzer) throws NullException {
        return Validator.notNull(analyzer, "analyzer");
    }

    /**
     * Анализирует объект, инициализирует и возвращает результирующий объект.
     *
     * @param object анализируемый объект.
     *
     * @return Результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта (анализируемого объекта).
     * @throws AnalyzeException исключение анализа объекта (анализируемого объекта).
     * @since 3.0.0
     */
    @Contract
    @NotNull R analyze(final @NotNull T object) throws NullException, AnalyzeException;

    /**
     * Проверяет переданный анализатор и, если он ненулевой, инициализирует другой анализатор, метод анализа которого
     * последовательно соединяет метод анализа этого и переданного анализатора, используя конструкцию try-finally, в
     * противном случае инициализирует и бросает исключение.
     *
     * @param analyzer объект анализатора.
     *
     * @return Анализатор с комбинированной логикой этого и переданного анализатора.
     *
     * @throws NullException исключение валидации нулевого анализатора.
     * @since 3.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <R_> @NotNull Analyzer<T, R_> with(final @NotNull Analyzer<? super R, R_> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return object -> analyzer.analyze(analyze(object));
    }

}
