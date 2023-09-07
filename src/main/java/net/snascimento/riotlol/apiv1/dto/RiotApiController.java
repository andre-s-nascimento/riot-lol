package net.snascimento.riotlol.apiv1.dto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.snascimento.riotlol.business.services.RiotApiService;
import net.snascimento.riotlol.business.services.SummonerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invocadores")
@RequiredArgsConstructor
@Tag(name = "RiotApi")
public class RiotApiController {
    private final RiotApiService service;
    private final SummonerService summonerService;

  @Operation(summary = "Busca invocador na API e Salva", method = "POST")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Busca Realizada com Sucesso."),
        @ApiResponse(responseCode = "500", description = "Erro ao Realizar Busca dos Dados.")
      })
  @PostMapping("/api")
  public ResponseEntity<List<SummonerDTO>> salvaInvocadorApi(
      @RequestParam("nomeInvocador") String nomeInvocador) {
        return ResponseEntity.ok(service.buscaInvocadores(nomeInvocador));
    }

    @Operation(summary = "Salva novos invocadores", method = "POST")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Invocador salvo com Sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro ao salvar invocadores.")
            })
    @PostMapping("/")
    public ResponseEntity<SummonerDTO> salvaInvocador(@RequestBody SummonerDTO summonerDTO) {

        return ResponseEntity.ok(summonerService.salvaInvocadorDTO(summonerDTO));
    }

    @Operation(summary = "Atualiza invocador", method = "PUT")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Invocador atualizado com Sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro ao atualizar o invocador.")
            })
    @PutMapping("/")
    public ResponseEntity<SummonerDTO> atualizaInvocador(
            @RequestParam("id") String id, @RequestBody SummonerDTO summonerDTO) {

        return ResponseEntity.ok(summonerService.atualizaInvocador(id, summonerDTO));
    }

    @Operation(summary = "Exclui invocador pelo nome", method = "DELETE")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "202", description = "Invocador excluído com Sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro ao excluir o invocador.")
            })
    @DeleteMapping("/")
    public ResponseEntity<Void> deletaInvocador(@RequestParam("invocador") String invocador) {
        summonerService.deletaInvocador(invocador);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os invocadores", method = "GET")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Invocadores listados com Sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro ao listar todos os invocadores.")
            })
    @GetMapping("/")
    public ResponseEntity<List<SummonerDTO>> buscaTodosInvocadores() {

        return ResponseEntity.ok(summonerService.buscaTodosInvocadores());
    }

    @Operation(summary = "Busca invocador por nome", method = "GET")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Produto encontrado com Sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro ao buscar o produto.")
            })
    @GetMapping("/{nome}")
    public ResponseEntity<SummonerDTO> buscaInvocadorPorNome(@PathVariable("invocador") String invocador) {

        return ResponseEntity.ok(summonerService.buscaInvocadorPorNome(invocador));
    }
}
