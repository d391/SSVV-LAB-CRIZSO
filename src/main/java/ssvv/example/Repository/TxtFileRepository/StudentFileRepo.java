package ssvv.example.Repository.TxtFileRepository;

import ssvv.example.Domain.HasId;
import ssvv.example.Domain.Student;
import ssvv.example.Validator.StudentValidator;

import java.io.IOException;

public class StudentFileRepo extends AbstractFileRepository {
    public StudentFileRepo(String filename, StudentValidator val) throws IOException {
        super(val, filename);
    }


    @Override
    public HasId extractEntity(String[] info) {
        String id = info[0];
        String nume = info[1];
        int grup = Integer.parseInt(info[2]);
        String email = info[3];
        String indrumator = info[4];
        Student s = new Student(id, nume, grup, email, indrumator);
        return s;

    }
}