package com.fabio.industria.Repository;

import com.fabio.industria.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    void deleteByNome(String nome);

    @Query(value = "SELECT * FROM funcionario  WHERE MONTH(data_nascimento) IN (:meses)", nativeQuery = true)
    List<Funcionario> findByMesNascimento(@Param("meses") List<Integer> meses);

    Funcionario findByNome(String nome);
}
