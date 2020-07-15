package com.example.persistence;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Board;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Before
	public void init() {
		for(int i=1; i<=100; i++) {
			Board board = new Board("title" + i , "content" +i , "writer" +i);
			boardRepo.save(board);
		}
	}
	@Test
	public void test() {
		System.out.println("test method");
	}

	@Test
	public void testFind() {
		Optional<Board> board = boardRepo.findById(1L);
		System.out.println(board);
	}
	@Test
	public void testUpdate() {
		Optional<Board> board = boardRepo.findById(2L);
		board.get().setTitle("updatedTitle");
		boardRepo.save(board.get());
	}
	@Test
	public void testFindByWriterContaining() {
		List<Board> boards=boardRepo.findBywriterContaining("rit");
		boards.forEach((board)->{
			System.out.println(board);
		});
	}
	
//	@After
//	public void testDelete() {
//		boardRepo.deleteById(3L);
//	}

}
