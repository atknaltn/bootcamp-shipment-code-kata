package com.trendyol.shipment;

import java.util.List;

public class Basket {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public ShipmentSize getShipmentSize()
    {
        ShipmentSizeCalculator shipmentSizeCalculator = new ShipmentSizeCalculator();
        return shipmentSizeCalculator.getShipmentSize(this.products);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
