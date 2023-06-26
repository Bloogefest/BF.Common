/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNls;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * Обёртка трёх обнуляемых объектов.
 *
 * @param <T1> тип первичного объекта.
 * @param <T2> тип вторичного объекта.
 * @param <T3> тип третичного объекта.
 *
 * @since 4.0.0-RC3
 */
public interface TriOptional<T1, T2, T3> {

    /**
     * Имя первичного объекта.
     *
     * @since 4.0.0-RC3
     */
    @NotNls @NotNull String FIRST_OBJECT_NAME = "first object";

    /**
     * Имя вторичного объекта.
     *
     * @since 4.0.0-RC3
     */
    @NotNls @NotNull String SECOND_OBJECT_NAME = "second object";

    /**
     * Имя третичного объекта.
     *
     * @since 4.0.0-RC3
     */
    @NotNls @NotNull String THIRD_OBJECT_NAME = "third object";

    /**
     * Имя поставщика первичного объекта.
     *
     * @since 4.0.0-RC3
     */
    @NotNls @NotNull String FIRST_OBJECT_SUPPLIER_NAME = "first object supplier";

    /**
     * Имя поставщика вторичного объекта.
     *
     * @since 4.0.0-RC3
     */
    @NotNls @NotNull String SECOND_OBJECT_SUPPLIER_NAME = "second object supplier";

    /**
     * Имя поставщика третичного объекта.
     *
     * @since 4.0.0-RC3
     */
    @NotNls @NotNull String THIRD_OBJECT_SUPPLIER_NAME = "third object supplier";

    /**
     * Создаёт и возвращает встроенную реализацию на основе объектов (нулевых объектов).
     *
     * @return Встроенная реализация на основе объектов (нулевых объектов).
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    static <T1, T2, T3> @NotNull TriOptional<T1, T2, T3> empty() {
        return new Objects<>(null, null, null);
    }

    /**
     * Проверяет обнуляемые объекты (первичный и вторичный объекты) с помощью
     * {@linkplain Validator#notNull(Object, String)}, а после создаёт и возвращает встроенную реализацию на основе
     * ненулевых объектов (первичного и вторичного объектов).
     *
     * @param first первичный объект.
     * @param second вторичный объект.
     *
     * @return Встроенная реализация по умолчанию на основе ненулевых объектов (первичного и вторичного объектов).
     *
     * @throws NullException исключение проверки нулевого объекта (первичного либо вторичного объекта).
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null -> new; _, _ -> failure")
    static <T1, T2, T3> @NotNull TriOptional<T1, T2, T3> checked(final @NotNull T1 first, final @NotNull T2 second,
                                                                 final @NotNull T3 third) throws NullException {
        return new Objects<>(Validator.notNull(first, FIRST_OBJECT_NAME), Validator.notNull(second, SECOND_OBJECT_NAME),
                             Validator.notNull(third, THIRD_OBJECT_SUPPLIER_NAME));
    }

    /**
     * Создаёт и возвращает встроенную реализацию на основе обнуляемых объектов (первичного и вторичного объектов).
     *
     * @param first первичный объект.
     * @param second вторичный объект.
     *
     * @return Встроенная реализация по умолчанию на основе обнуляемых объектов (первичного и вторичного объектов).
     *
     * @since 4.0.0-RC3
     */
    @Contract("_, _ -> new")
    static <T1, T2, T3> @NotNull TriOptional<T1, T2, T3> unchecked(final @Nullable T1 first, final @Nullable T2 second,
                                                                   final @Nullable T3 third) {
        return new Objects<>(first, second, third);
    }

    /**
     * Проверяет обнуляемые объекты (поставщики первичного и вторичного объектов) с помощью
     * {@linkplain Validator#notNull(Object, String)}, а после создаёт и возвращает встроенную реализацию на основе
     * поставщиков (поставщиков первичного и вторичного объектов).
     *
     * @param first поставщик первичного объекта.
     * @param second поставщик вторичного объекта.
     *
     * @return Встроенная реализация по умолчанию на основе поставщиков (поставщиков первичного и вторичного объектов).
     *
     * @throws NullException исключение проверки нулевого объекта (поставщика первичного либо вторичного объекта).
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null -> new; _, _ -> failure")
    static <T1, T2, T3> @NotNull TriOptional<T1, T2, T3> suppliers(final @NotNull Supplier<T1> first,
                                                                   final @NotNull Supplier<T2> second,
                                                                   final @NotNull Supplier<T3> third) throws NullException {
        return new Suppliers<>(Validator.notNull(first, FIRST_OBJECT_SUPPLIER_NAME),
                               Validator.notNull(second, SECOND_OBJECT_SUPPLIER_NAME),
                               Validator.notNull(third, THIRD_OBJECT_SUPPLIER_NAME));
    }

    /**
     * Проверяет обнуляемую обёртку (обёртку трёх обнуляемых объектов), и если она ненулевая, то возвращает её, в
     * противном случае создаёт и возвращает встроенную реализацию на основе объектов (нулевых объектов).
     *
     * @param optional обёртка трёх обнуляемых объектов.
     *
     * @return Ненулевая обёртка трёх обнуляемых объектов либо встроенная реализация на основе объектов (нулевых
     * объектов).
     *
     * @apiNote Используйте для безопасного использования обёртки трёх обнуляемых объектов.
     * @since 4.0.0-RC3
     */
    @Contract("!null -> 1; _ -> new")
    static <T1, T2, T3> @NotNull TriOptional<T1, T2, T3> auto(final @Nullable TriOptional<T1, T2, T3> optional) {
        return optional != null ? optional : empty();
    }

    /**
     * Возвращает обёртку (обёртку трёх обнуляемых объектов).
     *
     * @param optional обёртка трёх обнуляемый объектов.
     *
     * @return Обёртка трёх обнуляемых объектов.
     *
     * @apiNote Используйте для приведения лямбда-выражений к типу обёртки трёх обнуляемых объектов.
     * @since 4.0.0-RC3
     */
    @Contract("_ -> 1")
    static <T1, T2, T3> @NotNull TriOptional<T1, T2, T3> lambda(final @NotNull TriOptional<T1, T2, T3> optional) {
        return optional;
    }

    /**
     * Возвращает обнуляемый объект (первичный объект).
     *
     * @return Обнуляемый объект (первичный объект).
     *
     * @since 4.0.0-RC3
     */
    @Nullable T1 first();

    /**
     * Возвращает обнуляемый объект (вторичный объект).
     *
     * @return Обнуляемый объект (вторичный объект).
     *
     * @since 4.0.0-RC3
     */
    @Nullable T2 second();

    /**
     * Возвращает обнуляемый объект (третичный объект).
     *
     * @return Обнуляемый объект (третичный объект).
     *
     * @since 4.0.0-RC3
     */
    @Nullable T3 third();

    /**
     * Проверяет обнуляемый объект (первичный объект) с помощью метода {@linkplain Validator#notNull(Object, String)} и
     * возвращает его.
     *
     * @return Ненулевой объект (первичный объект).
     *
     * @throws NullException исключение проверки нулевого объекта (первичного объекта).
     * @since 4.0.0-RC3
     */
    default @NotNull T1 toFirst() throws NullException {
        return Validator.notNull(first(), FIRST_OBJECT_NAME);
    }

    /**
     * Проверяет обнуляемый объект (вторичный объект) с помощью метода {@linkplain Validator#notNull(Object, String)} и
     * возвращает его.
     *
     * @return Ненулевой объект (вторичный объект).
     *
     * @throws NullException исключение проверки нулевого объекта (вторичного объекта).
     * @since 4.0.0-RC3
     */
    default @NotNull T2 toSecond() throws NullException {
        return Validator.notNull(second(), SECOND_OBJECT_NAME);
    }

    /**
     * Проверяет обнуляемый объект (третичный объект) с помощью метода {@linkplain Validator#notNull(Object, String)} и
     * возвращает его.
     *
     * @return Ненулевой объект (третичный объект).
     *
     * @throws NullException исключение проверки нулевого объекта (третичного объекта).
     * @since 4.0.0-RC3
     */
    default @NotNull T3 toThird() throws NullException {
        return Validator.notNull(third(), THIRD_OBJECT_NAME);
    }

    /**
     * Оборачивает обнуляемый объект (первичный объект) с помощью метода {@linkplain Optional#auto(Object)} и возвращает
     * обёртку обнуляемого объекта (обёртку первичного объекта).
     *
     * @return Ненулевая обёртка обнуляемого объекта (обёртка первичного объекта).
     *
     * @since 4.0.0-RC3
     */
    default @NotNull Optional<T1> asFirst() {
        return Optional.auto(first());
    }

    /**
     * Оборачивает обнуляемый объект (вторичный объект) с помощью метода {@linkplain Optional#auto(Object)} и возвращает
     * обёртку обнуляемого объекта (обёртку вторичного объекта).
     *
     * @return Ненулевая обёртка обнуляемого объекта (обёртка вторичного объекта).
     *
     * @since 4.0.0-RC3
     */
    default @NotNull Optional<T2> asSecond() {
        return Optional.auto(second());
    }

    /**
     * Оборачивает обнуляемый объект (третичный объект) с помощью метода {@linkplain Optional#auto(Object)} и возвращает
     * обёртку обнуляемого объекта (обёртку третичного объекта).
     *
     * @return Ненулевая обёртка обнуляемого объекта (обёртка третичного объекта).
     *
     * @since 4.0.0-RC3
     */
    default @NotNull Optional<T3> asThird() {
        return Optional.auto(third());
    }


    /**
     * Встроенная реализация на основе объектов (первичного, вторичного и третичного объектов).
     *
     * @since 4.0.0-RC3
     */
    final class Objects<T1, T2, T3> implements TriOptional<T1, T2, T3> {

        /**
         * Первичный объект.
         *
         * @since 4.0.0-RC3
         */
        private final @Nullable T1 first;

        /**
         * Вторичный объект.
         *
         * @since 4.0.0-RC3
         */
        private final @Nullable T2 second;

        /**
         * Третичный объект.
         *
         * @since 4.0.0-RC3
         */
        private final @Nullable T3 third;

        /**
         * Создаёт встроенную реализацию на основе объектов (первичного, вторичного и третичного объектов).
         *
         * @param first первичный объект.
         * @param second вторичный объект.
         * @param third третичный объект.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_, _ -> new")
        private Objects(final @Nullable T1 first, final @Nullable T2 second, final @Nullable T3 third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        /**
         * Возвращает обнуляемый объект (первичный объект).
         *
         * @return Обнуляемый объект (первичный объект).
         *
         * @since 4.0.0-RC3
         */
        @Override
        public @Nullable T1 first() {
            return first;
        }

        /**
         * Возвращает обнуляемый объект (вторичный объект).
         *
         * @return Обнуляемый объект (вторичный объект).
         *
         * @since 4.0.0-RC3
         */
        @Override
        public @Nullable T2 second() {
            return second;
        }

        /**
         * Возвращает обнуляемый объект (третичный объект).
         *
         * @return Обнуляемый объект (третичный объект).
         *
         * @since 4.0.0-RC3
         */
        @Override
        public @Nullable T3 third() {
            return third;
        }

    }

    /**
     * Встроенная реализация на основе поставщиков (поставщиков первичного, вторичного и третичного объектов).
     *
     * @since 4.0.0-RC3
     */
    final class Suppliers<T1, T2, T3> implements TriOptional<T1, T2, T3> {

        /**
         * Поставщик первичного объекта.
         *
         * @since 4.0.0-RC3
         */
        private final @NotNull Supplier<T1> first;

        /**
         * Поставщик вторичного объекта.
         *
         * @since 4.0.0-RC3
         */
        private final @NotNull Supplier<T2> second;

        /**
         * Поставщик третичного объекта.
         *
         * @since 4.0.0-RC3
         */
        private final @NotNull Supplier<T3> third;

        /**
         * Создаёт встроенную реализацию на основе поставщиков (поставщиков первичного, вторичного и третичного
         * объектов).
         *
         * @param first поставщик первичного объекта.
         * @param second поставщик вторичного объекта.
         * @param third поставщик третичного объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_, _ -> new")
        private Suppliers(final @NotNull Supplier<T1> first, final @NotNull Supplier<T2> second,
                          final @NotNull Supplier<T3> third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        /**
         * Получает у поставщика (поставщика первичного объекта) обнуляемый объект (первичный объект) и возвращает его.
         *
         * @return Обнуляемый объект (первичный объект).
         *
         * @throws GetException исключение получения объекта (первичного объекта).
         * @since 4.0.0-RC3
         */
        @Override
        public @Nullable T1 first() throws GetException {
            try {
                return first.get();
            } catch (final @NotNull Exception failure) {
                throw new GetException(failure);
            }
        }

        /**
         * Получает у поставщика (поставщика вторичного объекта) обнуляемый объект (вторичный объект) и возвращает его.
         *
         * @return Обнуляемый объект (вторичный объект).
         *
         * @throws GetException исключение получения объекта (вторичного объекта).
         * @since 4.0.0-RC3
         */
        @Override
        public @Nullable T2 second() throws GetException {
            try {
                return second.get();
            } catch (final @NotNull Exception failure) {
                throw new GetException(failure);
            }
        }

        /**
         * Получает у поставщика (поставщика третичного объекта) обнуляемый объект (третичный объект) и возвращает его.
         *
         * @return Обнуляемый объект (третичный объект).
         *
         * @throws GetException исключение получения объекта (третичного объекта).
         * @since 4.0.0-RC3
         */
        @Override
        public @Nullable T3 third() throws GetException {
            try {
                return third.get();
            } catch (final @NotNull Exception failure) {
                throw new GetException(failure);
            }
        }

        /**
         * Проверяет обнуляемый объект (первичный объект) с помощью метода
         * {@linkplain Validator#notNull(Object, String)} и возвращает его.
         *
         * @return Ненулевой объект (первичный объект).
         *
         * @throws GetException исключение получения объекта (первичного объекта).
         * @throws NullException исключение проверки нулевого объекта (первичного объекта).
         * @since 4.0.0-RC3
         */
        @Override
        public @NotNull T1 toFirst() throws GetException, NullException {
            return Validator.notNull(first(), FIRST_OBJECT_NAME);
        }

        /**
         * Проверяет обнуляемый объект (вторичный объект) с помощью метода
         * {@linkplain Validator#notNull(Object, String)} и возвращает его.
         *
         * @return Ненулевой объект (вторичный объект).
         *
         * @throws GetException исключение получения объекта (вторичного объекта).
         * @throws NullException исключение проверки нулевого объекта (вторичного объекта).
         * @since 4.0.0-RC3
         */
        @Override
        public @NotNull T2 toSecond() throws GetException, NullException {
            return Validator.notNull(second(), SECOND_OBJECT_NAME);
        }

        /**
         * Проверяет обнуляемый объект (третичный объект) с помощью метода
         * {@linkplain Validator#notNull(Object, String)} и возвращает его.
         *
         * @return Ненулевой объект (третичный объект).
         *
         * @throws GetException исключение получения объекта (третичного объекта).
         * @throws NullException исключение проверки нулевого объекта (третичного объекта).
         * @since 4.0.0-RC3
         */
        @Override
        public @NotNull T3 toThird() throws GetException, NullException {
            return Validator.notNull(third(), THIRD_OBJECT_NAME);
        }

    }

}
