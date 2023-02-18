/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.bloogefest.common.creation.builder;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public interface Builder<P, T extends Throwable> {

    /**
     *
     */
    static <P, T extends Throwable> Builder<P, T> strict() {
        Builder.<Object, BuilderException>strict().build();
        return () -> null;
    }

    /**
     *
     */
    static <P, T extends Throwable> Builder<P, T> constant() {
        Builder.<Object, BuilderException>constant().build();
        return () -> null;
    }

    /**
     *
     */
    @Contract("-> new")
    @NotNull P build() throws T;

}
