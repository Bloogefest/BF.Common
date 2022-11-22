package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс поставщика объекта.
 *
 * @param <T> тип объекта.
 *
 * @author Bloogefest
 * @version 0.3
 * @see SupplyException
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Создаёт поставщик объекта с постоянным объектом.
     *
     * @param object объект.
     *
     * @return Постоянный поставщик объекта.
     *
     * @throws NullException объект не должен быть нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> @NotNull Supplier<T> constant(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

    /**
     * Проверяет поставщик объекта и возвращает его.
     *
     * @param supplier поставщик объекта.
     *
     * @return Проверенный поставщик объекта.
     *
     * @throws NullException поставщик объекта не должен быть нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Supplier<T> of(final @NotNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Поставляет объект.
     *
     * @return Объект.
     *
     * @throws SupplyException невозможно поставить объект.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @NotNull T supply() throws SupplyException;

}
