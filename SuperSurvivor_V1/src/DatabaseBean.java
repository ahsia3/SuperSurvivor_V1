

import java.awt.*;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseBean<pubic> implements Serializable {

    private static String url = "jdbc:sqlite:SuperSurvivorDB.db";
//    private static String url = "jdbc:sqlite:C:\\Users\\Nkwabo Saleh\\Documents\\Windowing class\\SuperSurvivor_Beta\\SuperSurvivor_Beta\\SuperSurvivorDB.db";

    public DatabaseBean(){

        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite Database has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void WriteUser(User usr){
        String u = usr.getUname();
        String p = usr.getPass();
        String sql = "INSERT INTO User(uname,pass) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, u);
                pstmt.setString(2, p);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteScenes(Scenes scn){
        String n = scn.getSname();
        int img = scn.getIid();
        String t = scn.getText();
        int op = scn.getOptions();
        String sql = "INSERT INTO Scenes(sname,iid,text,options) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, n);
                pstmt.setInt(2, img);
                pstmt.setString(3,t);
                pstmt.setInt(4,op);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteDeath(Death d){
        int u = d.getUid();
        int s = d.getSid();
        String sc = d.getScene();
        int num = d.getDeaths();
        String sql = "INSERT INTO Death(uid,sid,deaths,sc) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, u);
                pstmt.setInt(2,s);
                pstmt.setInt(3,num);
                pstmt.setString(4, sc);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
//    public static void UpdateDeath(Death d){
//        int u = d.getUid();
//        int s = d.getSid();
//        String sc = d.getScene();
//        int num = d.getDeaths();
//        String sql = "UPDATE Death SET(sid,deaths,sc) WHERE id";
//        try (Connection conn = DriverManager.getConnection(url)) {
//            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                pstmt.setInt(1, u);
//                pstmt.setInt(2,s);
//                pstmt.setInt(3,num);
//                pstmt.setString(4, sc);
//                pstmt.executeUpdate();
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static User RetrieveUser(int id){
        String sql = "SELECT id,uname,pass FROM User WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tid = rs.getInt("id");
            String tname = rs.getString("uname");
            String tpass = rs.getString("pass");
            User temp = new User(tid,tname,tpass);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            User temp = new User(-1,"fail","fail");
            return temp;
        }
    }
    
    public static ArrayList<User> RetriveAllUsers() {
        
        String sql = "SELECT id,uname,pass FROM User";
        ArrayList<User> user = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String text = rs.getString("uname");
//                System.out.println(text);
                
                int tid = rs.getInt("id");
                String tname = rs.getString("uname");
                String tpass = rs.getString("pass");
                User temp = new User(tid, tname, tpass);
                user.add(temp);
            }
            System.out.println(user.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            User temp = new User(-1,"fail","fail");
        }
        return user;
    }

    public static Death RetrieveDeath(int id){
        String sql = "SELECT uid,sc,sid,deaths FROM Death WHERE uid = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tuid = rs.getInt("uid");
            String ts = rs.getString("sc");
            int tsid = rs.getInt("sid");
            int tdeaths = rs.getInt("deaths");
            Death temp = new Death(tuid,tsid,tdeaths,ts);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Death temp = new Death(-1,-1,-1,"");
            return temp;
        }
    }

    public static Scenes RetrieveScenes(int id){
        String sql = "SELECT sid,sname,iid,stext,oid FROM Scenes WHERE sid = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tsid = rs.getInt("sid");
            String tsname = rs.getString("sname");
            int tiid = rs.getInt("iid");
            String ttext = rs.getString("stext");
            int top = rs.getInt("oid");
            Scenes temp = new Scenes(tsid,tsname,tiid,ttext,top);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Scenes temp = new Scenes(-1,"",-1,"",-1);
            return temp;
        }
    }
    
    public static ArrayList<Scenes> RetriveAllScenes() {
        
        String sql = "SELECT sid,sname,iid,stext,oid FROM Scenes";
        ArrayList<Scenes> scenes = new ArrayList<Scenes>();
        
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int text = rs.getInt("oid");
//                System.out.println(text);
                
                int tsid = rs.getInt("sid");
                String tsname = rs.getString("sname");
                int tiid = rs.getInt("iid");
                String ttext = rs.getString("stext");
                int top = rs.getInt("oid");
                Scenes temp = new Scenes(tsid,tsname,tiid,ttext,top);
                scenes.add(temp);
            }
            System.out.println(scenes.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Scenes temp = new Scenes(-1,"",-1,"",-1);
        }
        return scenes;
    }
    
    public static ArrayList<Scenes> RetriveAllCabinScenes() {
        
        String sql = "SELECT sid,sname,iid,stext,oid FROM Cabin_Scenes";
        ArrayList<Scenes> scenes = new ArrayList<Scenes>();
        
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int text = rs.getInt("oid");
//                System.out.println(text);
                
                int tsid = rs.getInt("sid");
                String tsname = rs.getString("sname");
                int tiid = rs.getInt("iid");
                String ttext = rs.getString("stext");
                int top = rs.getInt("oid");
                Scenes temp = new Scenes(tsid,tsname,tiid,ttext,top);
                scenes.add(temp);
            }
            System.out.println(scenes.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Scenes temp = new Scenes(-1,"",-1,"",-1);
        }
        return scenes;
    }

    public static Images RetrieveImages(int id){
        String sql = "SELECT iid,ipath FROM Images WHERE iid = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tiid = rs.getInt("iid");
            String tpath = rs.getString("ipath");
            Images temp = new Images(tiid,tpath);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
           Images temp = new Images(-1,"");
            return temp;
        }
    }
    
    public static Options RetrieveOptions(int id){
        String sql = "SELECT oid, first, second, third, fselected, sselected, tselected FROM Options WHERE oid = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int oid = rs.getInt("oid");
            String first = rs.getString("first");
            String second = rs.getString("second");
            String third = rs.getString("third");
            String fselected = rs.getString("fselected");
            String sselected = rs.getString("sselected");
            String tselected = rs.getString("tselected");
            Options temp = new Options(oid, first, second, third, fselected, sselected, tselected);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
           Options temp = new Options(-1,"", "", "", "", "", "");
            return temp;
        }
    }
    
    public static void DeleteUser(int id) {
        String sql = "DELETE FROM User WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
