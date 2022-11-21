package com.bloogefest.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Утилитарный класс предиката объекта.
 *
 * @author Bloogefest
 * @version 0.0
 * @see com.bloogefest.common.function.Predicate Предикат объекта.
 * @since 0.1.0
 */
@SuppressWarnings("unused")
public final class Predicates {

    /**
     * Бросает мягкое исключение.
     *
     * @throws CreationException невозможно создать объект.
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "-> fail", pure = true)
    private Predicates() throws CreationException {
        throw new CreationException();
    }

    /**
     * Оценивает объект на нулевое явление.
     *
     * @param object объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null -> true; !null -> false", pure = true)
    public static <T> boolean isNull(final @Nullable T object) {
        return object == null;
    }

    /**
     * Оценивает объект на ненулевое явление.
     *
     * @param object объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null -> false; !null -> true", pure = true)
    public static <T> boolean notNull(final @Nullable T object) {
        return object != null;
    }

    /**
     * Оценивает первичный объект на явление равенства со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null -> true; _, _ -> _", pure = true)
    public static <T, T_> boolean equals(final @Nullable T object, final @Nullable T_ object_) {
        return object == object_ || notNull(object) && object.equals(object_);
    }

    /**
     * Оценивает первичный объект на явление неравенства со вторичным.
     *
     * @param object  первичный объект.
     * @param object_ вторичный объект.
     *
     * @return Результат оценивания.
     *
     * @author Bloogefest
     * @since 0.1.0
     */
    @Contract(value = "null, null -> false; _, _ -> _", pure = true)
    public static <T, T_> boolean notEquals(final @Nullable T object, final @Nullable T_ object_) {
        return object != object_ && notNull(object) && object.equals(object_);
    }

}
