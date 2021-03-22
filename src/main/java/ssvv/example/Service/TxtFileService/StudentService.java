package ssvv.example.Service.TxtFileService;

import ssvv.example.Domain.Student;
import ssvv.example.Repository.TxtFileRepository.StudentFileRepo;

public class StudentService extends AbstractService<String, Student> {
    //StudentFileRepo stdRepo;
    public StudentService(StudentFileRepo stdRepo){
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


