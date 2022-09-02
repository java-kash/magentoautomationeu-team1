package com.unitedcoder.magentoautomationtest.apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadUtility {
    public static String getCustomerGroupPayload(int id, String customerGroupCode, int taxClassId) {
        long timeStamp = System.currentTimeMillis();
        String payload = null;
        CustomerGroupPayload customerGroupPayload = new CustomerGroupPayload(id, customerGroupCode + timeStamp, taxClassId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(customerGroupPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return payload;
    }

    public static String getCustomerGroupPayload(String customerGroupCode, int taxClassId) {
        String payload = null;
        CustomerGroupPayload customerGroupPayload = new CustomerGroupPayload(customerGroupCode, taxClassId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(customerGroupPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return payload;
    }
}
