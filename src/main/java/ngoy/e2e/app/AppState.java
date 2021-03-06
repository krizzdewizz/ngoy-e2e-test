package ngoy.e2e.app;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * thanks to
 * https://www.dev2qa.com/spring-mvc-request-and-session-scoped-bean-example/
 *
 * @author krizz
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AppState {
    private final String user;
    private final LocalDateTime created;
    private String message;

    public AppState() {
        user = UUID.randomUUID()
                .toString();
        created = LocalDateTime.now();
    }

    public String getUser() {
        return user;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
