package com.bloogefest.common.function;

import com.bloogefest.common.validation.NullException;
import com.bloogefest.common.validation.Validator;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Является функциональным интерфейсом обратного вызова.
 *
 * @author Bloogefest
 * @version 1.0
 * @see CallbackException
 * @since 0.2.0
 */
@ApiStatus.AvailableSince("0.2.0")
@SuppressWarnings("unused")
@FunctionalInterface
public interface Callback {

    /**
     * Производит пустой экземпляр обратного вызова.
     *
     * @return Пустой экземпляр обратного вызова.
     *
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(value = "-> new", pure = true)
    static @NotNull Callback empty() {
        return () -> {};
    }

    /**
     * Подтверждает ненулевое явление переданного экземпляра обратного вызова.
     *
     * @param callback экземпляр обратного вызова.
     *
     * @return Подтверждённый переданный экземпляр обратного вызова.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра обратного вызова.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(value = "_ -> param1", pure = true)
    static @NotNull Callback of(final @NotNull Callback callback) throws NullException {
        return Validator.notNull(callback, "callback");
    }

    /**
     * Выполняет обратный вызов.
     *
     * @throws CallbackException невозможность выполнения обратного вызова.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(pure = true)
    void call() throws CallbackException;

    /**
     * Подтверждает ненулевое явление переданного экземпляра обратного вызова.
     * Комбинирует данный экземпляр обратного вызова с переданным,
     * гарантируя последовательное выполнение обратного вызова каждым экземпляром.
     *
     * @param callback экземпляр обратного вызова.
     *
     * @return Комбинированный экземпляр обратного вызова.
     *
     * @throws NullException невозможность подтверждения ненулевого явления переданного экземпляра обратного вызова.
     * @author Bloogefest
     * @since 0.2.0
     */
    @ApiStatus.AvailableSince("0.2.0")
    @Contract(value = "_ -> new", pure = true)
    default @NotNull Callback with(final @NotNull Callback callback) throws NullException {
        Validator.notNull(callback, "callback");
        return () -> {
            try {
                call();
            } finally {
                callback.call();
            }
        };
    }

}
