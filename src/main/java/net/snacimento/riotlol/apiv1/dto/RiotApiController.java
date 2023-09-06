package net.snacimento.riotlol.apiv1.dto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.snacimento.riotlol.business.services.RiotApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invocadores")
@RequiredArgsConstructor
@Tag(name = "RiotApi")
public class RiotApiController {
    private final RiotApiService service;

  @Operation(summary = "Busca invocador na API e Salva", method = "POST")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Busca Realizada com Sucesso."),
        @ApiResponse(responseCode = "500", description = "Erro ao Realizar Busca dos Dados.")
      })
  @GetMapping()
  public ResponseEntity<SummonerDTO> salvaInvocadorApi(
      @RequestParam("nomeInvocador") String nomeInvocador) {
        return ResponseEntity.ok(service.buscaInvocador(nomeInvocador));
    }
}
