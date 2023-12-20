package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object (DTO) class for requesting information related to items to carry.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class ItemstoCarryRequestDTO extends RequestDTO {

    private Integer item_id;

    /**
     * Get the ID of the item to carry.
     *
     * @return The item ID.
     */
    public Integer getItem_id() {
        return item_id;
    }

    /**
     * Set the ID of the item to carry.
     *
     * @param item_id The item ID to set.
     */
    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
}
