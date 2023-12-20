package com.group9.group09.repository.interfaces;

import com.group9.group09.model.Activity;
import com.group9.group09.model.ItemstoCarry;

import java.util.List;

public interface ItemsRepository {
    List<ItemstoCarry> getAllItems();
}
