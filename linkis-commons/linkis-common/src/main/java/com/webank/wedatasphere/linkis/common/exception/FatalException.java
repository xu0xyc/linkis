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

/**
 * author: enjoyyin
 * date: 2018/9/11
 * time: 20:40
 * Description:
 */
package com.webank.wedatasphere.linkis.common.exception;

public class FatalException extends DWCException{
    private ExceptionLevel level = ExceptionLevel.FATAL;
    public FatalException(int errCode, String desc){
        super(errCode, desc);
    }
    public FatalException(int errCode, String desc, String ip, int port, String serviceKind){
        super(errCode, desc, ip, port, serviceKind);
    }

    @Override
    public ExceptionLevel getLevel(){
        return this.level;
    }
}
