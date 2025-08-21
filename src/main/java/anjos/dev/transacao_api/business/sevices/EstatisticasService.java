package anjos.dev.transacao_api.business.sevices;


import anjos.dev.transacao_api.controller.dtos.EstatisticasResponseDTO;
import anjos.dev.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){

        log.info("iniciada o processamento de estatisticas de transacoes pelo periodo de tempo: {}", intervaloBusca);

        long start = System.currentTimeMillis();

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        if(transacoes.isEmpty()){// se nao houver transacoes, retorna um erro
            return new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Tempo de execução: " + duration + " ms");

        log.info("finalizada o processamento de estatisticas de transacoes");

        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMax(),
                estatisticasTransacoes.getMin());
    }
}
