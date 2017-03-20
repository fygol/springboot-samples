package io.samples.data.jpa.repository;

import io.samples.data.jpa.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
