package ssvv.example;

import org.junit.Test;
import ssvv.example.Exceptions.ValidatorException;
import ssvv.example.Repository.XMLFileRepository.StudentXMLRepo;
import ssvv.example.Repository.XMLFileRepository.TemaLabXMLRepo;
import ssvv.example.Service.XMLFileService.StudentXMLService;
import ssvv.example.Service.XMLFileService.TemaLabXMLService;
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
    public void tc_validHomework() {
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
    public void tc_invalidHomework() {
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
}
