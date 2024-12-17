public class Notification {
    String id;
    String message;
    Boolean read;

    public Notification(String id, String message) {
        this.id = id;
        this.message = message;
        this.read = false;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}
