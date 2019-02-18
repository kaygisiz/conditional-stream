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
package com.github.kaygisiz.conditionalstream.stream;

import java.util.function.Function;
import java.util.function.Predicate;

public interface ConditionalStream<T> extends EndStream<T>, BaseStream<T> {
    ConditionalStream<T> fi(Predicate<? super T> condition, Function<? super T, ? extends T> action);

    ConditionalStream<T> fi(boolean condition, Function<? super T, ? extends T> action);

    ConditionalStream<T> witch(T object, Function<? super T, ? extends T> action);

    EndStream<T> elsa(Function<? super T, ? extends T> action);
}
