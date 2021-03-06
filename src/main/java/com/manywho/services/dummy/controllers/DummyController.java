package com.manywho.services.dummy.controllers;

import com.manywho.sdk.entities.run.EngineValue;
import com.manywho.sdk.entities.run.elements.config.ServiceRequest;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.enums.InvokeType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/dummy")
@Consumes("application/json")
@Produces("application/json")
public class DummyController {

    @Path("/dummy")
    @POST
    public ServiceResponse dummy(ServiceRequest serviceRequest) throws Exception {
        EngineValue value = new EngineValue("Body", ContentType.String, "Hello from the Dummy Service");

        return new ServiceResponse(InvokeType.Forward, value, serviceRequest.getToken());
    }

    @Path("throwexception")
    @POST
    public ServiceResponse throwException(ServiceRequest serviceRequest) throws Exception {
        throw new Exception("Oh no! This is an exception");
    }
}
