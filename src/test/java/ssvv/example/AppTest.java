package ssvv.example;

import org.junit.Test;
import ssvv.example.Exceptions.ValidatorException;
import ssvv.example.Repository.XMLFileRepository.StudentXMLRepo;
import ssvv.example.Service.XMLFileService.StudentXMLService;
import ssvv.example.Validator.StudentValidator;

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
}
