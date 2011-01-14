/*
 * Copyright 2011 Chad Retz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cretz.gwtnode.dev.debug.client.jdwp.ec.event;

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferUtils;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.EventKind;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.Location;

public class ThreadedLocationObjectEvent extends Event {
    
    private int threadId;
    private int objectId;
    private Location location;
    
    public ThreadedLocationObjectEvent(EventKind eventKind) {
        setEventKind(eventKind);
    }
    
    public int getThreadId() {
        return threadId;
    }
    
    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
    
    public int getObjectId() {
        return objectId;
    }
    
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    protected Buffer buildEventBuffer() {
        return BufferUtils.concat(
                BufferUtils.toBuffer(threadId),
                BufferUtils.toBuffer(objectId),
                location.buildBuffer());
    }

}
