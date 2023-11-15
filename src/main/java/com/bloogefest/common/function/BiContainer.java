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
 * Контейнер двух объектов — это функциональный инструмент, способный содержать два объекта. Он предоставляет методы для
 * получения их контейнеров ({@linkplain #first()}, {@linkplain #second()}).
 *
 * @param <T1> тип первого объекта.
 * @param <T2> тип второго объекта.
 *
 * @see Impl
 * @see #without()
 * @see #withFirst(Object)
 * @see #withSecond(Object)
 * @see #with(Object, Object)
 * @see #autoFirst(Object, Object)
 * @see #autoSecond(Object, Object)
 * @see #auto(Object, Object)
 * @since 4.0.0-RC2
 */
public interface BiContainer<T1, T2> {

    /**
     * Создаёт и возвращает контейнер двух несуществующих объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     *
     * @return Контейнер двух несуществующих объектов.
     *
     * @see Impl
     * @see Impl#Impl()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    static <T1, T2> @NonNull BiContainer<T1, T2> without() {
        return new Impl<>();
    }

    /**
     * Создаёт и возвращает контейнер переданного первого и несуществующего объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param object первый объект.
     *
     * @return Контейнер переданного первого и несуществующего объекта.
     *
     * @throws NullException исключение валидации нулевого переданного первого объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container)
     * @see #without()
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null -> new; _ -> fail")
    static <T1, T2> @NonNull BiContainer<T1, T2> withFirst(final @NonNull T1 object) throws NullException {
        return new Impl<>(Container.with(object), Container.without());
    }

    /**
     * Создаёт и возвращает контейнер несуществующего объекта и переданного второго объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param object второй объект.
     *
     * @return Контейнер несуществующего объекта и переданного второго объекта.
     *
     * @throws NullException исключение валидации нулевого переданного второго объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null -> new; _ -> fail")
    static <T1, T2> @NonNull BiContainer<T1, T2> withSecond(final @NonNull T2 object) throws NullException {
        return new Impl<>(Container.without(), Container.with(object));
    }

    /**
     * Создаёт и возвращает контейнер переданного первого и второго объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return Контейнер переданного первого и второго объектов.
     *
     * @throws NullException исключение валидации нулевого переданного первого или второго объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null -> new; _, _ -> fail")
    static <T1, T2> @NonNull BiContainer<T1, T2> with(final @NonNull T1 first,
                                                      final @NonNull T2 second) throws NullException {
        return new Impl<>(Container.with(first), Container.with(second));
    }

    /**
     * Если переданный первый объект ненулевой, то создаёт и возвращает контейнер переданного первого и второго
     * объектов, в противном случае — несуществующего объекта и переданного второго объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return Контейнер переданного первого и второго объектов или несуществующего объекта и переданного второго
     * объекта.
     *
     * @throws NullException исключение валидации нулевого переданного второго объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, !null -> new; _, _ -> fail")
    static <T1, T2> @NonNull BiContainer<T1, T2> autoFirst(final @Nullable T1 first,
                                                           final @NonNull T2 second) throws NullException {
        return first != null ? with(first, second) : withSecond(second);
    }

    /**
     * Если переданный второй объект ненулевой, то создаёт и возвращает контейнер переданного первого и второго
     * объектов, в противном случае — переданного первого объекта и несуществующего объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return Контейнер переданного первого и второго объектов или переданного первого объекта и несуществующего
     * объекта.
     *
     * @throws NullException исключение валидации нулевого переданного первого объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, _ -> new; _, _ -> fail")
    static <T1, T2> @NonNull BiContainer<T1, T2> autoSecond(final @NonNull T1 first,
                                                            final @Nullable T2 second) throws NullException {
        return second != null ? with(first, second) : withFirst(first);
    }

    /**
     * Если переданные первый и второй объекты ненулевые, то создаёт и возвращает контейнер переданного первого и
     * второго объектов, в противном случае если только переданный первый объект ненулевой, то — переданного первого
     * объекта и несуществующего объекта, в противном случае если только переданный второй объект ненулевой, то —
     * несуществующего объекта и переданного второго объекта, в противном случае — двух несуществующих объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return Контейнер переданного первого и второго объектов, или переданного первого объекта и несуществующего
     * объекта, или несуществующего объекта и переданного второго объекта, или двух несуществующих объектов.
     *
     * @see Impl#Impl()
     * @see Impl#Impl(Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, _ -> new")
    static <T1, T2> @NonNull BiContainer<T1, T2> auto(final @Nullable T1 first, final @Nullable T2 second) {
        return first != null ? second != null ? with(first, second) : withFirst(first) :
               second != null ? withSecond(second) : without();
    }

    /**
     * Возвращает контейнер текущего первого объекта.
     *
     * @return Контейнер текущего первого объекта.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> !null")
    @NonNull Container<T1> first();

    /**
     * Возвращает контейнер текущего второго объекта.
     *
     * @return Контейнер текущего второго объекта.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> !null")
    @NonNull Container<T2> second();

    /**
     * Интегрированная реализация контейнера двух объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     *
     * @see BiContainer
     * @see #Impl()
     * @see #Impl(Container, Container)
     * @since 4.0.0-RC3
     */
    class Impl<T1, T2> implements BiContainer<T1, T2> {

        /**
         * Контейнер текущего первого объекта.
         *
         * @since 4.0.0-RC3
         */
        protected final @NonNull Container<T1> first;

        /**
         * Контейнер текущего второго объекта.
         *
         * @since 4.0.0-RC3
         */
        protected final @NonNull Container<T2> second;

        /**
         * Создаёт интегрированную реализацию контейнера двух объектов на основе двух контейнеров несуществующего
         * объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("-> new")
        public Impl() {
            this(Container.without(), Container.without());
        }

        /**
         * Создаёт интегрированную реализацию контейнера двух объектов на основе переданных контейнеров первого и
         * второго объектов.
         *
         * @param first контейнер первого объекта.
         * @param second контейнер второго объекта.
         *
         * @throws NullException исключение валидации нулевого переданного контейнера первого или второго объекта.
         * @since 4.0.0-RC3
         */
        @Contract("!null, !null -> new; _, _ -> fail")
        public Impl(final @NonNull Container<T1> first, final @NonNull Container<T2> second) throws NullException {
            this.first = Validator.notNull(first, "The passed container of the first object");
            this.second = Validator.notNull(second, "The passed container of the second object");
        }

        /**
         * Возвращает {@linkplain #first контейнер текущего первого объекта}.
         *
         * @return {@linkplain #first Контейнер текущего первого объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> const")
        public @NonNull Container<T1> first() {
            return first;
        }

        /**
         * Возвращает {@linkplain #second контейнер текущего второго объекта}.
         *
         * @return {@linkplain #second Контейнер текущего второго объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> const")
        public @NonNull Container<T2> second() {
            return second;
        }

    }

}
