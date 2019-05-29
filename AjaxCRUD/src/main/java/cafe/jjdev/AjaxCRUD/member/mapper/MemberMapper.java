package cafe.jjdev.AjaxCRUD.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.AjaxCRUD.member.vo.Member;

@Mapper
public interface MemberMapper {
	public String selectMemberId(String id); //멤버 아이디
	public int selectMemberCount(); //총 멤버 수
	public List<Member> selectMemberList(int beginRow, int rowPerPage); //멤버 목록
	public int insertMember(Member member); //멤버 추가
	public int deleteMember(Member member); //멤버 삭제
	public int updateMember(Member member); //멤버 수정
}
