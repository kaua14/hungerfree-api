package br.com.hungerfree.hungerfreeapi.Repository;

import br.com.hungerfree.hungerfreeapi.Model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador,Long> {

}
