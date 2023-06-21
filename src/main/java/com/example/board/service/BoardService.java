package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    //1. 객체선언 @Autowired 사용
    @Autowired
    private BoardRepository boardRepository;

    // 글 작성 처리
    public void write(Board board){ //매개변수 지정
        boardRepository.save(board); //위에서 지정한 매개변수 입력
    }

    //게시글 리스트 처리
    public List<Board> boardList(){
        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
