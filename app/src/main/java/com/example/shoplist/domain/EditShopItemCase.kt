package com.example.shoplist.domain

class EditShopItemCase(private val shopItemRepository: ShopItemRepository) {
    fun editShopItem(shopItem: ShopItem){
        shopItemRepository.editShopItem(shopItem)
    }
}