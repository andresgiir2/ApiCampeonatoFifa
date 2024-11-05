package apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Usuario;

public class UsuarioLoginDTO {

    private Usuario usuario;
    private String token;

    public UsuarioLoginDTO(Usuario usuario){
        this.usuario = usuario;
        this.token = "";
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
