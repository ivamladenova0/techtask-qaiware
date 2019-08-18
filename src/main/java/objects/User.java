package objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "email",
        "first_name",
        "last_name",
        "name",
        "avatar",
        "job",
        "createdAt",
        "updatedAt",
        "password"
})
public class User {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("email")
    public String email;

    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;

    @JsonProperty("name")
    public String name;

    @JsonProperty("avatar")
    public String avatar;

    @JsonProperty("job")
    public String job;

    @JsonProperty("createdAt")
    public String createdAt;

    @JsonProperty("updatedAt")
    public String updatedAt;

    @JsonProperty("password")
    public String password;

    @JsonProperty("data")
    public User data;
}