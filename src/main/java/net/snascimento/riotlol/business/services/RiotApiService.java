package net.snascimento.riotlol.business.services;

import lombok.RequiredArgsConstructor;
import net.snascimento.riotlol.apiv1.dto.SummonerDTO;
import net.snascimento.riotlol.business.converter.SummonerConverter;
import net.snascimento.riotlol.infrastructure.client.RiotApiClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiotApiService {
  private final RiotApiClient riotApiClient;
  private final SummonerConverter summonerConverter;
  private final SummonerService summonerService;

  public List<SummonerDTO> buscaInvocadores(String nomeInvocador) {

    try {

      SummonerDTO summonerDTO = riotApiClient.buscaInvocadorPeloNome(nomeInvocador);
      if (summonerService.existsByNomeInvocador(summonerDTO.getName()).equals(false))
        summonerService.salvaInvocador(summonerConverter.toEntity(summonerDTO));
      return summonerService.buscaTodosInvocadores().stream().toList();
    } catch (Exception e) {
      throw new RuntimeException("Erro ao buscar e gravar invocadores no banco de dados");
    }
  }
}
