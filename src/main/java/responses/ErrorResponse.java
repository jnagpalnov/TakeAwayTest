package responses;

import java.util.List;

public class ErrorResponse {
    private List<String> errors;

    public void setErrors(List<String> errors){
        this.errors = errors;
    }
    public List<String> getErrors(){
        return this.errors;
    }
}
