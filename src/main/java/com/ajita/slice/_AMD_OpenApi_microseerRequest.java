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

final class _AMD_OpenApi_microseerRequest extends IceInternal.IncomingAsync implements AMD_OpenApi_microseerRequest
{
    public _AMD_OpenApi_microseerRequest(IceInternal.Incoming in)
    {
        super(in);
    }

    public void ice_response(int __ret, String response)
    {
        if(__validateResponse(true))
        {
            try
            {
                IceInternal.BasicStream __os = this.__startWriteParams(Ice.FormatType.DefaultFormat);
                __os.writeString(response);
                __os.writeInt(__ret);
                this.__endWriteParams(true);
            }
            catch(Ice.LocalException __ex)
            {
                __exception(__ex);
                return;
            }
            __response();
        }
    }
}
