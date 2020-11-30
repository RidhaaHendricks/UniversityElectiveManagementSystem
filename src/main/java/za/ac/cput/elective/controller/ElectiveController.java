package za.ac.cput.elective.controller;
/**
 *  @author: Shane Mapasie
 *  Desc: Spring Boot controller for Elective to access the ElectiveService method 'CRUD'
 *  Date: 22st September 2020
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.factory.ElectiveFactory;
import za.ac.cput.elective.service.impl.ElectiveServiceImpl;
import java.util.*;


@RestController
@RequestMapping("/elective")
public class ElectiveController {


    @Autowired
    private ElectiveServiceImpl electiveService;

    @PostMapping("/create")
    public Elective create(@RequestBody Elective elective){

       Elective elect = ElectiveFactory.createElective(
                elective.getElectCode(),
                elective.getElectName());


        return electiveService.create(elect);

    }

    @GetMapping("/read/{electCode}")
    public Elective read(@PathVariable String electCode){ //fix from here
        return electiveService.read(electCode);
    }


    @GetMapping("/update")
    public Elective update (@RequestBody Elective elective){
        return  electiveService.update(elective);
    }

    @GetMapping("/all")
    public Set<Elective> getAll() {
        return electiveService.getAll();
    }

    @DeleteMapping("/delete/{electCode}")
    public boolean delete(@PathVariable String electCode){
        return electiveService.delete(electCode);
    }

}