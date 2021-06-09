package teste;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

  @RequestMapping("/api/ola")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @PreAuthorize("isAuthenticated()")
  @RequestMapping("/api/autenticado")
  public String token() {
    return "token";
  }

  @PreAuthorize("hasAuthority('default')")
  @RequestMapping("/api/certo")
  public String teste2() {
    return "teste precisa do default";
  }

  @PreAuthorize("hasAuthority('papel_inexistente')")
  @RequestMapping("/api/erro")
  public String teste_precisa_de_outro_papel2() {
    return "nao_vai_dar_certo";
  }

  @RequestMapping("/token")
  public String getToken(HttpServletRequest request){
    KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();

    KeycloakSecurityContext context = (KeycloakSecurityContext) token.getCredentials();
    System.out.println(context.getToken().getResourceAccess());
    System.out.println(context.getToken().getResourceAccess("GUIA").getRoles());
    System.out.println(context.getToken().getResourceAccess("GUIA").isUserInRole("default"));
    System.out.println(context.getToken().getResourceAccess("GUIA").isUserInRole("papel_inexistente"));
    System.out.println(context.getToken().getFamilyName());
    System.out.println(context.getToken().getGivenName());
    System.out.println(context.getToken().getEmail());
    System.out.println("principal: "+ token.getPrincipal());

    return JWTUtil.getJWTToken();
  }
}