package com.onsale.onsaleapi.domains.shared.types

// TODO: generate only one mapper
interface IMapper<Source, Destination> {
    fun transform(source: Source): Destination
}

interface IMapperWithAdditionalParams<Source, Destination, AdditionalParams> {
    fun transform(source: Source, additionalParams: AdditionalParams): Destination
}
