package com.trendyol.shipment;


public class ShipmentSizeCalculationGreaterThanThresholdStrategy implements ShipmentSizeCalculationStrategy
{
    private final ShipmentSize shipmentSize;
    public ShipmentSizeCalculationGreaterThanThresholdStrategy(ShipmentSize shipmentSize)
    {
        this.shipmentSize = shipmentSize;
    }

    @Override
    public ShipmentSize getShipmentSize() {
        return ShipmentSize.values()[this.shipmentSize.ordinal()+1];
    }
}
