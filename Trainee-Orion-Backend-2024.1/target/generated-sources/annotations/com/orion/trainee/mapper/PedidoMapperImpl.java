package com.orion.trainee.mapper;

import com.orion.trainee.dto.PedidoDto;
import com.orion.trainee.model.Item;
import com.orion.trainee.model.Pedido;
import com.orion.trainee.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-11T18:23:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public Pedido toEntity(PedidoDto pedidoDto) {
        if ( pedidoDto == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        pedido.setId( pedidoDto.getId() );
        pedido.setValor( pedidoDto.getValor() );
        List<Item> list = pedidoDto.getPedidoItem();
        if ( list != null ) {
            pedido.setPedidoItem( new ArrayList<Item>( list ) );
        }

        return pedido;
    }

    @Override
    public PedidoDto toDto(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        PedidoDto pedidoDto = new PedidoDto();

        pedidoDto.setIdUser( pedidoUserId( pedido ) );
        pedidoDto.setId( pedido.getId() );
        pedidoDto.setValor( pedido.getValor() );
        List<Item> list = pedido.getPedidoItem();
        if ( list != null ) {
            pedidoDto.setPedidoItem( new ArrayList<Item>( list ) );
        }

        return pedidoDto;
    }

    @Override
    public List<PedidoDto> toDtos(List<Pedido> pedidos) {
        if ( pedidos == null ) {
            return null;
        }

        List<PedidoDto> list = new ArrayList<PedidoDto>( pedidos.size() );
        for ( Pedido pedido : pedidos ) {
            list.add( toDto( pedido ) );
        }

        return list;
    }

    private Long pedidoUserId(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }
        User user = pedido.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
