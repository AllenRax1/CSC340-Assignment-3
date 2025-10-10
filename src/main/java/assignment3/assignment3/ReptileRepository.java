package assignment3.assignment3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReptileRepository extends JpaRepository<Reptile, Long> {
    
//ALL I NEED HERE IS NAME, SPECIES, AND AGE.

List<Reptile>getReptilesBySpecies(String species);

@Query(value = "Select * from reptiles r where r.age = ?1", nativeQuery = true)
List<Reptile>getReptilesByAge(Double age);

@Query(value = "Select * from reptiles r where r.name like %?1%", nativeQuery = true)
List<Reptile>getReptilesByName(String name);

}
