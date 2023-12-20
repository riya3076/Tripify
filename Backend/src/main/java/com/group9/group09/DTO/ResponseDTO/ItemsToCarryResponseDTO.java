package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.ItemstoCarry;

import java.util.List;

/**
 * Data Transfer Object for Items to Carry Response.
 */
public class ItemsToCarryResponseDTO {
    private List<ItemstoCarry> itemstoCarryResponseList;

    /**
     * Get the list of items to carry in the response.
     *
     * @return the list of items to carry
     */
    public List<ItemstoCarry> getItemstoCarryResponseList() {
        return itemstoCarryResponseList;
    }

    /**
     * Set the list of items to carry in the response.
     *
     * @param itemstoCarryResponseList the list of items to carry to set
     */
    public void setItemstoCarryResponseList(List<ItemstoCarry> itemstoCarryResponseList) {
        this.itemstoCarryResponseList = itemstoCarryResponseList;
    }
}
