package responses;

public class ClearListResponse {
    private int items_deleted;

    private String status_message;

    private int id;

    private int status_code;

    private boolean success;

    public void setItems_deleted(int items_deleted){
        this.items_deleted = items_deleted;
    }
    public int getItems_deleted(){
        return this.items_deleted;
    }
    public void setStatus_message(String status_message){
        this.status_message = status_message;
    }
    public String getStatus_message(){
        return this.status_message;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setStatus_code(int status_code){
        this.status_code = status_code;
    }
    public int getStatus_code(){
        return this.status_code;
    }
    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return this.success;
    }
}
