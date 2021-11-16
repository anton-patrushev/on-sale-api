package com.onsale.onsaleapi.domains.cities.entities

import com.onsale.onsaleapi.domains.shared.types.ID

data class City(val id: ID, val name: String)

data class CityFields(val name: String)