package responses;

public class UpdatedListResponse {
    private String status_message;
    private boolean success;
    private float status_code;


    // Getter Methods

    public String getStatus_message() {
        return status_message;
    }

    public boolean getSuccess() {
        return success;
    }

    public float getStatus_code() {
        return status_code;
    }

    // Setter Methods

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setStatus_code(float status_code) {
        this.status_code = status_code;
    }
}
