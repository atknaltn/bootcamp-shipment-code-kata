package com.trendyol.shipment;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ShipmentSizeCalculationStrategyFactory {

    private static final int THRESHOLD = 3;
    private static Map<ShipmentSize, Integer> shipmentSizeCountMap;
    private ShipmentSizeCalculationStrategyFactory() {}

    public static ShipmentSizeCalculationStrategy create(List<Product> products)
    {
        initializeShipmentSizeCounterMap(products);

        Optional<ShipmentSize> shipmentSizeEntryGreaterThanThreshold = findShipmentSizeGreaterThanThreshold();

        if (shipmentSizeEntryGreaterThanThreshold.isPresent())
        {
            return new ShipmentSizeCalculationGreaterThanThresholdStrategy(shipmentSizeEntryGreaterThanThreshold.get());
        }

        ShipmentSize shipmentSizeLessThanThreshold = findShipmentSizeLessThanThreshold();

        return new ShipmentSizeCalculationLessThanThresholdStrategy(shipmentSizeLessThanThreshold);
    }

    private static void initializeShipmentSizeCounterMap(List<Product> products)
    {
        shipmentSizeCountMap = new EnumMap<>(ShipmentSize.class);

        for (ShipmentSize size : ShipmentSize.values())
        {
            shipmentSizeCountMap.put(size, 0);
        }

        for (Product product : products)
        {
            shipmentSizeCountMap.put(product.getSize(), shipmentSizeCountMap.get(product.getSize()) + 1);
        }
    }

    private static Optional<ShipmentSize> findShipmentSizeGreaterThanThreshold() {
        return shipmentSizeCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= THRESHOLD && entry.getKey() != ShipmentSize.X_LARGE)
                .map(Map.Entry::getKey)
                .findAny();
    }

    private static ShipmentSize findShipmentSizeLessThanThreshold() {
        return shipmentSizeCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .max(ShipmentSize::compareTo)
                .orElseThrow(NullPointerException::new);
    }
}
