package ssvv.example;

import org.junit.Test;
import ssvv.example.Exceptions.ValidatorException;
import ssvv.example.Repository.XMLFileRepository.NotaXMLRepo;
import ssvv.example.Repository.XMLFileRepository.StudentXMLRepo;
import ssvv.example.Repository.XMLFileRepository.TemaLabXMLRepo;
import ssvv.example.Service.XMLFileService.NotaXMLService;
import ssvv.example.Service.XMLFileService.StudentXMLService;
import ssvv.example.Service.XMLFileService.TemaLabXMLService;
import ssvv.example.Validator.NotaValidator;
import ssvv.example.Validator.StudentValidator;
import ssvv.example.Validator.TemaLabValidator;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private StudentXMLRepo repo;
    private StudentValidator validator;
    private StudentXMLService ctrl;

    private TemaLabXMLRepo tema_repo;
    private TemaLabValidator tema_validator;
    private TemaLabXMLService tema_ctrl;


    private NotaXMLRepo nota_repo;
    private NotaValidator nota_validator;
    private NotaXMLService nota_ctrl;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void tc_validStudent()
    {
        validator = new StudentValidator();
        repo = new StudentXMLRepo(validator, "ValidStudentTest.xml");
        ctrl = new StudentXMLService(repo);
        String[] params={"1","nume","536","email","prof"};
        try
        {
            ctrl.add(params);
        }
        catch (ValidatorException ex)
        {
            fail();
            System.out.println(ex.getMessage());
        }
        assertEquals(1, ctrl.getSize());

    }

    @Test
    public void tc_invalidStudent()
    {
        validator = new StudentValidator();
        repo = new StudentXMLRepo(validator, "ValidStudentTest.xml");
        ctrl = new StudentXMLService(repo);
        String[] params={"","","536","email","prof"};
        try
        {
            ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void tc_maxBoundaryGroup() {
        validator = new StudentValidator();
        repo = new StudentXMLRepo(validator, "ValidStudentTest.xml");
        ctrl = new StudentXMLService(repo);
        String[] params={"2","andreea","9999999999999999999999999999999999999999999999999999999999999","email","prof"};
        try
        {
            ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_invalidGroup() {
        validator = new StudentValidator();
        repo = new StudentXMLRepo(validator, "ValidStudentTest.xml");
        ctrl = new StudentXMLService(repo);
        String[] params={"2","noemi","-1","email","prof"};
        try
        {
            ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_maxIntGroup() {
        validator = new StudentValidator();
        repo = new StudentXMLRepo(validator, "ValidStudentTest.xml");
        ctrl = new StudentXMLService(repo);
        String[] params={"3","noemi","2147483647","email","prof"};
        try
        {
            ctrl.add(params);
            assertTrue(true);
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            fail();
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_validHomework() { // path 3
        tema_validator = new TemaLabValidator();
        tema_repo = new TemaLabXMLRepo(tema_validator, "ValidTemaTest.xml");
        tema_ctrl = new TemaLabXMLService(tema_repo);
        String[] params = {"1","abcd","12","7"};
        try {
            tema_ctrl.add(params);
        } catch (ValidatorException ex)
        {
            fail();
            System.out.println(ex.getMessage());
        }
        assertEquals(1, tema_ctrl.getSize());
    }

    @Test
    public void tc_invalidHomework() { // path 4
        tema_validator = new TemaLabValidator();
        tema_repo = new TemaLabXMLRepo(tema_validator, "ValidTemaTest.xml");
        tema_ctrl = new TemaLabXMLService(tema_repo);
        String[] params = {"","abcde","12","8"};
        try
        {
            tema_ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_nullAssignment() {
        tema_validator = new TemaLabValidator();
        tema_repo = new TemaLabXMLRepo(tema_validator, "Path1_Test.xml");
        tema_ctrl = new TemaLabXMLService(tema_repo);
        String[] params = {"","","",""};
        try
        {
            tema_ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_invalidDescription() { // path 4
        tema_validator = new TemaLabValidator();
        tema_repo = new TemaLabXMLRepo(tema_validator, "ValidTemaTest.xml");
        tema_ctrl = new TemaLabXMLService(tema_repo);
        String[] params = {"3","","12","8"};
        try
        {
            tema_ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_invalidDeadline() { // path 4
        tema_validator = new TemaLabValidator();
        tema_repo = new TemaLabXMLRepo(tema_validator, "ValidTemaTest.xml");
        tema_ctrl = new TemaLabXMLService(tema_repo);
        String[] params = {"3","sdf","","8"};
        try
        {
            tema_ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_invalidDeliveryWeek() { // path 4
        tema_validator = new TemaLabValidator();
        tema_repo = new TemaLabXMLRepo(tema_validator, "ValidTemaTest.xml");
        tema_ctrl = new TemaLabXMLService(tema_repo);
        String[] params = {"3","sefg","12",""};
        try
        {
            tema_ctrl.add(params);
            fail();
        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            assertTrue(true);
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_validGrade() {
        nota_validator = new NotaValidator();
        nota_repo = new NotaXMLRepo(nota_validator, "ValidNotaTest.xml");
        nota_ctrl = new NotaXMLService(nota_repo);
        String[] params = {"1","3","12","9","2017-01-13T17:09:42.411"};
        try
        {
            nota_ctrl.add(params);
            assertTrue(true);

        }
        catch (IllegalArgumentException | ValidatorException ex)
        {
            fail();
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void tc_addStudent() {
        tc_validStudent();
        tc_invalidStudent();
        tc_maxBoundaryGroup();
        tc_invalidGroup();
        tc_maxIntGroup();
        assertTrue(true);
    }

    @Test
    public void tc_addAssignment() {
        tc_validHomework();
        tc_invalidHomework();
        tc_nullAssignment();
        tc_invalidDeadline();
        tc_invalidDescription();
        tc_invalidDeliveryWeek();
        assertTrue(true);
    }

    @Test
    public void tc_addGrade() {
        tc_validGrade();
        assertTrue(true);
    }

    @Test
    public void tc_all() {
        tc_addStudent();
        tc_addAssignment();
        tc_addGrade();
        assertTrue(true);
    }

    @Test
    public void tc_integration1() {
        tc_addStudent();
        assertTrue(true);
    }

    @Test
    public void tc_integration2() {
        tc_addStudent();
        tc_addAssignment();
        assertTrue(true);
    }

    @Test
    public void tc_integration3() {
        tc_addStudent();
        tc_addAssignment();
        tc_addGrade();
        assertTrue(true);
    }

}
