/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Admin
 */
public class Category {
    private int ID;
    private String name;
    private String describe;

    public Category() {
    }

    public Category(int ID, String name, String describe) {
        this.ID = ID;
        this.name = name;
        this.describe = describe;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Category{" + "ID=" + ID + ", name=" + name + ", describe=" + describe + '}';
    }
    
}
