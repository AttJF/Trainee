package com.orion.trainee.mapper;

import com.orion.trainee.dto.ItemDto;
import com.orion.trainee.model.Item;
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
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toEntity(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( itemDto.getId() );
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setValor( itemDto.getValor() );

        return item;
    }

    @Override
    public ItemDto toDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setId( item.getId() );
        itemDto.setValor( item.getValor() );
        itemDto.setName( item.getName() );
        itemDto.setDescription( item.getDescription() );

        return itemDto;
    }

    @Override
    public List<ItemDto> toDtos(List<Item> itens) {
        if ( itens == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( itens.size() );
        for ( Item item : itens ) {
            list.add( toDto( item ) );
        }

        return list;
    }
}
