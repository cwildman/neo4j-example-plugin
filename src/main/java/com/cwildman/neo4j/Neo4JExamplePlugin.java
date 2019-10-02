package com.cwildman.neo4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class Neo4JExamplePlugin {
    @GET
    public Response get() {
        return Response.ok().build();
    }
}
