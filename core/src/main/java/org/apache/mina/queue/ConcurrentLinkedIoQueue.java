/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.mina.queue;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * An {@link IoQueue} which uses a {@link ConcurrentLinkedQueue} as its
 * backing storage.
 *
 * @author The Apache MINA project (dev@mina.apache.org)
 * @version $Rev$, $Date$
 *
 * @param <E> the type of this queue's elements
 */
public class ConcurrentLinkedIoQueue<E> extends AbstractIoQueue<E> {

    private final Queue<E> q = new ConcurrentLinkedQueue<E>();

    public E peek() {
        return q.peek();
    }

    @Override
    public Iterator<E> iterator() {
        return q.iterator();
    }

    @Override
    public int size() {
        return q.size();
    }

    @Override
    public Object[] toArray() {
        return q.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return q.toArray(a);
    }

    @Override
    protected void doOffer(E e) {
        q.offer(e);
    }

    @Override
    protected E doPoll() {
        return q.poll();
    }
}