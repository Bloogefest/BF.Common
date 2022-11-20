package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс потребителя объекта.
 *
 * @param <T> тип потребляемого объекта.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Создаёт пустого потребителя.
     *
     * @return Пустой потребитель.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Consumer<T> empty() {
        return __ -> {};
    }

    /**
     * Проверяет потребителя и возвращает его.
     *
     * @param consumer потребитель.
     *
     * @return Проверенный потребитель.
     *
     * @throws NullException потребитель не должен являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Consumer<T> of(final @NotNull Consumer<T> consumer) throws NullException {
        return Validator.notNull(consumer, "consumer");
    }

    /**
     * Потребляет объект.
     *
     * @param object объект.
     *
     * @throws NullException    объект не должен являться нулём.
     * @throws ConsumeException невозможно потребить объект.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void consume(final @Nullable T object) throws NullException, ConsumeException;

    /**
     * Комбинирует данный потребитель с переданным.
     * Гарантирует последовательное потребление объекта потребителями.
     *
     * @param consumer потребитель.
     *
     * @return Комбинированный потребитель.
     *
     * @throws NullException потребитель не должен являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Consumer<T> with(final @NotNull Consumer<T> consumer) throws NullException {
        Validator.notNull(consumer, "consumer");
        return object -> {
            try {
                consume(object);
            } finally {
                consumer.consume(object);
            }
        };
    }

}
