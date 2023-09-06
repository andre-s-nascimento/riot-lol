package net.snacimento.riotlol.business.services;

import lombok.RequiredArgsConstructor;
import net.snacimento.riotlol.apiv1.dto.SummonerDTO;
import net.snacimento.riotlol.infrastructure.client.RiotApiClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiotApiService {
    private final RiotApiClient cliente;

    public SummonerDTO buscaInvocador(String nomeInvocador){
        return cliente.buscaInvocadorPeloNome(nomeInvocador);
    }
}
