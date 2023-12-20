package com.group9.group09.repository.interfaces;

import com.group9.group09.DTO.RequestDTO.WishListRequestDTO;
import com.group9.group09.model.wishList;

import java.util.List;

public interface WishlistRepository {

    List<wishList> getWishListbyUserID(Integer userID);

    int addtoWishlist(WishListRequestDTO wishListRequestDTO);

    int deletewishlistbyID(Integer wishlistid);
}
