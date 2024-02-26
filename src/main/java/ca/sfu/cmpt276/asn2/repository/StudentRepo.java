// Source code is decompiled from a .class file using FernFlower decompiler.
package ca.sfu.cmpt276.asn2.repository;

import ca.sfu.cmpt276.asn2.models.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
   List<Student> findByUid(int uid);
}
