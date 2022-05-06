package com.a1tech.retrofittest;

public class GetDataModel {

    private int zakazId;
    private int userId;
    private String zakazFrom;

    public GetDataModel(int zakazId, int userId, String zakazFrom) {
        this.zakazId = zakazId;
        this.userId = userId;
        this.zakazFrom = zakazFrom;
    }

    public int getZakazId() {
        return zakazId;
    }

    public void setZakazId(int zakazId) {
        this.zakazId = zakazId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getZakazFrom() {
        return zakazFrom;
    }

    public void setZakazFrom(String zakazFrom) {
        this.zakazFrom = zakazFrom;
    }
}
