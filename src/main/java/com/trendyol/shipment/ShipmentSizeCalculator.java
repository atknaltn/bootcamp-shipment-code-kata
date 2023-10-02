package com.trendyol.shipment;

import java.util.List;

public class ShipmentSizeCalculator
{
    public ShipmentSize getShipmentSize(List<Product> products) {
        ShipmentSizeCalculationStrategy shipmentSizeCalculationStrategy = ShipmentSizeCalculationStrategyFactory.create(products);
        return shipmentSizeCalculationStrategy.getShipmentSize();
    }
}
