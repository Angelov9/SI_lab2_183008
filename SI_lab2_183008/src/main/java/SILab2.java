import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        if (user==null) {
            throw new RuntimeException("The user argument is not initialized!");
        }
        else {
            if (user.getUsername()==null || allUsers.contains(user.getUsername())) {
                throw new RuntimeException("User already exists!");
            }
            else {
                if (user.getEmail()==null)
                    return false;
                boolean atChar = false, dotChar = false;
                for (int i=0;i<user.getEmail().length();i++) {
                    if (user.getEmail().charAt(i)=='@')
                        atChar = true;
                    if (atChar && user.getEmail().charAt(i)=='.') {
                        dotChar = true;
                    }
                }
                if (!atChar || !dotChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
