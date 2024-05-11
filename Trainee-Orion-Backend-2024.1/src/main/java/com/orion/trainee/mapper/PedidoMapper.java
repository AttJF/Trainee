package com.orion.trainee.mapper;

import com.orion.trainee.dto.PedidoDto;
import com.orion.trainee.model.Pedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
    @Mapping(target="user",ignore = true)
    Pedido toEntity(PedidoDto pedidoDto);
    @Mapping(source="user.id",target="idUser")
    PedidoDto toDto(Pedido pedido);
    @Mapping(source="user.id",target="idUser")
    List<PedidoDto> toDtos(List<Pedido> pedidos);

}