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
package com.github.kaygisiz.conditionalstream;

import com.github.kaygisiz.conditionalstream.stream.ConditionalStream;
import com.github.kaygisiz.conditionalstream.stream.EndStream;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Conditions<T> implements ConditionalStream<T> {
    private T object;
    private boolean runElsa = true;

    private Conditions(T object) {
        this.object = object;
    }

    public static <T> ConditionalStream<T> of(T object) {
        return new Conditions<>(object);
    }

    public ConditionalStream<T> fi(Predicate<? super T> condition, Function<? super T, ? extends T> action) {
        Objects.requireNonNull(condition);
        return fi(condition.test(this.object), action);
    }

    public ConditionalStream<T> fi(boolean condition, Function<? super T, ? extends T> action) {
        if (condition) {
            performAction(this.object, action);
        }
        return this;
    }

    public ConditionalStream<T> witch(T object, Function<? super T, ? extends T> action) {
        if (Objects.equals(this.object, object)) {
            performAction(object, action);
        }
        return this;
    }

    public EndStream<T> elsa(Function<? super T, ? extends T> action) {
        if (runElsa) {
            this.object = action.apply(this.object);
        }
        return this;
    }

    public T finalize(Function<? super T, ? extends T> action) {
        return action.apply(this.object);
    }

    public T get() {
        return this.object;
    }

    @SuppressWarnings("unchecked")
    public <U> ConditionalStream<U> cast(Class<U> clazz) {
        return new Conditions<>((U) this.object);
    }

    public <U> ConditionalStream<U> branch(Function<? super T, ? extends U> action) {
        return new Conditions<>(action.apply(this.object));
    }

    private void performAction(T object, Function<? super T, ? extends T> action) {
        this.object = action.apply(object);
        runElsa = false;
    }
}
