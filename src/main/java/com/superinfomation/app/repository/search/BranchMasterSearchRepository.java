package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.BranchMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link BranchMaster} entity.
 */
public interface BranchMasterSearchRepository extends ElasticsearchRepository<BranchMaster, Long> {
}
