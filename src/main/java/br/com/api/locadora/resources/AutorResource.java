package br.com.api.locadora.resources;

import javax.ws.rs.Path;
import br.com.api.locadora.models.Autor;
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
@Path("autor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutorResource {
    
    @PersistenceContext(unitName = "LocadoraPU")
    EntityManager entityManager;
    
    @GET
    public List<Autor> getAutores() {
        return entityManager
                .createQuery("SELECT a FROM Autor a", Autor.class)
                .getResultList();
    }
    
    @GET
    @Path("{id}")
    public Autor getAutor(@PathParam("id") UUID id) {
        return entityManager.find(Autor.class, id);
    }
    
    @POST
    public Response addAutor(Autor genero) {
        entityManager.persist(genero);
        return Response
                .status(Response.Status.CREATED)
                .entity(genero)
                .build();
    }
    
    @PUT
    @Path("{id}")
    public Autor updateAutor(@PathParam("id") UUID id, Autor genero) {
        genero.setId(id);
        entityManager.merge(genero);
        return genero;
    }
    
    @DELETE
    @Path("{id}")
    public void deleteAutor(@PathParam("id") UUID id) {
        Autor genero = entityManager.find(Autor.class, id);
        entityManager.remove(genero);
    }
}
