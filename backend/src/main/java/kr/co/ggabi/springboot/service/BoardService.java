package kr.co.ggabi.springboot.service;
import kr.co.ggabi.springboot.domain.board.Board;
import kr.co.ggabi.springboot.domain.posts.PostList;
import kr.co.ggabi.springboot.dto.BoardListResponseDto;
import kr.co.ggabi.springboot.dto.BoardResponseDto;
import kr.co.ggabi.springboot.dto.BoardSaveRequestDto;
import kr.co.ggabi.springboot.repository.BoardRepository;
import kr.co.ggabi.springboot.repository.PostListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final PostListRepository postListRepository;


    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        List<Long> postlistId = entity.getPostlistId();
        List<PostList> postlist = new ArrayList<>();
        for(Long iter:postlistId) {
            postlist.add(postListRepository.findById(iter).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+iter)));
        }
        BoardResponseDto tmp = new BoardResponseDto(entity);
        tmp.setPostList(postlist);
        return tmp;
    }

    @Transactional(readOnly = true) // 조회기능
    public List<BoardListResponseDto>   findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)// == .map(Board->new BoardListResponseDto(board))
                .collect(Collectors.toList());
    }

}
