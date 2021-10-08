package com.example.reporteasyfixapplication.data.database

import org.jetbrains.exposed.sql.Table

object Material:Table("material") {
    val material_id = integer("material_id").autoIncrement()
    val material_name = varchar("material_name",20)
    val price_material = integer("price")
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(material_id, name = "material_id_PK")

}