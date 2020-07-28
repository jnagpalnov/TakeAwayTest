package responses;

public class ListResponse {
    private float status_code;
    private String status_message;
    private boolean success;
    private int id;


    // Getter Methods

    public float getStatus_code() {
        return status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public boolean getSuccess() {
        return success;
    }

    public int getId() {
        return id;
    }

    // Setter Methods

    public void setStatus_code(float status_code) {
        this.status_code = status_code;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setId(int id) {
        this.id = id;
    }
}
