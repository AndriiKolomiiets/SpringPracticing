package Main;

import org.springframework.stereotype.Component;

@Component
public class Client {

    private int id;
    private String fullName;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    private String greeting;

    public Client(int id, String name) {
        this.id = id;
        this.fullName = name;
    }

    public Client() {

    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
