package com.orion.trainee.service;

import com.orion.trainee.dto.PedidoDto;
import com.orion.trainee.exception.ResourceNotFoundException;
import com.orion.trainee.mapper.PedidoMapper;
import com.orion.trainee.mapper.UserMapper;
import com.orion.trainee.model.Item;
import com.orion.trainee.model.Pedido;
import com.orion.trainee.model.User;
import com.orion.trainee.repository.ItemRepository;
import com.orion.trainee.repository.PedidoRepository;
import com.orion.trainee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemRepository itemRepository;
    private final PedidoMapper pedidoMapper;
    private final UserRepository userRepository;
    @Transactional
    public PedidoDto savePedido(PedidoDto pedidoDto) {
        Pedido entity = PedidoMapper.INSTANCE.toEntity(pedidoDto);
        Optional<User> user = userRepository.findById(pedidoDto.getIdUser());
        if(user.isEmpty()){
            throw new ResourceNotFoundException("ID invalido");
        }
        entity.setUser(user.get());
        return PedidoMapper.INSTANCE.toDto(pedidoRepository.save(entity));
    }

    public List<PedidoDto> findAllPedidoByUser(Long id) {
        Optional<User> user = userRepository.findById(id); /*Usando o optional(que é basicamente
         poder vir o que eu quero ou n) eu uso o metodo ja feito pelo JPA e passo o id de parametro
          para buscar o user com o ID que foi passado como parametro pathVariable*/
        if(user.isEmpty()){
            throw new ResourceNotFoundException("ID invalido");
        }/*testo se veio alguma coisa*/
        Optional<List<Pedido>> pedidos = pedidoRepository.findPedidoByUser(user.get());
        /*faz a mesma coisa so que dessa vez usando o .get()(pq o user é uma Optional e ai transforma
        o optional para user) para conseguir a lista de pedido usando o id*/
        if(pedidos.isEmpty())
        {
            throw new ResourceNotFoundException("Lista de pedidos nao encontrada");
        }
        return PedidoMapper.INSTANCE.toDtos(pedidos.get());
    }

    public PedidoDto adicionarItem(Long idUser,Long idPedido, Long idItem) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new ResourceNotFoundException("Pedido not found"));
        if(pedido.getUser().getId().equals(idUser)){
        Item item = itemRepository.findById(idItem).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        pedido.getPedidoItem().add(item);
            pedido.setValor(pedido.getValor()+ item.getValor());
        }
        else{
            new ResourceNotFoundException("Pedido nao encontrado");
        }
        return PedidoMapper.INSTANCE.toDto(pedidoRepository.save(pedido));
    }

    public PedidoDto removerItem(Long idUser ,Long idPedido, Long idItem) {
        List<PedidoDto> pedidos = findAllPedidoByUser(idUser);
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new ResourceNotFoundException("Pedido not found"));
        if(pedido.getUser().getId().equals(idUser)){
        Item item = itemRepository.findById(idItem).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        pedido.getPedidoItem().remove(item);
        pedido.setValor(pedido.getValor() - item.getValor());}
        else {
            new ResourceNotFoundException("Pedido nao encontrado");
        }
        return PedidoMapper.INSTANCE.toDto(pedidoRepository.save(pedido));
    }
}
