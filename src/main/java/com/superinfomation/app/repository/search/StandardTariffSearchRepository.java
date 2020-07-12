package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.StandardTariff;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link StandardTariff} entity.
 */
public interface StandardTariffSearchRepository extends ElasticsearchRepository<StandardTariff, Long> {
}
