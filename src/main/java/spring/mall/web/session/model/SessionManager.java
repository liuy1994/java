package spring.mall.web.session.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SessionManager {
    private HashMap<Long, Session> sessions = new HashMap<>();

    public HashMap<Long, Session> getSessions() {
        return sessions;
    }

    public void setSessions(HashMap<Long, Session> sessions) {
        this.sessions = sessions;
    }
}
