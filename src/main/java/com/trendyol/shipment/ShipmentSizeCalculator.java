package com.trendyol.shipment;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ShipmentSizeCalculator
{
    public ShipmentSize getShipmentSize(List<Product> products) {
        ShipmentSizeCalculationStrategy shipmentSizeCalculationStrategy = ShipmentSizeCalculationStrategyFactory.create(products);
        return shipmentSizeCalculationStrategy.getShipmentSize();
    }
}
