package za.ac.cput.elective.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.entity.Student;

import static org.junit.Assert.*;

public class ElectiveFactoryTest {

    @Test
    public void createElective() {
        ElectiveFactory ef = new ElectiveFactory();

        Elective e = ef.createElective("000155", "BNA");
        Assert.assertEquals(java.util.Optional.of(000155), e.getElectCode());
        Assert.assertEquals("BNA", e.getElectName());
    }

}