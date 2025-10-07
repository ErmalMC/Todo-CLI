


public class Task {
    private int ID;
    private String description;
    private Boolean status;

    public Task(int ID, String description, Boolean status) {
        this.ID = ID;
        this.description = description;
        this.status = status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(ID).append(".");

        if(status == true) {
            sb.append(" [x] ");
        }else{
            sb.append(" [] ");
        }
        sb.append(description);
        return sb.toString();
    }

    public static Task fromString(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String description = parts[1];
        boolean status = Boolean.parseBoolean(parts[2]);
        return new Task(id, description, status);
    }
}
