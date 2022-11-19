package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс, позволяющий реализовать логику возврата типизированного экземпляра.
 *
 * @param <T> тип возвращаемого экземпляра.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Getter<T> {

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
    static <T> @NotNull Getter<T> nullable() {
        return () -> null;
    }

    /**
     * Создаёт строгий экземпляр данного интерфейса.
     * Гарантирует возврат только переданного типизированного экземпляра.
     *
     * @param object типизированный экземпляр.
     *
     * @return Строгий экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> @NotNull Getter<T> strict(final @Nullable T object) {
        return () -> object;
    }

    /**
     * Проверяет переданный экземпляр данного интерфейса и возвращает его.
     *
     * @param getter экземпляр данного интерфейса.
     *
     * @return Переданный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Getter<T> of(final @NotNull Getter<T> getter) throws NullException {
        return Validator.notNull(getter, "getter");
    }

    /**
     * Выполняет логику возврата типизированного экземпляра.
     *
     * @return Возвращаемый типизированный экземпляр.
     *
     * @throws GetException невозможно продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @Nullable T get() throws GetException;

    /**
     * Комбинирует переданный типизированный экземпляр с данным экземпляром.
     * Гарантирует возврат только переданного типизированного экземпляра.
     *
     * @param object типизированный экземпляр.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Getter<T> suppress(final @Nullable T object) {
        return () -> object;
    }

}
