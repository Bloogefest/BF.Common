package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс, позволяющий реализовать логику задания типизированного экземпляра.
 *
 * @param <T> тип задаваемого экземпляра.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Setter<T> {

    /**
     * Создаёт пустой экземпляр данного интерфейса.
     *
     * @return Пустой экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Setter<T> empty() {
        return __ -> {};
    }

    /**
     * Проверяет переданный экземпляр данного интерфейса и возвращает его.
     *
     * @param setter экземпляр данного интерфейса.
     *
     * @return Переданный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Setter<T> of(final @NotNull Setter<T> setter) throws NullException {
        return Validator.notNull(setter, "setter");
    }

    /**
     * Выполняет логику задания типизированного экземпляра.
     *
     * @param object типизированный экземпляр.
     *
     * @throws NullException переданный типизированный экземпляр является нулевым.
     * @throws SetException невозможно продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void set(final @Nullable T object) throws NullException, SetException;

    /**
     * Комбинирует переданный экземпляр данного интерфейса с данным экземпляром.
     * Гарантирует выполнение логики обоих экземпляров данного интерфейса,
     * начиная с данного и заканчивая переданным.
     *
     * @param setter экземпляр данного интерфейса.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    default @NotNull Setter<T> with(final @NotNull Setter<T> setter) throws NullException {
        Validator.notNull(setter, "setter");
        return object -> {
            try {
                set(object);
            } finally {
                setter.set(object);
            }
        };
    }

    /**
     * Комбинирует переданный типизированный экземпляр с данным экземпляром.
     * Гарантирует выполнение логики задания только этого типизированного экземпляра.
     *
     * @param object типизированный экземпляр.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    default @NotNull Setter<T> suppress(final @Nullable T object) {
        return __ -> set(object);
    }

}
