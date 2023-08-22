package spring.mall.web.user.model;

public class UserSimple {
    private long id;
    private String username;

    private String token;

    public UserSimple(long id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }
    public UserSimple(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
