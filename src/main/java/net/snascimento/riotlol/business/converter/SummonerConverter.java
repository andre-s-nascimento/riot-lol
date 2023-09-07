package net.snascimento.riotlol.business.converter;

import net.snascimento.riotlol.apiv1.dto.SummonerDTO;
import net.snascimento.riotlol.infrastructure.entities.SummonerEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SummonerConverter {
  public SummonerEntity toEntity(SummonerDTO summonerDTO) {
    return SummonerEntity.builder()
        .riotId(summonerDTO.getId())
        .accountId(summonerDTO.getAccountId())
        .puuid(summonerDTO.getPuuid())
        .summonerName(summonerDTO.getName())
        .profileIconId(summonerDTO.getProfileIconId())
        .revisionDate(summonerDTO.getRevisionDate())
        .summonerLevel(summonerDTO.getSummonerLevel())
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .build();
  }

  public SummonerDTO toDTO(SummonerEntity summonerEntity) {
    return SummonerDTO.builder()
        .id(summonerEntity.getRiotId())
        .accountId(summonerEntity.getAccountId())
        .puuid(summonerEntity.getPuuid())
        .name(summonerEntity.getSummonerName())
        .profileIconId(summonerEntity.getProfileIconId())
        .revisionDate(summonerEntity.getRevisionDate())
        .summonerLevel(summonerEntity.getSummonerLevel())
        .build();
  }

  public SummonerEntity toEntityUpdate(
      SummonerEntity summonerEntity, SummonerDTO summonerDTO, String riotId) {
    return SummonerEntity.builder()
        .riotId(summonerEntity.getRiotId())
        .accountId(summonerEntity.getAccountId())
        .puuid(summonerEntity.getPuuid())
        .summonerName(
            summonerDTO.getName() != null
                ? summonerDTO.getName()
                : summonerEntity.getSummonerName())
        .profileIconId(
            summonerDTO.getProfileIconId() != 0L
                ? summonerDTO.getProfileIconId()
                : summonerEntity.getProfileIconId())
        .revisionDate(
            summonerDTO.getRevisionDate() != 0L
                ? summonerDTO.getRevisionDate()
                : summonerEntity.getRevisionDate())
        .summonerLevel(
            summonerDTO.getSummonerLevel() != 0L
                ? summonerDTO.getSummonerLevel()
                : summonerEntity.getSummonerLevel())
        .createdDate(summonerEntity.getCreatedDate())
        .updatedDate(LocalDateTime.now())
        .build();
  }

  public List<SummonerDTO> toListDTO(List<SummonerEntity> summonerEntityList){
    return summonerEntityList.stream().map(this::toDTO).toList();
  }
}
