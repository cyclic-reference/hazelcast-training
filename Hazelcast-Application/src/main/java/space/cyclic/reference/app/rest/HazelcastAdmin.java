package space.cyclic.reference.app.rest;

import space.cyclic.reference.beans.HazelcastSingleton;
import space.cyclic.reference.interfaces.SuperBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Path("/admin")
public class HazelcastAdmin {
    @Inject @SuperBean
    HazelcastSingleton hazelcastSingleton;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/get/thing")
    public String getThing() throws ExecutionException, InterruptedException {
        return hazelcastSingleton.getThing().get();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/get/destroyThing")
    public String getDestroyThing() throws ExecutionException, InterruptedException {
        return hazelcastSingleton.getDestroyThing().get();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/get/partitionThing")
    public String getPartitionThing() throws ExecutionException, InterruptedException {
        return hazelcastSingleton.getPartitionThing().get();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/get/atomicLongThing")
    public String getAtomicLongThing() throws ExecutionException, InterruptedException {
        return hazelcastSingleton.getAtomicLongThing().get();
    }

    @GET
    @Produces("application/json")
    @Path("/get/mapReduce")
    public Map<String, Set<String>> getMapReduce() throws ExecutionException, InterruptedException {
        return hazelcastSingleton.getTestMapReduce();
    }
}
