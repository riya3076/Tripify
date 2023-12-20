package com.group9.group09.repositoryTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.group9.group09.exception.ItemNotFoundException;
import com.group9.group09.model.ItemstoCarry;
import com.group9.group09.repository.ItemsRepositoryImp;
import com.group9.group09.repository.rowmapper.ItemstoCarryRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
class ItemsRepositoryImpTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ItemsRepositoryImp itemsRepository;

    private ItemstoCarry testItem;

    @BeforeEach
    public void setup() {
        testItem = new ItemstoCarry();
    }

    @Test
    public void testGetAllItems_ExistingItems_ReturnsListOfItems() {
        List<ItemstoCarry> itemsList = new ArrayList<>();
        itemsList.add(testItem);

        when(jdbcTemplate.query(anyString(), any(ItemstoCarryRowMapper.class), any())).thenReturn(itemsList);

        List<ItemstoCarry> result = itemsRepository.getAllItems();

        assertEquals(itemsList, result);

        verify(jdbcTemplate).query(anyString(), any(ItemstoCarryRowMapper.class), eq(null));
    }
}