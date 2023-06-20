package com.maxvision.room.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 描述
 */
class UserAndAllPets {
    @Embedded
    var user: User? = null

    @Relation(parentColumn = "id",
    entityColumn = "owner")
    var pets : List<Pet> = ArrayList()
}