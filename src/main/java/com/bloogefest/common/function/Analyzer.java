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
 * Функциональный интерфейс анализатора экземпляра.
 *
 * @param <T> тип анализируемого экземпляра.
 *
 * @since 3.0
 */
@FunctionalInterface
public interface Analyzer<T> {

    /**
     * Инициализирует экземпляр без логики.
     *
     * @param <T> тип анализируемого экземпляра.
     *
     * @return Экземпляр анализатора без логики.
     *
     * @since 3.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Analyzer<T> empty() {
        return instance -> {
        };
    }

    /**
     * Проверяет переданный экземпляр анализатора и анализируемый экземпляр и, если они ненулевые, инициализирует другой
     * экземпляр анализатора с логикой игнорирования и замены передаваемого ему экземпляра на переданный в этот метод
     * анализируемый экземпляр, в противном случае генерирует исключение.
     *
     * @param analyzer экземпляр анализатора.
     * @param instance анализируемый экземпляр.
     *
     * @return Экземпляр анализатора с постоянным анализируемым экземпляром.
     *
     * @throws NullException исключение проверки экземпляра.
     * @since 3.0
     */
    @Contract(value = "!null, !null -> new; _, _ -> fail", pure = true)
    static <T> @NotNull Analyzer<T> constant(final @Nullable Analyzer<T> analyzer,
                                             final @Nullable T instance) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        Validator.notNull(instance, "instance");
        return ignored -> analyzer.analyze(instance);
    }

    /**
     * Проверяет и возвращает экземпляр, если он ненулевой, в противном случае генерирует исключение.
     *
     * @param analyzer экземпляр анализатора.
     *
     * @return Экземпляр анализатора.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод можно использовать для инициализации лямбда-выражений и приведения их к типу
     * функционального интерфейса анализатора экземпляра.
     * @since 3.0
     */
    @Contract(value = "!null -> param1; _ -> fail", pure = true)
    static <T> @NotNull Analyzer<T> of(final @Nullable Analyzer<T> analyzer) throws NullException {
        return Validator.notNull(analyzer, "analyzer");
    }

    /**
     * Анализирует экземпляр.
     *
     * @param instance анализируемый экземпляр.
     *
     * @throws AnalyzeException исключение анализа экземпляра.
     * @since 3.0
     */
    @Contract(pure = true)
    void analyze(final @NotNull T instance) throws AnalyzeException;

    /**
     * Проверяет и соединяет переданный экземпляр с данным, если он ненулевой, в противном случае генерирует
     * исключение.
     *
     * @param analyzer экземпляр анализатора.
     *
     * @return Экземпляр анализатора.
     *
     * @throws NullException исключение проверки экземпляра.
     * @apiNote Данный метод соединяет переданный экземпляр с данным последовательно за счёт конструкции try-finally,
     * таким образом, сначала гарантированно выполняется логика данного экземпляра, а потом логика переданного.
     * @since 3.0
     */
    @Contract(value = "!null -> new; _ -> fail", pure = true)
    default @NotNull Analyzer<T> with(final @Nullable Analyzer<? super T> analyzer) throws NullException {
        Validator.notNull(analyzer, "analyzer");
        return instance -> {
            try {
                analyze(instance);
            } finally {
                analyzer.analyze(instance);
            }
        };
    }

}
