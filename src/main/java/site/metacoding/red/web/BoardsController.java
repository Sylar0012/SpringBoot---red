package site.metacoding.red.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.web.dto.request.boards.UpdateDto;
import site.metacoding.red.web.dto.request.boards.WriteDto;
import site.metacoding.red.web.dto.response.RespDto;


@RequiredArgsConstructor
@RestController
public class BoardsController {
	
	private final BoardsDao boardsDao;
	
	
	@PostMapping("/boards")
	public RespDto<?> insert(WriteDto writeDto) {
		boardsDao.insert(writeDto);
		return new RespDto<> (1, "글이 작성 되었습니다", null);
	}
	
	@GetMapping("/boards/users/{id}")
	public RespDto<?> findById(@PathVariable Integer id){
		boardsDao.findByIdList(id);
		return new RespDto<> (1, "해당 유저의 작성글 입니다", boardsDao.findByIdList(id));
	}
	
	@GetMapping("/boards/{id}")
	public RespDto<?> find(@PathVariable Integer id){
		boardsDao.findByIdtoDetail(id);
		return new RespDto<> (1,"해당 작성글 입니다", boardsDao.findByIdtoDetail(id));
		
	}
	
	@GetMapping("/boards")
	public RespDto<?> findAll(){
		boardsDao.findAll();
		return new RespDto<> (1, "모든 작성글 입니다", boardsDao.findAll());
	}
	
	@DeleteMapping("/boards/{id}")
	public RespDto<?> delete(@PathVariable Integer id){
		boardsDao.delete(id);
		return new RespDto<> (1, "글 삭제 완료", null);
	}
	
	@PutMapping("/boards/{id}")
	public RespDto<?>  update(@PathVariable Integer id, UpdateDto updateDto){
		Boards boardsPs = boardsDao.findById(id);
		
		boardsPs.전체수정(updateDto); 
		
		boardsDao.update(boardsPs);
		return new RespDto<> (1, "글 수정 완료", null);
	}
}
