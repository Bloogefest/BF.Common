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
     * Проверяет переданный результирующий объект и, если тот нулевой, инициализирует и бросает исключение валидации
     * нулевого объекта (переданного результирующего объекта) с переопределённым сообщением (отформатированным именем
     * переданного результирующего объекта шаблонным сообщением), в противном случае инициализирует и возвращает
     * анализатор, метод анализа которого возвращает переданный в этот метод результирующий объект.
     *
     * @param object результирующий объект.
     *
     * @return Новый анализатор, метод анализа которого возвращает переданный в этот метод результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного результирующего объекта).
     * @since 3.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T, R> @NotNull Analyzer<T, R> constant(final @NotNull R object) throws NullException {
        Validator.notNull(object, "object");
        return ignored -> object;
    }

    /**
     * Проверяет анализатор и, если тот ненулевой, возвращает его, в противном случае инициализирует и бросает
     * исключение валидации нулевого объекта (анализатора) с переопределённым сообщением (отформатированным именем
     * анализатора шаблонным сообщением).
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
     * Проверяет анализатор и, если тот ненулевой, инициализирует и возвращает другой анализатор, метод анализа которого
     * сначала вызывает метод анализа этого анализатора, потом вызывает метод анализа переданного в этот метод
     * анализатора, используя результирующий объект этого анализатора, а после возвращает результирующий объект
     * переданного в этот метод анализатора, в противном случае инициализирует и бросает исключение валидации нулевого
     * объекта (анализатора) с переопределённым сообщением (отформатированным именем анализатора шаблонным сообщением).
     *
     * @param analyzer анализатор.
     *
     * @return Новый анализатор, метод анализа которого сначала вызывает метод анализа этого анализатора, потом вызывает
     * метод анализа переданного в этот метод анализатора, используя результирующий объект этого анализатора, а после
     * возвращает результирующий объект переданного в этот метод анализатора.
     *
     * @throws NullException исключение валидации нулевого объекта (анализатора).
     * @since 3.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <R_> @NotNull Analyzer<T, R_> with(final @NotNull Analyzer<? super R, R_> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return object -> analyzer.analyze(analyze(object));
    }

}
