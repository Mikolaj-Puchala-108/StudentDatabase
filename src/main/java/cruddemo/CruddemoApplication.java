package cruddemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.luv2code.cruddemo")
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}






	@Bean
	public CommandLineRunner comandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			//createMultiStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByTheLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);

		};


		/* 
		@Bean: Metoda jest komponentem Springa, który zostaje wstrzyknięty do kontekstu aplikacji.
		CommandLineRunner: Interfejs Springa, który pozwala uruchamiać kod po starcie aplikacji.
		W tym przypadku służy do wywoływania metod CRUD (np. createStudent, readStudent).
		studentDAO: Obiekt DAO wstrzykiwany przez Springa do wykonania operacji na bazie danych
		 */






	}
/*
	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting stident id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrive student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to scooby
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		//update student
		studentDAO.update(myStudent);

		//display updatet student
		System.out.println("Update student: " + myStudent);
	}

	private void queryForStudentsByTheLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Put");

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of student
		List<Student> theStudents = studentDAO.findAll();

		//display list of student
		for (Student tempStudent : theStudents){
			System.out.println((tempStudent));
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//tworzy obiekt student
		System.out.println("Creating new student");
		Student tempStudent = new Student("Maria", "Put", "mil@gmail.com");

		//zapsuje obiket studenta
		System.out.println("Creating new student...");
		studentDAO.save(tempStudent);

		//wypisuje id
		int theId = tempStudent.getId();
		System.out.println("Saved student. ID = " + theId);

		//znajduje po id studenta
		System.out.println("Retrieving sttudent with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//wyświetla znalezionego po id studenta
		System.out.println("Found the student: " + myStudent );
	}

	private void createMultiStudent(StudentDAO studentDAO) {
		//tworzy kilka obiktów
		System.out.println("Creating new 3 student object ...");
		Student tempStudent1 = new Student("Miki", "Puchala", "miki@gmail.com");
		Student tempStudent2 = new Student("Klaudia", "Pruchnik", "Cay@gmail.com");
		Student tempStudent3 = new Student("Sebstian", "Pruchnik", "Seb4@gmail.com");
		//zapsiuje ich
		System.out.println("Saving the 3 student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "Pad@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
	*/
}
