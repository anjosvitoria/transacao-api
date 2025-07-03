package anjos.dev.transacao_api.business.sevices;

import anjos.dev.transacao_api.controller.dtos.TransacapRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final List<TransacapRequestDTO> listaTrasacoes = new ArrayList<>();

    
}
