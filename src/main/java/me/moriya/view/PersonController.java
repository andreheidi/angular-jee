package me.moriya.view;

import me.moriya.entity.Person;
import me.moriya.repository.GenericRepository;
import me.moriya.service.PersonService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andre on 6/4/16.
 */
@Named
@Path("/personController")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController implements Serializable {

    private static final long serialVersionUID = 7565582288410333716L;

    @Inject
    private PersonService personService;

    @GET
    @Path("list")
    public List<Person> list() {
        return this.personService.list();
    }

    @POST
    @Path("save")
    public Response save(Person person) {
        this.personService.save(person);
        return Response.ok().build();
    }
}