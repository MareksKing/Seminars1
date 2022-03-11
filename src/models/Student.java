package models;

public class Student implements Comparable<Student> {
        //1.mainīgie
    private int id;
    private String name;
    private String surname;
    
    private static int idCounter= 20000;

        //2.get funkcijas
    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return String return the surname
     */
    public String getSurname() {
        return surname;
    }
   

        //3.set funkcijas
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if(name!=null && name.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+\\s?([A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+)?")){
            this.name = name;
        }
        else {
            this.name = "notknown";
        }
    }
    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        if(surname!=null && surname.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+[-]?([A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+)?")){
            this.surname = surname;
        }
        else {
            this.surname = "notknown";
        }
    }
    /**
     * @param id the id to set
     */
    public void setId() {
        this.id = idCounter;
        idCounter++;
    }


        //4.konstuktori

    public Student() {
        setId();
        setName("Test");
        setSurname("Students");
    } 
    public Student(String name, String surname) {
        setId();
        setName(name);
        setSurname(surname);
    }

    
    //5.toString()
    @Override
    public String toString() {
        return "Student [" + id + ", " + name + ", " + surname + "]";
    }

    @Override
    public int compareTo(Student o) {
        if(surname.charAt(0) < o.surname.charAt(0)){return -1;}
        else if (surname.charAt(0) > o.surname.charAt(0)){return 1;}
        else{return 0;}
    }
    
    
    
    

}
