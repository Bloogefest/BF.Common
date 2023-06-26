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
 * Обёртка объекта — это функциональный инструмент, способный содержать объект. Он предоставляет методы для получения
 * ({@linkplain #get()}, {@linkplain #withNullable()}, {@linkplain #withAnother(Object)},
 * {@linkplain #withSupplier(Supplier)}, {@linkplain #withThrowable(Supplier)}) и проверки его существования
 * ({@linkplain #contains()}).
 *
 * @param <T> тип объекта.
 *
 * @see Without
 * @see With
 * @see #without()
 * @see #with(Object)
 * @see #auto(Object)
 * @since 4.0.0-RC2
 */
@Experimental("4.0.0-RC5")
public interface Optional<T> {

    /**
     * Создаёт и возвращает {@linkplain Without интегрированную реализацию обёртки несуществующего объекта}.
     *
     * @param <T> тип объекта.
     *
     * @return {@linkplain Without Интегрированную реализацию обёртки несуществующего объекта}.
     *
     * @see Without#Without()
     * @see #with(Object)
     * @see #auto(Object)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("-> new")
    static <T> @NotNull Optional<T> without() {
        return new Without<>();
    }

    /**
     * Создаёт и возвращает встроенную реализацию на основе объекта (нулевого объекта).
     *
     * @return Встроенная реализация на основе объекта (нулевого объекта).
     *
     * @since 4.0.0-RC2
     * @deprecated Используйте {@linkplain #with(Object)}, но вместе с {@linkplain Validator#notNull(Object, String)}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.Optional::without()")
    @Contract("-> new")
    static <T> @NotNull Optional<T> empty() {
        return without();
    }

    /**
     * Создаёт и возвращает {@linkplain With интегрированную реализацию обёртки существующего объекта} (переданного
     * объекта).
     *
     * @param <T> тип объекта.
     * @param object объект.
     *
     * @return {@linkplain With Интегрированную реализацию обёртки существующего объекта} (переданного объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного объекта).
     * @see With#With(Object)
     * @see #without()
     * @see #auto(Object)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("!null -> new; _ -> fail")
    static <T> @NotNull Optional<T> with(final @NotNull T object) throws NullException {
        return new With<>(object);
    }

    /**
     * Проверяет обнуляемый объект (объект) с помощью {@linkplain Validator#notNull(Object, String)}, а после создаёт и
     * возвращает встроенную реализацию на основе на основе ненулевого объекта (объекта).
     *
     * @param object объект.
     *
     * @return Встроенная реализация по умолчанию на основе ненулевого объекта (объекта).
     *
     * @throws NullException исключение проверки нулевого объекта (объекта).
     * @since 4.0.0-RC2
     * @deprecated Используйте {@linkplain #with(Object)}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.Optional::with(Object)")
    @Contract("!null -> new; _ -> fail")
    static <T> @NotNull Optional<T> of(final @NotNull T object) throws NullException {
        return with(object);
    }

    /**
     * Если переданный объект ненулевой, то создаёт и возвращает
     * {@linkplain With интегрированную реализацию обёртки существующего объекта} (переданного объекта), в противном
     * случае — {@linkplain Without интегрированную реализацию обёртки несуществующего объекта}.
     *
     * @param <T> тип объекта.
     * @param object объект.
     *
     * @return {@linkplain With Интегрированную реализацию обёртки существующего объекта} (переданного объекта) или
     * {@linkplain Without интегрированную реализацию обёртки несуществующего объекта}.
     *
     * @see With#With(Object)
     * @see #without()
     * @see #with(Object)
     * @since 4.0.0-RC3
     */
    @Contract("_ -> new")
    static <T> @NotNull Optional<T> auto(final @Nullable T object) {
        return object != null ? with(object) : without();
    }

    /**
     * Создаёт и возвращает встроенную реализацию на основе на основе обнуляемого объекта (объекта).
     *
     * @param object объект.
     *
     * @return Встроенная реализация по умолчанию на основе обнуляемого объекта (объекта).
     *
     * @since 4.0.0-RC2
     * @deprecated Используйте {@linkplain #auto(Object)}.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.function.Optional::auto(Object)")
    @Contract("_ -> new")
    static <T> @NotNull Optional<T> nullable(final @Nullable T object) {
        return auto(object);
    }

    /**
     * Проверяет обнуляемую обёртку. Если она ненулевая, то возвращает её, в противном случае генерирует исключение с её
     * именем.
     *
     * @param optional обёртка обнуляемого объекта.
     *
     * @return Ненулевая обёртка.
     *
     * @throws NullException исключение проверки нулевой обёртки.
     * @apiNote Используйте для проверки обёртки обнуляемого объекта перед её использованием.
     * @since 4.0.0-RC2
     * @deprecated Используйте {@linkplain Validator#notNull(Object, String)} самостоятельно.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete("com.bloogefest.common.validation.Validation::notNull(Object, String)")
    @Contract("!null -> 1; _ -> failure")
    static <T> @NotNull Optional<T> check(final @Nullable Optional<T> optional) throws NullException {
        return Validator.notNull(optional, "optional");
    }

    /**
     * Проверяет обнуляемую обёртку (обёртку обнуляемого объекта), и если она ненулевая, то возвращает её, в противном
     * случае создаёт и возвращает встроенную реализацию на основе объекта (нулевого объекта).
     *
     * @param optional обёртка обнуляемого объекта.
     *
     * @return Ненулевая обёртка обнуляемого объекта либо встроенная реализация на основе объекта (нулевого объекта).
     *
     * @apiNote Используйте для безопасного использования обёртки обнуляемого объекта.
     * @since 4.0.0-RC2
     * @deprecated Проверяйте и используйте {@linkplain #without()} самостоятельно.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete
    @Contract("!null -> 1; _ -> new")
    static <T> @NotNull Optional<T> auto(final @Nullable Optional<T> optional) {
        return optional != null ? optional : empty();
    }

    /**
     * Возвращает обёртку (обёртку обнуляемого объекта).
     *
     * @param optional обёртка обнуляемого объекта.
     *
     * @return Обёртка обнуляемого объекта.
     *
     * @apiNote Используйте для приведения лямбда-выражений к типу обёртки обнуляемого объекта.
     * @since 4.0.0-RC2
     * @deprecated Приводите к типу обёртки самостоятельно.
     */
    @Deprecated(since = "4.0.0-RC3", forRemoval = true)
    @Removal("4.0.0-RC4")
    @Obsolete
    @Contract("_ -> 1")
    static <T> @NotNull Optional<T> lambda(final @NotNull Optional<T> optional) {
        return optional;
    }

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} истинный, то возвращает текущий объект, в
     * противном случае генерирует {@linkplain GetException исключение получения объекта} (текущего объекта).
     *
     * @return Текущий объект.
     *
     * @throws GetException исключение получения объекта (текущего объекта).
     * @see #withNullable()
     * @see #withAnother(Object)
     * @see #withSupplier(Supplier)
     * @see #withThrowable(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("-> _")
    @NotNull T get() throws GetException;

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} истинный, то возвращает текущий объект, в
     * противном случае — нулевой.
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
        return contains() ? get() : null;
    }

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} истинный, то возвращает текущий объект, в
     * противном случае — переданный.
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
    @Contract("!null -> !null; _ -> fail")
    default @NotNull T withAnother(final @NotNull T object) throws NullException {
        Validator.notNull(object, "The passed object");
        return contains() ? get() : object;
    }

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} истинный, то возвращает текущий объект, в
     * противном случае получает и возвращает объект от переданного поставщика объекта.
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
    default @NotNull T withSupplier(final @NotNull Supplier<? extends T> supplier) throws NullException, GetException {
        Validator.notNull(supplier, "The passed supplier of an object");
        return contains() ? get() : Validator.notNull(supplier.get(), "An object supplied by the passed supplier");
    }

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} истинный, то возвращает текущий объект, в
     * противном случае получает и бросает исключение от переданного поставщика исключения.
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
    default <F extends Throwable> @NotNull T withThrowable(
            final @NotNull Supplier<F> supplier) throws NullException, GetException, F {
        Validator.notNull(supplier, "The passed supplier of a throwable");
        if (!contains()) throw Validator.notNull(supplier.get(), "A throwable supplied by the passed supplier");
        return get();
    }

    /**
     * Возвращает параметр существования текущего объекта.
     *
     * @return Параметр существования текущего объекта.
     *
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("-> const")
    boolean contains();

    /**
     * Интегрированная реализация обёртки несуществующего объекта.
     *
     * @see Optional
     * @see With
     * @see #Without()
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5") class Without<T> implements Optional<T> {

        /**
         * Создаёт интегрированную реализацию обёртки несуществующего объекта.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        @Contract("-> new")
        public Without() {}

        /**
         * Генерирует {@linkplain GetException исключение получения объекта} (текущего объекта).
         *
         * @throws GetException исключение получения объекта (текущего объекта).
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract("-> fail")
        public @Null T get() {
            throw new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object"));
        }

        /**
         * Возвращает нулевой объект.
         *
         * @return Нулевой объект.
         *
         * @see #get()
         * @see #withNullable()
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Override
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
         * @throws NullException исключение валидации объекта (переданного объекта).
         * @see #get()
         * @see #withNullable()
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("!null -> 1; _ -> fail")
        public @NotNull T withAnother(final @NotNull T object) throws NullException {
            return Validator.notNull(object, "The passed object");
        }

        /**
         * Получает и возвращает объект от переданного поставщика объекта.
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
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("!null -> _; _ -> fail")
        public @NotNull T withSupplier(
                final @NotNull Supplier<? extends T> supplier) throws NullException, GetException {
            return Validator.notNull(Validator.notNull(supplier, "The passed supplier of an object").get(),
                                     "An object supplied by the passed supplier");
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
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("_ -> fail")
        public <F extends Throwable> @Null T withThrowable(
                final @NotNull Supplier<F> supplier) throws NullException, GetException, F {
            throw Validator.notNull(Validator.notNull(supplier, "The passed supplier of a throwable").get(),
                                    "A throwable supplied by the passed supplier");
        }

        /**
         * Возвращает параметр существования текущего объекта.
         *
         * @return Параметр существования текущего объекта.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract("-> false")
        public boolean contains() {
            return false;
        }

    }

    /**
     * Интегрированная реализация обёртки существующего объекта.
     *
     * @see Optional
     * @see Without
     * @see #With(Object)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5") class With<T> implements Optional<T> {

        /**
         * Текущий объект.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        protected final @NotNull T object;

        /**
         * Создаёт интегрированную реализацию обёртки существующего объекта (переданного объекта).
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
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract("-> const & !null")
        public @NotNull T get() {
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
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("-> const & !null")
        public @NotNull T withNullable() {
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
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("!null -> const & !null; _ -> fail")
        public @NotNull T withAnother(final @Nullable T object) throws NullException {
            Validator.notNull(object, "The passed object");
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
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("!null -> const & !null; _ -> fail")
        public @NotNull T withSupplier(final @NotNull Supplier<? extends T> supplier) throws NullException {
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
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("!null -> const & !null; _ -> fail")
        public <F extends Throwable> @NotNull T withThrowable(
                final @NotNull Supplier<F> supplier) throws NullException {
            Validator.notNull(supplier, "The passed supplier of a throwable");
            return object;
        }

        /**
         * Возвращает параметр существования текущего объекта.
         *
         * @return Параметр существования текущего объекта.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract("-> true")
        public boolean contains() {
            return true;
        }

    }

}
