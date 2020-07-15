package com.example.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Board;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>{
	 
	public List<Board> findBywriterContaining(String writer);
	public List<Board> findByTitleAndWriterStartingWith(String title, String writer);

}
