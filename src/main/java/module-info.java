/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

/**
 * Модуль общего назначения.
 *
 * @since 3.0
 */
module com.bloogefest.common {

    requires transitive org.jetbrains.annotations;

    exports com.bloogefest.common;
    exports com.bloogefest.common.creation;
    exports com.bloogefest.common.function;
    exports com.bloogefest.common.validation;

}