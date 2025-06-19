package kr.ac.kopo.board.vo;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardVO {

	private int no;
//	@NotEmpty(message = "필수항목입니다")
	@Length(min=2, max=100, message="제목은 2글자 이상 100글자 이하로만 입력하세요.")
	private String title;
	@NotEmpty(message = "필수항목입니다")
	@Pattern(regexp = "^[A-Za-z0-9ㄱ-ㅎ]*$", message = "특수기호는 사용하실 수 없습니다")
	private String writer;
	@NotEmpty(message = "필수항목입니다")
	private String content;
	private int viewCnt;
	private String regDate;
}
