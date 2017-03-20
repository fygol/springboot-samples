package io.samples.data.jpa.repository;

import io.samples.data.jpa.domain.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildEntityRepository extends JpaRepository<ChildEntity, Long> {
}
