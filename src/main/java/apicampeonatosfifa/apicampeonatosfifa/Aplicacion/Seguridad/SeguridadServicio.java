package apicampeonatosfifa.apicampeonatosfifa.Aplicacion.Seguridad;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class SeguridadServicio {

    public static final String SECRETO = "eyJhbGciOi32425JIU3453345zI14353245NiIsI45nR5cCI6346Ik43p5342XVCJ9";

    public String generarToken(String nombreUsuario) {
        Map<String, Object> declaraciones = new HashMap<>();
        return crearToken(declaraciones, nombreUsuario);
    }

    private String crearToken(Map<String, Object> declaraciones, String nombreUsuario) {
        return Jwts.builder()
                .setClaims(declaraciones)
                .setSubject(nombreUsuario)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getClaveFirma(), SignatureAlgorithm.HS256).compact();
    }

    private Key getClaveFirma() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRETO);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extraerNombreUsuario(String token) {
        return extraerDeclaracion(token, Claims::getSubject);
    }

    public <T> T extraerDeclaracion(String token, Function<Claims, T> declaracionesResolver) {
        final Claims declaraciones = extraerDeclaraciones(token);
        return declaracionesResolver.apply(declaraciones);
    }

    private Claims extraerDeclaraciones(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getClaveFirma())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean tokenExpirado(String token){
        return extraerExpiracion(token).before(new Date());
    }

    public Boolean validarToken(String token, UserDetails userDetails){
        final String nombreUsuario = extraerNombreUsuario(token);
        return (nombreUsuario.equals(userDetails.getUsername()) && !tokenExpirado(token));
    }

    public Date extraerExpiracion(String token){
        return extraerDeclaracion(token, Claims::getExpiration);
    }

}
