package anjos.dev.transacao_api.business.sevices;

import anjos.dev.transacao_api.controller.dtos.TransacaoRequestDTO;
import anjos.dev.transacao_api.infractructure.exceptions.unprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTrasacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto){

        log.info("iniciada o processamento de gravar transaçoes" + dto);

        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("data e hora maiores que a data atual");
            throw new unprocessableEntity("data e hora maiores que a data e hora atuais");
        }
        if(dto.valor() < 0){
            log.error("valor n pode ser menor q 0");
            throw new unprocessableEntity ("valor n pode ser menor q 0");
        }

        listaTrasacoes.add(dto);// armazenando transação em menoria no array list
        log.info("finalizada o processamento de gravar transaçoes");

    }
    public void limparTransacoes(){
        log.info("iniciada o processamento de limpar transacoes");
        listaTrasacoes.clear();
        log.info("finalizada o processamento de limpar transacoes");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca){
        log.info("iniciada o processamento de buscar transacoes pelo periodo de tempo: {}", intervaloBusca);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        log.info("finalizada o processamento de buscar transacoes pelo periodo de tempo: {}", intervaloBusca);
        return  listaTrasacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();
    }
}
