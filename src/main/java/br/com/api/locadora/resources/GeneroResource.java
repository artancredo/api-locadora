package br.com.api.locadora.resources;

import javax.ws.rs.Path;
import br.com.api.locadora.models.Genero;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("genero")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GeneroResource {
    
    @PersistenceContext(unitName = "LocadoraPU")
    EntityManager entityManager;
    
    @GET
    public List<Genero> getGeneros() {
        return entityManager
                .createQuery("SELECT a FROM Genero a", Genero.class)
                .getResultList();
    }
    
    @GET
    @Path("{id}")
    public Genero getGenero(@PathParam("id") UUID id) {
        return entityManager.find(Genero.class, id);
    }
    
    @POST
    public Response addGenero(Genero genero) {
        entityManager.persist(genero);
        return Response
                .status(Response.Status.CREATED)
                .entity(genero)
                .build();
    }
    
    @PUT
    @Path("{id}")
    public Genero updateGenero(@PathParam("id") UUID id, Genero genero) {
        genero.setId(id);
        entityManager.merge(genero);
        return genero;
    }
    
    @DELETE
    @Path("{id}")
    public void deleteGenero(@PathParam("id") UUID id) {
        Genero genero = entityManager.find(Genero.class, id);
        entityManager.remove(genero);
    }
}
