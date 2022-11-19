package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс, позволяющий реализовать логику внутри контекста.
 *
 * @param <T> тип контекстного экземпляра.
 * @param <R> тип возвращаемого экземпляра.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Создаёт нулевой экземпляр данного интерфейса.
     * Гарантирует возврат только нулевого типизированного экземпляра.
     *
     * @return Нулевой экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T, R> @NotNull Function<T, R> nullable() {
        return __ -> null;
    }

    /**
     * Создаёт строгий экземпляр данного интерфейса.
     * Гарантирует возврат только переданного типизированного экземпляра.
     *
     * @param result возвращаемый экземпляр.
     *
     * @return Строгий экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    static <T, R> @NotNull Function<T, R> strict(final @Nullable R result) {
        return __ -> result;
    }

    /**
     * Проверяет переданный экземпляр данного интерфейса и возвращает его.
     *
     * @param function экземпляр данного интерфейса.
     *
     * @return Переданный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T, R> @NotNull Function<T, R> of(final @NotNull Function<T, R> function) throws NullException {
        return Validator.notNull(function, "function");
    }

    /**
     * Выполняет логику внутри контекста.
     *
     * @return Типизированный экземпляр.
     *
     * @throws ExecuteException невозможно продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @Nullable R execute(final @Nullable T object) throws ExecuteException;

    /**
     * Комбинирует переданный экземпляр данного интерфейса с данным экземпляром.
     *
     * @param function экземпляр данного интерфейса.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default <R_> @NotNull Function<T, R_> with(final @NotNull Function<? super R, R_> function) throws NullException {
        Validator.notNull(function, "function");
        return object -> function.execute(execute(object));
    }

    /**
     * Комбинирует переданный возвращаемый экземпляр с данным экземпляром.
     * Гарантирует возврат только переданного типизированного экземпляра.
     *
     * @param object возвращаемый экземпляр.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Function<T, R> suppress(final @NotNull T object) {
        return __ -> execute(object);
    }

}
