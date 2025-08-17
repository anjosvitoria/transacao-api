package anjos.dev.transacao_api.controller;

import anjos.dev.transacao_api.business.sevices.TransacaoService;
import anjos.dev.transacao_api.controller.dtos.TransacaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;

    @PostMapping
    @Operation(description = "endpoint para adicionar transacoes", responses = {
            @ApiResponse(responseCode = "201", description = "transacao criada com sucesso"),
            @ApiResponse(responseCode = "422", description = "data e hora maiores que a data e hora atuais"),
            @ApiResponse(responseCode = "400", description = "erro de requisição"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")})
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {

        transacaoService.adicionarTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(description = "endpoint para deletar transacoes", responses = {
            @ApiResponse(responseCode = "201", description = "transacao deletadas com sucesso"),
            @ApiResponse(responseCode = "422", description = "data e hora maiores que a data e hora atuais"),
            @ApiResponse(responseCode = "400", description = "erro de requisição"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")})
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }
}
