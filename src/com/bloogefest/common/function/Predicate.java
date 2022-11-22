package com.bloogefest.common.function;

import com.bloogefest.common.base.Predicates;
import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс предиката объекта.
 *
 * @param <T> тип объекта.
 *
 * @author Bloogefest
 * @version 0.2
 * @see EvaluateException
 * @see Predicates
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Создаёт предикат объекта с постоянным результатом оценивания.
     *
     * @param result результат оценивания.
     *
     * @return Постоянный предикат объекта.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Predicate<T> constant(final boolean result) {
        return __ -> result;
    }

    /**
     * Проверяет предикат объекта и возвращает его.
     *
     * @param predicate предикат объекта.
     *
     * @return Проверенный предикат объекта.
     *
     * @throws NullException предикат объекта не должен быть нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T> @NotNull Predicate<T> of(final @NotNull Predicate<T> predicate) throws NullException {
        return Validator.notNull(predicate, "predicate");
    }

    /**
     * Оценивает объект и возвращает результат оценивания.
     *
     * @param object объект.
     *
     * @return Результат оценивания.
     *
     * @throws NullException     объект не должен быть нулевым.
     * @throws EvaluateException невозможно оценить объект.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> _", pure = true)
    boolean evaluate(final @NotNull T object) throws NullException, EvaluateException;

    /**
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> invert() {
        return object -> !evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> and(final Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) && predicate.evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> or(final Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) || predicate.evaluate(object);
    }

    /**
     * @param predicate Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> xor(final Predicate<T> predicate) throws NullException {
        Validator.notNull(predicate, "predicate");
        return object -> evaluate(object) ^ predicate.evaluate(object);
    }

    /**
     * @param object Not specified
     *
     * @return Not specified
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default Predicate<T> suppress(final boolean object) {
        return __ -> object;
    }

}
