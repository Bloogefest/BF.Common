/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.Contract;
import com.bloogefest.annotation.NonNull;
import com.bloogefest.annotation.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

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
     * Проверяет переданный анализатор и анализируемый объект и, если те нулевые, генерирует исключение валидации
     * нулевого объекта (переданного анализатора либо анализируемого объекта) с переопределённым сообщением
     * (отформатированным именем переданного анализатора либо анализируемого объекта шаблонным сообщением), в противном
     * случае инициализирует другой анализатор, метод анализа которого вызывает метод анализа переданного в этот метод
     * анализатора, используя переданный в этот метод анализируемый объект, а после возвращает его результирующий
     * объект.
     *
     * @param analyzer анализатор объекта.
     * @param object анализируемый объект.
     *
     * @return Новый анализатор, метод анализа которого вызывает метод анализа переданного в этот метод анализатора,
     * используя переданный в этот метод анализируемый объект, а после возвращает его результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного анализатора либо анализируемого
     * объекта).
     * @since 4.0.0
     */
    @Contract(value = "_, _ -> new")
    static <T, R> @NonNull Analyzer<T, R> constant(final @NonNull Analyzer<? super T, R> analyzer,
                                                   final @NonNull T object) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        Validator.notNull(object, "object");
        return ignored -> analyzer.analyze(object);
    }

    /**
     * Проверяет переданный результирующий объект и, если тот нулевой, генерирует исключение валидации нулевого объекта
     * (переданного результирующего объекта) с переопределённым сообщением (отформатированным именем переданного
     * результирующего объекта шаблонным сообщением), в противном случае инициализирует и возвращает анализатор, метод
     * анализа которого возвращает переданный в этот метод результирующий объект.
     *
     * @param object результирующий объект.
     *
     * @return Новый анализатор, метод анализа которого возвращает переданный в этот метод результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного результирующего объекта).
     * @since 3.0.0
     */
    @Contract(value = "_ -> new")
    static <T, R> @NonNull Analyzer<T, R> constant(final @NonNull R object) throws NullException {
        Validator.notNull(object, "object");
        return ignored -> object;
    }

    /**
     * Проверяет переданный анализатор и, если тот нулевой, генерирует исключение валидации нулевого объекта
     * (переданного анализатора) с переопределённым сообщением (отформатированным именем переданного анализатора
     * шаблонным сообщением), в противном случае возвращает его.
     *
     * @param analyzer анализатор объекта.
     *
     * @return Переданный анализатор.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного анализатора).
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу анализатора объекта.
     * @since 4.0.0-RC3
     */
    @Contract("!null -> 1; _ -> failure")
    static <T, R> @NonNull Analyzer<T, R> check(final @Nullable Analyzer<T, R> analyzer) throws NullException {
        return Validator.notNull(analyzer, "analyzer");
    }

    /**
     * Возвращает переданный анализатор.
     *
     * @param analyzer анализатор объекта.
     *
     * @return Переданный анализатор.
     *
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу анализатора объекта.
     * @since 4.0.0-RC3
     */
    @Contract("_ -> 1")
    static <T, R> @NonNull Analyzer<T, R> lambda(final @NonNull Analyzer<T, R> analyzer) {
        return analyzer;
    }

    /**
     * Анализирует переданный анализируемый объект, инициализирует и возвращает результирующий объект.
     *
     * @param object анализируемый объект.
     *
     * @return Результирующий объект этого анализатора.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного анализируемого объекта).
     * @throws AnalyzeException исключение анализа объекта (переданного анализируемого объекта).
     * @since 3.0.0
     */
    @NonNull R analyze(final @NonNull T object) throws NullException, AnalyzeException;

    /**
     * Проверяет переданный анализатор и, если тот нулевой, генерирует исключение валидации нулевого объекта
     * (переданного анализатора) с переопределённым сообщением (отформатированным именем переданного анализатора
     * шаблонным сообщением), в противном случае инициализирует и возвращает другой анализатор, метод анализа которого
     * сначала вызывает метод анализа этого анализатора, используя передаваемый в него анализируемый объект, потом
     * вызывает метод анализа переданного в этот метод анализатора, используя результирующий объект этого анализатора, а
     * после возвращает его результирующий объект.
     *
     * @param analyzer анализатор объекта.
     *
     * @return Новый анализатор, метод анализа которого сначала вызывает метод анализа этого анализатора, используя свой
     * анализируемый объект, потом вызывает метод анализа переданного в этот метод анализатора, используя результирующий
     * объект этого анализатора, а после возвращает его результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного анализатора).
     * @since 3.0.0
     */
    @Contract("!null -> new; _ -> fail")
    default <R_> @NonNull Analyzer<T, R_> with(final @NonNull Analyzer<? super R, R_> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return object -> analyzer.analyze(analyze(object));
    }

}
