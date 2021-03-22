package ssvv.example.Repository.MemoryRepository;


import ssvv.example.Domain.Nota;
import ssvv.example.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer, Nota> {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}