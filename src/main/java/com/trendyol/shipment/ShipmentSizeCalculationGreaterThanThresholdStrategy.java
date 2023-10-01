package com.trendyol.shipment;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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
