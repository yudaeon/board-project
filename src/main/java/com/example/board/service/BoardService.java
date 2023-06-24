package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    //1. 객체선언 @Autowired 사용
    @Autowired
    private BoardRepository boardRepository;

    // 글 작성 처리
    public void write(Board board, MultipartFile file) throws IOException { //매개변수 지정
        //파일 첨부 코드 추가
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        //파일이름을 랜덤으로 생성
        UUID uuid = UUID.randomUUID();

        //파일이름 생성
        String fileName = uuid + "_" + file.getOriginalFilename();

        //파일 생성할거고 이 경로에 이름은 이렇게 저장할거다
        File savaFile = new File(projectPath, fileName);

        //파일 저장
        file.transferTo(savaFile);

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
