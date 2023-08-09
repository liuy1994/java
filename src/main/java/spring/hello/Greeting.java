package spring.hello;

public class Greeting {
    private final long id;
    private final String content;

    private final String date;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
        this.date = new java.util.Date().toString();
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
