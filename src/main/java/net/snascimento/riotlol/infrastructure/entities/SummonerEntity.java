package net.snascimento.riotlol.infrastructure.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("riot_summoner")
public class SummonerEntity {

  @Id private String riotId;

  private String accountId;
  private String puuid;
  private String summonerName;
  private int profileIconId;
  private Long revisionDate;
  private Long summonerLevel;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
}
