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
 * Контейнер трёх объектов — это функциональный инструмент, способный содержать три объекта. Он предоставляет методы для
 * получения их контейнеров ({@linkplain #first()}, {@linkplain #second()}, {@linkplain #third()}).
 *
 * @param <T1> тип первого объекта.
 * @param <T2> тип второго объекта.
 * @param <T3> тип третьего объекта.
 *
 * @see Impl
 * @see #without()
 * @see #withFirst(Object)
 * @see #withSecond(Object)
 * @see #withThird(Object)
 * @see #withFirstAndSecond(Object, Object)
 * @see #withSecondAndThird(Object, Object)
 * @see #withFirstAndThird(Object, Object)
 * @see #with(Object, Object, Object)
 * @see #autoFirst(Object, Object, Object)
 * @see #autoSecond(Object, Object, Object)
 * @see #autoThird(Object, Object, Object)
 * @see #autoFirstAndSecond(Object, Object, Object)
 * @see #autoSecondAndThird(Object, Object, Object)
 * @see #autoFirstAndThird(Object, Object, Object)
 * @see #auto(Object, Object, Object)
 * @since 4.0.0-RC2
 */
public interface TriContainer<T1, T2, T3> extends BiContainer<T1, T2> {

    /**
     * Создаёт и возвращает контейнер трёх несуществующих объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     *
     * @return Контейнер трёх несуществующих объектов.
     *
     * @see Impl
     * @see Impl#Impl()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("-> new")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> without() {
        return new Impl<T1, T2, T3>();
    }

    /**
     * Создаёт и возвращает контейнер переданного первого объекта и двух несуществующих объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param object первый объект.
     *
     * @return Контейнер переданного первого объекта и двух несуществующих объектов.
     *
     * @throws NullException исключение валидации нулевого переданного первого объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null -> new; _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> withFirst(final @NonNull T1 object) throws NullException {
        return new Impl<T1, T2, T3>(Container.with(object), Container.without(), Container.without());
    }

    /**
     * Создаёт и возвращает контейнер двух несуществующих объектов и переданного второго объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param object второй объект.
     *
     * @return Контейнер двух несуществующих объектов и переданного второго объекта.
     *
     * @throws NullException исключение валидации нулевого переданного второго объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null -> new; _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> withSecond(final @NonNull T2 object) throws NullException {
        return new Impl<T1, T2, T3>(Container.without(), Container.with(object), Container.without());
    }

    /**
     * Создаёт и возвращает контейнер двух несуществующих объектов и переданного третьего объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param object третий объект.
     *
     * @return Контейнер двух несуществующих объектов и переданного третьего объекта.
     *
     * @throws NullException исключение валидации нулевого переданного третьего объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null -> new; _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> withThird(final @NonNull T3 object) throws NullException {
        return new Impl<T1, T2, T3>(Container.without(), Container.without(), Container.with(object));
    }

    /**
     * Создаёт и возвращает контейнер переданного первого и второго объектов и несуществующего объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return Контейнер переданного первого и второго объектов и несуществующего объекта.
     *
     * @throws NullException исключение валидации нулевого переданного первого или второго объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null -> new; _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> withFirstAndSecond(final @NonNull T1 first,
                                                                             final @NonNull T2 second) throws NullException {
        return new Impl<T1, T2, T3>(Container.with(first), Container.with(second), Container.without());
    }

    /**
     * Создаёт и возвращает контейнер переданного второго и третьего объектов и несуществующего объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return Контейнер переданного второго и третьего объектов и несуществующего объекта.
     *
     * @throws NullException исключение валидации нулевого переданного второго или третьего объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null -> new; _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> withSecondAndThird(final @NonNull T2 second,
                                                                             final @NonNull T3 third) throws NullException {
        return new Impl<T1, T2, T3>(Container.without(), Container.with(second), Container.with(third));
    }

    /**
     * Создаёт и возвращает контейнер переданного первого и третьего объектов и несуществующего объекта.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param third третий объект.
     *
     * @return Контейнер переданного первого и третьего объектов и несуществующего объекта.
     *
     * @throws NullException исключение валидации нулевого переданного первого или третьего объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null -> new; _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> withFirstAndThird(final @NonNull T1 first,
                                                                            final @NonNull T3 third) throws NullException {
        return new Impl<T1, T2, T3>(Container.with(first), Container.without(), Container.with(third));
    }

    /**
     * Создаёт и возвращает контейнер переданного первого и второго объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return Контейнер переданного первого и второго объектов.
     *
     * @throws NullException исключение валидации нулевого переданного первого или второго объекта.
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null, !null -> new; _, _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> with(final @NonNull T1 first, final @NonNull T2 second,
                                                               final @NonNull T3 third) throws NullException {
        return new Impl<>(Container.with(first), Container.with(second), Container.with(third));
    }

    /**
     * Если переданный первый объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего объектов),
     * в противном случае —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Container, Container, Container) Интегрированную реализацию контейнера на основе
     * переданных контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего
     * объектов) или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, !null, !null -> new; _, _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> autoFirst(final @Nullable T1 first, final @NonNull T2 second,
                                                                    final @NonNull T3 third) throws NullException {
        return first != null ? with(first, second, third) : withSecondAndThird(second, third);
    }

    /**
     * Если переданный второй объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего объектов),
     * в противном случае —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Container, Container, Container) Интегрированную реализацию контейнера на основе
     * переданных контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего
     * объектов) или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, _, !null -> new; _, _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> autoSecond(final @NonNull T1 first, final @Nullable T2 second,
                                                                     final @NonNull T3 third) throws NullException {
        return second != null ? with(first, second, third) : withFirstAndThird(first, third);
    }

    /**
     * Если переданный третий объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего объектов),
     * в противном случае —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Container, Container, Container) Интегрированную реализацию контейнера на основе
     * переданных контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего
     * объектов) или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или второго объекта).
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null, _ -> new; _, _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> autoThird(final @NonNull T1 first, final @NonNull T2 second,
                                                                    final @Nullable T3 third) throws NullException {
        return third != null ? with(first, second, third) : withFirstAndSecond(first, second);
    }

    /**
     * Если переданный первый и второй объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего объектов),
     * в противном случае если только переданный первый объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта), в противном случае если только переданный второй объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов), в противном случае —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного третьего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Container, Container, Container) Интегрированную реализацию контейнера на основе
     * переданных контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного третьего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, _, !null -> new; _, _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> autoFirstAndSecond(final @Nullable T1 first,
                                                                             final @Nullable T2 second,
                                                                             final @NonNull T3 third) throws NullException {
        return first != null ? second != null ? with(first, second, third) : withFirstAndThird(first, third) :
               second != null ? withSecondAndThird(second, third) : withThird(third);
    }

    /**
     * Если переданный второй и третий объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего объектов),
     * в противном случае если только переданный второй объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта), в противном случае если только переданный третий объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта), в противном случае —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера переданного первого объекта и двух контейнеров
     * несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Container, Container, Container) Интегрированную реализацию контейнера на основе
     * переданных контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера переданного первого объекта и двух контейнеров
     * несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, _, _ -> new; _, _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> autoSecondAndThird(final @NonNull T1 first,
                                                                             final @Nullable T2 second,
                                                                             final @Nullable T3 third) throws NullException {
        return second != null ? third != null ? with(first, second, third) : withFirstAndSecond(first, second) :
               third != null ? withFirstAndThird(first, third) : withFirst(first);
    }

    /**
     * Если переданный первый и третий объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего объектов),
     * в противном случае если только переданный первый объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта), в противном случае если только переданный третий объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов), в противном случае —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного второго объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Container, Container, Container) Интегрированную реализацию контейнера на основе
     * переданных контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного второго объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или второго объекта).
     * @see Impl
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #auto(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, !null, _ -> new; _, _, _ -> fail")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> autoFirstAndThird(final @Nullable T1 first,
                                                                            final @NonNull T2 second,
                                                                            final @Nullable T3 third) throws NullException {
        return first != null ? third != null ? with(first, second, third) : withFirstAndSecond(first, second) :
               third != null ? withSecondAndThird(second, third) : withSecond(second);
    }

    /**
     * Если переданный первый, второй и третий объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего объектов),
     * в противном случае если только переданный первый и второй объекты ненулевые, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта), в противном случае если только переданный первый и третий объекты ненулевые,
     * то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта), в противном случае если только переданный первый объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера переданного первого и двух контейнеров
     * несуществующего объекта), в противном случае если только переданный второй и третий объекты ненулевые, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов), в противном случае если только переданный второй объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного второго объекта), в противном случае если только переданный третий объект ненулевой, то —
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного третьего объекта), в противном случае —
     * {@linkplain Impl#Impl() интегрированную реализацию контейнера на основе трёх контейнеров несуществующего
     * объекта}.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Container, Container, Container) Интегрированную реализацию контейнера на основе
     * переданных контейнеров первого, второго и третьего объектов} (контейнеров переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и второго объектов и
     * контейнера несуществующего объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнеров переданного первого и третьего объектов и
     * контейнера несуществующего объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера переданного первого и двух контейнеров
     * несуществующего объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (контейнера несуществующего объекта и контейнеров переданного
     * второго и третьего объектов), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного второго объекта), или
     * {@linkplain Impl#Impl(Container, Container, Container) интегрированную реализацию контейнера на основе переданных
     * контейнеров первого, второго и третьего объектов} (двух контейнеров несуществующего объекта и контейнера
     * переданного третьего объекта), или
     * {@linkplain Impl#Impl() интегрированную реализацию контейнера на основе трёх контейнеров несуществующего
     * объекта}.
     *
     * @see Impl
     * @see Impl#Impl()
     * @see Impl#Impl(Container, Container, Container)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #withThird(Object)
     * @see #withFirstAndSecond(Object, Object)
     * @see #withSecondAndThird(Object, Object)
     * @see #withFirstAndThird(Object, Object)
     * @see #with(Object, Object, Object)
     * @see #autoFirst(Object, Object, Object)
     * @see #autoSecond(Object, Object, Object)
     * @see #autoThird(Object, Object, Object)
     * @see #autoFirstAndSecond(Object, Object, Object)
     * @see #autoSecondAndThird(Object, Object, Object)
     * @see #autoFirstAndThird(Object, Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, _, _ -> new")
    static <T1, T2, T3> @NonNull TriContainer<T1, T2, T3> auto(final @Nullable T1 first, final @Nullable T2 second,
                                                               final @Nullable T3 third) {
        return first != null ?
               second != null ? third != null ? with(first, second, third) : withFirstAndSecond(first, second) :
               third != null ? withFirstAndThird(first, third) : withFirst(first) :
               second != null ? third != null ? withSecondAndThird(second, third) : withSecond(second) :
               third != null ? withThird(third) : without();
    }

    /**
     * Возвращает контейнер текущего третьего объекта.
     *
     * @return Контейнер текущего третьего объекта.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> !null")
    @NonNull Container<T3> third();

    /**
     * Интегрированная реализация контейнера трёх объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     *
     * @see TriContainer
     * @see #Impl()
     * @see #Impl(Container, Container, Container)
     * @since 4.0.0-RC3
     */
    class Impl<T1, T2, T3> extends BiContainer.Impl<T1, T2> implements TriContainer<T1, T2, T3> {

        /**
         * Контейнер текущего третьего объекта.
         *
         * @since 4.0.0-RC3
         */
        protected final @NonNull Container<T3> third;

        /**
         * Создаёт интегрированную реализацию контейнера трёх объектов на основе трёх контейнеров несуществующего
         * объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("-> new")
        public Impl() {
            this(Container.without(), Container.without(), Container.without());
        }

        /**
         * Создаёт интегрированную реализацию контейнера трёх объектов на основе переданных контейнеров первого, второго
         * и третьего объектов.
         *
         * @param first контейнер первого объекта.
         * @param second контейнер второго объекта.
         * @param third контейнер третьего объекта.
         *
         * @throws NullException исключение валидации нулевого переданного контейнера первого, второго или третьего
         * объекта).
         * @since 4.0.0-RC3
         */
        @Contract("!null, !null, !null -> new; _, _, _ -> fail")
        public Impl(final @NonNull Container<T1> first, final @NonNull Container<T2> second,
                    final @NonNull Container<T3> third) throws NullException {
            super(first, second);
            this.third = Validator.notNull(third, "The passed container of the third object");
        }

        /**
         * Возвращает {@linkplain #third контейнер текущего третьего объекта}.
         *
         * @return {@linkplain #third Контейнер текущего третьего объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> const")
        public @NonNull Container<T3> third() {
            return third;
        }

    }

}
