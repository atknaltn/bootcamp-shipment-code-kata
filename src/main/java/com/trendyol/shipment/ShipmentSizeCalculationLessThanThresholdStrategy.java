package com.trendyol.shipment;

public class ShipmentSizeCalculationLessThanThresholdStrategy implements ShipmentSizeCalculationStrategy{

    private final ShipmentSize shipmentSize;

    public ShipmentSizeCalculationLessThanThresholdStrategy(ShipmentSize shipmentSize) {
        this.shipmentSize = shipmentSize;
    }

    @Override
    public ShipmentSize getShipmentSize() {
        return this.shipmentSize;
    }
}
