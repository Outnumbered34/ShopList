package com.example.shoplist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplist.data.ShopItemRepositoryImpl
import com.example.shoplist.domain.*

class MainViewModel: ViewModel() {

    val repository = ShopItemRepositoryImpl
    private var getShopListUseCase = GetShopListCase(repository)
    private var deleteShopItemUseCase = DeleteShopItemCase(repository)
    private var editShopItemUseCase = EditShopItemCase(repository)

    val shopList = getShopListUseCase.getShopList()



    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledStare(shopItem: ShopItem){
        val newShopItem = shopItem.copy()
        newShopItem.enabled = !shopItem.enabled
        editShopItemUseCase.editShopItem(newShopItem)
    }


}