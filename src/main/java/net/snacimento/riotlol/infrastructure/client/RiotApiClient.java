package net.snacimento.riotlol.infrastructure.client;

import net.snacimento.riotlol.apiv1.dto.SummonerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "riot-api", url = "${riot-api.url:#{null}}")
public interface RiotApiClient {

  @GetMapping("/summoners/by-name/{summonername}?api_key=" + "${riot-api.key:#{null}}")
  SummonerDTO buscaInvocadorPeloNome(@PathVariable("summonername") String nomeInvocador);
}
