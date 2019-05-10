package com.bridgelab.microfundoo.user.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bridgelab.microfundoo.user.model.MicroUserModel;
@Repository
public  interface MicroUserRepo extends JpaRepository<MicroUserModel, Long>{	
	Optional<MicroUserModel> findByEmail(String email);
	@Override
	Optional<MicroUserModel> findById(Long id);		
}

