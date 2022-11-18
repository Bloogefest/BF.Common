package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Функциональный интерфейс, позволяющий реализовать логику для обработки типизированного экземпляра.
 *
 * @param <T> тип обрабатываемого экземпляра.
 *
 * @author Bloogefest
 * @version 0.0
 * @since 0.0.0
 */
@FunctionalInterface
public interface Consumer<T> {

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
    static <T> @NotNull Consumer<T> empty() {
        return __ -> {};
    }

    /**
     * Предоставляет экземпляр данного функционального интерфейса, преобразуя либо лямбда-выражение, либо экземпляр какого-либо типа в экземпляр данного функционального интерфейса.
     *
     * @param consumer либо лямбда-выражение, либо экземпляр какого-либо типа.
     *
     * @return Экземпляр данного функционального интерфейса.
     *
     * @throws NullException переданное значение является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <T> @NotNull Consumer<T> of(final @NotNull Consumer<T> consumer) throws NullException {
        return Validator.notNull(consumer, "consumer");
    }

    /**
     * Выполняет логику, не связанную с контекстом.
     *
     * @param object типизированный экземпляр.
     *
     * @throws NullException переданное значение является нулевым.
     * @throws ConsumeException возникла исключительная ситуация, не позволяющая продолжить выполнение логики.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void consume(final @NotNull T object) throws NullException, ConsumeException;

    /**
     * Предоставляет экземпляр данного функционального интерфейса, гарантирующий последовательное выполнение логики, начиная с данного и заканчивая либо переданным лямбда-выражением, либо переданным экземпляром какого-либо типа.
     *
     * @param consumer либо лямбда-выражение, либо экземпляр какого-либо типа.
     *
     * @return Экземпляр данного функционального интерфейса.
     *
     * @throws NullException переданное значение является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Consumer<T> with(final @NotNull Consumer<T> consumer) throws NullException {
        Validator.notNull(consumer, "consumer");
        return object -> {
            consume(object);
            consumer.consume(object);
        };
    }

    /**
     * Подавляет любые типизированные экземпляры переданным.
     *
     * @param object типизированный экземпляр.
     *
     * @return Экземпляр данного функционального интерфейса.
     *
     * @throws NullException переданное значение является нулевым.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Consumer<T> suppress(final @NotNull T object) throws NullException {
        Validator.notNull(object, "object");
        return __ -> consume(object);
    }

}
