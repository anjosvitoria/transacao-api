package anjos.dev.transacao_api.controller.dtos;

import java.time.OffsetDateTime;

public record TransacapRequestDTO(Double valor, OffsetDateTime dataHora) {

}
