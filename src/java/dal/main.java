/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import data.Category;
import data.Products;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class main extends DBContext {
    public static void main(String[] args) {
        Handle hd = new Handle();
        List<Category> list = hd.getListCategory();
        List<Products> news = hd.getNewProducts();
        List<Products> olds = hd.getOldProducts();
        Products products = hd.getProductsById("ip1");
        System.out.println("aaaaaaaaa"+products);
//        List<Products>list1 = hd.getProductsByCid(0);
//        System.out.println("aasvsdgsdgsg"+list1);
//        System.out.println(" Ma giao new: " + news.toString());
//        System.out.println(" Ma giao id  " + id.toString());
    }
    
}
