package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс потребителя объекта.
 *
 * @param <T> тип объекта.
 *
 * @author Bloogefest
 * @version 0.2
 * @see ConsumeException
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Создаёт пустого потребителя объекта.
     *
     * @return Пустой потребитель объекта.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Consumer<T> empty() {
        return __ -> {};
    }

    /**
     * Проверяет потребителя объекта и возвращает его.
     *
     * @param consumer потребитель объекта.
     *
     * @return Проверенный потребитель объекта.
     *
     * @throws NullException потребитель объекта не должен быть нулевым.
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
     * @throws NullException    объект не должен быть нулевым.
     * @throws ConsumeException невозможно потребить объект.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void consume(final @NotNull T object) throws NullException, ConsumeException;

    /**
     * Комбинирует данный потребитель объекта с переданным.
     * Гарантирует последовательное потребление объекта обоими потребителями.
     *
     * @param consumer потребитель объекта.
     *
     * @return Комбинированный потребитель объекта.
     *
     * @throws NullException потребитель объекта не должен быть нулевым.
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
