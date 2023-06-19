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

import java.util.concurrent.locks.StampedLock;

/**
 * Контейнер объекта.
 *
 * @apiNote Данный функциональный инструмент имеет определённую особенность — объект, контейнером которого он является,
 * может одновременно быть нулевым и существовать.
 * @since 4.0.0-RC3
 */
@Experimental("4.0.0-RC4")
public interface Container<T> {

    /**
     * Создаёт и возвращает непотокобезопасный контейнер объекта (нулевого объекта).
     *
     * @return Непотокобезопасный контейнер объекта (нулевого объекта).
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    static <T> @NotNull Container<T> sync() {
        return new Sync<>();
    }

    /**
     * Создаёт и возвращает непотокобезопасный контейнер объекта (переданного объекта).
     *
     * @return Непотокобезопасный контейнер объекта (переданного объекта).
     *
     * @since 4.0.0-RC3
     */
    @Contract("_ -> new")
    static <T> @NotNull Container<T> sync(final @Nullable T object) {
        return new Sync<>(object);
    }

    /**
     * Создаёт и возвращает потокобезопасный контейнер объекта (нулевого объекта).
     *
     * @return Потокобезопасный контейнер объекта (нулевого объекта).
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    static <T> @NotNull Container<T> async() {
        return new Async<>();
    }

    /**
     * Создаёт и возвращает потокобезопасный контейнер объекта (переданного объекта).
     *
     * @return Потокобезопасный контейнер объекта (переданного объекта).
     *
     * @since 4.0.0-RC3
     */
    @Contract("_ -> new")
    static <T> @NotNull Container<T> async(final @Nullable T object) {
        return new Async<>(object);
    }

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} ложный, то генерирует
     * {@linkplain GetException исключение получения объекта} (текущего объекта). Возвращает текущий объект.
     *
     * @return Текущий объект.
     *
     * @throws GetException исключение получения объекта (текущего объекта).
     * @since 4.0.0-RC3
     */
    @Contract("-> _")
    @Nullable T get() throws GetException;

    /**
     * Устанавливает переданный объект. Возвращает контейнер объекта (переданного объекта).
     *
     * @param object объект.
     *
     * @return Контейнер объекта (переданного объекта).
     *
     * @throws SetException исключение установки объекта (переданного объекта).
     * @since 4.0.0-RC3
     */
    @Contract("_ -> this")
    @NotNull Container<T> set(final @Nullable T object) throws SetException;

    /**
     * Если {@linkplain #contains() параметр существования текущего объекта} ложный, то генерирует
     * {@linkplain ResetException исключение сброса объекта} (текущего объекта). Сбрасывает текущий объект. Возвращает
     * контейнер объекта (нулевого объекта).
     *
     * @return Контейнер объекта (нулевого объекта).
     *
     * @throws ResetException исключение сброса объекта (текущего объекта).
     * @since 4.0.0-RC3
     */
    @Contract("-> this")
    @NotNull Container<T> reset() throws ResetException;

    /**
     * Возвращает параметр существования текущего объекта.
     *
     * @return Параметр существования текущего объекта.
     *
     * @since 4.0.0-RC3
     */
    boolean contains();

    /**
     * Непотокобезопасный контейнер объекта.
     *
     * @since 4.0.0-RC3
     */
    class Sync<T> implements Container<T> {

        /**
         * Текущий объект.
         *
         * @since 4.0.0-RC3
         */
        protected @Nullable T object;

        /**
         * Параметр существования текущего объекта.
         *
         * @since 4.0.0-RC3
         */
        protected boolean contains;

        /**
         * Создаёт непотокобезопасный контейнер объекта на основе нулевого объекта и ложного параметра его
         * существования.
         *
         * @since 4.0.0-RC3
         */
        @Contract("-> new")
        public Sync() {
            this(null, false);
        }

        /**
         * Создаёт непотокобезопасный контейнер объекта на основе переданного объекта и ложного параметра его
         * существования.
         *
         * @param object объект.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_ -> new")
        public Sync(final @Nullable T object) {
            this(object, true);
        }

        /**
         * Создаёт непотокобезопасный контейнер объекта на основе нулевого объекта и переданного параметра его
         * существования.
         *
         * @param contains параметр существования объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_ -> new")
        public Sync(final boolean contains) {
            this(null, contains);
        }

        /**
         * Создаёт непотокобезопасный контейнер объекта на основе переданного объекта и параметра его существования.
         *
         * @param object объект.
         * @param contains параметр существования объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_, _ -> new")
        public Sync(final @Nullable T object, final boolean contains) {
            this.object = object;
            this.contains = contains;
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} ложный, то генерирует
         * {@linkplain GetException исключение получения объекта} (текущего объекта). Возвращает текущий объект.
         *
         * @return Текущий объект.
         *
         * @throws GetException исключение получения объекта (текущего объекта).
         * @since 4.0.0-RC3
         */
        @Contract("-> _")
        public @Nullable T get() throws GetException {
            if (!contains) throw new GetException();
            return object;
        }

        /**
         * Устанавливает переданный объект.
         *
         * @param object объект.
         *
         * @return Контейнер объекта (переданного объекта).
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("_ -> this")
        public @NotNull Container<T> set(final T object) {
            this.object = object;
            contains = true;
            return this;
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} ложный, то генерирует
         * {@linkplain ResetException исключение сброса объекта} (текущего объекта). Сбрасывает текущий объект.
         * Возвращает контейнер объекта (нулевого объекта).
         *
         * @return Контейнер объекта (нулевого объекта).
         *
         * @throws ResetException исключение сброса объекта (текущего объекта).
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> this")
        public @NotNull Container<T> reset() throws ResetException {
            if (!contains) throw new ResetException();
            object = null;
            contains = false;
            return this;
        }

        /**
         * Возвращает {@linkplain #contains параметр существования текущего объекта}.
         *
         * @return {@linkplain #contains Параметр существования текущего объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Contract("-> _")
        public boolean contains() {
            return contains;
        }

    }

    /**
     * Потокобезопасный контейнер объекта.
     *
     * @since 4.0.0-RC3
     */
    class Async<T> implements Container<T> {

        /**
         * Инструмент для управления доступом.
         *
         * @since 4.0.0-RC3
         */
        protected final @NotNull StampedLock lock = new StampedLock();

        /**
         * Текущий объект.
         *
         * @since 4.0.0-RC3
         */
        protected volatile @Nullable T object;

        /**
         * Параметр существования текущего объекта.
         *
         * @since 4.0.0-RC3
         */
        protected volatile boolean contains;

        /**
         * Создаёт потокобезопасный контейнер объекта на основе нулевого объекта и ложного параметра его существования.
         *
         * @since 4.0.0-RC3
         */
        @Contract("-> new")
        public Async() {
            this(null, false);
        }

        /**
         * Создаёт потокобезопасный контейнер объекта на основе переданного объекта и ложного параметра его
         * существования.
         *
         * @param object объект.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_ -> new")
        public Async(final @Nullable T object) {
            this(object, true);
        }

        /**
         * Создаёт потокобезопасный контейнер объекта на основе нулевого объекта и переданного параметра его
         * существования.
         *
         * @param contains параметр существования объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_ -> new")
        public Async(final boolean contains) {
            this(null, contains);
        }

        /**
         * Создаёт потокобезопасный контейнер объекта на основе переданного объекта и параметра его существования.
         *
         * @param object объект.
         * @param contains параметр существования объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("_, _ -> new")
        public Async(final @Nullable T object, final boolean contains) {
            this.object = object;
            this.contains = contains;
        }

        /**
         * Если {@linkplain #contains параметр существования текущего объекта} ложный, то генерирует
         * {@linkplain GetException исключение получения объекта} (текущего объекта). Возвращает текущий объект.
         *
         * @return Текущий объект.
         *
         * @throws GetException исключение получения объекта (текущего объекта).
         * @since 4.0.0-RC3
         */
        @Contract("-> _")
        public @Nullable T get() throws GetException {
            final var stamp = lock.readLock();
            try {
                if (!contains) throw new GetException();
                return object;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        /**
         * Устанавливает переданный объект.
         *
         * @param object объект.
         *
         * @return Контейнер объекта (переданного объекта).
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("_ -> this")
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
         * Если {@linkplain #contains параметр существования текущего объекта} ложный, то генерирует
         * {@linkplain ResetException исключение сброса объекта} (текущего объекта). Сбрасывает текущий объект.
         * Возвращает контейнер объекта (нулевого объекта).
         *
         * @return Контейнер объекта (нулевого объекта).
         *
         * @throws ResetException исключение сброса объекта (текущего объекта).
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> this")
        public @NotNull Container<T> reset() throws ResetException {
            var stamp = lock.readLock();
            try {
                if (!contains) throw new ResetException();
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
