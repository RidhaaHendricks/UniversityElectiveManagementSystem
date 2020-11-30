package za.ac.cput.elective.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @author: Shane  Mapasie, GitHub: SPMapasie216182425
 * Desc: Create Elective.java class with attributes using the Builder pattern
 * Date: 4rd July 2020
 */
@Entity
public class Elective  {

    @Id
    private String electCode;
    private String electName;
   // ArrayList<String> electives = new ArrayList<>();


    /*No argument constructor, protected*/
    protected Elective(){}

    /* constructor */
    public Elective(Builder builder) {
        this.electName = builder.electName;
        this.electCode = builder.electCode;
    }

    //getters
    public String getElectName() {
        return electName;
    }

    public String getElectCode() {
        return electCode;
    }

    //toString Method
    @Override
    public String toString() {
        return "Elective{" +
                "Elective Name=" + electName +
                ", Elective Code=" + electCode + '\'' +
                '}';
    }

    public static class Builder {

        private String electName;
        private String electCode;
        private ArrayList<String> electives = new ArrayList<>();

        /* setters using builder */
        public Builder setElectName(String electName) {
            this.electName = electName;
            return this;
        }

        public Builder setElectCode(String electCode) {
            this.electCode = electCode;
            return this;
        }
        public Builder setElectives(ArrayList<String> electives) {
            this.electives = electives;
            return this;
        }//ArrayList set method

        public Builder getElectives() {
            this.electives = electives;
            return this;
        }//ArrayList get method

        /*Constructor with Builder Implemented*/
        public Builder copy(Elective elect) {
            this.electName = elect.electName;
            this.electCode = elect.electCode;
            for ( String e : electives){
                this.electives.add(e);
            }
            return this;
        }

        /*Methods*/
        public Elective build() {
            return new Elective(this);
        }

    }//end of builder class
    public static void main(String[] args) {

        ArrayList<String> electives = new ArrayList<>();
        electives.add("BNA");
        electives.add("Scala");
        electives.add("JavaScript");
        electives.add("Data Structures");
        electives.add("Android");
        electives.add("Docker");
        electives.add("eCommerce");
        electives.add("Python");
        electives.add("PHP");
        electives.add("R Programming");
        electives.add("C++");
        electives.add("Ruby");
        electives.add("SQL");
        electives.add("HTML");
        electives.add("Java");

        // Displaying elements
        System.out.println("ArrayList after add operation:");
        for(String ignored :electives)
            System.out.println(electives);
            Collections.sort(electives);

    }
}





