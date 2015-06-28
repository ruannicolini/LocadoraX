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
import model.domain.Cliente;
import model.domain.Dependente;
import model.domain.Socio;

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
            @QueryParam("status") String ativo,
            @QueryParam("sex") String sexo
            ){
        char s = sexo.charAt(0);
        
        return ClienteBD.cadastrarSocio(end,tel,cpf,nome,dtNasc,s);  
        
    }
    
    @GET
    @Path("/inscreverDependente")
    @Produces(MediaType.TEXT_PLAIN)
    public int inserirDependente(
            @QueryParam("nome") String nome, 
            @QueryParam("idSocio") String idSocio, 
            @QueryParam("dataNascimento") String dtNasc, 
            @QueryParam("sex") String sexo
            ){
        char s = sexo.charAt(0);
        return ClienteBD.inscreverDependente(Integer.parseInt(idSocio), nome, s, dtNasc);
    }
    
    @GET
    @Path("/consultarCliente")
    @Produces(MediaType.TEXT_PLAIN)
    public Cliente consultaId(
            @QueryParam("id") String id
            ){
        return ClienteBD.consultaId(id);
    }
    
    @GET
    @Path("/EditarSocio")
    @Produces(MediaType.TEXT_PLAIN)
    public int editarSocio(
            @QueryParam("idSocio") String idSocio,
            @QueryParam("nome") String nome,
            @QueryParam("sex") String sexo,
            @QueryParam("dataNascimento") String nasc,
            @QueryParam("cpf") String cpf,
            @QueryParam("endereco") String endereco,
            @QueryParam("tel") String tel
            ){
        Socio so = ((Socio) ClienteBD.consultaId(idSocio));
        char s = sexo.charAt(0);
        so.setNome(nome);
        so.setSexo(s);
        so.setDataNascimento(nasc);
        so.setCpf(cpf);
        so.setEndereco(endereco);
        so.setTelefone(tel);
        
        return ClienteBD.EditarCliente(so);
    }
    
    @GET
    @Path("/EditarDependente")
    @Produces(MediaType.TEXT_PLAIN)
    public int editarDependente(
            @QueryParam("idSocio") String idSocio,
            @QueryParam("idDependente") String idDependente,
            @QueryParam("nome") String nome,
            @QueryParam("sex") String sexo,
            @QueryParam("dataNascimento") String nasc
            ){
        Socio so = ((Socio) ClienteBD.consultaId(idSocio));
        Dependente dep = ((Dependente) ClienteBD.consultaId(idDependente));
        
        dep.setNome(nome);
        dep.setDataNascimento(nasc);
        char s = sexo.charAt(0);
        dep.setSexo(s);
        
        so.inserirDependente(dep);
        return ClienteBD.EditarCliente(dep);
    }
    
    @GET
    @Path("/excluirSocio")
    @Produces(MediaType.TEXT_PLAIN)
    public int excluirSocio(
            @QueryParam("id") String idSocio
            ){
        Socio so = (Socio) ClienteBD.consultaId(idSocio);
        return ClienteBD.ExcluiCliente(so);
    }
    
    
    @GET
    @Path("/excluirDependente")
    @Produces(MediaType.TEXT_PLAIN)
    public int excluirDependente(
            @QueryParam("idSocio") String idSocio,
            @QueryParam("idDep") String idDependente
            ){
        Dependente dep = (Dependente) ClienteBD.consultaId(  idDependente  );
        Socio so = (Socio) ClienteBD.consultaId(idSocio);
        
        return ClienteBD.removerDependente(so, dep);
    }
    
    
    
}
