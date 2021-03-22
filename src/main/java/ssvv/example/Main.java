package ssvv.example;
import ssvv.example.Exceptions.ValidatorException;
import ssvv.example.Repository.XMLFileRepository.NotaXMLRepo;
import ssvv.example.Repository.XMLFileRepository.StudentXMLRepo;
import ssvv.example.Repository.XMLFileRepository.TemaLabXMLRepo;
import ssvv.example.Service.XMLFileService.NotaXMLService;
import ssvv.example.Service.XMLFileService.StudentXMLService;
import ssvv.example.Service.XMLFileService.TemaLabXMLService;
import ssvv.example.UI.ui;
import ssvv.example.Validator.NotaValidator;
import ssvv.example.Validator.StudentValidator;
import ssvv.example.Validator.TemaLabValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}