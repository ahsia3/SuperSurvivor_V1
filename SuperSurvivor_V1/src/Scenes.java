

public class Scenes {

    private int sid;
    private String sname;
    private int iid;
    private String text;
    private int options;

    public Scenes(int id, String n, int imgId, String t, int op){
        sid = id;
        sname = n;
        iid = imgId;
        text = t;
        options = op;
}

    public int getIid() {
        return iid;
    }

    public int getOptions() {
        return options;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getText() {
        return text;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public void setOptions(int options) {
        this.options = options;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setText(String text) {
        this.text = text;
    }
}
