/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.api.impl.pb.client;

import com.google.protobuf.ServiceException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.yarn.api.ContainerManager;
import org.apache.hadoop.yarn.api.protocolrecords.*;
import org.apache.hadoop.yarn.api.protocolrecords.impl.pb.*;
import org.apache.hadoop.yarn.exceptions.YarnRemoteException;
import org.apache.hadoop.yarn.ipc.ProtoOverHadoopRpcEngine;
import org.apache.hadoop.yarn.proto.ContainerManager.ContainerManagerService;
import org.apache.hadoop.yarn.proto.YarnServiceProtos.GetContainerStatusRequestProto;
import org.apache.hadoop.yarn.proto.YarnServiceProtos.StartContainerRequestProto;
import org.apache.hadoop.yarn.proto.YarnServiceProtos.StopContainerRequestProto;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.InetSocketAddress;

public class ContainerManagerPBClientImpl implements ContainerManager {

  private ContainerManagerService.BlockingInterface proxy;
  
  public ContainerManagerPBClientImpl(long clientVersion, InetSocketAddress addr, Configuration conf) throws IOException {
    RPC.setProtocolEngine(conf, ContainerManagerService.BlockingInterface.class, ProtoOverHadoopRpcEngine.class);
    proxy = (ContainerManagerService.BlockingInterface)RPC.getProxy(
        ContainerManagerService.BlockingInterface.class, clientVersion, addr, conf);
  }

  public void close() {
    if (this.proxy != null) {
      RPC.stopProxy(this.proxy);
    }
  }

  @Override
  public GetContainerStatusResponse getContainerStatus(
      GetContainerStatusRequest request) throws YarnRemoteException {
    GetContainerStatusRequestProto requestProto = ((GetContainerStatusRequestPBImpl)request).getProto();
    try {
      return new GetContainerStatusResponsePBImpl(proxy.getContainerStatus(null, requestProto));
    } catch (ServiceException e) {
      if (e.getCause() instanceof YarnRemoteException) {
        throw (YarnRemoteException)e.getCause();
      } else if (e.getCause() instanceof UndeclaredThrowableException) {
        throw (UndeclaredThrowableException)e.getCause();
      } else {
        throw new UndeclaredThrowableException(e);
      }
    }
  }

  @Override
  public StartContainerResponse startContainer(StartContainerRequest request)
      throws YarnRemoteException {
    StartContainerRequestProto requestProto = ((StartContainerRequestPBImpl)request).getProto();
    try {
      return new StartContainerResponsePBImpl(proxy.startContainer(null, requestProto));
    } catch (ServiceException e) {
      if (e.getCause() instanceof YarnRemoteException) {
        throw (YarnRemoteException)e.getCause();
      } else if (e.getCause() instanceof UndeclaredThrowableException) {
          ////
          System.out.print("[ACT-HADOOP]May be bugs:" + e.getMessage());
        throw (UndeclaredThrowableException)e.getCause();
      } else {
          ////
          System.out.print("[ACT-HADOOP]May be bugs:" + e.getMessage());
        throw new UndeclaredThrowableException(e);
      }
    }
  }

  @Override
  public StopContainerResponse stopContainer(StopContainerRequest request)
      throws YarnRemoteException {
    StopContainerRequestProto requestProto = ((StopContainerRequestPBImpl)request).getProto();
    try {
      return new StopContainerResponsePBImpl(proxy.stopContainer(null, requestProto));
    } catch (ServiceException e) {
      if (e.getCause() instanceof YarnRemoteException) {
        throw (YarnRemoteException)e.getCause();
      } else if (e.getCause() instanceof UndeclaredThrowableException) {
        throw (UndeclaredThrowableException)e.getCause();
      } else {
        throw new UndeclaredThrowableException(e);
      }
    }
  }

}
