package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс, являющийся действием.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Action {

    /**
     * Создаёт пустое действие..
     *
     * @return Пустое действие.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static @NotNull Action empty() {
        return () -> {};
    }

    /**
     * Проверяет действие и возвращает его.
     *
     * @param action действие.
     *
     * @return Проверенное действие.
     *
     * @throws NullException действие является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static @NotNull Action of(final @NotNull Action action) throws NullException {
        return Validator.notNull(action, "action");
    }

    /**
     * Выполняет действие.
     *
     * @throws PerformException невозможно выполнить действие.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void perform() throws PerformException;

    /**
     * Комбинирует данное действие с переданным.
     * Гарантирует последовательное выполнение обоих действий.
     *
     * @param action действие.
     *
     * @return Комбинированное действие.
     *
     * @throws NullException действие является нулевым.
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
