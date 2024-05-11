package com.orion.trainee.mapper;

import com.orion.trainee.dto.ItemDto;
import com.orion.trainee.dto.PedidoDto;
import com.orion.trainee.model.Item;
import com.orion.trainee.model.Pedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
    Item toEntity(ItemDto itemDto);
    ItemDto toDto(Item item);
    List<ItemDto> toDtos(List<Item> itens);
}