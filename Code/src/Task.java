


public class Task {
    private int ID;
    private String description;
    private Boolean status;

    public Task(int ID, String description, Boolean status) {
        this.ID = ID;
        this.description = description;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ID + " " + status + " " + description;
    }
}
