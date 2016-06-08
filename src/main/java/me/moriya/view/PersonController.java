package me.moriya.view;

import me.moriya.entity.Person;
import me.moriya.repository.GenericRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by andre on 6/4/16.
 */
@Named
@Path("/personController")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    private GenericRepository<Person, Long> personRepository;

    @GET
    @Path("list")
    public List<Person> list() {
        return this.personRepository.list();
    }

    @POST
    @Path("save")
    public Response save(Person person) {
        this.personRepository.save(person);
        return Response.ok().build();
    }
}