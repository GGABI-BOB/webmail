package kr.co.ggabi.springboot.repository;
import kr.co.ggabi.springboot.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Query("SELECT b.id, b.title FROM Board b ORDER BY b.id DESC")
    List<Board> findAllDesc();
}
