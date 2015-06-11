/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.application.ClienteBD;

/**
 *
 * @author Ruan
 */
@Path("/cliente")
public class InserirCliente_Restfull {
    
    @GET
    @Path("/inscreverSocio")
    @Produces(MediaType.TEXT_PLAIN)
    public int inserirSocio(
            @QueryParam("nome") String nome, 
            @QueryParam("endereco") String end, 
            @QueryParam("tel") String tel,
            @QueryParam("cpf") String cpf,
            @QueryParam("dataNascimento") String dtNasc, 
            @QueryParam("status") Boolean ativo,
            @QueryParam("sex") char sexo
            ){
        
        return ClienteBD.cadastrarSocio(end,tel,cpf,nome,dtNasc,sexo);  
        
    }
    
}
