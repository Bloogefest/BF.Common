package com.bloogefest.common.environment;

import com.bloogefest.common.environment.version.EnvironmentVersion;
import org.jetbrains.annotations.ApiStatus.AvailableSince;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * Среда выполнения.
 *
 * @author Bloogefest
 * @version 1.0
 * @apiNote Рекомендуется использовать только реализацию по умолчанию, во избежание возникновения неожиданных проблем.
 * @see #defaultInstance() Реализация по умолчанию.
 * @since 0.3.0
 */
@Experimental
@AvailableSince("0.3.0")
@SuppressWarnings("unused")
public interface Environment {

    /**
     * Код завершения работы по умолчанию.
     *
     * @see #shutdown()
     * @see #shutdown(int)
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    int DEFAULT_SHUTDOWN_CODE = 0;

    /**
     * Код принудительного завершения работы по умолчанию.
     *
     * @see #halt()
     * @see #halt(int)
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    int DEFAULT_HALT_CODE = 0;

    /**
     * Возвращает экземпляр среды выполнения с реализацией по умолчанию.
     * Если такого экземпляра не существует, создаёт его, сохраняет и возвращает.
     *
     * @return Экземпляр среды выполнения по умолчанию.
     *
     * @apiNote Рекомендуется использовать только данный метод для получения экземпляра среды выполнения,
     * ведь реализация по умолчанию гарантированно соответствует всем требованиям спецификации.
     * @implNote Рекомендуется использовать метод хранения экземпляра среды выполнения,
     * поддерживающий ленивую инициализацию, для повышения производительности и эффективности.
     * @author Bloogefest
     * @see Environment Среда выполнения.
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    static @NotNull Environment defaultInstance() {
        interface Internal {

            /**
             * Экземпляр среды выполнения по умолчанию.
             *
             * @since 0.3.0
             */
            @Experimental
            @AvailableSince("0.3.0")
            @NotNull Environment defaultInstance = new Environment() {};

        }
        return Internal.defaultInstance;
    }

    /**
     * Возвращает экземпляр версии среды выполнения с реализацией по умолчанию.
     * Если такого экземпляра не существует, создаёт его, сохраняет и возвращает.
     *
     * @return Экземпляр версии среды выполнения по умолчанию.
     *
     * @apiNote Рекомендуется использовать только данный метод для получения экземпляра среды выполнения,
     * ведь реализация по умолчанию гарантированно соответствует всем требованиям спецификации.
     * @implSpec Предполагается возврат постоянного экземпляра версии среды выполнения с корректной реализацией,
     * гарантированно соответствующей всем требованиям спецификации.
     * @implNote Рекомендуется использовать метод хранения экземпляра версии среды выполнения,
     * поддерживающий ленивую инициализацию, для повышения производительности и эффективности.
     * @author Bloogefest
     * @see EnvironmentVersion Версия среды выполнения.
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    default @NotNull EnvironmentVersion version() {
        interface Internal {

            /**
             * Экземпляр версии среды выполнения по умолчанию.
             *
             * @since 0.3.0
             */
            @Experimental
            @AvailableSince("0.3.0")
            @NotNull EnvironmentVersion defaultInstance = new EnvironmentVersion() {};

        }
        return Internal.defaultInstance;
    }

    /**
     * Возвращает количество ядер процессора, доступных для среды выполнения.
     *
     * @return Количество ядер процессора, доступных для среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение,
     * если это может повысить производительность, эффективность и т.п.,
     * ведь оно способно изменяться время от времени.
     * @author Bloogefest
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    default @Range(from = 1, to = Integer.MAX_VALUE) int availableCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Возвращает количество оперативной памяти, доступной для среды выполнения на момент вызова данного метода.
     *
     * @return Количество оперативной памяти, доступных для среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение,
     * если это может повысить производительность, эффективность и т.п.,
     * ведь оно способно изменяться время от времени.
     * @author Bloogefest
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    default @Range(from = 0, to = Integer.MAX_VALUE) long availableMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    /**
     * Возвращает количество оперативной памяти, не загруженной компонентами среды выполнения на момент вызова данного метода.
     *
     * @return Количество оперативной памяти, не загруженной компонентами среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение,
     * если это может повысить производительность, эффективность и т.п.,
     * ведь оно способно изменяться время от времени.
     * @author Bloogefest
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    default @Range(from = 0, to = Integer.MAX_VALUE) long unloadedMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    /**
     * Возвращает количество оперативной памяти, загруженной компонентами среды выполнения на момент вызова данного метода.
     *
     * @return Количество оперативной памяти, загруженной компонентами среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение,
     * если это может повысить производительность, эффективность и т.п.,
     * ведь оно способно изменяться время от времени.
     * @author Bloogefest
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract(pure = true)
    default @Range(from = 0, to = Integer.MAX_VALUE) long loadedMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    /**
     * Запускает сборщик мусора в среде выполнения.
     *
     * @author Bloogefest
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract
    default void collectGarbage() {
        Runtime.getRuntime().gc();
    }

    /**
     * Завершает работу среды выполнения, используя код по умолчанию.
     *
     * @throws EnvironmentException отсутствие разрешения на завершение работы.
     * @author Bloogefest
     * @see #DEFAULT_SHUTDOWN_CODE  Код по умолчанию.
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract("-> fail")
    default void shutdown() throws EnvironmentException {
        shutdown(DEFAULT_SHUTDOWN_CODE);
    }

    /**
     * Завершает работу среды выполнения, используя переданный код.
     *
     * @param code код завершения работы.
     *
     * @throws EnvironmentException отсутствие разрешения на завершение работы.
     * @author Bloogefest
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract("_ -> fail")
    default void shutdown(final @Range(from = Integer.MIN_VALUE, to = Integer.MAX_VALUE) int code) throws EnvironmentException {
        try {
            Runtime.getRuntime().exit(code);
        } catch (final SecurityException e) {
            throw new EnvironmentException(e);
        }
    }

    /**
     * Принудительно завершает работу среды выполнения, используя код по умолчанию.
     *
     * @throws EnvironmentException отсутствие разрешения на принудительное завершение работы.
     * @author Bloogefest
     * @see #DEFAULT_HALT_CODE  Код по умолчанию.
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract("-> fail")
    default void halt() throws EnvironmentException {
        halt(DEFAULT_HALT_CODE);
    }

    /**
     * Принудительно завершает работу среды выполнения, используя переданный код.
     *
     * @param code код принудительного завершения работы.
     *
     * @throws EnvironmentException отсутствие разрешения на принудительное завершение работы.
     * @author Bloogefest
     * @since 0.3.0
     */
    @Experimental
    @AvailableSince("0.3.0")
    @Contract("_ -> fail")
    default void halt(final @Range(from = Integer.MIN_VALUE, to = Integer.MAX_VALUE) int code) throws EnvironmentException {
        try {
            Runtime.getRuntime().halt(code);
        } catch (final SecurityException e) {
            throw new EnvironmentException(e);
        }
    }

}
