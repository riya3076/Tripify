package com.group9.group09.model;

public class ItemstoCarry {
    private Integer itemID;
    private String itemName;

    /**
     * Get the name of the item.
     *
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the name of the item.
     *
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Get the ID of the item.
     *
     * @return the itemID
     */
    public Integer getItemID() {
        return itemID;
    }

    /**
     * Set the ID of the item.
     *
     * @param itemID the itemID to set
     */
    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }
}
