package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.SoftwareUpgrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareUpgradeRepository extends JpaRepository<SoftwareUpgrade, Integer> {
}
