/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.*;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * Поставщик объекта — это функциональный инструмент, способный поставлять объект. Он предоставляет методы для его
 * получения ({@linkplain #get()}, {@linkplain #withNullable()}, {@linkplain #withAnother(Object)},
 * {@linkplain #withSupplier(Supplier)}, {@linkplain #withThrowable(Supplier)}).
 *
 * @param <T> тип объекта.
 *
 * @see Without
 * @see With
 * @see #without()
 * @see #with(Object)
 * @since 1.0.0
 */
@Experimental("4.0.0-RC5")
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Создаёт и возвращает {@linkplain Without интегрированную реализацию поставщика несуществующего объекта}.
     *
     * @return {@linkplain Without#Without() Интегрированную реализацию поставщика несуществующего объекта}.
     *
     * @see Without#Without()
     * @see #with(Object)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("_ -> new")
    static <T> @NotNull Supplier<T> without() {
        return new Without<>();
    }

    /**
     * Создаёт и возвращает {@linkplain With интегрированную реализацию поставщика существующего объекта} (переданного
     * объекта).
     *
     * @param <T> тип объекта.
     * @param object объект.
     *
     * @return {@linkplain With Интегрированную реализацию поставщика существующего объекта} (переданного объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного объекта).
     * @see With#With(Object)
     * @see #without()
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("_ -> new")
    static <T> @NotNull Supplier<T> with(final @Nullable T object) throws NullException {
        return new With<>(object);
    }

    /**
     * Проверяет переданный поставляемый объект и, если тот нулевой, генерирует исключение валидации нулевого объекта
     * (переданного поставляемого объекта) с переопределённым сообщением (отформатированным именем переданного
     * поставляемого объекта шаблонным сообщением), в противном случае инициализирует и возвращает поставщик, метод
     * поставки которого возвращает переданный в этот метод поставляемый объект.
     *
     * @param object поставляемый объект.
     *
     * @return Новый поставщик, метод поставки которого возвращает переданный в этот метод поставляемый объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставляемого объекта).
     * @since 1.0.0
     * @deprecated Используйте {@linkplain #with(Object)}, но вместе с {@linkplain Validator#notNull(Object, String)}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.Supplier::with(Object)")
    @Contract("!null -> new; _ -> fail")
    static <T> @NotNull Supplier<T> constant(final @NotNull T object) throws NullException {
        return with(Validator.notNull(object, "The passed object"));
    }

    /**
     * Проверяет переданный поставщик и, если тот нулевой, генерирует исключение валидации нулевого объекта (переданного
     * поставщика) с переопределённым сообщением (отформатированным именем переданного поставщика шаблонным сообщением),
     * в противном случае возвращает его.
     *
     * @param supplier поставщик объекта.
     *
     * @return Переданный поставщик.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставщика).
     * @since 1.0.0
     * @deprecated Используйте {@linkplain Validator#notNull(Object, String)} самостоятельно.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.validation.Validation::notNull(Object, String)")
    @Contract("!null -> 1; _ -> fail")
    static <T> @NotNull Supplier<T> of(final @NotNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Возвращает переданный поставщик объекта.
     *
     * @param supplier поставщик объекта.
     *
     * @return Переданный поставщик объекта.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставщика).
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("!null -> 1; _ -> fail")
    static <T> @NotNull Supplier<T> lambda(final @NotNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "The passed supplier");
    }

    /**
     * Возвращает переданный поставщик.
     *
     * @param supplier поставщик объекта.
     *
     * @return Переданный поставщик.
     *
     * @apiNote Этот метод можно использовать для приведения лямбда-выражений к типу поставщика объекта.
     * @since 4.0.0
     * @deprecated Используйте {@linkplain #lambda(Supplier)}, но учтите, что он использует
     * {@linkplain Validator#notNull(Object, String)}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.Supplier::lambda(Supplier)")
    @Contract("_ -> 1")
    static <T> @NotNull Supplier<T> as(final @NotNull Supplier<T> supplier) {
        return supplier;
    }


    /**
     * Получает и возвращает текущий объект.
     *
     * @return Текущий объект.
     *
     * @throws GetException исключение получения объекта (текущего объекта).
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("-> _")
    @Nullable T get() throws GetException;

    /**
     * Поставляет поставляемый объект.
     *
     * @return Поставляемый объект этого поставщика.
     *
     * @throws SupplyException исключение поставки объекта (поставляемого объекта этого поставщика).
     * @since 1.0.0
     * @deprecated Используйте {@linkplain #get()}, но учтите, что может вернуть нулевой объект.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.Supplier::lambda(Supplier)")
    @Contract("-> ")
    default @NotNull T supply() throws SupplyException {
        final @Nullable var object = get();
        if (object == null) throw new SupplyException(SupplyException.TEMPLATE_MESSAGE.formatted("the current object"));
        return object;
    }

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает его, в противном случае — нулевой.
     *
     * @return Текущий или нулевой объект.
     *
     * @see #get()
     * @see #withAnother(Object)
     * @see #withSupplier(Supplier)
     * @see #withThrowable(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5")
    @Contract("-> _")
    default @Nullable T withNullable() {
        return withAnother(null);
    }

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает его, в противном случае — переданный.
     *
     * @param object объект.
     *
     * @return Текущий или переданный объект.
     *
     * @see #get()
     * @see #withNullable()
     * @see #withSupplier(Supplier)
     * @see #withThrowable(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5")
    @Contract("_ -> _")
    default @Nullable T withAnother(final @Nullable T object) {
        try {
            return get();
        } catch (final @NotNull GetException e) {
            return object;
        }
    }

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает его, в противном случае получает и возвращает
     * объект от переданного поставщика.
     *
     * @param supplier поставщик объекта.
     *
     * @return Текущий или полученный от переданного поставщика объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставщика объекта).
     * @throws GetException исключение получения объекта (поставляемого переданным поставщиком объекта).
     * @see #get()
     * @see #withNullable()
     * @see #withAnother(Object)
     * @see #withThrowable(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5")
    @Contract("!null -> _; _ -> fail")
    default @Nullable T withSupplier(final @NotNull Supplier<? extends T> supplier) throws NullException, GetException {
        Validator.notNull(supplier, "The passed supplier of an object");
        try {
            return get();
        } catch (final @NotNull GetException e) {
            return supplier.get();
        }
    }

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает его, в противном случае получает и бросает
     * исключение от переданного поставщика исключения.
     *
     * @param supplier поставщик исключения.
     *
     * @return Текущий объект.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного поставщика исключения или поставляемого
     * им исключения).
     * @throws GetException исключение получения объекта (поставляемого переданным поставщиком исключения).
     * @throws F поставляемое переданным поставщиком исключение.
     * @see #get()
     * @see #withNullable()
     * @see #withAnother(Object)
     * @see #withSupplier(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5")
    @Contract("!null -> _; _ -> fail")
    default <F extends Throwable> @Nullable T withThrowable(
            final @NotNull Supplier<F> supplier) throws NullException, GetException, F {
        Validator.notNull(supplier, "The passed supplier of a throwable");
        try {
            return get();
        } catch (final @NotNull GetException e) {
            throw Validator.notNull(supplier.get(), "A throwable supplied by the passed supplier");
        }
    }

    /**
     * Интегрированная реализация поставщика несуществующего объекта.
     *
     * @see Supplier
     * @see With
     * @see #Without()
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5") class Without<T> implements Supplier<T> {


        /**
         * Создаёт интегрированную реализацию поставщика несуществующего объекта.
         *
         * @since 4.0.0-RC3
         */
        public Without() {}

        /**
         * Генерирует исключение получения объекта (текущего объекта).
         *
         * @throws GetException исключение получения объекта (текущего объекта).
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        @Contract("-> fail")
        public @Null T get() throws GetException {
            throw new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object"));
        }

        /**
         * Возвращает нулевой объект.
         *
         * @return Нулевой объект.
         *
         * @see #get()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("-> null")
        public @Null T withNullable() {
            return null;
        }

        /**
         * Возвращает переданный объект.
         *
         * @param object объект.
         *
         * @return Переданный объект.
         *
         * @see #get()
         * @see #withNullable()
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("_ -> 1")
        public @Nullable T withAnother(final @Nullable T object) {
            return object;
        }

        /**
         * Получает и возвращает объект от переданного поставщика.
         *
         * @param supplier поставщик объекта.
         *
         * @return Полученный от переданного поставщика объект.
         *
         * @throws NullException исключение валидации нулевого объекта (переданного поставщика объекта).
         * @throws GetException исключение получения объекта (поставляемого переданным поставщиком объекта).
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("!null -> _; _ -> fail")
        public @Nullable T withSupplier(
                final @NotNull Supplier<? extends T> supplier) throws NullException, GetException {
            return Validator.notNull(supplier, "The passed supplier of an object").get();
        }

        /**
         * Получает и бросает исключение от переданного поставщика исключения.
         *
         * @param supplier поставщик исключения.
         *
         * @throws NullException исключение валидации нулевого объекта (переданного поставщика исключения или
         * поставляемого им исключения).
         * @throws GetException исключение получения объекта (поставляемого переданным поставщиком исключения).
         * @throws F поставляемое переданным поставщиком исключение.
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("_ -> fail")
        public <F extends Throwable> @Null T withThrowable(
                final @NotNull Supplier<F> supplier) throws NullException, GetException, F {
            throw Validator.notNull(Validator.notNull(supplier, "The passed supplier of a throwable").get(),
                                    "A throwable supplied by the passed supplier");
        }

    }

    /**
     * Интегрированная реализация поставщика существующего объекта.
     *
     * @see Supplier
     * @see Without
     * @see #With(Object)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5") class With<T> implements Supplier<T> {

        /**
         * Текущий объект.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        private final @NotNull T object;

        /**
         * Создаёт интегрированную реализацию поставщика существующего объекта (переданного объекта).
         *
         * @param object объект.
         *
         * @throws NullException исключение валидации нулевого объекта (переданного объекта).
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        @Contract("!null -> new; _ -> fail")
        public With(final @NotNull T object) throws NullException {
            this.object = Validator.notNull(object, "The passed object");
        }

        /**
         * Возвращает {@linkplain #object текущий объект}.
         *
         * @return {@linkplain #object Текущий объект}.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        @Contract("-> const")
        public @Nullable T get() {
            return object;
        }

        /**
         * Возвращает {@linkplain #object текущий объект}.
         *
         * @return {@linkplain #object Текущий объект}.
         *
         * @see #get()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("-> const")
        public @Nullable T withNullable() {
            return object;
        }

        /**
         * Возвращает {@linkplain #object текущий объект}.
         *
         * @param object объект.
         *
         * @return {@linkplain #object Текущий объект}.
         *
         * @see #get()
         * @see #withNullable()
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("_ -> const")
        public @Nullable T withAnother(final @Nullable T object) {
            return this.object;
        }

        /**
         * Возвращает {@linkplain #object текущий объект}.
         *
         * @param supplier поставщик объекта.
         *
         * @return {@linkplain #object Текущий объект}.
         *
         * @throws NullException исключение валидации нулевого объекта (переданного поставщика объекта).
         * @throws GetException исключение получения объекта (поставляемого переданным поставщиком объекта).
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("!null -> const; _ -> fail")
        public @Nullable T withSupplier(
                final @NotNull Supplier<? extends T> supplier) throws NullException, GetException {
            Validator.notNull(supplier, "The passed supplier of an object");
            return object;
        }

        /**
         * Возвращает {@linkplain #object текущий объект}.
         *
         * @param supplier поставщик исключения.
         *
         * @return {@linkplain #object Текущий объект}.
         *
         * @throws NullException исключение валидации нулевого объекта (переданного поставщика исключения).
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("!null -> const; _ -> fail")
        public <F extends Throwable> @Nullable T withThrowable(
                final @NotNull Supplier<F> supplier) throws NullException {
            Validator.notNull(supplier, "The passed supplier of a throwable");
            return object;
        }

    }

}
