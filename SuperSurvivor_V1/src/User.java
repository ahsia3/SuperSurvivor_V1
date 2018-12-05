

public class User {

    private int id;
    private String uname;
    private String pass;
    private Death death;

    public User(int i, String u,String p){
        id = i;
        uname = u;
        pass =p;
    }

    public int getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }
    
    public Death getDeath() {
        return death;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setDeaths(int uid, int sid, int deaths, String sn) {
        death = new Death(uid, sid, deaths, sn);
    }
}
