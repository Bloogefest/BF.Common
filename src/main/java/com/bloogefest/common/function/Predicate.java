/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс предиката объекта.
 *
 * @param <T> оцениваемый тип.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Инициализирует предикат, метод оценивания которого всегда возвращает переданный результат оценивания.
     *
     * @param result результат оценивания.
     *
     * @return Предикат с постоянным результатом оценивания.
     *
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Predicate<T> constant(final boolean result) {
        return ignored -> result;
    }

    /**
     * Проверяет предикат и, если он ненулевой, возвращает его, в противном случае инициализирует и бросает исключение
     * валидации нулевого предиката.
     *
     * @param predicate предикат.
     *
     * @return Ненулевой предикат.
     *
     * @throws NullException исключение валидации нулевого предиката.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Predicate<T> of(final @NotNull Predicate<T> predicate) throws NullException {
        return Validator.notNull(predicate, "predicate");
    }

    /**
     * Оценивает объект, инициализирует результат оценивания и возвращает его.
     *
     * @param object объект.
     *
     * @return Результат оценивания.
     *
     * @throws NullException исключение валидации нулевого объекта.
     * @throws EvaluateException исключение оценивания объекта.
     * @since 1.0
     */
    @Contract
    boolean evaluate(final @NotNull T object) throws NullException, EvaluateException;

    /**
     * Инициализирует предикат, метод оценивания которого инвертирует результат оценивания этого предиката.
     *
     * @return Предикат с инвертированным результатом оценивания этого предиката.
     *
     * @since 1.0
     */
    @Contract(value = "-> new", pure = true)
    default @NotNull Predicate<T> invert() {
        return object -> !evaluate(object);
    }

    /**
     * Проверяет вторичный предикат и, если он нулевой, инициализирует исключение валидации нулевого вторичного
     * предиката, в противном случае инициализирует другой предикат, метод оценивания которого последовательно соединяет
     * метод оценивания этого и вторичного предиката конъюнкцией.
     *
     * @param predicate вторичный предикат.
     *
     * @return Предикат с соединённым конъюнкцией результатом оценивания этого и вторичного предиката.
     *
     * @throws NullException исключение валидации нулевого вторичного предиката.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> and(final @NotNull Predicate<? super T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) && predicate.evaluate(object);
    }

    /**
     * Проверяет вторичный предикат и, если он нулевой, инициализирует исключение валидации нулевого вторичного
     * предиката, в противном случае инициализирует другой предикат, метод оценивания которого последовательно соединяет
     * метод оценивания этого и вторичного предиката строгой дизъюнкцией.
     *
     * @param predicate вторичный предикат.
     *
     * @return Предикат с соединённым строгой дизъюнкцией результатом оценивания этого и вторичного предиката.
     *
     * @throws NullException исключение валидации нулевого вторичного предиката.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> xor(final @NotNull Predicate<? super T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) ^ predicate.evaluate(object);
    }

    /**
     * Проверяет вторичный предикат и, если он нулевой, инициализирует исключение валидации нулевого вторичного
     * предиката, в противном случае инициализирует другой предикат, метод оценивания которого последовательно соединяет
     * метод оценивания этого и вторичного предиката мягкой дизъюнкцией.
     *
     * @param predicate вторичный предикат.
     *
     * @return Предикат с соединённым мягкой дизъюнкцией результатом оценивания этого и вторичного предиката.
     *
     * @throws NullException исключение валидации нулевого вторичного предиката.
     * @since 1.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> or(final @NotNull Predicate<? super T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) || predicate.evaluate(object);
    }

    /**
     * Проверяет обратный вызов и, если он нулевой, инициализирует исключение валидации нулевого обратного вызова, в
     * противном случае инициализирует предикат, метод оценивания которого проверяет результат оценивания этого
     * предиката и, если он истинный, вызывает функцию обратного вызова, а после возвращает результат оценивания этого
     * предиката.
     *
     * @param callback обратный вызов.
     *
     * @return Предикат с результатом оценивания этого предиката, при истинности которого вызывается функция обратного
     * вызова.
     *
     * @throws NullException исключение валидации нулевого обратного вызова.
     * @since 4.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> then(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return object -> {
            final var result = evaluate(object);
            if (result) callback.call();
            return result;
        };
    }

    /**
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> then(final @NotNull Handler<T> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return object -> {
            final var result = evaluate(object);
            if (result) handler.handle(object);
            return result;
        };
    }

    /**
     * Проверяет поставщик и, если он нулевой, инициализирует исключение валидации нулевого поставщика с
     * переопределённым сообщением, отформатированным именем поставщика шаблонным сообщением, в противном случае
     * инициализирует предикат, метод оценивания которого проверяет результат оценивания этого предиката и, если он
     * истинный, инициализирует исключение оценивания объекта с переопределённой причиной, полученным исключением либо
     * ошибкой от поставщика, и бросает его, в противном случае возвращает ложный результат оценивания этого предиката.
     *
     * @param supplier поставщик исключения либо ошибки.
     *
     * @return Предикат с результатом оценивания этого предиката, при истинности которого инициализируется исключение
     * оценивания объекта с переопределённой причиной, полученным исключением либо ошибкой от поставщика, и бросается.
     *
     * @throws NullException исключение валидации нулевого поставщика.
     * @since 4.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> then(final @NotNull Supplier<? extends Throwable> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return object -> {
            if (evaluate(object)) throw new EvaluateException(supplier.supply());
            return false;
        };
    }

    /**
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> otherwise(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return object -> {
            final var result = evaluate(object);
            if (!result) callback.call();
            return result;
        };
    }

    /**
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> otherwise(final @NotNull Handler<T> handler) throws NullException {
        Validator.notNull(handler, "handler");
        return object -> {
            final var result = evaluate(object);
            if (!result) handler.handle(object);
            return result;
        };
    }

    /**
     * @since 3.1
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Predicate<T> otherwise(
            final @NotNull Supplier<? extends Throwable> supplier) throws NullException {
        Validator.notNull(supplier, "supplier");
        return object -> {
            if (!evaluate(object)) throw new ComputeException(supplier.supply());
            return true;
        };
    }

}
