/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.environment;

import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * Инструмент-представление среды выполнения.
 *
 * @version 1.0
 * @apiNote Используйте только экземпляр инструмента-представления среды выполнения с реализацией по умолчанию, во
 * избежание некорректной работы.
 * @implNote Следуйте спецификации, во избежание некорректной работы.
 * @see #defaultInstance() Метод получения реализации по умолчанию.
 * @since 3.0
 */
@Experimental
public interface Environment {

    /**
     * Статус завершения работы по умолчанию.
     *
     * @see #exit()
     * @see #exit(int)
     * @since 3.0
     */
    int DEFAULT_EXIT_STATUS = 0;

    /**
     * Статус принудительного завершения работы по умолчанию.
     *
     * @see #halt()
     * @see #halt(int)
     * @since 3.0
     */
    int DEFAULT_HALT_STATUS = 0;

    /**
     * Возвращает экземпляр инструмента-представления среды выполнения с реализацией по умолчанию.
     *
     * @return Экземпляр инструмента-представления среды выполнения с реализацией по умолчанию.
     *
     * @apiNote Используйте только данный метод для получения экземпляра инструмента-представления среды выполнения с
     * реализацией по умолчанию, во избежание некорректной работы.
     * @implSpec Всегда возвращайте один и тот же экземпляр инструмента-представления среды выполнения с реализацией по
     * умолчанию.
     * @see Environment Инструмент-представление среды выполнения.
     * @since 3.0
     */
    @Contract(pure = true)
    static @NotNull Environment defaultInstance() {
        interface Internal {

            @NotNull Environment defaultInstance = new Environment() {
            };

        }
        return Internal.defaultInstance;
    }

    /**
     * Возвращает количество ядер процессора, доступных для среды выполнения.
     *
     * @return Количество ядер процессора, доступных для среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение, если это может повысить производительность,
     * эффективность и т.п., ведь оно способно изменяться время от времени.
     * @since 3.0
     */
    @Experimental
    @Contract(pure = true)
    default @Range(from = 1, to = Integer.MAX_VALUE) int availableCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Возвращает количество оперативной памяти, доступной для среды выполнения на момент вызова данного метода.
     *
     * @return Количество оперативной памяти, доступных для среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение, если это может повысить производительность,
     * эффективность и т.п., ведь оно способно изменяться время от времени.
     * @since 3.0
     */
    @Experimental
    @Contract(pure = true)
    default @Range(from = 0, to = Integer.MAX_VALUE) long availableMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    /**
     * Возвращает количество оперативной памяти, не загруженной компонентами среды выполнения на момент вызова данного
     * метода.
     *
     * @return Количество оперативной памяти, не загруженной компонентами среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение, если это может повысить производительность,
     * эффективность и т.п., ведь оно способно изменяться время от времени.
     * @since 3.0
     */
    @Experimental
    @Contract(pure = true)
    default @Range(from = 0, to = Integer.MAX_VALUE) long unloadedMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    /**
     * Возвращает количество оперативной памяти, загруженной компонентами среды выполнения на момент вызова данного
     * метода.
     *
     * @return Количество оперативной памяти, загруженной компонентами среды выполнения.
     *
     * @apiNote Рекомендуется периодически обновлять данное значение, если это может повысить производительность,
     * эффективность и т.п., ведь оно способно изменяться время от времени.
     * @since 3.0
     */
    @Experimental
    @Contract(pure = true)
    default @Range(from = 0, to = Integer.MAX_VALUE) long loadedMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    /**
     * Запускает сборщик мусора в среде выполнения.
     *
     * @since 3.0
     */
    @Experimental
    @Contract
    default void collectGarbage() {
        Runtime.getRuntime().gc();
    }

    /**
     * Завершает работу среды выполнения, используя статус по умолчанию.
     *
     * @throws EnvironmentException отсутствует разрешение на завершение работы.
     * @see #DEFAULT_EXIT_STATUS  Статус завершения работы по умолчанию.
     * @since 3.0
     */
    @Contract("-> fail")
    default void exit() throws EnvironmentException {
        exit(DEFAULT_EXIT_STATUS);
    }

    /**
     * Завершает работу среды выполнения, используя переданный статус завершения работы.
     *
     * @param code статус завершения работы.
     *
     * @throws EnvironmentException отсутствует разрешение на завершение работы.
     * @since 3.0
     */
    @Contract("_ -> fail")
    default void exit(
            final @Range(from = Integer.MIN_VALUE, to = Integer.MAX_VALUE) int code) throws EnvironmentException {
        try {
            Runtime.getRuntime().exit(code);
        } catch (final SecurityException e) {
            throw new EnvironmentException(e);
        }
    }

    /**
     * Принудительно завершает работу среды выполнения, используя код по умолчанию.
     *
     * @throws EnvironmentException отсутствует разрешение на принудительное завершение работы.
     * @see #DEFAULT_HALT_STATUS  Статус принудительного завершения работы по умолчанию.
     * @since 3.0
     */
    @Contract("-> fail")
    default void halt() throws EnvironmentException {
        halt(DEFAULT_HALT_STATUS);
    }

    /**
     * Принудительно завершает работу среды выполнения, используя переданный статус принудительного завершения работы.
     *
     * @param code статус принудительного завершения работы.
     *
     * @throws EnvironmentException отсутствует разрешение на принудительное завершение работы.
     * @since 3.0
     */
    @Contract("_ -> fail")
    default void halt(
            final @Range(from = Integer.MIN_VALUE, to = Integer.MAX_VALUE) int code) throws EnvironmentException {
        try {
            Runtime.getRuntime().halt(code);
        } catch (final SecurityException e) {
            throw new EnvironmentException(e);
        }
    }

}
