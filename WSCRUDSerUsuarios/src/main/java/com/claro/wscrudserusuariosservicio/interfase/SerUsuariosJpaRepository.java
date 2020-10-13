package com.claro.wscrudserusuariosservicio.interfase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.claro.wscrudserusuariosservicio.dto.SerUsuarios;

@Component
public interface SerUsuariosJpaRepository extends JpaRepository<SerUsuarios, Long> , CrudRepository<SerUsuarios, Long>{
	
}
