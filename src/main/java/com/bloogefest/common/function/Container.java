/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.Experimental;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

import java.util.concurrent.locks.StampedLock;

/**
 * Контейнер объекта — это функциональный инструмент, способный содержать объект. Он предоставляет методы для получения
 * ({@linkplain #get()}, {@linkplain #withNullable()}, {@linkplain #withAnother(Object)},
 * {@linkplain #withSupplier(Supplier)}, {@linkplain #withThrowable(Supplier)}), установки ({@linkplain #set(Object)}),
 * сброса ({@linkplain #reset()}) и проверки его существования ({@linkplain #contains()}).
 *
 * @param <T> тип объекта.
 *
 * @see Impl
 * @see #without()
 * @see #with(Object)
 * @since 4.0.0-RC3
 */
@Experimental("4.0.0-RC5")
public interface Container<T> {

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl() интегрированную реализацию контейнера объекта на основе нулевого объекта и ложного
     * параметра его существования}.
     *
     * @param <T> тип объекта.
     *
     * @return {@linkplain Impl#Impl() Интегрированную реализацию контейнера объекта на основе нулевого объекта и
     * ложного параметра его существования}.
     *
     * @see Impl#Impl()
     * @see #with(Object)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("-> new")
    static <T> @NotNull Container<T> without() {
        return new Impl<>();
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Object) интегрированную реализацию контейнера объекта на основе переданного объекта и
     * истинного параметра его существования}.
     *
     * @param <T> тип объекта.
     * @param object объект.
     *
     * @return {@linkplain Impl Интегрированную реализацию контейнера объекта на основе переданного объекта и истинного
     * параметра его существования}.
     *
     * @see Impl#Impl(Object)
     * @see #without()
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("_ -> new")
    static <T> @NotNull Container<T> with(final @Nullable T object) {
        return new Impl<>(object);
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
    @Nullable T get() throws GetException;

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
        return withAnother(null);
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
    @Contract("_ -> _")
    default @Nullable T withAnother(final @Nullable T object) {
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
    default @Nullable T withSupplier(final @NotNull Supplier<? extends T> supplier) throws NullException, GetException {
        Validator.notNull(supplier, "The passed supplier of an object");
        return contains() ? get() : supplier.get();
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
    default <F extends Throwable> @Nullable T withThrowable(
            final @NotNull Supplier<F> supplier) throws NullException, GetException, F {
        Validator.notNull(supplier, "The passed supplier of a throwable");
        if (!contains()) throw Validator.notNull(supplier.get(), "A throwable supplied by the passed supplier");
        return get();
    }

    /**
     * Устанавливает переданный объект. Возвращает текущий контейнер переданного объекта.
     *
     * @param object объект.
     *
     * @return Текущий контейнер переданного объекта.
     *
     * @throws SetException исключение установки объекта (переданного объекта).
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract(value = "_ -> this", pure = false)
    @NotNull Container<T> set(final @Nullable T object) throws SetException;

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} истинный, то сбрасывает текущий объект, в
     * противном случае генерирует {@linkplain ResetException исключение сброса объекта} (текущего объекта). Возвращает
     * текущий контейнер несуществующего объекта.
     *
     * @return Текущий контейнер несуществующего объекта.
     *
     * @throws ResetException исключение сброса объекта (текущего объекта).
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract(value = "-> this", pure = false)
    @NotNull Container<T> reset() throws ResetException;

    /**
     * Возвращает параметр существования текущего объекта.
     *
     * @return Параметр существования текущего объекта.
     *
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC4")
    @Contract("-> _")
    boolean contains();

    /**
     * Интегрированная реализация контейнера объекта.
     *
     * @see Container
     * @see #Impl()
     * @see #Impl(Object)
     * @since 4.0.0-RC3
     */
    @Experimental("4.0.0-RC5") class Impl<T> implements Container<T> {

        /**
         * Инструмент для управления доступом.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        protected final @NotNull StampedLock lock = new StampedLock();

        /**
         * Текущий объект.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        private @Nullable T object;

        /**
         * Параметр существования текущего объекта.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        private boolean contains;

        /**
         * Создаёт интегрированную реализацию контейнера объекта на основе нулевого объекта и ложного параметра его
         * существования.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        @Contract("-> new")
        public Impl() {
            this(null, false);
        }

        /**
         * Создаёт интегрированную реализацию контейнера объекта на основе переданного объекта и истинного параметра его
         * существования.
         *
         * @param object объект.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC4")
        @Contract("_ -> new")
        public Impl(final @Nullable T object) {
            this(object, true);
        }

        /**
         * Создаёт интегрированную реализацию контейнера объекта на основе переданного объекта и параметра его
         * существования.
         *
         * @param object объект.
         * @param contains параметр существования объекта.
         *
         * @since 4.0.0-RC3
         */
        @Experimental("4.0.0-RC5")
        @Contract("_, _ -> new")
        public Impl(final @Nullable T object, final boolean contains) {
            this.object = object;
            this.contains = contains;
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} истинный, то возвращает
         * {@linkplain #object текущий объект}, в противном случае генерирует
         * {@linkplain GetException исключение получения объекта} ({@linkplain #object текущего объекта}).
         *
         * @return {@linkplain #object Текущий объект}.
         *
         * @throws GetException исключение получения объекта ({@linkplain #object текущего объекта}).
         * @see #withNullable()
         * @see #withAnother(Object)
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract("-> _")
        public @Nullable T get() throws GetException {
            final var stamp = lock.readLock();
            try {
                if (!contains) throw new GetException(GetException.TEMPLATE_MESSAGE.formatted("the current object"));
                return object;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} истинный, то возвращает
         * {@linkplain #object текущий объект}, в противном случае — переданный.
         *
         * @param object объект.
         *
         * @return {@linkplain #object Текущий} или переданный объект.
         *
         * @see #get()
         * @see #withNullable()
         * @see #withSupplier(Supplier)
         * @see #withThrowable(Supplier)
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC5")
        @Contract("_ -> _")
        public @Nullable T withAnother(final @Nullable T object) {
            final var stamp = lock.readLock();
            try {
                return contains ? this.object : object;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} истинный, то возвращает
         * {@linkplain #object текущий объект}, в противном случае получает и возвращает объект от переданного
         * поставщика объекта.
         *
         * @param supplier поставщик объекта.
         *
         * @return {@linkplain #object Текущий} или полученный от переданного поставщика объект.
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
        public @Nullable T withSupplier(
                final @NotNull Supplier<? extends T> supplier) throws NullException, GetException {
            Validator.notNull(supplier, "The passed supplier of an object");
            final var stamp = lock.readLock();
            try {
                return contains ? object : supplier.get();
            } finally {
                lock.unlockRead(stamp);
            }
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} истинный, то возвращает
         * {@linkplain #object текущий объект}, в противном случае получает и бросает исключение от переданного
         * поставщика исключения.
         *
         * @param supplier поставщик исключения.
         *
         * @return {@linkplain #object Текущий объект}.
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
        @Contract("!null -> _; _ -> fail")
        public <F extends Throwable> @Nullable T withThrowable(
                final @NotNull Supplier<F> supplier) throws NullException, GetException, F {
            Validator.notNull(supplier, "The passed supplier of a throwable");
            final var stamp = lock.readLock();
            try {
                if (!contains) throw Validator.notNull(supplier.get(), "A throwable supplied by the passed supplier");
                return object;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        /**
         * Устанавливает переданный объект. Возвращает текущий контейнер переданного объекта.
         *
         * @param object объект.
         *
         * @return Текущий контейнер переданного объекта.
         *
         * @throws SetException исключение установки объекта (переданного объекта).
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract(value = "_ -> this", pure = false)
        public @NotNull Container<T> set(final T object) {
            final var stamp = lock.writeLock();
            try {
                this.object = object;
                contains = true;
                return this;
            } finally {
                lock.unlockWrite(stamp);
            }
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} истинный, то сбрасывает
         * {@linkplain #object текущий объект}, в противном случае генерирует
         * {@linkplain ResetException исключение сброса объекта} ({@linkplain #object текущего объекта}). Возвращает
         * текущий контейнер несуществующего объекта.
         *
         * @return Текущий контейнер несуществующего объекта.
         *
         * @throws ResetException исключение сброса объекта ({@linkplain #object текущего объекта}).
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract(value = "-> this", pure = false)
        public @NotNull Container<T> reset() throws ResetException {
            var stamp = lock.readLock();
            try {
                if (!contains)
                    throw new ResetException(ResetException.TEMPLATE_MESSAGE.formatted("the current object"));
                stamp = lock.tryConvertToWriteLock(stamp);
                if (stamp == 0) stamp = lock.writeLock();
                object = null;
                contains = false;
                return this;
            } finally {
                lock.unlock(stamp);
            }
        }

        /**
         * Возвращает {@linkplain #contains параметр существования текущего объекта}.
         *
         * @return {@linkplain #contains Параметр существования текущего объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Experimental("4.0.0-RC4")
        @Contract("-> _")
        public boolean contains() {
            final var stamp = lock.readLock();
            try {
                return contains;
            } finally {
                lock.unlockRead(stamp);
            }
        }

    }

}
