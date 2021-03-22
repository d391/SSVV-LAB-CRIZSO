package ssvv.example.Service.TxtFileService;

import ssvv.example.Domain.Nota;
import ssvv.example.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
