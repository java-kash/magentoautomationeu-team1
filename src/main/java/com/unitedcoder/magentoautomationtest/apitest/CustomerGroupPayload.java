package com.unitedcoder.magentoautomationtest.apitest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerGroupPayload {
    @JsonProperty("id")
    private int id;
    @JsonProperty("customerGroupCode")
    private String customerGroupCode;
    @JsonProperty("taxClassId")
    private int taxClassId;

    public CustomerGroupPayload(int id, String customerGroupCode, int taxClassId) {
        this.id = id;
        this.customerGroupCode = customerGroupCode;
        this.taxClassId = taxClassId;
    }

    public CustomerGroupPayload(String customerGroupCode, int taxClassId) {
        this.customerGroupCode = customerGroupCode;
        this.taxClassId = taxClassId;
    }
}
