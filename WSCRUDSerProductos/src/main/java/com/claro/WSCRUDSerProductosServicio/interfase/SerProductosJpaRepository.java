package com.claro.WSCRUDSerProductosServicio.interfase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.claro.WSCRUDSerProductosServicio.dto.SerProductos;

@Component
public interface SerProductosJpaRepository extends JpaRepository<SerProductos, Long> , CrudRepository<SerProductos, Long>{
	
}
