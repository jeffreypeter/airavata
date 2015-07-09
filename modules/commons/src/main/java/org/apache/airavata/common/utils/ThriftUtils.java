/*
 *
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
 *
 */

package org.apache.airavata.common.utils;

import org.apache.airavata.model.task.DataStagingTaskModel;
import org.apache.airavata.model.task.TaskModel;
import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

public class ThriftUtils {
	public static byte[] serializeThriftObject(TBase object) throws TException {
		return new TSerializer().serialize(object);
	}

	public static void createThriftFromBytes(byte[] bytes, TBase object) throws TException {
		new TDeserializer().deserialize(object, bytes);
	}

	public static Object getSubTaskModel(TaskModel taskModel) throws TException {
		switch (taskModel.getTaskType()) {
			case DATA_STAGING:
				DataStagingTaskModel dataStagingTaskModel = new DataStagingTaskModel();
				ThriftUtils.createThriftFromBytes(taskModel.getSubTaskModel(), dataStagingTaskModel);
				return dataStagingTaskModel;
			case ENV_SETUP:
				// TODO return Environment Setup task model
			case JOB_SUBMISSION:
				// TODO return Job Submission task model
			case MONITORING:
				// TODO return Job Monitoring task model
			case ENV_CLEANUP:
				// TODO return Environment Clean up task  model
			default:
				return null;
		}
	}
}