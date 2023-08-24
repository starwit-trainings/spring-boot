package de.starwit.example.apppropsdemo;

public class ProfiledBean {
    private String username;
    private String password;
    private boolean encrypted = false;
    private String url;
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean isEncrypted() {
        return encrypted;
    }
    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    
}
