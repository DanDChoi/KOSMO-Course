package soo.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private long seq;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private Date rdate;
}
