package Transformers.Discools.repository;

import Transformers.Discools.model.DiscosCD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscoRepository extends JpaRepository<DiscosCD, Integer> {
}
