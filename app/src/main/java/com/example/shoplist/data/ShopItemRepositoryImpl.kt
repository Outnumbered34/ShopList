package com.example.shoplist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoplist.domain.ShopItem
import com.example.shoplist.domain.ShopItemRepository
import java.lang.RuntimeException

object ShopItemRepositoryImpl: ShopItemRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()

    private var shopItemIdM = 0
    override fun addShopItem(shopItem: ShopItem) {
        shopItem.id = shopItemIdM++
        shopList.add(shopItem)
        updateShopList()

    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateShopList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItemById(shopItem.id)
        shopList.remove(oldShopItem)
        shopList.add(shopItem)
        updateShopList()
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun getShopItemById(shopItemId: Int): ShopItem {
        return shopList.find{it.id == shopItemId} ?: throw RuntimeException("Element with $shopItemId id not found")
    }

    private fun updateShopList(){
        shopListLD.value = shopList.toList()
    }
}