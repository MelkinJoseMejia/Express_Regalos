package com.claro.WSCRUDSerAsesoresComercialServicio.interfase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.claro.WSCRUDSerAsesoresComercialServicio.dto.SerAsesoresComercial;

@Component
public interface SerAsesoresComercialJpaRepository extends JpaRepository<SerAsesoresComercial, Long> , CrudRepository<SerAsesoresComercial, Long>{
	
}
