package password.manager;

public class PasswordEntry {

    private String password;
    private String serviceName;
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

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
}
