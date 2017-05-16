/**
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
 */
/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.cloud.aurora.client.sdk;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
public class aurora_apiConstants {

  public static final String AURORA_EXECUTOR_NAME = "AuroraExecutor";

  public static final Set<ScheduleStatus> ACTIVE_STATES = new HashSet<ScheduleStatus>();
  static {
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.ASSIGNED);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.DRAINING);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.KILLING);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.PENDING);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.PREEMPTING);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.RESTARTING);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.RUNNING);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.STARTING);
    ACTIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.THROTTLED);
  }

  public static final Set<ScheduleStatus> SLAVE_ASSIGNED_STATES = new HashSet<ScheduleStatus>();
  static {
    SLAVE_ASSIGNED_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.ASSIGNED);
    SLAVE_ASSIGNED_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.DRAINING);
    SLAVE_ASSIGNED_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.KILLING);
    SLAVE_ASSIGNED_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.PREEMPTING);
    SLAVE_ASSIGNED_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.RESTARTING);
    SLAVE_ASSIGNED_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.RUNNING);
    SLAVE_ASSIGNED_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.STARTING);
  }

  public static final Set<ScheduleStatus> LIVE_STATES = new HashSet<ScheduleStatus>();
  static {
    LIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.KILLING);
    LIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.PREEMPTING);
    LIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.RESTARTING);
    LIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.DRAINING);
    LIVE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.RUNNING);
  }

  public static final Set<ScheduleStatus> TERMINAL_STATES = new HashSet<ScheduleStatus>();
  static {
    TERMINAL_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.FAILED);
    TERMINAL_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.FINISHED);
    TERMINAL_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.KILLED);
    TERMINAL_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus.LOST);
  }

  public static final String GOOD_IDENTIFIER_PATTERN = "^[\\w\\-\\.]+$";

  public static final String GOOD_IDENTIFIER_PATTERN_JVM = "^[\\w\\-\\.]+$";

  public static final String GOOD_IDENTIFIER_PATTERN_PYTHON = "^[\\w\\-\\.]+$";

  /**
   * States the job update can be in while still considered active.
   */
  public static final Set<JobUpdateStatus> ACTIVE_JOB_UPDATE_STATES = new HashSet<JobUpdateStatus>();
  static {
    ACTIVE_JOB_UPDATE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.JobUpdateStatus.ROLLING_FORWARD);
    ACTIVE_JOB_UPDATE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.JobUpdateStatus.ROLLING_BACK);
    ACTIVE_JOB_UPDATE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.JobUpdateStatus.ROLL_FORWARD_PAUSED);
    ACTIVE_JOB_UPDATE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.JobUpdateStatus.ROLL_BACK_PAUSED);
    ACTIVE_JOB_UPDATE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.JobUpdateStatus.ROLL_FORWARD_AWAITING_PULSE);
    ACTIVE_JOB_UPDATE_STATES.add(org.apache.airavata.cloud.aurora.client.sdk.JobUpdateStatus.ROLL_BACK_AWAITING_PULSE);
  }

  public static final String BYPASS_LEADER_REDIRECT_HEADER_NAME = "Bypass-Leader-Redirect";

  public static final String TASK_FILESYSTEM_MOUNT_POINT = "taskfs";

}
