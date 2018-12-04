

public class Images {

    private int iid;
    private String ipath;

    public Images(int id, String path){
        iid = id;
        ipath = path;
    }

    public int getIid() {
        return iid;
    }

    public String getIpath() {
        return ipath;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public void setIpath(String ipath) {
        this.ipath = ipath;
    }
}
