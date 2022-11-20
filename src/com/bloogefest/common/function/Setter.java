package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Функциональный интерфейс установщика значения.
 *
 * @param <V> тип значения.
 *
 * @author Bloogefest
 * @version 0.1
 * @since 0.0.0
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface Setter<V> {

    /**
     * Создаёт пустой установщик значения.
     *
     * @return Пустой установщик значения.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "-> new", pure = true)
    static <V> @NotNull Setter<V> empty() {
        return __ -> {};
    }

    /**
     * Проверяет установщик значения и возвращает его.
     *
     * @param setter установщик значения.
     *
     * @return Проверенный установщик значения.
     *
     * @throws NullException установщик значения не должно являться нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(value = "_ -> param1", pure = true)
    static <V> @NotNull Setter<V> of(final @NotNull Setter<V> setter) throws NullException {
        return Validator.notNull(setter, "setter");
    }

    /**
     * Устанавливает значение.
     *
     * @param value значение.
     *
     * @throws NullException значение не должно быть нулём.
     * @throws SetException  невозможно установить значение.
     * @author Bloogefest
     * @since 0.0.0
     */
    @Contract(pure = true)
    void set(final @Nullable V value) throws NullException, SetException;

    /**
     * Комбинирует данный установщик значения с переданным.
     * Гарантирует последовательную установку значения обоими установщиками.
     *
     * @param setter установщик значения.
     *
     * @return Комбинированный установщик значения.
     *
     * @throws NullException установщик значения не должен быть нулём.
     * @author Bloogefest
     * @since 0.0.0
     */
    default @NotNull Setter<V> with(final @NotNull Setter<V> setter) throws NullException {
        Validator.notNull(setter, "setter");
        return value -> {
            try {
                set(value);
            } finally {
                setter.set(value);
            }
        };
    }

}
