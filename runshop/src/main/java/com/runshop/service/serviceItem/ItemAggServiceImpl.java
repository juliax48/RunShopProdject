package com.runshop.service.serviceItem;

import java.util.Map;

public class ItemAggServiceImpl implements ItemAggregationService {
    @Override
    public Map<String, Object> getStats() {
        return null;
    }
}

//    private final ItemRepository itemRepository = new ItemRepositoryImpl(new DatabaseProperties());
//
//    @Override
//    public Map<String, Object> getStats() {
//
//        List<Item> itemList = itemRepository.findAll();
//        Item one = itemRepository.findOne(1L);
//
//        Map<String, Object> resultMap = new HashMap<>();
//
//        resultMap.put("allUsers", itemList);
//        resultMap.put("oneItem", one);
//
//        return resultMap;
