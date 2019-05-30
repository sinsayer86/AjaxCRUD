package cafe.jjdev.AjaxCRUD.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.AjaxCRUD.member.mapper.MemberMapper;
import cafe.jjdev.AjaxCRUD.member.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired MemberMapper memberMapper;
	
	// 멤버 아이디
	public String getMemberId(String id) {
		return memberMapper.selectMemberId(id);
	}
	
	// 멤버 목록
	public Map<String, Object> getMembers(int currentPage) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		int rowCount = memberMapper.selectMemberCount(); //총 멤버 수
		int lastPage = 0;
		if(rowCount % rowPerPage == 0) {
			lastPage = rowCount / rowPerPage;
		}
		else {
			lastPage = rowCount / rowPerPage + 1;
		}
		
		List<Member> list = memberMapper.selectMemberList(beginRow, rowPerPage); //멤버 목록
		System.out.println(list + " :: list |MemberService.getMembers");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		map.put("rowCount", rowCount);
		map.put("list", list);
		
		return map;
	}
	
	// 멤버 추가
	public void addMember(Member member) {
		memberMapper.insertMember(member);
	}
	
	// 멤버 삭제
	public void removeMember(String[] ck) {
		for(String id : ck) {
			Member member = new Member();
			member.setId(id);
			memberMapper.deleteMember(member);
		}
	}
	
	// 멤버 수정
	public void modifyMember(Member member){
		memberMapper.updateMember(member);
	}
}
