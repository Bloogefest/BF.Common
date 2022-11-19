package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс, позволяющий реализовать логику обработки типизированного экземпляра.
 *
 * @param <T> тип обрабатываемого экземпляра.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Создаёт пустой экземпляр данного интерфейса.
     *
     * @return Пустой экземпляр данного интерфейса.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <T> @NotNull Consumer<T> empty() {
        return __ -> {};
    }

    /**
     * Проверяет переданный экземпляр данного интерфейса и возвращает его.
     *
     * @param consumer экземпляр данного интерфейса.
     *
     * @return Переданный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Consumer<T> of(final @NotNull Consumer<T> consumer) throws NullException {
        return Validator.notNull(consumer, "consumer");
    }

    /**
     * Выполняет логику обработки типизированного экземпляра.
     *
     * @param object обрабатываемый экземпляр.
     *
     * @throws NullException    переданный типизированный экземпляр является нулевым.
     * @throws ConsumeException невозможно продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void consume(final @NotNull T object) throws NullException, ConsumeException;

    /**
     * Комбинирует переданный экземпляр данного интерфейса с данным экземпляром.
     * Гарантирует выполнение логики обоих экземпляров данного интерфейса,
     * начиная с данного и заканчивая переданным.
     *
     * @param consumer экземпляр данного интерфейса.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @throws NullException переданный экземпляр данного интерфейса является нулевым.
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

    /**
     * Комбинирует переданный обрабатываемый экземпляр с данным экземпляром.
     * Гарантирует выполнение логики обработки только этого типизированного экземпляра.
     *
     * @param object обрабатываемый экземпляр.
     *
     * @return Комбинированный экземпляр данного интерфейса.
     *
     * @throws NullException переданный типизированный экземпляр является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Consumer<T> suppress(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return object_ -> {
            Validator.notNull(object_, "object");
            consume(object);
        };
    }

}
