package API.rest.assured.dominio;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @JsonAlias("first_name")
    private String name;
    private String job;

    private String email;
    @JsonAlias("last_name")
    private String lastname;


}
