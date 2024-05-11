package com.orion.trainee.repository;

import com.orion.trainee.model.Pedido;
import com.orion.trainee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<List<Pedido>> findPedidoByUser(User user);

}
