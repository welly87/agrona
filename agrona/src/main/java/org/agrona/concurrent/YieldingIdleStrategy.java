/*
 * Copyright 2014-2019 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.agrona.concurrent;

/**
 * {@link IdleStrategy} that will call {@link Thread#yield()} when the work count is zero.
 */
public final class YieldingIdleStrategy implements IdleStrategy
{
    /**
     * As there is no instance state then this object can be used to save on allocation.
     */
    public static final YieldingIdleStrategy INSTANCE = new YieldingIdleStrategy();

    public void idle(final int workCount)
    {
        if (workCount > 0)
        {
            return;
        }

        Thread.yield();
    }

    public void idle()
    {
        Thread.yield();
    }

    public void reset()
    {
    }

    public String toString()
    {
        return "YieldingIdleStrategy{}";
    }
}
