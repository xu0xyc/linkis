/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.linkis.entrance.interceptor

import com.webank.wedatasphere.linkis.governance.common.entity.task.RequestPersistTask
import com.webank.wedatasphere.linkis.protocol.task.Task

/**
  * Description: this interceptor is used to complete code with run type for
  * further use in engine
  */
class RuntypeInterceptor extends EntranceInterceptor {

  override def apply(task: Task, logAppender: java.lang.StringBuilder): Task = task match {
    case requestPersistTask: RequestPersistTask =>
      requestPersistTask.getRunType.toLowerCase() match {
        case "python" | "py" | "pyspark" => val code = requestPersistTask.getExecutionCode
          requestPersistTask.setExecutionCode("%python\n" + code)
          requestPersistTask
        case "sql" | "hql" =>
          val code = requestPersistTask.getExecutionCode
          requestPersistTask.setExecutionCode("%sql\n" + code)
          requestPersistTask
        case "scala" =>
          val code = requestPersistTask.getExecutionCode
          requestPersistTask.setExecutionCode("%scala\n" + code)
          requestPersistTask
        case _ => requestPersistTask
      }
    case _ => task
  }

}