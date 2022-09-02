package site.metacoding.red.domain.boards.mapper;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardsDetail {
	private Integer id;
	private String title;
	private String content;
	private Timestamp createdAt;
	private Integer usersid;
	private String username;
	private String password;
	private String email;
}
