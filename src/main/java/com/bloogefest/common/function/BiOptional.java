/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.annotation.analysis.Contract;
import com.bloogefest.annotation.analysis.NotNull;
import com.bloogefest.annotation.analysis.Nullable;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;

/**
 * Обёртка двух объектов — это функциональный инструмент, способный содержать два объекта. Он предоставляет методы для
 * получения их обёрток ({@linkplain #first()}, {@linkplain #second()}).
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
public interface BiOptional<T1, T2> {

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl() интегрированную реализацию обёртки двух объектов на основе двух обёрток несуществующего
     * объекта}.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     *
     * @return {@linkplain Impl#Impl() Интегрированную реализацию обёртки двух объектов на основе двух обёрток
     * несуществующего объекта}.
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
    static <T1, T2> @NotNull BiOptional<T1, T2> without() {
        return new Impl<>();
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объекта} (обёртки переданного первого объекта и обёртки несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param object первый объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional) Интегрированную реализацию обёртки на основе переданных обёрток
     * первого и второго объектов} (обёртки переданного первого объекта и обёртки несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional)
     * @see #without()
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null -> new; _ -> fail")
    static <T1, T2> @NotNull BiOptional<T1, T2> withFirst(final @NotNull T1 object) throws NullException {
        return new Impl<>(Optional.with(object), Optional.without());
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки несуществующего объекта и обёртки переданного второго объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param object второй объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional) Интегрированную реализацию обёртки на основе переданных обёрток
     * первого и второго объекта} (обёртки несуществующего объекта и обёртки переданного второго объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional)
     * @see #without()
     * @see #withFirst(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null -> new; _ -> fail")
    static <T1, T2> @NotNull BiOptional<T1, T2> withSecond(final @NotNull T2 object) throws NullException {
        return new Impl<>(Optional.without(), Optional.with(object));
    }

    /**
     * Создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёрток переданного первого и второго объектов).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional) Интегрированную реализацию обёртки двух объектов на основе
     * переданных обёрток первого и второго объекта)}.
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого или второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, !null -> new; _, _ -> fail")
    static <T1, T2> @NotNull BiOptional<T1, T2> with(final @NotNull T1 first,
                                                     final @NotNull T2 second) throws NullException {
        return new Impl<>(Optional.with(first), Optional.with(second));
    }

    /**
     * Если переданный первый объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёрток переданного первого и второго объектов), в противном случае —
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки несуществующего объекта и обёртки переданного второго объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional) Интегрированную реализацию обёртки на основе переданных обёрток
     * первого и второго объектов} (обёрток переданного первого и второго объектов) или
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки несуществующего объекта и обёртки переданного второго объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного второго объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoSecond(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, !null -> new; _, _ -> fail")
    static <T1, T2> @NotNull BiOptional<T1, T2> autoFirst(final @Nullable T1 first,
                                                          final @NotNull T2 second) throws NullException {
        return first != null ? with(first, second) : withSecond(second);
    }

    /**
     * Если переданный второй объект ненулевой, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёрток переданного первого и второго объектов), в противном случае —
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки переданного первого объекта и обёртки несуществующего объекта).
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional) Интегрированную реализацию обёртки на основе переданных обёрток
     * первого и второго объектов} (обёрток переданного первого и второго объектов) или
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки переданного первого объекта и обёртки несуществующего объекта).
     *
     * @throws NullException исключение валидации нулевого объекта (переданного первого объекта).
     * @see Impl
     * @see Impl#Impl(Optional, Optional)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #auto(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("!null, _ -> new; _, _ -> fail")
    static <T1, T2> @NotNull BiOptional<T1, T2> autoSecond(final @NotNull T1 first,
                                                           final @Nullable T2 second) throws NullException {
        return second != null ? with(first, second) : withFirst(first);
    }

    /**
     * Если переданные первый и второй объекты ненулевые, то создаёт и возвращает
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёрток переданного первого и второго объектов), в противном случае если только переданный
     * первый объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки переданного первого объекта и обёртки несуществующего объекта), в противном случае
     * если только переданный второй объект ненулевой, то —
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки несуществующего объекта и обёртки переданного второго объекта), в противном случае —
     * {@linkplain Impl#Impl() интегрированную реализацию обёртки двух объектов на основе двух обёрток несуществующего
     * объекта}.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     * @param first первый объект.
     * @param second второй объект.
     *
     * @return {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток
     * первого и второго объектов} (обёрток переданного первого и второго объектов), или
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки переданного первого объекта и обёртки несуществующего объекта), или
     * {@linkplain Impl#Impl(Optional, Optional) интегрированную реализацию обёртки на основе переданных обёрток первого
     * и второго объектов} (обёртки несуществующего объекта и обёртки переданного второго объекта), или
     * {@linkplain Impl#Impl() интегрированную реализацию обёртки двух объектов на основе двух обёрток несуществующего
     * объекта}
     *
     * @see Impl#Impl()
     * @see Impl#Impl(Optional, Optional)
     * @see #without()
     * @see #withFirst(Object)
     * @see #withSecond(Object)
     * @see #with(Object, Object)
     * @see #autoFirst(Object, Object)
     * @see #autoSecond(Object, Object)
     * @since 4.0.0-RC3
     */
    @Contract("_, _ -> new")
    static <T1, T2> @NotNull BiOptional<T1, T2> auto(final @Nullable T1 first, final @Nullable T2 second) {
        return first != null ? second != null ? with(first, second) : withFirst(first) :
               second != null ? withSecond(second) : without();
    }

    /**
     * Возвращает обёртку текущего первого объекта.
     *
     * @return Обёртка текущего первого объекта.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> const")
    @NotNull Optional<T1> first();

    /**
     * Возвращает обёртку текущего второго объекта.
     *
     * @return Обёртка текущего второго объекта.
     *
     * @since 4.0.0-RC3
     */
    @Contract("-> const")
    @NotNull Optional<T2> second();

    /**
     * Интегрированная реализация обёртки двух объектов.
     *
     * @param <T1> тип первого объекта.
     * @param <T2> тип второго объекта.
     *
     * @see BiOptional
     * @see #Impl()
     * @see #Impl(Optional, Optional)
     * @since 4.0.0-RC3
     */
    class Impl<T1, T2> implements BiOptional<T1, T2> {

        /**
         * Обёртка текущего первого объекта.
         *
         * @since 4.0.0-RC3
         */
        protected final @NotNull Optional<T1> first;

        /**
         * Обёртка текущего второго объекта.
         *
         * @since 4.0.0-RC3
         */
        protected final @NotNull Optional<T2> second;

        /**
         * Создаёт интегрированную реализацию обёртки двух объектов на основе двух обёрток несуществующего объекта.
         *
         * @since 4.0.0-RC3
         */
        @Contract("-> new")
        public Impl() {
            this(Optional.without(), Optional.without());
        }

        /**
         * Создаёт интегрированную реализацию обёртки двух объектов на основе переданных обёрток первого и второго
         * объектов.
         *
         * @param first обёртка первого объекта.
         * @param second обёртка второго объекта.
         *
         * @throws NullException исключение валидации нулевого объекта (переданной обёртки первого или второго
         * объекта).
         * @since 4.0.0-RC3
         */
        @Contract("!null, !null -> new; _, _ -> fail")
        public Impl(final @NotNull Optional<T1> first, final @NotNull Optional<T2> second) throws NullException {
            this.first = Validator.notNull(first, "The passed optional of the first object");
            this.second = Validator.notNull(second, "The passed optional of the second object");
        }

        /**
         * Возвращает {@linkplain #first обёртку текущего первого объекта}.
         *
         * @return {@linkplain #first Обёртка текущего первого объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> const")
        public @NotNull Optional<T1> first() {
            return first;
        }

        /**
         * Возвращает {@linkplain #second обёртку текущего второго объекта}.
         *
         * @return {@linkplain #second Обёртка текущего второго объекта}.
         *
         * @since 4.0.0-RC3
         */
        @Override
        @Contract("-> const")
        public @NotNull Optional<T2> second() {
            return second;
        }

    }

}
