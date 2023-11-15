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
 * Обёртка трёх объектов — это функциональный инструмент, способный содержать три объекта. Он предоставляет методы для
 * получения их обёрток ({@linkplain #first()}, {@linkplain #second()}, {@linkplain #third()}).
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
public interface TriOptional<T1, T2, T3> extends BiOptional<T1, T2> {

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl() интегрированную реализацию обёртки трёх объектов на основе трёх обёрток несуществующего
     * объекта}.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     *
     * @return {@linkplain Impl#Impl() Интегрированную реализацию обёртки трёх объектов на основе трёх обёрток
     * несуществующего объекта}.
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> without() {
        return new Impl<T1, T2, T3>();
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки переданного первого объекта и двух обёрток несуществующего
     * объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param object первый объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёртки переданного первого объекта и двух обёрток
     * несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> withFirst(final @NonNull T1 object) throws NullException {
        return new Impl<T1, T2, T3>(Optional.with(object), Optional.without(), Optional.without());
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного второго
     * объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param object второй объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки
     * переданного второго объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> withSecond(final @NonNull T2 object) throws NullException {
        return new Impl<T1, T2, T3>(Optional.without(), Optional.with(object), Optional.without());
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного
     * третьего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param object третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки
     * переданного третьего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного третьего объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> withThird(final @NonNull T3 object) throws NullException {
        return new Impl<T1, T2, T3>(Optional.without(), Optional.without(), Optional.with(object));
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и
     * обёртки несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> withFirstAndSecond(final @NonNull T1 first,
                                                                            final @NonNull T2 second) throws NullException {
        return new Impl<T1, T2, T3>(Optional.with(first), Optional.with(second), Optional.without());
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного второго и третьего объектов и обёртки
     * несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного второго и третьего объектов и
     * обёртки несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> withSecondAndThird(final @NonNull T2 second,
                                                                            final @NonNull T3 third) throws NullException {
        return new Impl<T1, T2, T3>(Optional.without(), Optional.with(second), Optional.with(third));
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и
     * обёртки несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> withFirstAndThird(final @NonNull T1 first,
                                                                           final @NonNull T3 third) throws NullException {
        return new Impl<T1, T2, T3>(Optional.with(first), Optional.without(), Optional.with(third));
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки трёх объектов на
     * основе переданных обёрток первого и второго объекта)}.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> with(final @NonNull T1 first, final @NonNull T2 second,
                                                              final @NonNull T3 third) throws NullException {
        return new Impl<>(Optional.with(first), Optional.with(second), Optional.with(third));
    }

    /**
     * Если переданный первый объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов), в
     * противном случае —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего
     * объектов) или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> autoFirst(final @Nullable T1 first, final @NonNull T2 second,
                                                                   final @NonNull T3 third) throws NullException {
        return first != null ? with(first, second, third) : withSecondAndThird(second, third);
    }

    /**
     * Если переданный второй объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов), в
     * противном случае —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего
     * объектов) или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> autoSecond(final @NonNull T1 first, final @Nullable T2 second,
                                                                    final @NonNull T3 third) throws NullException {
        return second != null ? with(first, second, third) : withFirstAndThird(first, third);
    }

    /**
     * Если переданный третий объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов), в
     * противном случае —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего
     * объектов) или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> autoThird(final @NonNull T1 first, final @NonNull T2 second,
                                                                   final @Nullable T3 third) throws NullException {
        return third != null ? with(first, second, third) : withFirstAndSecond(first, second);
    }

    /**
     * Если переданный первый и второй объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов), в
     * противном случае если только переданный первый объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта), в противном случае если только переданный второй объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов), в противном случае —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного
     * третьего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного
     * третьего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> autoFirstAndSecond(final @Nullable T1 first,
                                                                            final @Nullable T2 second,
                                                                            final @NonNull T3 third) throws NullException {
        return first != null ? second != null ? with(first, second, third) : withFirstAndThird(first, third) :
               second != null ? withSecondAndThird(second, third) : withThird(third);
    }

    /**
     * Если переданный второй и третий объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов), в
     * противном случае если только переданный второй объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта), в противном случае если только переданный третий объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта), в противном случае —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки переданного первого объекта и двух обёрток несуществующего
     * объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки переданного первого объекта и двух обёрток несуществующего
     * объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго или третьего объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> autoSecondAndThird(final @NonNull T1 first,
                                                                            final @Nullable T2 second,
                                                                            final @Nullable T3 third) throws NullException {
        return second != null ? third != null ? with(first, second, third) : withFirstAndSecond(first, second) :
               third != null ? withFirstAndThird(first, third) : withFirst(first);
    }

    /**
     * Если переданный первый и третий объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов), в
     * противном случае если только переданный первый объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта), в противном случае если только переданный третий объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов), в противном случае —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного второго
     * объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного второго
     * объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> autoFirstAndThird(final @Nullable T1 first,
                                                                           final @NonNull T2 second,
                                                                           final @Nullable T3 third) throws NullException {
        return first != null ? third != null ? with(first, second, third) : withFirstAndSecond(first, second) :
               third != null ? withSecondAndThird(second, third) : withSecond(second);
    }

    /**
     * Если переданный первый, второй и третий объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего объектов), в
     * противном случае если только переданный первый и второй объекты ненулевые, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта), в противном случае если только переданный первый и третий объекты ненулевые, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта), в противном случае если только переданный первый объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки переданного первого и двух обёрток несуществующего
     * объекта), в противном случае если только переданный второй и третий объекты ненулевые, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов), в противном случае если только переданный второй объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного второго
     * объекта), в противном случае если только переданный третий объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного
     * третьего объекта), в противном случае —
     * {@linkplain Impl#Impl() интегрированную реализацию обёртки на основе трёх обёрток несуществующего объекта}.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     * @param first первый объект.
     * @param second второй объект.
     * @param third третий объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional, Optional) Интегрированную реализацию обёртки на основе
     * переданных обёрток первого, второго и третьего объектов} (обёрток переданного первого, второго и третьего
     * объектов), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и второго объектов и обёртки
     * несуществующего объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёрток переданного первого и третьего объектов и обёртки
     * несуществующего объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки переданного первого и двух обёрток несуществующего
     * объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (обёртки несуществующего объекта и обёрток переданного второго и
     * третьего объектов), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного второго
     * объекта), или
     * {@linkplain Impl#Impl(Optional, Optional, Optional) интегрированную реализацию обёртки на основе переданных
     * обёрток первого, второго и третьего объектов} (двух обёрток несуществующего объекта и обёртки переданного
     * третьего объекта), или
     * {@linkplain Impl#Impl() интегрированную реализацию обёртки на основе трёх обёрток несуществующего объекта}.
     *
     * @see Impl
     * @see Impl#Impl()
     * @see Impl#Impl(Optional, Optional, Optional)
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
    static <T1, T2, T3> @NonNull TriOptional<T1, T2, T3> auto(final @Nullable T1 first, final @Nullable T2 second,
                                                              final @Nullable T3 third) {
        return first != null ?
               second != null ? third != null ? with(first, second, third) : withFirstAndSecond(first, second) :
               third != null ? withFirstAndThird(first, third) : withFirst(first) :
               second != null ? third != null ? withSecondAndThird(second, third) : withSecond(second) :
               third != null ? withThird(third) : without();
    }

    /**
     * Возвращает обёртку текущего третьего объекта.
     *
     * @return Обёртка текущего третьего объекта.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> const")
    @NonNull Optional<T3> third();

    /**
     * Интегрированная реализация обёртки трёх объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param <T3> тип третьего объекта.
     *
     * @see TriOptional
     * @see #Impl()
     * @see #Impl(Optional, Optional, Optional)
     * @since 4.0.0-RC3
     */
    class Impl<T1, T2, T3> extends BiOptional.Impl<T1, T2> implements TriOptional<T1, T2, T3> {

        /**
         * Обёртка текущего третьего объекта.
         *
         * @since 4.0.0-RC3
         */
        protected final @NonNull Optional<T3> third;

        /**
         * Создаёт интегрированную реализацию обёртки трёх объектов на основе трёх обёрток несуществующего объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("-> new")
        public Impl() {
            this(Optional.without(), Optional.without(), Optional.without());
        }

        /**
         * Создаёт интегрированную реализацию обёртки трёх объектов на основе переданных обёрток первого, второго и
         * третьего объектов.
         *
         * @param first обёртка первого объекта.
         * @param second обёртка второго объекта.
         * @param third обёртка третьего объекта.
         *
         * @throws NullException исключение валидации нулевого объекта (переданной обёртки первого, второго или третьего
         * объекта).
         * @since 4.0.0-RC3
         */
        @Contract("!null, !null, !null -> new; _, _, _ -> fail")
        public Impl(final @NonNull Optional<T1> first, final @NonNull Optional<T2> second,
                    final @NonNull Optional<T3> third) throws NullException {
            super(first, second);
            this.third = Validator.notNull(third, "The passed optional of the third object");
        }

        /**
         * Возвращает {@linkplain #third обёртку текущего третьего объекта}.
         *
         * @return {@linkplain #third Обёртка текущего третьего объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> const")
        public @NonNull Optional<T3> third() {
            return third;
        }

    }

}
