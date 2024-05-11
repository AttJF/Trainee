package com.orion.trainee.controller;

import com.orion.trainee.dto.PedidoDto;
import com.orion.trainee.model.Pedido;
import com.orion.trainee.model.User;
import com.orion.trainee.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDto> savePedido(@RequestBody PedidoDto pedidoDto) {
        return new ResponseEntity<>(pedidoService.savePedido(pedidoDto), HttpStatus.CREATED);
    }
    @GetMapping("/findAllPedidoByUser/{id}")
    public ResponseEntity<List<PedidoDto>> findAllPedidoByUser(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findAllPedidoByUser(id));
    }
    @PostMapping("/adicionarItem/{idUser}/{idPedido}/{idItem}")
    public ResponseEntity<PedidoDto> adicionarItem(@PathVariable Long idUser, @PathVariable Long idPedido, @PathVariable Long idItem){
        return ResponseEntity.ok(pedidoService.adicionarItem(idUser, idPedido, idItem));

    }
    @PostMapping("/removerItem/{idUser}/{idPedido}/{idItem}")
    public ResponseEntity<PedidoDto> removerItem(@PathVariable Long idUser, @PathVariable Long idPedido, @PathVariable Long idItem){
        return ResponseEntity.ok(pedidoService.removerItem(idUser, idPedido, idItem));

    }
}
