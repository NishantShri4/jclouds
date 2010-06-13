/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
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
 * ====================================================================
 */
package org.jclouds.chef.functions;
import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.net.UnknownHostException;

import org.jclouds.http.HttpResponse;
import org.jclouds.util.Utils;
import org.testng.annotations.Test;

/**
 * @author Adrian Cole
 */
@Test(groups = "unit", testName = "chef.ParseErrorFromJsonOrReturnBodyTest")
public class ParseErrorFromJsonOrReturnBodyTest {

   @Test
   public void testApplyInputStreamDetails() throws UnknownHostException {
      InputStream is = Utils
               .toInputStream("{\"error\":[\"invalid tarball: tarball root must contain java-bytearray\"]}");

      ParseErrorFromJsonOrReturnBody parser = new ParseErrorFromJsonOrReturnBody();
      String response = parser.apply(new HttpResponse(is));
      assertEquals(response, "invalid tarball: tarball root must contain java-bytearray");
   }

}
