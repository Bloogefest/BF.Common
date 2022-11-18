package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс, позволяющий реализовать логику, не связанную с контекстом.
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Action {

    /**
     * Создаёт экземпляр данного функционального интерфейса, не содержащий логику.
     *
     * @return Экземпляр данного функционального интерфейса, не содержащий логику.
     *
     * @apiNote Данный метод всегда возвращает схожие между собой экземпляры данного функционального интерфейса, поэтому рекомендуется, кэшировать экземпляр, для разгрузки сборщика мусора.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static @NotNull Action empty() {
        return () -> {};
    }

    /**
     * Предоставляет экземпляр данного функционального интерфейса, преобразуя либо лямбда-выражение, либо экземпляр какого-либо типа в экземпляр данного функционального интерфейса.
     *
     * @param action либо лямбда-выражение, либо экземпляр какого-либо типа.
     *
     * @return Экземпляр данного функционального интерфейса.
     *
     * @throws NullException переданное значение является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static @NotNull Action of(final @NotNull Action action) throws NullException {
        return Validator.notNull(action, "action");
    }

    /**
     * Выполняет логику, не связанную с контекстом.
     *
     * @throws PerformException возникла исключительная ситуация, не позволяющая продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void perform() throws PerformException;

    /**
     * Предоставляет экземпляр данного функционального интерфейса, гарантирующий последовательное выполнение логики, начиная с данного и заканчивая либо переданным лямбда-выражением, либо переданным экземпляром какого-либо типа.
     *
     * @param action либо лямбда-выражение, либо экземпляр какого-либо типа.
     *
     * @return Экземпляр данного функционального интерфейса.
     *
     * @throws NullException переданное значение является нулевым.
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
