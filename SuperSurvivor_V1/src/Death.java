

public class Death {
    private int uid;
    String sc;
    private int sid;
    private int deaths;

    public Death(int u, int s, int d, String sn){
        uid = u;
        sc = sn;
        sid = s;
        deaths = d;
    }

    public int getSid() {
        return sid;
    }

    public int getUid() {
        return uid;
    }

    public int getDeaths() {
        return deaths;
    }
    public String getScene() {
        return sc;
    }
    
    public void setScene(String s) {
        sc = s;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
