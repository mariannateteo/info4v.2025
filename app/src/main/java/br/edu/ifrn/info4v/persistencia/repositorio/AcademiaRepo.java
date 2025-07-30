package br.edu.ifrn.info4v.persistencia.repositorio;

import br.edu.ifrn.info4v.persistencia.modelo.Academia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AcademiaRepo extends JpaRepository<Academia, Integer> {
    Optional<Academia> findByCnpj(String cnpj);
}