package net.snascimento.riotlol.infrastructure.repositories;

import net.snascimento.riotlol.infrastructure.entities.SummonerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerRepository extends MongoRepository<SummonerEntity, String> {
    SummonerEntity findBySummonerName(String summonerName);

    void deleteBySummonerName(String summonerName);

    Boolean existsBySummonerName(String summonerName);
}
