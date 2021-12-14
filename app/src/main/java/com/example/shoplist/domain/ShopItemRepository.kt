package com.example.shoplist.domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopList(): LiveData<List<ShopItem>>
    fun getShopItemById(shopItemId: Int): ShopItem

}