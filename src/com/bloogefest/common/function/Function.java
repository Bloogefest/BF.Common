package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс функции.
 *
 * @param <T> тип потребляемого объекта.
 * @param <R> тип результата потребления.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Создаёт функцию с нулевым результатом потребления.
     *
     * @return Нулевая функция.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T, R> @NotNull Function<T, R> nullable() {
        return __ -> null;
    }

    /**
     * Создаёт функцию с постоянным результатом потребления.
     *
     * @param result результат потребления.
     *
     * @return Постоянная функция.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T, R> @NotNull Function<T, R> constant(final @Nullable R result) {
        return __ -> result;
    }

    /**
     * Проверяет функцию и возвращает её.
     *
     * @param function функция.
     *
     * @return Проверенная функция.
     *
     * @throws NullException функция не должна являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T, R> @NotNull Function<T, R> of(final @NotNull Function<T, R> function) throws NullException {
        return Validator.notNull(function, "function");
    }

    /**
     * Потребляет объект и возвращает результат потребления.
     *
     * @param object объект.
     *
     * @return Результат потребления.
     *
     * @throws NullException объект не должен являться нулём.
     * @throws ExecuteException невозможно потребить объект.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @Nullable R execute(final @Nullable T object) throws NullException, ExecuteException;

    /**
     * Комбинирует данную функцию с переданной.
     *
     * @param function функция.
     *
     * @return Комбинированная функция.
     *
     * @throws NullException фунция не должна являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <R_> @NotNull Function<T, R_> with(final @NotNull Function<R, R_> function) throws NullException {
        Validator.notNull(function, "function");
        return object -> function.execute(execute(object));
    }

}
