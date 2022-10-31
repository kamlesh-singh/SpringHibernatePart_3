package org.ttn.springhibernatepart3.manyToMany;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import org.ttn.springhibernatepart3.manyToMany.entity.Address;
import org.ttn.springhibernatepart3.manyToMany.entity.Author;
import org.ttn.springhibernatepart3.manyToMany.entity.Book;
import org.ttn.springhibernatepart3.manyToMany.entity.Subject;
import org.ttn.springhibernatepart3.manyToMany.repository.AuthorRepository;

import java.util.HashSet;
import java.util.Optional;
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

	@Test
	@Order(value=2)
	public void testGetData(){
		Optional<Author> byId = authorRepository.findById(1);
		if(byId.isPresent()){
			System.out.println(byId.get());
		}
	}
//
//	@Test
//	@Order(value=3)
//	public void testGetDataA(){
//		Optional<Book> byId = bookRepository.findById(2);
//		if(byId.isPresent()){
//			System.out.println(byId.get());
//			System.out.println(byId.get().getAuthor());
//		}
//	}
}
