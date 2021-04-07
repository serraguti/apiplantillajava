package services;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Funciones;
import models.Plantilla;
import repositories.RepositoryPlantilla;

@Path("/plantilla")
public class ServicePlantilla {

    RepositoryPlantilla repo;

    public ServicePlantilla() {
        this.repo = new RepositoryPlantilla();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Plantilla> getPlantilla() throws SQLException {
        return this.repo.getPlantilla();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Plantilla findPlantilla(@PathParam("id") String id) throws SQLException {
        int idplantilla = Integer.parseInt(id);
        return this.repo.findPlantilla(idplantilla);
    }

    @GET
    @Path("buscarfuncion/{funcion}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Plantilla> getPlantillaFuncion(@PathParam("funcion") String funcion) throws SQLException {
        return this.repo.getPlantillaFuncion(funcion);
    }

    @GET
    @Path("funciones")
    @Produces(MediaType.APPLICATION_XML)
    public Funciones getFunciones() throws SQLException {
        return this.repo.getFunciones();
    }
}
