package table;

import java.util.Date;

public class User {
//    private int user_id;
    private String username;
    private String password;
    private String full_name;
    private String email;
    private String phone;
    private String address;
    private enum role{
        admin,user
    }
    private Date membership;
    private role role;
    public User( String username, String password, String full_name, String email, String phone, String address) {
//        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role.user;

    }
    public String getRole()
    {
        return this.role.name();
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
