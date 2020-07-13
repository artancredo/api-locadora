package br.com.api.locadora.resources;

import javax.ws.rs.Path;
import br.com.api.locadora.models.Filme;
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
@Path("filme")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FilmeResource {
    
    @PersistenceContext(unitName = "LocadoraPU")
    EntityManager entityManager;
    
    @GET
    public List<Filme> getFilmes() {
        return entityManager
                .createQuery("SELECT a FROM Filme a", Filme.class)
                .getResultList();
    }
    
    @GET
    @Path("{id}")
    public Filme getFilme(@PathParam("id") UUID id) {
        return entityManager.find(Filme.class, id);
    }
    
    @POST
    public Response addFilme(Filme filme) {
        entityManager.persist(filme);
        return Response
                .status(Response.Status.CREATED)
                .entity(filme)
                .build();
    }
    
    @PUT
    @Path("{id}")
    public Filme updateFilme(@PathParam("id") UUID id, Filme filme) {
        filme.setId(id);
        entityManager.merge(filme);
        return filme;
    }
    
    @DELETE
    @Path("{id}")
    public void deleteFilme(@PathParam("id") UUID id) {
        Filme filme = entityManager.find(Filme.class, id);
        entityManager.remove(filme);
    }
}
