package com.example.shoplist.domain

import androidx.lifecycle.LiveData

class GetShopListCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopItemRepository.getShopList()
    }
}