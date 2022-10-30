package org.ttn.springhibernatepart3.manyToOne;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.ttn.springhibernatepart3.manyToOne.entity.Address;
import org.ttn.springhibernatepart3.manyToOne.entity.Author;
import org.ttn.springhibernatepart3.manyToOne.entity.Book;
import org.ttn.springhibernatepart3.manyToOne.entity.Subject;
import org.ttn.springhibernatepart3.manyToOne.repository.AuthorRepository;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestEntityManager
class Springhibernatepart3ApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Order(value = 1)
	public void testCreate(){
		Address address = new Address("1","abc","a");
		Subject subject1 = new Subject("Java");
		Subject subject2 = new Subject("C++");
		Subject subject3 = new Subject("C#");

		Set<Subject> set = new HashSet<>();
		set.add(subject1);
		set.add(subject2);
		set.add(subject3);

		Book book1=new Book();
		book1.setBookName("Java Core in Easy Steps");

		Book book2 = new Book();
		book2.setBookName("Spring Core in Easy Steps");




		Author author = new Author();
		author.setName("kamlesh");
		author.setAddress(address);
		author.setSubjects(set);
		author.addBookDetails(book1);
		author.addBookDetails(book2);

		authorRepository.save(author);

	}
}
