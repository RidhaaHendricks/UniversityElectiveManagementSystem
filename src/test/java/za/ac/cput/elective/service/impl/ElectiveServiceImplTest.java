package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.factory.ElectiveFactory;
import za.ac.cput.elective.service.ElectiveService;

/**
 * @author @ShanePhumlaniMapasie
 * Desc: Test for ElectiveServiceImpl
 * Date: 06/09/2020
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElectiveServiceImplTest {

    @Autowired
    private static ElectiveService eService;
    private static Elective elect = ElectiveFactory.createElective("000110", "JavaScript");

    @Test
    public void a_create() {
        Elective e = eService.create(elect);
        Assert.assertEquals(e.getElectCode(), elect.getElectCode());
        System.out.println(e);
    }


    @Test
    public void b_read() {

        Elective elec = eService.create(elect);
        eService.read(elec.getElectCode());
        System.out.println(elec);
    }

    @Test
    public void c_update() {
        Elective e = new Elective.Builder()
                .copy(elect)
                .setElectCode("000111")
                .build();
        e = eService.update(e);
        System.out.println(e);
    }

    @Test
    public void e_delete() {
        boolean erased = eService.delete(elect.getElectCode());
        Assert.assertTrue(erased);
        if (erased = true ){
            System.out.println("Elective successfully deleted");
        } else {
            System.out.println("Elective deletion not successful");
        }
    }

}