// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `viphrm.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.ajita.slice;

public interface OpenApiPrx extends Ice.ObjectPrx
{
    public int microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response);

    public int microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Ice.Callback __cb);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Callback_OpenApi_microseerRequest __cb);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Callback_OpenApi_microseerRequest __cb);

    public interface FunctionalCallback_OpenApi_microseerRequest_Response
    {
        void apply(int __ret, String response);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                  IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  java.util.Map<String, String> __ctx, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  java.util.Map<String, String> __ctx, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                  IceInternal.Functional_BoolCallback __sentCb);

    public int end_microseerRequest(Ice.StringHolder response, Ice.AsyncResult __result);

    public int microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response);

    public int microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Ice.Callback __cb);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Callback_OpenApi_microseerBroadcast __cb);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Callback_OpenApi_microseerBroadcast __cb);

    public interface FunctionalCallback_OpenApi_microseerBroadcast_Response
    {
        void apply(int __ret, String response);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                    IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    java.util.Map<String, String> __ctx, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    java.util.Map<String, String> __ctx, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                    IceInternal.Functional_BoolCallback __sentCb);

    public int end_microseerBroadcast(Ice.StringHolder response, Ice.AsyncResult __result);
}