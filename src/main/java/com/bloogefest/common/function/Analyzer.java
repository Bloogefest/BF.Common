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
 * Анализатор объектов.
 *
 * @param <T> тип анализируемого объекта.
 *
 * @since 3.0
 */
@FunctionalInterface
public interface Analyzer<T> {

    /**
     * Инициализирует анализатор без логики.
     *
     * @return Анализатор без логики.
     *
     * @since 3.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Analyzer<T> empty() {
        return ignored -> {};
    }

    /**
     * Проверяет переданный анализатор и анализируемый объект и, если они ненулевые, инициализирует другой анализатор,
     * метод анализа которого всегда вызывает метод анализа переданного анализатора, используя переданный анализируемый
     * объект, в противном случае генерирует исключение.
     *
     * @param analyzer анализатор.
     * @param object анализируемый объект.
     *
     * @return Анализатор с постоянным анализируемым объектом.
     *
     * @throws NullException исключение валидации нулевого анализатора либо анализируемого объекта.
     * @since 3.0
     */
    @Contract(value = "!null, !null -> new; _, _ -> fail", pure = true)
    static <T> @NotNull Analyzer<T> constant(final @Nullable Analyzer<T> analyzer,
                                             final @Nullable T object) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        Validator.notNull(object, "object");
        return ignored -> analyzer.analyze(object);
    }

    /**
     * Проверяет анализатор и, если он ненулевой, возвращает его, в противном случае генерирует исключение.
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
    static <T> @NotNull Analyzer<T> of(final @Nullable Analyzer<T> analyzer) throws NullException {
        return Validator.notNull(analyzer, "analyzer");
    }

    /**
     * Проверяет анализатор и, если он ненулевой, возвращает его, в противном случае инициализирует и возвращает
     * другой анализатор без логики.
     *
     * @param analyzer анализатор.
     *
     * @return Переданный либо другой анализатор.
     *
     * @since 3.0
     */
    @Contract(value = "!null -> param1; _ -> new", pure = true)
    static <T> @NotNull Analyzer<T> auto(final @Nullable Analyzer<T> analyzer) {
        return analyzer != null ? analyzer : empty();
    }

    /**
     * Анализирует объект.
     *
     * @param object анализируемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта.
     * @throws AnalyzeException исключение анализа объекта.
     * @since 3.0
     */
    @Contract
    void analyze(final @Nullable T object) throws NullException, AnalyzeException;

    /**
     * Проверяет переданный анализатор и, если он ненулевой, инициализирует другой анализатор, метод анализа которого
     * последовательно соединяет метод анализа этого и переданного анализатора, используя конструкцию try-finally, в
     * противном случае генерирует исключение.
     *
     * @param analyzer анализатор.
     *
     * @return Анализатор, метод анализа которого последовательно соединяет метод анализа этого и переданного
     * анализатора, используя конструкцию try-finally.
     *
     * @throws NullException исключение валидации нулевого анализатора.
     * @since 3.0
     */
    @Contract(value = "!null -> new; _ -> fail", pure = true)
    default @NotNull Analyzer<T> with(final @Nullable Analyzer<? super T> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return object -> {
            try {
                analyze(object);
            } finally {
                analyzer.analyze(object);
            }
        };
    }

}
