/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

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
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс анализатора объекта.
 *
 * @param <T> тип анализируемого объекта.
 * @param <R> тип результирующего объекта.
 *
 * @since 3.0
 */
@FunctionalInterface
public interface Analyzer<T, R> {

    /**
     * Проверяет результирующий объект и, если он ненулевой, инициализирует анализатор, метод анализа которого всегда
     * возвращает его, в противном случае инициализирует и бросает исключение.
     *
     * @param object результирующий объект.
     *
     * @return Анализатор с постоянным результирующим объектом.
     *
     * @throws NullException исключение валидации нулевого результирующего объекта.
     * @since 3.0
     */
    @Contract(value = "!null -> new; _ -> fail", pure = true)
    static <T, R> @NotNull Analyzer<T, R> constant(final @Nullable R object) throws NullException {
        Validator.notNull(object, "object");
        return ignored -> object;
    }

    /**
     * Проверяет анализатор и, если он ненулевой, возвращает его, в противном случае инициализирует и бросает
     * исключение.
     *
     * @param analyzer анализатор.
     *
     * @return Переданный анализатор.
     *
     * @throws NullException исключение валидации нулевого анализатора.
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу анализатора.
     * @since 3.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static <T, R> @NotNull Analyzer<T, R> of(final @Nullable Analyzer<T, R> analyzer) throws NullException {
        return Validator.notNull(analyzer, "analyzer");
    }

    /**
     * Анализирует переданный объект, инициализирует результирующий объект и возвращает его.
     *
     * @param object анализируемый объект.
     *
     * @return Результирующий объект.
     *
     * @throws NullException исключение валидации нулевого объекта.
     * @throws AnalyzeException исключение анализа объекта.
     * @since 3.0
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
     * @since 3.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <R_> @NotNull Analyzer<T, R_> with(final @Nullable Analyzer<? super R, R_> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return object -> analyzer.analyze(analyze(object));
    }

}
