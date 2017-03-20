package io.samples.data.jpa;

import io.samples.data.jpa.domain.BudgetSegment;
import io.samples.data.jpa.domain.Campaign;
import io.samples.data.jpa.repository.CampaignRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CampaignTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    private CampaignRepository repository;

    @Test
    public void testSave() throws Exception {
        Campaign campaign = new Campaign();
        campaign.setName("test campaign");

        BudgetSegment segment = new BudgetSegment();
        segment.setCampaign(campaign);
        segment.setStartDate(LocalDateTime.now());
        segment.setEndDate(LocalDateTime.now());
        segment.setBudgetCap(new BigDecimal(1000));
        campaign.setBudgetSegments(Arrays.asList(segment));

        Long id = em.persistAndFlush(campaign).getId();
        em.clear();

        Campaign c = repository.findOne(id);
        System.out.println(c);
    }
}
