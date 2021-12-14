package com.example.shoplist.domain

class GetShopItemById(private val shopItemRepository: ShopItemRepository) {
    fun getShopItemById(shopItemId: Int): ShopItem{
        return shopItemRepository.getShopItemById(shopItemId)
    }
}