package responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetList {
    private String iso_639_1;
    private float id;
    private float page;
    private String iso_3166_1;
    private float total_results;
    ArrayList< Object > object_ids = new ArrayList < Object > ();
    private float revenue;
    private float total_pages;
    private String name;
    @SerializedName("public")
    private boolean isPublic;
    ArrayList < Object > comments = new ArrayList < Object > ();
    private String sort_by;
    private String description;
    private String backdrop_path = null;
    ArrayList < Object > results = new ArrayList < Object > ();
    private float average_rating;
    private float runtime;
    Created_by Created_byObject;
    private String poster_path = null;


    // Getter Methods

    public String getIso_639_1() {
        return iso_639_1;
    }

    public float getId() {
        return id;
    }

    public float getPage() {
        return page;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public float getTotal_results() {
        return total_results;
    }

    public float getRevenue() {
        return revenue;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public String getName() {
        return name;
    }

    public boolean getPublic() {
        return isPublic;
    }

    public String getSort_by() {
        return sort_by;
    }

    public String getDescription() {
        return description;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public float getAverage_rating() {
        return average_rating;
    }

    public float getRuntime() {
        return runtime;
    }

    public Created_by getCreated_by() {
        return Created_byObject;
    }

    public String getPoster_path() {
        return poster_path;
    }

    // Setter Methods

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setPage(float page) {
        this.page = page;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public void setTotal_results(float total_results) {
        this.total_results = total_results;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setAverage_rating(float average_rating) {
        this.average_rating = average_rating;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }

    public void setCreated_by(Created_by created_byObject) {
        this.Created_byObject = created_byObject;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
class Created_by {
    private String gravatar_hash;
    private String name;
    private String username;
    private String id;


    // Getter Methods

    public String getGravatar_hash() {
        return gravatar_hash;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    // Setter Methods

    public void setGravatar_hash(String gravatar_hash) {
        this.gravatar_hash = gravatar_hash;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }
}

