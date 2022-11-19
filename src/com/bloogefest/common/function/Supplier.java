package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс, позволяющий реализовать логику поставки типизированного экземпляра.
 *
 * @param <T> тип поставляемого экземпляра.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Создаёт строгий экземпляр данного интерфейса.
     * Гарантирует поставку только переданного типизированного экземпляра.
     *
     * @param object задаваемый экземпляр.
     *
     * @return Строгий экземпляр данного интерфейса.
     *
     * @throws NullException переданный типизированный экземпляр является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    static <T> @NotNull Supplier<T> strict(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

    /**
     * Проверяет переданный экземпляр данного интерфейса и возвращает его.
     *
     * @param supplier экземпляр данного интерфейса.
     *
     * @return Переданный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Supplier<T> of(final @NotNull Supplier<T> supplier) throws NullException {
        return Validator.notNull(supplier, "supplier");
    }

    /**
     * Выполняет логику поставки типизированного экземпляра.
     *
     * @return Типизированный экземпляр.
     *
     * @throws SupplyException невозможно продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    @NotNull T supply() throws SupplyException;

    /**
     * Комбинирует переданный поставляемый экземпляр с данным экземпляром.
     * Гарантирует поставку только переданного типизированного экземпляра.
     *
     * @param object поставляемый экземпляр.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @throws NullException переданный типизированный экземпляр является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Supplier<T> suppress(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return () -> object;
    }

}
