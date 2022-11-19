package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс, позволяющий реализовать логику вне контекста.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Action {

    /**
     * Создаёт пустой экземпляр данного интерфейса.
     *
     * @return Пустой экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static @NotNull Action empty() {
        return () -> {};
    }

    /**
     * Проверяет переданный экземпляр данного интерфейса и возвращает его.
     *
     * @param action экземпляр данного интерфейса.
     *
     * @return Переданный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static @NotNull Action of(final @NotNull Action action) throws NullException {
        return Validator.notNull(action, "action");
    }

    /**
     * Выполняет логику вне контекста.
     *
     * @throws PerformException невозможно продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void perform() throws PerformException;

    /**
     * Комбинирует переданный экземпляр данного интерфейса с данным экземпляром.
     * Гарантирует выполнение логики обоих экземпляров данного интерфейса,
     * начиная с данного и заканчивая переданным.
     *
     * @param action экземпляр данного интерфейса.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Action with(final @NotNull Action action) throws NullException {
        Validator.notNull(action, "action");
        return () -> {
            try {
                perform();
            } finally {
                action.perform();
            }
        };
    }

}
