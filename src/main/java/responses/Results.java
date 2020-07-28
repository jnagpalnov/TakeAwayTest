package responses;

public class Results
{
    private int sort_order;

    private int media_id;

    private boolean success;

    private String media_type;

    public void setSort_order(int sort_order){
        this.sort_order = sort_order;
    }
    public int getSort_order(){
        return this.sort_order;
    }
    public void setMedia_id(int media_id){
        this.media_id = media_id;
    }
    public int getMedia_id(){
        return this.media_id;
    }
    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public void setMedia_type(String media_type){
        this.media_type = media_type;
    }
    public String getMedia_type(){
        return this.media_type;
    }
}
