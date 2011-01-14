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
package org.cretz.gwtnode.dev.debug.client.jdwp.common;

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferBuilder;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferUtils;

public class Location implements BufferBuilder {

    public static final int SIZE = 17;
    
    private TypeTag typeTag;
    private int classId;
    private int methodId;
    private long index;
    
    public Location() {
    }
    
    public Location(Buffer buffer) {
        typeTag = TypeTag.fromByte(buffer.get(0));
        classId = BufferUtils.toInteger(buffer.slice(1, 5));
        methodId = BufferUtils.toInteger(buffer.slice(5, 9));
        index = BufferUtils.toLong(buffer.slice(9, 17));
    }

    public TypeTag getTypeTag() {
        return typeTag;
    }

    public void setTypeTag(TypeTag typeTag) {
        this.typeTag = typeTag;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getMethodId() {
        return methodId;
    }

    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Override
    public Buffer buildBuffer() {
        /*typeTag = TypeTag.fromByte(buffer.get(0));
        classId = BufferUtils.toInteger(buffer.slice(1, 5));
        methodId = BufferUtils.toInteger(buffer.slice(5, 9));
        index = BufferUtils.toLong(buffer.slice(9, 17));*/
        return BufferUtils.concat(
                Buffer.create(typeTag.getByte()),
                BufferUtils.toBuffer(classId),
                BufferUtils.toBuffer(methodId),
                BufferUtils.toBuffer(index));
    }
}
