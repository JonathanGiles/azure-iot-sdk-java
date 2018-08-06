/*
 *  Copyright (c) Microsoft. All rights reserved.
 *  Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */

package com.microsoft.azure.sdk.iot.device.edge;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MethodResult
{
    private static final String STATUS_KEY_NAME = "status";
    @Expose(serialize = false, deserialize = true)
    @SerializedName(STATUS_KEY_NAME)
    private int status;

    private static final String PAYLOAD_KEY_NAME = "payload";
    @Expose(serialize = false, deserialize = true)
    @SerializedName(PAYLOAD_KEY_NAME)
    private Object payload;

    public MethodResult(String json)
    {
        System.out.println("Creating MethodResult from json: ");
        System.out.println(json);
        // Codes_SRS_DIRECTMETHODRESULT_34_003: [This constructor shall retrieve the payload and status from the provided json.]
        MethodResult result = new GsonBuilder().create().fromJson(json, MethodResult.class);

        this.payload = result.payload != null ? result.payload : null;
        this.status = result.status;
    }

    public int getStatus()
    {
        // Codes_SRS_DIRECTMETHODRESULT_34_001: [This function shall return the saved status.]
        return this.status;
    }

    //public Object getPayloadObject()
    //{
    //    return this.payload;
    //}

    public Object getPayload()
    {
        return this.payload;
    }
}
