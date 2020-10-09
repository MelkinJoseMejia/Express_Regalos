package com.claro.WSCRUDSerUsuariosXCampanaServicio.interfase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.claro.WSCRUDSerUsuariosXCampanaServicio.dto.SerUsuariosXCampana;

@Component
public interface SerUsuariosXCampanaJpaRepository extends JpaRepository<SerUsuariosXCampana, Long> , CrudRepository<SerUsuariosXCampana, Long>{
	
}
