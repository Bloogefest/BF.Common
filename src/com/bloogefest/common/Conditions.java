package com.bloogefest.common;

/**
 * Утилитарный класс, содержащий базовые условия.
 *
 * @author Bloogefest
 * @version 0.1
 * @apiNote Предполагается использование методов данного класса вместо написания повторяющегося кода, если это возможно.
 * @since 0.0.0
 */
public final class Conditions {

    /**
     * Базовый конструктор утилитарного класса.
     *
     * @throws CreationException Означает то, что была совершена попытка создания экземпляра утилитарного класса.
     * @apiNote Предполагается, что экземпляр утилитарного класса не должен быть создан, поэтому при попытке его создания, будет брошено строгое исключение.
     * @author Bloogefest
     * @since 0.0.0
     */
    private Conditions() throws CreationException {
        throw new CreationException();
    }

    /**
     * Базовое условие, определяющее, является ли проверяемый объект нулевым, или же нет.
     *
     * @param <T>    Тип проверяемого объекта.
     * @param object Проверяемый объект.
     *
     * @return Если проверяемый объект является нулевым, возвращается true, иначе, false.
     *
     * @author Bloogefest
     * @since 0.0.1
     */
    public static <T> boolean isNull(final T object) {
        return object == null;
    }

    /**
     * Базовое условие, определяющее, является ли проверяемый объект нулевым, или же нет.
     *
     * @param <T>    Тип проверяемого объекта.
     * @param object Проверяемый объект.
     *
     * @return Если проверяемый объект не является нулевым, возвращается true, иначе, false.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T> boolean notNull(final T object) {
        return object != null;
    }

    /**
     * Базовое условие, определяющее, является ли проверяемый объект другим проверяемым объектом, или же нет.
     *
     * @param <T1>    Тип проверяемого объекта.
     * @param <T2>    Тип другого проверяемого объекта.
     * @param object  Проверяемый объект.
     * @param another Другой проверяемый объект.
     *
     * @return Если проверяемый объект является другим проверяемым объектом, возвращается true, иначе, false.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> boolean equals(final T1 object, final T2 another) {
        return object == another || notNull(object) && object.equals(another);
    }

    /**
     * Базовое условие, определяющее, является ли проверяемый объект другим проверяемым объектом, или же нет.
     *
     * @param <T1>    Тип проверяемого объекта.
     * @param <T2>    Тип другого проверяемого объекта.
     * @param object  Проверяемый объект.
     * @param another Другой проверяемый объект.
     *
     * @return Если проверяемый объект не является другим проверяемым объектом, возвращается true, иначе, false.
     *
     * @author Bloogefest
     * @since 0.0.0
     */
    public static <T1, T2> boolean notEquals(final T1 object, final T2 another) {
        return object != another && notNull(object) && object.equals(another);
    }

}
