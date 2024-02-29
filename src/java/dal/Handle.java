/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import data.Admin;
import data.Cart;
import data.Category;
import data.Item;
import data.Products;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Handle {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Trading2022;"
            + "encrypt=true;"
            + "trustServerCertificate=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "101000";

    public List<Category> getListCategory() {
        List<Category> list = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String selectQuery = "SELECT * from dbo.categories";
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(c);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCategoryById(int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String selectQuery = "SELECT * from dbo.categories where id =" + id;
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                return c;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Products> getProductsByCid(int cid) {
        String selectQuery = "SELECT * FROM dbo.products";
        if (cid != 0) {
            selectQuery = "SELECT * FROM dbo.products where cid = " + cid;
//                selectQuery+="where cid="+cid;
        }
        List<Products> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
//                p.setCid(rs.getInt("cid"));
                Category c = getCategoryById(rs.getInt("cid"));
                p.setCategory(c);
                list.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Products> getNewProducts() {
        List<Products> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String sql = "select top 3 * from dbo.Products order by releaseDate desc";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
//                p.setCid(rs.getInt("cid"));
                Category c = getCategoryById(rs.getInt("cid"));
                p.setCategory(c);
                list.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Products> getOldProducts() {
        List<Products> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String sql = "select top 3 * from dbo.Products order by releaseDate";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
//                p.setCid(rs.getInt("cid"));
                Category c = getCategoryById(rs.getInt("cid"));
                p.setCategory(c);
                list.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Products> searchByKey(String key) {
        List<Products> list = new ArrayList<>();
        String sql = "select * from dbo.products where name like N'%" + key + "%' or describe like N'%" + key + "%'";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
//                p.setCid(rs.getInt("cid"));
                Category c = getCategoryById(rs.getInt("cid"));
                p.setCategory(c);
                list.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

//    public List<Products> searchByCheck(int[] cid){
//        List<Products> list = new ArrayList<>();
//        String sql = "select * from dbo.products";
//        if(cid!=null && cid[0]!=0){
//            sql = "select * from dbo.products  cid in(";
//            for(int i =0;i<cid.length;i++){
//                sql+=cid[i]+",";
//            }
//            if(sql.endsWith(",")){
//                sql=sql.substring(0,sql.length()-1);
//            }
//            sql +=")";
//        }
//        try{
//            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()){
//                Products p = new Products();
//                p.setID(rs.getString("ID"));
//                p.setName(rs.getString("name"));
//                p.setQuantity(rs.getInt("quantity"));
//                p.setPrice(rs.getDouble("price"));
//                p.setReleaseDate(rs.getDate("releaseDate"));
//                p.setDescribe(rs.getString("describe"));
//                p.setImage(rs.getString("image"));
////                p.setCid(rs.getInt("cid"));
//                Category c = getCategoryById(rs.getInt("cid"));
//                p.setCategory(c);
//                list.add(p);
//            }
//        }catch (Exception e) {
//            System.out.println(e);
//        }
//        return list;
//    }
    public List<Products> getData(String sql) throws SQLException {
        List<Products> list = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Products p = new Products();
            p.setID(rs.getString("ID"));
            p.setName(rs.getString("name"));
            p.setQuantity(rs.getInt("quantity"));
            p.setPrice(rs.getDouble("price"));
            p.setReleaseDate(rs.getDate("releaseDate"));
            p.setDescribe(rs.getString("describe"));
            p.setImage(rs.getString("image"));
//                p.setCid(rs.getInt("cid"));
            Category c = getCategoryById(rs.getInt("cid"));
            p.setCategory(c);
            list.add(p);
        }
        return list;
    }

    public List<Products> searchByCheck(int[] cid) {
        int a = 0;
        int b = 0;
        List<Products> list = new ArrayList<>();
        List<Products> listCheck = new ArrayList<>();
        String sql = "";
        try {
            boolean check = false;
            for (int i = 0; i < cid.length; i++) {
                switch (cid[i]) {
                    case 0: {
                        //all
                        sql = "select * from dbo.products";
                        list = getData(sql);
                        check = true;
                        break;
                    }
                    case 1: {
                        // iphone
                        sql = "select * from dbo.products where cid in (1)";
                        listCheck = getData(sql);
                        break;
                    }
                    case 2: {
                        // samsung
                        sql = "select * from dbo.products where cid in (2)";
                        listCheck = getData(sql);
                        break;
                    }
                    case 3: {
                        // oppo
                        sql = "select * from dbo.products where cid in (3)";
                        listCheck = getData(sql);
                        break;
                    }
                    case 4: {
                        // vsmart
                        sql = "select * from dbo.products where cid in (4)";
                        listCheck = getData(sql);
                        break;
                    }
                }

                list.addAll(listCheck);
                if (check == true) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

//
//    public List<Products> getProductsByPrice(double from, double to) {
//        List<Products> list = new ArrayList<>();
//        String sql = "select * from dbo.products where price between" + from + "and" + to;
//        System.out.println("aaaaaaaaaaaaaaaaaaaa");
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Products p = new Products();
//                p.setID(rs.getString("ID"));
//                p.setName(rs.getString("name"));
//                p.setQuantity(rs.getInt("quantity"));
//                p.setPrice(rs.getDouble("price"));
//                p.setReleaseDate(rs.getDate("releaseDate"));
//                p.setDescribe(rs.getString("describe"));
//                p.setImage(rs.getString("image"));
////                p.setCid(rs.getInt("cid"));
//                Category c = getCategoryById(rs.getInt("cid"));
//                p.setCategory(c);
//                list.add(p);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return list;
//    }
    public List<Products> getProductsByPrice(int[] pric) {
        int a = 0;
        int b = 0;
        List<Products> list = new ArrayList<>();
        List<Products> listCheck = new ArrayList<>();
        String sql = "";
        try {
            boolean check = false;
            for (int i = 0; i < pric.length; i++) {
                switch (pric[i]) {
                    case 0: {
                        //all
                        sql = "select * from dbo.products";
                        list = getData(sql);
                        check = true;
                        break;
                    }
                    case 1: {
                        // 0-1000
                        sql = "select * from dbo.products where price between 0 and 1000";
                        listCheck = getData(sql);
                        break;
                    }
                    case 2: {
                        // 1000-3000
                        sql = "select * from dbo.products where price between 1000 and 3000";
                        listCheck = getData(sql);
                        break;
                    }
                    case 3: {
                        // 3000-5000
                        sql = "select * from dbo.products where price between 3000 and 5000";
                        listCheck = getData(sql);
                        break;
                    }
                    case 4: {
                        // 5000-10000
                        sql = "select * from dbo.products where price between 5000 and 10000";
                        listCheck = getData(sql);
                        break;
                    }
                    case 5: {
                        // 10000-20000
                        sql = "select * from dbo.products where price between 10000 and 20000";
                        listCheck = getData(sql);
                        break;
                    }
                }

                list.addAll(listCheck);
                if (check == true) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Products getProductsById(String id) {
        List<Products> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String selectQuery = "SELECT * from dbo.products where id = '" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
//                p.setCid(rs.getInt("cid"));
                Category c = getCategoryById(rs.getInt("cid"));
                p.setCategory(c);
                list.add(p);
                return p;
//              return p;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//----------------------------------------------------------------------//
    public Admin check(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String selectQuery = "SELECT * from dbo.admin where username='" + username + "'and password='" + password + "'";
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Admin c = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
                return c;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Admin checkacc(String username) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String selectQuery = "SELECT * from dbo.admin where username='" + username + "'";
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Admin c = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
                return c;
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void signup(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            String selectQuery = "insert into dbo.admin(Username,Password,role,amount) values (N'" + username + "',N'" + password + "',2,100000)";
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addOrder(Admin c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //add order
            String sql = "insert to dbo.orderr value(" + date + "," + c.getId() + "," + cart.getTotalMoney() + ")";
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            //lay id cua order vua add
            String sql1 = "select top 1 id from dbo.orderr by id desc";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            //add bang orderdetail
            if (rs.next()) {
                int oid = rs.getInt("id");
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into dbo.orderdetail values(" + oid + ",N'" + i.getProduct().getID() + "'," + i.getQuantity() + "," + i.getPrice() + ")";
                    PreparedStatement st2=conn.prepareStatement(sql2);
                    st2.executeUpdate();
                }
            }
            //cap nhat lai so luong san pham
            String sql3 ="update products set quantity=quantity-? where id=?";
            PreparedStatement st3 =conn.prepareStatement(sql3);
            for(Item i:cart.getItems()){
                st3.setInt(1, i.getQuantity());
                st3.setString(2, i.getProduct().getID());
                st3.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
