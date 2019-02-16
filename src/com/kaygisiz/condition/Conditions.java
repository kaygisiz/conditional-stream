/*
 * Copyright (C) 2019 Necati Caner Gaygisiz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kaygisiz.condition;

import com.kaygisiz.condition.stream.ConditionalStream;
import com.kaygisiz.condition.stream.EndStream;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Conditions<T> implements ConditionalStream<T> {
    private final T object;

    private Conditions(T object) {
        this.object = object;
    }

    public static <T> ConditionalStream<T> of(T object) {
        return new Conditions<>(object);
    }

    public <R> ConditionalStream<T> fi(Predicate<? super T> condition, Function<? super T, ? extends R> action) {
        Objects.requireNonNull(condition);
        return fi(condition.test(object), action);
    }

    public <R> ConditionalStream<T> fi(boolean condition, Function<? super T, ? extends R> action) {
        if (condition) {
            action.apply(object);
        }
        return this;
    }

    public <R> ConditionalStream<T> witch(T object, Function<? super T, ? extends R> action) {
        if (Objects.equals(this.object, object)) {
            action.apply(object);
        }
        return this;
    }

    public <R> EndStream<T> elsa(Function<? super T, ? extends R> action) {
        action.apply(object);
        return this;
    }

    public <R> R finalize(Function<? super T, ? extends R> action) {
        return action.apply(object);
    }
}
