package password.manager;

import lombok.ToString;

import java.util.Objects;
@ToString
public class PasswordEntry {

    private String password;
    private final String serviceName;
    private String login;
    private String description;


    public PasswordEntry(String password, String serviceName, String login, String description) {
        this.password = password;
        this.serviceName = serviceName;
        this.login = login;
        this.description = description;
    }

    public PasswordEntry(String password, String serviceName) {
        this.password = password;
        this.serviceName = serviceName;
        login = "";
        description = "";
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setLogin(String login) {
        this.login = login;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getLogin() {
        return login;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PasswordEntry)) return false;
        PasswordEntry that = (PasswordEntry) o;
        return Objects.equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName);
    }
}
