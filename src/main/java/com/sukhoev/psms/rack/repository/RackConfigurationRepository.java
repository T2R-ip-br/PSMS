package com.sukhoev.psms.rack.repository;

import com.sukhoev.psms.rack.entity.RackConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackConfigurationRepository extends JpaRepository<RackConfiguration, Long> {
}
