package objects;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "page",
            "per_page",
            "total",
            "total_pages",
            "data"
    })

    public class UserList {
        @JsonProperty("page")
        private Integer page;

        @JsonProperty("per_page")
        private Integer perPage;

        @JsonProperty("total")
        private Integer total;

        @JsonProperty("total_pages")
        private Integer totalPages;

        @JsonProperty("data")
        private List<User> data = null;

        @JsonProperty("per_page")
        public Integer getPerPage() { return perPage; }

        @JsonProperty("total_pages")
        public Integer getTotalPages() {
            return totalPages;
        }

        @JsonProperty("data")
        public List<User> getData() {
            return data;
        }
    }