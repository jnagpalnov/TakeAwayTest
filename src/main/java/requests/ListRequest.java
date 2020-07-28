package requests;

import com.google.gson.annotations.SerializedName;

public class ListRequest {
    private String name;
    private String iso_639_1;
    private String description;
    @SerializedName("public")
    private boolean isPublic;
    private String iso_3166_1;

    // Getter Methods

    public String getName() {
        return name;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public String getDescription(){
        return description;
    }

    public boolean getPublic(){
        return isPublic;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }


    public void setDescription(String description){
        this.description=description;
    }

    public void setPublic(boolean isPublic){
        this.isPublic=isPublic;
    }
}
