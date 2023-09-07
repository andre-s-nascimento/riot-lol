package net.snascimento.riotlol.business.services;

import lombok.RequiredArgsConstructor;
import net.snascimento.riotlol.apiv1.dto.SummonerDTO;
import net.snascimento.riotlol.business.converter.SummonerConverter;
import net.snascimento.riotlol.infrastructure.entities.SummonerEntity;
import net.snascimento.riotlol.infrastructure.repositories.SummonerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class SummonerService {
  private final SummonerRepository summonerRepository;
  private final SummonerConverter summonerConverter;

  public SummonerEntity salvaInvocador(SummonerEntity summoner) {
    try {
      return summonerRepository.save(summoner);
    } catch (Exception e) {
      throw new RuntimeException("Erro ao Salvar Invocador " + e);
    }
  }

  public SummonerDTO salvaInvocadorDTO(SummonerDTO summonerDTO) {
    try {
      SummonerEntity summonerEntity = summonerConverter.toEntity(summonerDTO);
      return summonerConverter.toDTO(summonerRepository.save(summonerEntity));
    } catch (Exception e) {
      throw new RuntimeException(
          format("Erro ao Salvar Invocador: %s ", summonerDTO.getName()) + e);
    }
  }

  public List<SummonerDTO> buscaTodosInvocadores() {
    try {
      return summonerConverter.toListDTO(summonerRepository.findAll());
    } catch (Exception e) {
      throw new RuntimeException("Erro ao buscar todos os invocadores " + e);
    }
  }

  public SummonerDTO buscaInvocadorPorNome(String invocador) {
    try {
      return summonerConverter.toDTO(summonerRepository.findBySummonerName(invocador));
    } catch (Exception e) {
      throw new RuntimeException(format("Erro ao buscar o invocador: %s ", invocador) + e);
    }
  }

  public void deletaInvocador(String invocador) {
    try {
      summonerRepository.deleteBySummonerName(invocador);
    } catch (Exception e) {
      throw new RuntimeException(format("Erro ao deletar invocador por nome: %s ", invocador), e);
    }
  }

  public Boolean existsByNomeInvocador(String invocador) {
    try {
      return summonerRepository.existsBySummonerName(invocador);
    } catch (Exception e) {
      throw new RuntimeException(format("Erro ao buscar invocador pelo nome: %s ", invocador), e);
    }
  }

  public SummonerDTO atualizaInvocador(String id, SummonerDTO summonerDTO) {
    try {
      SummonerEntity summonerEntity =
          summonerRepository
              .findById(id)
              .orElseThrow(() -> new RuntimeException("Id não existe no banco de dados."));
      salvaInvocador(summonerConverter.toEntityUpdate(summonerEntity, summonerDTO, id));
      return summonerConverter.toDTO(
          summonerRepository.findBySummonerName(summonerEntity.getSummonerName()));
    } catch (Exception e) {
      throw new RuntimeException(
          format("Erro ao atualizar invocador: %s ", summonerDTO.getName()), e);
    }
  }
}
