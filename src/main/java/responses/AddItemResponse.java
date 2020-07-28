package responses;

import java.util.List;

public class AddItemResponse {
    private int status_code;

    private String status_message;

    private boolean success;

    private List<Results> results;

    public void setStatus_code(int status_code){
        this.status_code = status_code;
    }
    public int getStatus_code(){
        return this.status_code;
    }
    public void setStatus_message(String status_message){
        this.status_message = status_message;
    }
    public String getStatus_message(){
        return this.status_message;
    }
    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public void setResults(List<Results> results){
        this.results = results;
    }
    public List<Results> getResults(){
        return this.results;
    }
}

