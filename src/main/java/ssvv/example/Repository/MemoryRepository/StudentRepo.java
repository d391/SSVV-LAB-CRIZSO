package ssvv.example.Repository.MemoryRepository;


import ssvv.example.Domain.Student;
import ssvv.example.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}