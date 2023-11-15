/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.*;
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
@Experimental(from = "4.0.0-RC5")
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Создаёт и возвращает поставщик несуществующего объекта.
     *
     * @return Поставщик несуществующего объекта.
     *
     * @see Without#Without()
     * @see #with(Object)
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC4")
    @Contract("_ -> new")
    static <T> @NonNull Supplier<T> without() {
        return new Without<>();
    }

    /**
     * Создаёт и возвращает поставщик переданного объекта.
     *
     * @param <T> тип объекта.
     * @param object объект.
     *
     * @return Поставщик переданного объекта.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного объекта).
     * @see With#With(Object)
     * @see #without()
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC4")
    @Contract("_ -> new")
    static <T> @NonNull Supplier<T> with(final @Nullable T object) throws NullException {
        return new With<>(object);
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
    @Experimental(from = "4.0.0-RC4")
    @Contract("!null -> 1; _ -> fail")
    static <T> @NonNull Supplier<T> lambda(final @NonNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "The passed supplier");
    }


    /**
     * Получает и возвращает текущий объект.
     *
     * @return Текущий объект.
     *
     * @throws GetException исключение получения текущего объекта.
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC4")
    @Contract("-> _")
    @Nullable T get() throws GetException;

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает обёртку его и несуществующего объекта, в
     * противном случае — нулевого объекта и исключения, возникшего при получении текущего объекта.
     *
     * @return Обёртку текущего и несуществующего объекта или нулевого объекта и исключения, возникшего при получении
     * текущего объекта.
     *
     * @see BiContainer
     * @see BiContainer#withFirst(Object)
     * @see BiContainer#with(Object, Object)
     * @see #get()
     * @see #withAnother(Object)
     * @see #withSupplier(Supplier)
     * @see #withThrowable(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC5")
    @Contract("-> new")
    default @NonNull BiContainer<T, ? extends Exception> withNullable() {
        try {
            return BiContainer.withFirst(get());
        } catch (final @NonNull Exception failure) {
            return BiContainer.with(null, failure);
        }
    }

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает обёртку его и несуществующего объекта, в
     * противном случае — переданного объекта и исключения, возникшего при получении текущего объекта.
     *
     * @param object объект.
     *
     * @return Обёртку текущего и несуществующего объекта или переданного объекта и исключения, возникшего при получении
     * текущего объекта.
     *
     * @see BiContainer
     * @see BiContainer#withFirst(Object)
     * @see BiContainer#with(Object, Object)
     * @see #get()
     * @see #withNullable()
     * @see #withSupplier(Supplier)
     * @see #withThrowable(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC5")
    @Contract("_ -> new")
    default @NonNull BiContainer<T, ? extends Exception> withAnother(final @Nullable T object) {
        try {
            return BiContainer.withFirst(get());
        } catch (final @NonNull Exception e) {
            return BiContainer.with(object, e);
        }
    }

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает обёртку его и двух несуществующих объектов, в
     * противном случае пытается получить объект от переданного поставщика и возвращает обёртку его, исключения,
     * возникшего при получении текущего объекта, и несуществующего объекта, в противном случае возвращает обёртку
     * несуществующего объекта, исключения, возникшего при получении текущего объекта, и исключения, возникшего при
     * получении объекта от переданного поставщика.
     *
     * @param supplier поставщик объекта.
     *
     * @return Обёртку текущего и двух несуществующих объектов, или объекта, полученного от переданного поставщика,
     * исключения, возникшего при получении текущего объекта, и несуществующего объекта, или несуществующего объекта,
     * исключения, возникшего при получении текущего объекта, и исключения, возникшего при получении объекта от
     * переданного поставщика.
     *
     * @throws NullException исключение валидации нулевого переданного поставщика объекта.
     * @see TriOptional
     * @see TriOptional#withFirst(Object)
     * @see TriOptional#withFirstAndSecond(Object, Object)
     * @see TriOptional#withSecondAndThird(Object, Object)
     * @see #get()
     * @see #withNullable()
     * @see #withAnother(Object)
     * @see #withThrowable(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC5")
    @Contract("!null -> new; _ -> fail")
    default @NonNull TriOptional<T, ? extends Exception, ? extends Exception> withSupplier(
            final @NonNull Supplier<? extends T> supplier) throws NullException {
        Validator.notNull(supplier, "The passed supplier of an object");
        try {
            return TriOptional.withFirst(get());
        } catch (final @NonNull Exception e) {
            try {
                return TriOptional.withFirstAndSecond(supplier.get(), e);
            } catch (final @NonNull Exception e_) {
                return TriOptional.withSecondAndThird(e, e_);
            }
        }
    }

    /**
     * Пытается получить текущий объект и, если успешно, то возвращает обёртку его и двух несуществующих объектов, в
     * противном случае пытается получить и бросить исключение от переданного поставщика, в противном случае возвращает
     * обёртку несуществующего объекта, исключения, возникшего при получении текущего объекта, и исключения, возникшего
     * при получении исключения от переданного поставщика.
     *
     * @param supplier поставщик исключения.
     *
     * @return Обёртку текущего и двух несуществующих объектов или несуществующего объекта, исключения, возникшего при
     * получении текущего объекта, и исключения, возникшего при получении исключения от переданного поставщика.
     *
     * @throws NullException исключение валидации нулевого переданного поставщика исключения или поставляемого им
     * исключения.
     * @throws E поставляемое переданным поставщиком исключение.
     * @see TriOptional
     * @see TriOptional#withFirst(Object)
     * @see TriOptional#withSecondAndThird(Object, Object)
     * @see #get()
     * @see #withNullable()
     * @see #withAnother(Object)
     * @see #withSupplier(Supplier)
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC5")
    @Contract("!null -> _; _ -> fail")
    default <E extends Throwable> @NonNull TriOptional<T, ? extends Exception, ? extends Exception> withThrowable(
            final @NonNull Supplier<? extends E> supplier) throws NullException, GetException, E {
        Validator.notNull(supplier, "The passed supplier of a throwable");
        try {
            return TriOptional.withFirst(get());
        } catch (final @NonNull Exception e) {
            final E e_;
            try {
                e_ = Validator.notNull(supplier.get(), "A throwable supplied by the passed supplier");
            } catch (final @NonNull Exception e__) {
                return TriOptional.withSecondAndThird(e, e__);
            }
            throw e_;
        }
    }

    /**
     * Интегрированная реализация поставщика несуществующего объекта.
     *
     * @param <T> тип объекта.
     *
     * @see Supplier
     * @see With
     * @see #Without()
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC5") class Without<T> implements Supplier<T> {


        /**
         * Создаёт интегрированную реализацию поставщика несуществующего объекта.
         *
         * @since 4.0.0-RC3
         */
        public Without() {}

        /**
         * Генерирует исключение получения текущего объекта.
         *
         * @throws GetException исключение получения объекта (текущего объекта).
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC4")
        @Contract("-> fail")
        public @Null T get() throws GetException {
            throw new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object"));
        }

        /**
         * Возвращает обёртку нулевого объекта и исключения получения текущего объекта.
         *
         * @return Обёртку нулевого объекта и исключения получения текущего объекта.
         *
         * @see BiContainer
         * @see BiContainer#with(Object, Object)
         * @see #get()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("-> new")
        public @NonNull BiContainer<T, ? extends Exception> withNullable() {
            return BiContainer.with(null,
                                    new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object")));
        }

        /**
         * Возвращает обёртку переданного объекта и исключения получения текущего объекта.
         *
         * @param object объект.
         *
         * @return Обёртку переданного объекта и исключения получения текущего объекта.
         *
         * @see BiContainer
         * @see BiContainer#with(Object, Object)
         * @see #get()
         * @see #withNullable()
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("_ -> new")
        public @NonNull BiContainer<T, ? extends Exception> withAnother(final @Nullable T object) {
            return BiContainer.with(object,
                                    new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object")));
        }

        /**
         * Пытается получить объект от переданного поставщика и возвращает обёртку его, исключения получения текущего
         * объекта и несуществующего объекта, в противном случае возвращает обёртку несуществующего объекта, исключения
         * получения текущего объекта и исключения, возникшего при получении объекта от переданного поставщика.
         *
         * @param supplier поставщик объекта.
         *
         * @return Обёртку объекта, полученного от переданного поставщика, исключения получения текущего объекта и
         * несуществующего объекта, или несуществующего объекта, исключения получения текущего объекта и исключения,
         * возникшего при получении объекта от переданного поставщика.
         *
         * @throws NullException исключение валидации нулевого переданного поставщика объекта.
         * @see TriOptional
         * @see TriOptional#withFirstAndSecond(Object, Object)
         * @see TriOptional#withSecondAndThird(Object, Object)
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("!null -> new; _ -> fail")
        public @NonNull TriOptional<T, ? extends Exception, ? extends Exception> withSupplier(
                final @NonNull Supplier<? extends T> supplier) throws NullException, GetException {
            Validator.notNull(supplier, "The passed supplier of an object");
            final var e = new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object"));
            try {
                return TriOptional.withFirstAndSecond(supplier.get(), e);
            } catch (final @NonNull Exception e_) {
                return TriOptional.withSecondAndThird(e, e_);
            }
        }

        /**
         * Пытается получить и бросить исключение от переданного поставщика, в противном случае возвращает обёртку
         * несуществующего объекта, исключения получения текущего объекта и исключения, возникшего при получении
         * исключения от переданного поставщика.
         *
         * @param supplier поставщик исключения.
         *
         * @return Обёртку несуществующего объекта, исключения получения текущего объекта и исключения, возникшего при
         * получении исключения от переданного поставщика.
         *
         * @throws NullException исключение валидации нулевого переданного поставщика исключения или поставляемого им
         * исключения.
         * @throws E поставляемое переданным поставщиком исключение.
         * @see TriOptional
         * @see TriOptional#withSecondAndThird(Object, Object)
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("!null -> _; _ -> fail")
        public <E extends Throwable> @NonNull TriOptional<T, ? extends Exception, ? extends Exception> withThrowable(
                final @NonNull Supplier<? extends E> supplier) throws NullException, GetException, E {
            Validator.notNull(supplier, "The passed supplier of a throwable");
            final var e = new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object"));
            final E e_;
            try {
                e_ = Validator.notNull(supplier.get(), "A throwable supplied by the passed supplier");
            } catch (final @NonNull Exception e__) {
                return TriOptional.withSecondAndThird(e, e__);
            }
            throw e_;
        }

    }

    /**
     * Интегрированная реализация поставщика существующего объекта.
     *
     * @param <T> тип объекта.
     *
     * @see Supplier
     * @see Without
     * @see #With(Object)
     * @since 4.0.0-RC3
     */
    @Experimental(from = "4.0.0-RC5") class With<T> implements Supplier<T> {

        /**
         * Текущий объект.
         *
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC4")
        protected final @NonNull T object;

        /**
         * Создаёт интегрированную реализацию поставщика переданного объекта.
         *
         * @param object объект.
         *
         * @throws NullException исключение валидации нулевого переданного объекта.
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC4")
        @Contract("!null -> new; _ -> fail")
        public With(final @NonNull T object) throws NullException {
            this.object = Validator.notNull(object, "The passed object");
        }

        /**
         * Возвращает {@linkplain #object текущий объект}.
         *
         * @return {@linkplain #object Текущий объект}.
         *
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC4")
        @Contract("-> const")
        public @Nullable T get() {
            return object;
        }

        /**
         * Возвращает обёртку {@linkplain #object текущего} и несуществующего объекта.
         *
         * @return Обёртку {@linkplain #object текущего} и несуществующего объекта.
         *
         * @see BiContainer
         * @see BiContainer#withFirst(Object)
         * @see #get()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("-> new")
        public @NonNull BiContainer<T, Exception> withNullable() {
            return BiContainer.withFirst(object);
        }

        /**
         * Возвращает обёртку {@linkplain #object текущего} и несуществующего объекта.
         *
         * @param object объект.
         *
         * @return Обёртку {@linkplain #object текущего} и несуществующего объекта.
         *
         * @see BiContainer
         * @see BiContainer#withFirst(Object)
         * @see #get()
         * @see #withNullable()
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("_ -> new")
        public @NonNull BiContainer<T, Exception> withAnother(final @Nullable T object) {
            return BiContainer.withFirst(this.object);
        }

        /**
         * Возвращает обёртку {@linkplain #object текущего} и двух несуществующих объектов.
         *
         * @param supplier поставщик объекта.
         *
         * @return Обёртку {@linkplain #object текущего} и двух несуществующих объектов.
         *
         * @throws NullException исключение валидации нулевого переданного поставщика объекта.
         * @see TriOptional
         * @see TriOptional#withFirst(Object)
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("!null -> new; _ -> fail")
        public @NonNull TriOptional<T, Exception, Exception> withSupplier(
                final @NonNull Supplier<? extends T> supplier) throws NullException {
            Validator.notNull(supplier, "The passed supplier of an object");
            return TriOptional.withFirst(object);
        }

        /**
         * Возвращает обёртку {@linkplain #object текущего} и двух несуществующих объектов.
         *
         * @param supplier поставщик исключения.
         *
         * @return Обёртку {@linkplain #object текущего} и двух несуществующих объектов.
         *
         * @throws NullException исключение валидации нулевого переданного поставщика исключения.
         * @see TriOptional
         * @see TriOptional#withFirst(Object)
         * @see #get()
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @since 4.0.0-RC3
         */
        @Experimental(from = "4.0.0-RC5")
        @Contract("!null -> const; _ -> fail")
        public <E extends Throwable> @NonNull TriOptional<T, Exception, Exception> withThrowable(
                final @NonNull Supplier<? extends E> supplier) throws NullException {
            Validator.notNull(supplier, "The passed supplier of a throwable");
            return TriOptional.withFirst(object);
        }

    }

}
