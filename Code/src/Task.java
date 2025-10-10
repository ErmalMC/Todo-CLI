


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

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(ID);

        if(status == true) {
            sb.append(" [x] ");
        }else{
            sb.append(" [] ");
        }
        sb.append(description);
        return sb.toString();
    }

    public static Task fromString(String line) {
        String[] parts = line.split(" ",3);
        int id = Integer.parseInt(parts[0]);
        boolean status = false;
        String description = parts[2];
        if(parts[1].equals("[x]")){
            status = true;
        }
        return new Task(id, description, status);
    }
}
