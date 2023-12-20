package com.group9.group09.repositoryTest;

import com.group9.group09.model.wishList;
import com.group9.group09.repository.WishListRepositoryImp;
import com.group9.group09.repository.rowmapper.WishListRowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WishListRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private WishListRepositoryImp wishListRepository;

    @Test
    public void testGetWishListbyUserIDValid() {
        List<wishList> mockResultList = new ArrayList<>();
        mockResultList.add(new wishList(/* Add relevant fields for the wishList object */));
        when(jdbcTemplate.query(anyString(), any(WishListRowMapper.class), anyInt()))
                .thenReturn(mockResultList);

        Integer userID = 10004;
        List<wishList> result = wishListRepository.getWishListbyUserID(userID);

        assertEquals(1, result.size());
    }

    @Test
    public void testGetWishListbyUserIDNoResults() {
        when(jdbcTemplate.query(anyString(), any(WishListRowMapper.class), anyInt()))
                .thenReturn(new ArrayList<>());

        Integer userID = 10004;
        List<wishList> result = wishListRepository.getWishListbyUserID(userID);

        assertEquals(0, result.size());
    }

    @Test(expected = RuntimeException.class)
    public void testGetWishListbyUserIDException() {
        when(jdbcTemplate.query(anyString(), any(WishListRowMapper.class), anyInt()))
                .thenThrow(new RuntimeException("Mocked exception"));

        Integer userID = 10004;
        wishListRepository.getWishListbyUserID(userID);
    }
}