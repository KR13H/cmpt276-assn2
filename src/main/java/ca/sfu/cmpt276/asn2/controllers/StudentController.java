// Source code is decompiled from a .class file using FernFlower decompiler.
package ca.sfu.cmpt276.asn2.controllers;

import ca.sfu.cmpt276.asn2.models.Student;
import ca.sfu.cmpt276.asn2.repository.StudentRepo;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
   @Autowired
   private StudentRepo studentRepo;

   public StudentController() {
   }

   @GetMapping({"/error"})
   public String errorPage(Model model) {
      return "error";
   }

   @GetMapping({"/students/menu"})
   public String getMenuStudent(Model model) {
      try {
         System.out.println("Getting all students");
         List<Student> students = this.studentRepo.findAll();
         model.addAttribute("stu", students);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return "students/menu";
   }

   @GetMapping({"/students/view"})
   public String getAllStudents(Model model) {
      try {
         System.out.println("Getting all students");
         List<Student> students = this.studentRepo.findAll();
         model.addAttribute("stu", students);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return "students/showAll";
   }

   @GetMapping({"/students/add"})
   public String gotoAddStudent() {
      return "students/add";
   }

   @PostMapping({"/students/add"})
   public String addStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response) {
      try {
         System.out.println("ADD user");
         String newName = (String)newStudent.get("name");
         String newWeight = (String)newStudent.get("weight");
         String newHeight = (String)newStudent.get("height");
         String newHairColor = (String)newStudent.get("hairColor");
         String newGpa = (String)newStudent.get("gpa");
         this.studentRepo.save(new Student(newName, Double.parseDouble(newWeight), Double.parseDouble(newHeight), newHairColor, Double.parseDouble(newGpa)));
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return "redirect:/students/view";
   }

   @PostMapping({"/students/delete/{uid}"})
   public String deleteStudent(@PathVariable("uid") int uid, HttpServletResponse response) {
      System.out.println("DELETE user uid:");
      System.out.println(uid);

      try {
         Optional<Student> userRecord = this.studentRepo.findById(uid);
         if (userRecord.isPresent()) {
            System.out.println("[DELETE]Success");
            this.studentRepo.deleteById(uid);
            response.setStatus(205);
         } else {
            System.out.println("[DELETE]Record not found");
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return "redirect:/students/view";
   }

   @GetMapping({"/students/edit/{uid}"})
   public String gotoEditStudent(@PathVariable("uid") int uid, Model model, HttpServletResponse response) {
      try {
         Student student = (Student)this.studentRepo.findById(uid).orElseThrow(() -> {
            return new Exception("null");
         });
         model.addAttribute("stu", student);
         model.addAttribute("stuId", uid);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return "students/edit";
   }

   @PostMapping({"/students/edit/{uid}"})
   public String editStudent(@PathVariable("uid") int uid, @RequestParam Map<String, String> newStudent, HttpServletResponse response) {
      try {
         System.out.println("EDIT student uid:");
         System.out.println(uid);
         String newName = (String)newStudent.get("newName");
         double newWeight = Double.parseDouble((String)newStudent.get("newWeight"));
         double newHeight = Double.parseDouble((String)newStudent.get("newHeight"));
         String newHairColor = (String)newStudent.get("newHairColor");
         double newGpa = Double.parseDouble((String)newStudent.get("newGpa"));
         Student student = (Student)this.studentRepo.findById(uid).orElseThrow(() -> {
            return new Exception("null");
         });
         student.setName(newName);
         student.setWeight(newWeight);
         student.setHeight(newHeight);
         student.setHairColor(newHairColor);
         student.setGpa(newGpa);
         this.studentRepo.save(student);
      } catch (Exception var13) {
         var13.printStackTrace();
      }

      return "redirect:/students/view";
   }
}
