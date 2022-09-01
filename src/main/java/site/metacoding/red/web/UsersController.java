package site.metacoding.red.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;
import site.metacoding.red.web.dto.response.RespDto;


@RequiredArgsConstructor
@RestController
public class UsersController {

	private final UsersDao usersDao;
	
	@GetMapping("/users/{id}")
	public RespDto<?> getUsers(@PathVariable Integer id) {
		return new RespDto<>(1, "하나 불러옴", usersDao.findById(id));
	}
	
	@GetMapping("/users")
	public RespDto<?> getUsersList(){
		return new RespDto<>(1, "모두 불러옴", usersDao.findAll());
	}
	
	@PostMapping("/users")
	public RespDto<?> insert(JoinDto joinDto) {
		usersDao.insert(joinDto);
		return new RespDto<>(1, "회원가입 완료", null); 
	}
	
	@DeleteMapping("/users/{id}")
	public RespDto<?> deleteUsers(@PathVariable Integer id){
		usersDao.delete(id);
		return new RespDto<>(1, "회원탈퇴 완료", null);
	}
	
	@PutMapping("/users/{id}")
	public RespDto<?> updateById(@PathVariable Integer id,UpdateDto updateDto){
		//1번 : id로 select 하자 ( 영속화 ) db에 있는 행을 스냅샷해서 자바에서 쓸수 있게 오브젝트화 한다 
		Users usersPs = usersDao.findById(id);
		
		//2번 : 변경
		usersPs.전체수정(updateDto);
		
		//3번 : 영속화된 오브젝트로 update 하기
		usersDao.update(usersPs);
		return new RespDto<>(1, "회원 정보 수정", null);
	}
	@PutMapping("/users/{id}/password")
	public RespDto<?> updatePassword(@PathVariable Integer id, String password){
		//1번 : 영속화
		Users usersPs = usersDao.findById(id);
		
		//2번 : 변경
		usersPs.패스워드수정(password);
		
		//3번 : 영속화된 오브젝트로 update하기
		
		usersDao.update(usersPs);
		return new RespDto<>(1, "비밀번호 수정", null);
		
	}
}
