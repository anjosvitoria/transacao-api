package anjos.dev.transacao_api.controller;

import anjos.dev.transacao_api.business.sevices.TransacaoService;
import anjos.dev.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService TransacaoService;

    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {

        TransacaoService.adicionarTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    
}
