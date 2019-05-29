package cafe.jjdev.AjaxCRUD.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.AjaxCRUD.member.service.MemberService;
import cafe.jjdev.AjaxCRUD.member.vo.Member;

@RestController
public class MemberController {
	@Autowired MemberService memberService;
	
	// 멤버 ID
	@PostMapping("/getMemberId")
	public String getMemberId(String id) {
		return memberService.getMemberId(id);
	}
	
	
	// 멤버 목록
	@PostMapping("/getMembers")
	public Map<String, Object> getMembers(int currentPage) {
		System.out.println("/getMembers 요청");
		System.out.println(currentPage + " :: currentPage |MemberController.getMembers post");
		Map<String, Object> map = memberService.getMembers(currentPage);
		System.out.println(map + " :: map |MemberController.getMembers post");
		return map;
	}
	
	// 멤버 추가
	@PostMapping("/addMember")
	public void addMember(Member member) {
		System.out.println("/addMember 요청");
		System.out.println(member + " :: member |MemberController.addMember post");
		memberService.addMember(member);
	}
	
	// 멤버 삭제
	@PostMapping("/removeMember")
	public void removeMember(@RequestParam(value="ck[]") String[] ck) {
		System.out.println("/removeMember 요청");
		System.out.println(ck.length + " :: ck.length |MemberController.removeMember get");
		memberService.removeMember(ck);
	}
	
	// 멤버 수정
	@PostMapping("/modifyMember")
	public void modifyMember(Member member) {
		System.out.println("/modifyMember 요청");
		System.out.println(member + " :: member |MemberController.modifyMember post");
		memberService.modifyMember(member);
	}
}
