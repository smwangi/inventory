package com.samwan.inventory.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by smwangi on 1/22/18.
 */
@Entity(tableName = "products")
public class ProductEntity implements Serializable {
    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("quantity")
    private int quantity;



    @SerializedName("price")
    private double price;

    @SerializedName("vendor_name")
    @ColumnInfo(name = "vendor_name")
    private String vendorName;

    @SerializedName("vendor_msisdn")
    @ColumnInfo(name = "vendor_msisdn")
    private String vendorMsisdn;


    @SerializedName("vendor_email")
    @ColumnInfo(name = "vendor_email")
    private String vendorEmail;

    /*public ProductEntity(){}

    public ProductEntity(int id,String name, String description,int quanitity, double price, String vendorName,String vendorEmail,String vendorMsisdn){
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quanitity;
        this.price = price;
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.vendorMsisdn = vendorMsisdn;
    }*/

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorMsisdn() {
        return vendorMsisdn;
    }

    public void setVendorMsisdn(String vendorMsisdn) {
        this.vendorMsisdn = vendorMsisdn;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", vendorName='" + vendorName + '\'' +
                ", vendorMsisdn='" + vendorMsisdn + '\'' +
                ", vendorEmail='" + vendorEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;

        ProductEntity that = (ProductEntity) o;

        if (getId() != that.getId()) return false;
        if (getQuantity() != that.getQuantity()) return false;
        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        if (!getVendorName().equals(that.getVendorName())) return false;
        if (!getVendorMsisdn().equals(that.getVendorMsisdn())) return false;
        return getVendorEmail().equals(that.getVendorEmail());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getQuantity();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getVendorName().hashCode();
        result = 31 * result + getVendorMsisdn().hashCode();
        result = 31 * result + getVendorEmail().hashCode();
        return result;
    }
}
