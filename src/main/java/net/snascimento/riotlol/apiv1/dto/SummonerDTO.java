package net.snascimento.riotlol.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SummonerDTO {
  @JsonProperty(value = "id")
  private String id;

  @JsonProperty(value = "accountId")
  private String accountId;

  @JsonProperty(value = "puuid")
  private String puuid;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "profileIconId")
  private int profileIconId;

  @JsonProperty(value = "revisionDate")
  private Long revisionDate;

  @JsonProperty(value = "summonerLevel")
  private Long summonerLevel;
}
