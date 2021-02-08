/*
 * Copyright 2017 HugeGraph Authors
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.baidu.hugegraph.computer.core.graph.value;

import java.io.IOException;

import org.junit.Test;

import com.baidu.hugegraph.computer.core.UnitTestBase;
import com.baidu.hugegraph.testutil.Assert;

public class LongValueTest extends UnitTestBase {

    @Test
    public void test() {
        LongValue longValue1 = new LongValue();
        LongValue longValue2 = new LongValue(Long.MIN_VALUE);

        Assert.assertEquals(ValueType.LONG, longValue1.type());
        Assert.assertEquals(0L, longValue1.value());
        Assert.assertEquals(Long.MIN_VALUE, longValue2.value());

        longValue2.value(Long.MAX_VALUE);
        Assert.assertEquals(Long.MAX_VALUE, longValue2.value());
        Assert.assertEquals(longValue2, new LongValue(longValue2.value()));
        Assert.assertNotEquals(longValue1, longValue2);
        Assert.assertEquals(Long.hashCode(Long.MAX_VALUE),
                            longValue2.hashCode());
    }

    @Test
    public void testReadWrite() throws IOException {
        assertValueEqualAfterWriteAndRead(new LongValue(Long.MAX_VALUE));
    }

    @Test
    public void testCompare() {
        LongValue value1 = new LongValue(123L);
        LongValue value2 = new LongValue(123L);
        LongValue value3 = new LongValue(321L);
        Assert.assertEquals(0, value1.compareTo(value2));
        Assert.assertLt(0, value1.compareTo(value3));
        Assert.assertGt(0, value3.compareTo(value1));
    }
}