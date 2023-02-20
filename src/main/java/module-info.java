/**
 * Содержит инструменты общего назначения.
 *
 * @since 3.0
 */
module com.bloogefest.common {

    requires transitive org.jetbrains.annotations;

    exports com.bloogefest.common.base;
    exports com.bloogefest.common.creation;
    exports com.bloogefest.common.creation.builder;
    exports com.bloogefest.common.environment;
    exports com.bloogefest.common.function;
    exports com.bloogefest.common.validation;

}