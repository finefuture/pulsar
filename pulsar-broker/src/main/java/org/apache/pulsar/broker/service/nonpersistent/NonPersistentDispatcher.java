/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.broker.service.nonpersistent;

import java.util.List;
import org.apache.bookkeeper.mledger.Entry;
import org.apache.bookkeeper.mledger.Position;
import org.apache.pulsar.broker.service.Consumer;
import org.apache.pulsar.broker.service.Dispatcher;
import org.apache.pulsar.common.stats.Rate;


public interface NonPersistentDispatcher extends Dispatcher {

    void sendMessages(List<Entry> entries);

    Rate getMessageDropRate();

    boolean hasPermits();

    @Override
    default void redeliverUnacknowledgedMessages(Consumer consumer, long consumerEpoch) {
        // No-op
    }

    @Override
    default void redeliverUnacknowledgedMessages(Consumer consumer, List<Position> positions) {
        // No-op
    }

    @Override
    default void addUnAckedMessages(int unAckMessages) {
        // No-op
    }

}
