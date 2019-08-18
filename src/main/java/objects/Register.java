package objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "token",
            "error"
    })
    public class Register {
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("token")
        public String token;
        @JsonProperty("error")
        public String error;
    }