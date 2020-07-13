package br.com.api.locadora.resources;

import javax.ws.rs.Path;
import br.com.api.locadora.models.Locacao;
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
@Path("locacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocacaoResource {
    
    @PersistenceContext(unitName = "LocadoraPU")
    EntityManager entityManager;
    
    @GET
    public List<Locacao> getLocacaoes() {
        return entityManager
                .createQuery("SELECT a FROM Locacao a", Locacao.class)
                .getResultList();
    }
    
    @GET
    @Path("{id}")
    public Locacao getLocacao(@PathParam("id") UUID id) {
        return entityManager.find(Locacao.class, id);
    }
    
    @POST
    public Response addLocacao(Locacao genero) {
        entityManager.persist(genero);
        return Response
                .status(Response.Status.CREATED)
                .entity(genero)
                .build();
    }
    
    @PUT
    @Path("{id}")
    public Locacao updateLocacao(@PathParam("id") UUID id, Locacao genero) {
        genero.setId(id);
        entityManager.merge(genero);
        return genero;
    }
    
    @DELETE
    @Path("{id}")
    public void deleteLocacao(@PathParam("id") UUID id) {
        Locacao genero = entityManager.find(Locacao.class, id);
        entityManager.remove(genero);
    }
}
