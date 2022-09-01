package site.metacoding.red.web.dto.request.boards;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindRespDto {
	
	private Integer id;
	private String title;
	private String content;
	private String username;
	private Timestamp createdAt;
	
}
