package br.com.api.locadora.resources;

import javax.ws.rs.Path;
import br.com.api.locadora.models.Cliente;
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
@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {
    
    @PersistenceContext(unitName = "LocadoraPU")
    EntityManager entityManager;
    
    @GET
    public List<Cliente> getClientes() {
        return entityManager
                .createQuery("SELECT a FROM Cliente a", Cliente.class)
                .getResultList();
    }
    
    @GET
    @Path("{id}")
    public Cliente getCliente(@PathParam("id") UUID id) {
        return entityManager.find(Cliente.class, id);
    }
    
    @POST
    public Response addCliente(Cliente cliente) {
        entityManager.persist(cliente);
        return Response
                .status(Response.Status.CREATED)
                .entity(cliente)
                .build();
    }
    
    @PUT
    @Path("{id}")
    public Cliente updateCliente(@PathParam("id") UUID id, Cliente cliente) {
        cliente.setId(id);
        entityManager.merge(cliente);
        return cliente;
    }
    
    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") UUID id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }
}
