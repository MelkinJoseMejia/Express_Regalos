package com.claro.WSCRUDSerSegmentosServicio.interfase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.claro.WSCRUDSerSegmentosServicio.dto.SerSegmento;

@Component
public interface SerSegmentosJpaRepository extends JpaRepository<SerSegmento, Long> , CrudRepository<SerSegmento, Long>{
	
}
