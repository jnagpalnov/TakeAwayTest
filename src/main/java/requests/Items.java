package requests;

public class Items {
    private String media_type;

    private int media_id;
    private String comment;

    public void setMedia_type(String media_type){
        this.media_type = media_type;
    }
    public String getMedia_type(){
        return this.media_type;
    }
    public void setMedia_id(int media_id){
        this.media_id = media_id;
    }
    public int getMedia_id(){
        return this.media_id;
    }
    public void setComment(String comment){
        this.comment=comment;
    }
    public String getComment(){
        return this.comment;
    }

//    @Override
//    public String toString()
//    {
//        return "ClassPojo [media_type = "+media_type+", media_id = "+media_id+"]";
//    }
}
