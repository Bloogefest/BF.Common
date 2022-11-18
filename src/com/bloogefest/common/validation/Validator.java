package com.bloogefest.common.validation;

import com.bloogefest.common.Conditions;
import com.bloogefest.common.CreationException;
import com.bloogefest.common.function.Supplier;

/**
 * Утилитарный класс, содержащий методы валидации условий.
 *
 * @author Bloogefest
 * @version 0.0
 * @apiNote Предполагается использование методов данного класса вместо написания повторяющегося кода, если это возможно.
 * @since 0.0.0
 */
public final class Validator {

    /**
     * Базовый конструктор утилитарного класса.
     *
     * @throws CreationException Означает то, что была совершена попытка создания экземпляра утилитарного класса.
     * @apiNote Предполагается, что экземпляр утилитарного класса не должен быть создан, поэтому при попытке его создания, будет брошено строгое исключение.
     * @author Bloogefest
     * @since 0.0.0
     */
    private Validator() throws CreationException {
        throw new CreationException();
    }

    /**
     * Базовая валидация условия, определяющее, является ли проверяемый объект нулевым, или же нет.
     *
     * @param <T>    Тип проверяемого объекта.
     * @param object Проверяемый объект.
     *
     * @return Всегда null.
     *
     * @throws NotNullException Not specified
     * @author Bloogefest
     * @since 0.0.1
     */
    public static <T> T isNull(final T object) throws NotNullException {
        if (Conditions.isNull(object)) return null;
        throw new NotNullException();
    }

    /**
     * @param <T>    Not specified
     * @param object Not specified
     * @param name   Not specified
     *
     * @return Not specified
     *
     * @throws NotNullException Not specified
     * @throws NullException    Not specified
     * @author Bloogefest
     * @since 0.0.1
     */
    public static <T> T isNull(final T object, final String name) throws NotNullException, NullException {
        if (Conditions.isNull(object)) return null;
        throw new NotNullException("The %s must be null".formatted(notNull(name, "name")));
    }

    /**
     * @param <T>      Not specified
     * @param <E>      Not specified
     * @param object   Not specified
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.1
     */
    public static <T, E extends Throwable> T isNull(final T object, final Supplier<E> supplier) throws NullException, E {
        if (Conditions.isNull(object)) return null;
        throw notNull(notNull(supplier, "supplier").supply(), "throwable");
    }

    /**
     * @param <T>    Not specified
     * @param object Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T> T notNull(final T object) throws NullException {
        if (Conditions.notNull(object)) return object;
        throw new NullException();
    }

    /**
     * @param <T>    Not specified
     * @param object Not specified
     * @param name   Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T> T notNull(final T object, final String name) throws NullException {
        if (Conditions.notNull(object)) return object;
        throw new NullException("The %s mustn't be null".formatted(notNull(name, "name")));
    }

    /**
     * @param <T>      Not specified
     * @param <E>      Not specified
     * @param object   Not specified
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @throws NullException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T, E extends Throwable> T notNull(final T object, final Supplier<E> supplier) throws NullException, E {
        if (Conditions.notNull(object)) return object;
        throw notNull(notNull(supplier, "supplier").supply(), "throwable");
    }

    /**
     * @param <T1>    Not specified
     * @param <T2>    Not specified
     * @param object  Not specified
     * @param another Not specified
     *
     * @return Not specified
     *
     * @throws NotEqualException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> T1 equals(final T1 object, final T2 another) throws NotEqualException {
        if (Conditions.equals(object, another)) return object;
        throw new NotEqualException();
    }

    /**
     * @param <T1>    Not specified
     * @param <T2>    Not specified
     * @param object  Not specified
     * @param another Not specified
     * @param name    Not specified
     *
     * @return Not specified
     *
     * @throws NotEqualException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> T1 equals(final T1 object, final T2 another, final String name) throws NullException, NotEqualException {
        if (Conditions.equals(object, another)) return object;
        throw new NotEqualException("The %s must be equal to another".formatted(notNull(name, "name")));
    }

    /**
     * @param <T1>     Not specified
     * @param <T2>     Not specified
     * @param object   Not specified
     * @param another  Not specified
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @throws NotEqualException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2, E extends Throwable> T1 equals(final T1 object, final T2 another, final Supplier<E> supplier) throws NullException, E {
        if (Conditions.equals(object, another)) return object;
        throw notNull(notNull(supplier, "supplier").supply(), "throwable");
    }

    /**
     * @param <T1>    Not specified
     * @param <T2>    Not specified
     * @param object  Not specified
     * @param another Not specified
     *
     * @return Not specified
     *
     * @throws EqualException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> T1 notEquals(final T1 object, final T2 another) throws EqualException {
        if (Conditions.notEquals(object, another)) return object;
        throw new EqualException();
    }

    /**
     * @param <T1>    Not specified
     * @param <T2>    Not specified
     * @param object  Not specified
     * @param another Not specified
     * @param name    Not specified
     *
     * @return Not specified
     *
     * @throws EqualException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> T1 notEquals(final T1 object, final T2 another, final String name) throws NullException, EqualException {
        if (Conditions.notEquals(object, another)) return object;
        throw new EqualException("The %s must be equal to another".formatted(notNull(name, "name")));
    }

    /**
     * @param <T1>     Not specified
     * @param <T2>     Not specified
     * @param object   Not specified
     * @param another  Not specified
     * @param supplier Not specified
     *
     * @return Not specified
     *
     * @throws NotEqualException Not specified
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2, E extends Throwable> T1 notEquals(final T1 object, final T2 another, final Supplier<E> supplier) throws NullException, E {
        if (Conditions.notEquals(object, another)) return object;
        throw notNull(notNull(supplier, "supplier").supply(), "throwable");
    }

}
