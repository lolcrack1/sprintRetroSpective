package io.sprintretro.retroboard.controllers;

import io.sprintretro.retroboard.dto.BoardDTO;
import io.sprintretro.retroboard.dto.CreateBoardDTO;
import io.sprintretro.retroboard.dto.UpdateBoardDTO;
import io.sprintretro.retroboard.mapper.BoardMapper;
import io.sprintretro.retroboard.service.impl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board/")
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;


    @PostMapping("createBoard")
    public BoardDTO createBoard(@RequestBody CreateBoardDTO createBoardDto){

       return boardService.boardCreate(createBoardDto);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(@PathVariable Long id){

        boardService.boardDelete(id);
    }

    @GetMapping("{id}")
    public BoardDTO readBoard(@PathVariable Long id){

       return boardService.boardRead(id);
    }

    @PutMapping("{id}")
    public BoardDTO updateBoard(@RequestBody UpdateBoardDTO updateBoardDto, @PathVariable Long id){

       return boardService.boardUpdate(updateBoardDto, id);
    }

}
