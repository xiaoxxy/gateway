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

/**
 * Provides type-specific helper functions.
 **/
public final class OpenApiPrxHelper extends Ice.ObjectPrxHelperBase implements OpenApiPrx
{
    private static final String __microseerBroadcast_name = "microseerBroadcast";

    public int microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response)
    {
        return microseerBroadcast(pars, response, null, false);
    }

    public int microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response, java.util.Map<String, String> __ctx)
    {
        return microseerBroadcast(pars, response, __ctx, true);
    }

    private int microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__microseerBroadcast_name);
        return end_microseerBroadcast(response, begin_microseerBroadcast(pars, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars)
    {
        return begin_microseerBroadcast(pars, null, false, false, null);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx)
    {
        return begin_microseerBroadcast(pars, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Ice.Callback __cb)
    {
        return begin_microseerBroadcast(pars, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_microseerBroadcast(pars, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, Callback_OpenApi_microseerBroadcast __cb)
    {
        return begin_microseerBroadcast(pars, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Callback_OpenApi_microseerBroadcast __cb)
    {
        return begin_microseerBroadcast(pars, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_microseerBroadcast(pars, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                    IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_microseerBroadcast(pars, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    java.util.Map<String, String> __ctx, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_microseerBroadcast(pars, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                    java.util.Map<String, String> __ctx, 
                                                    FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                    IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                    IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_microseerBroadcast(pars, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                     java.util.Map<String, String> __ctx, 
                                                     boolean __explicitCtx, 
                                                     boolean __synchronous, 
                                                     FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb, 
                                                     IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                     IceInternal.Functional_BoolCallback __sentCb)
    {
        class CB extends IceInternal.Functional_TwowayCallback implements _Callback_OpenApi_microseerBroadcast
        {
            public CB(FunctionalCallback_OpenApi_microseerBroadcast_Response responseCb, 
                      IceInternal.Functional_GenericCallback1<Ice.Exception> exceptionCb, 
                      IceInternal.Functional_BoolCallback sentCb)
            {
                super(responseCb != null, exceptionCb, sentCb);
                __responseCb = responseCb;
            }

            public void response(int __ret, String response)
            {
                if(__responseCb != null)
                {
                    __responseCb.apply(__ret, response);
                }
            }

            public final void __completed(Ice.AsyncResult __result)
            {
                OpenApiPrxHelper.__microseerBroadcast_completed(this, __result);
            }

            private final FunctionalCallback_OpenApi_microseerBroadcast_Response __responseCb;
        }
        return begin_microseerBroadcast(pars, __ctx, __explicitCtx, __synchronous, new CB(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_microseerBroadcast(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                     java.util.Map<String, String> __ctx, 
                                                     boolean __explicitCtx, 
                                                     boolean __synchronous, 
                                                     IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__microseerBroadcast_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__microseerBroadcast_name, __cb);
        try
        {
            __result.prepare(__microseerBroadcast_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            PARAMSHelper.write(__os, pars);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public int end_microseerBroadcast(Ice.StringHolder response, Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __microseerBroadcast_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            response.value = __is.readString();
            int __ret;
            __ret = __is.readInt();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __microseerBroadcast_completed(_Callback_OpenApi_microseerBroadcast __cb, Ice.AsyncResult __result)
    {
    	com.ajita.slice.OpenApiPrx __proxy = (com.ajita.slice.OpenApiPrx)__result.getProxy();
        int __ret = 0;
        Ice.StringHolder response = new Ice.StringHolder();
        try
        {
            __ret = __proxy.end_microseerBroadcast(response, __result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret, response.value);
    }

    private static final String __microseerRequest_name = "microseerRequest";

    public int microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response)
    {
        return microseerRequest(pars, response, null, false);
    }

    public int microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response, java.util.Map<String, String> __ctx)
    {
        return microseerRequest(pars, response, __ctx, true);
    }

    private int microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Ice.StringHolder response, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__microseerRequest_name);
        return end_microseerRequest(response, begin_microseerRequest(pars, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars)
    {
        return begin_microseerRequest(pars, null, false, false, null);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx)
    {
        return begin_microseerRequest(pars, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Ice.Callback __cb)
    {
        return begin_microseerRequest(pars, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_microseerRequest(pars, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, Callback_OpenApi_microseerRequest __cb)
    {
        return begin_microseerRequest(pars, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, java.util.Map<String, String> __ctx, Callback_OpenApi_microseerRequest __cb)
    {
        return begin_microseerRequest(pars, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_microseerRequest(pars, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                  IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_microseerRequest(pars, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  java.util.Map<String, String> __ctx, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_microseerRequest(pars, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                  java.util.Map<String, String> __ctx, 
                                                  FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                  IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                  IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_microseerRequest(pars, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                   java.util.Map<String, String> __ctx, 
                                                   boolean __explicitCtx, 
                                                   boolean __synchronous, 
                                                   FunctionalCallback_OpenApi_microseerRequest_Response __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                   IceInternal.Functional_BoolCallback __sentCb)
    {
        class CB extends IceInternal.Functional_TwowayCallback implements _Callback_OpenApi_microseerRequest
        {
            public CB(FunctionalCallback_OpenApi_microseerRequest_Response responseCb, 
                      IceInternal.Functional_GenericCallback1<Ice.Exception> exceptionCb, 
                      IceInternal.Functional_BoolCallback sentCb)
            {
                super(responseCb != null, exceptionCb, sentCb);
                __responseCb = responseCb;
            }

            public void response(int __ret, String response)
            {
                if(__responseCb != null)
                {
                    __responseCb.apply(__ret, response);
                }
            }

            public final void __completed(Ice.AsyncResult __result)
            {
                OpenApiPrxHelper.__microseerRequest_completed(this, __result);
            }

            private final FunctionalCallback_OpenApi_microseerRequest_Response __responseCb;
        }
        return begin_microseerRequest(pars, __ctx, __explicitCtx, __synchronous, new CB(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_microseerRequest(java.util.Map<java.lang.String, java.lang.String> pars, 
                                                   java.util.Map<String, String> __ctx, 
                                                   boolean __explicitCtx, 
                                                   boolean __synchronous, 
                                                   IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__microseerRequest_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__microseerRequest_name, __cb);
        try
        {
            __result.prepare(__microseerRequest_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            PARAMSHelper.write(__os, pars);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public int end_microseerRequest(Ice.StringHolder response, Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __microseerRequest_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            response.value = __is.readString();
            int __ret;
            __ret = __is.readInt();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __microseerRequest_completed(_Callback_OpenApi_microseerRequest __cb, Ice.AsyncResult __result)
    {
    	com.ajita.slice.OpenApiPrx __proxy = (com.ajita.slice.OpenApiPrx)__result.getProxy();
        int __ret = 0;
        Ice.StringHolder response = new Ice.StringHolder();
        try
        {
            __ret = __proxy.end_microseerRequest(response, __result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret, response.value);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OpenApiPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), OpenApiPrx.class, OpenApiPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OpenApiPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), OpenApiPrx.class, OpenApiPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OpenApiPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), OpenApiPrx.class, OpenApiPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static OpenApiPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), OpenApiPrx.class, OpenApiPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static OpenApiPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, OpenApiPrx.class, OpenApiPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static OpenApiPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, OpenApiPrx.class, OpenApiPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::ms::service::slice::OpenApi"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, OpenApiPrx v)
    {
        __os.writeProxy(v);
    }

    public static OpenApiPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            OpenApiPrxHelper result = new OpenApiPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
