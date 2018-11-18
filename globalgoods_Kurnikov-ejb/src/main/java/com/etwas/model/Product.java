package com.etwas.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Products", schema = "dbo", catalog = "Northwind")
public class Product {
    private int productId;
    private String productName;
    private String quantityPerUnit;
    private Short unitsInStock;
    private Short unitsOnOrder;
    private Short reorderLevel;
    private boolean discontinued;



    private int supplierId;
    @Column(name = "SupplierID")
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    private int categoryId;
    @Column(name = "CategoryID")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private BigDecimal unitPrice;
    @Column(name = "UnitPrice")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }



    @Id
    @Column(name = "ProductID", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "ProductName", nullable = false, length = 40)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "QuantityPerUnit", nullable = true, length = 20)
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    @Basic
    @Column(name = "UnitsInStock", nullable = true)
    public Short getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Short unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Basic
    @Column(name = "UnitsOnOrder", nullable = true)
    public Short getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Short unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    @Basic
    @Column(name = "ReorderLevel", nullable = true)
    public Short getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Short reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @Basic
    @Column(name = "Discontinued", nullable = false)
    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (productId != that.productId) return false;
        if (discontinued != that.discontinued) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (quantityPerUnit != null ? !quantityPerUnit.equals(that.quantityPerUnit) : that.quantityPerUnit != null)
            return false;
        if (unitsInStock != null ? !unitsInStock.equals(that.unitsInStock) : that.unitsInStock != null) return false;
        if (unitsOnOrder != null ? !unitsOnOrder.equals(that.unitsOnOrder) : that.unitsOnOrder != null) return false;
        if (reorderLevel != null ? !reorderLevel.equals(that.reorderLevel) : that.reorderLevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (quantityPerUnit != null ? quantityPerUnit.hashCode() : 0);
        result = 31 * result + (unitsInStock != null ? unitsInStock.hashCode() : 0);
        result = 31 * result + (unitsOnOrder != null ? unitsOnOrder.hashCode() : 0);
        result = 31 * result + (reorderLevel != null ? reorderLevel.hashCode() : 0);
        result = 31 * result + (discontinued ? 1 : 0);
        return result;
    }
}
