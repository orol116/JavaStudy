package edu.kh.comm.member.model.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.comm.common.Util;
import edu.kh.comm.member.model.dao.MyPageDAO;
import edu.kh.comm.member.model.vo.Member;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	// ȸ�� ���� ���� Service
	@Override
	public int updateInfo(Map<String, Object> paramMap) {
		return dao.updateInfo(paramMap);
	}

	// ��й�ȣ ���� Service
	@Override
	public int updatePw(Map<String, Object> pwMap) {
		
		String nowPw = dao.selectCurrentPw((int)pwMap.get("memberNo"));

		if (bcrypt.matches((String)pwMap.get("currentPw"), nowPw)) {
			pwMap.put("newPw", bcrypt.encode((String)pwMap.get("newPw")));
			return dao.updatePw(pwMap);
		}
		
		return 0;
	}

	// ȸ�� Ż�� Service
	@Override
	public int secession(Member loginMember) {

		String nowPw = dao.selectCurrentPw(loginMember.getMemberNo());

		if (bcrypt.matches(loginMember.getMemberPw(), nowPw)) {
			return dao.secession(loginMember.getMemberNo());
		}
		
		return 0;
	}

	// ������ �̹��� ���� ���� ����
	@Override
	public int updateProfile(Map<String, Object> map) throws IllegalStateException, IOException {
		
		// ���־��� �� ������ ����
		MultipartFile uploadImage = (MultipartFile)map.get("uploadImage");
		String delete = (String)map.get("delete"); // "0" ���� / "1" ����
		
		// ������ �̹��� �������θ� Ȯ���ؼ�
		// ������ �ƴ� ���(== �� �̹����� ����) -> ���ε�� ���ϸ��� ����
		// ������ ��� -> NULL ���� �غ�
		String renameImage = null; // ����� ���ϸ� ����
		
		if (delete.equals("0")) { // �̹����� ����� ���
			// ���ϸ� ����
			// upload.getOriginalFilename() : ���� ���ϸ�
			renameImage = Util.fileRename(uploadImage.getOriginalFilename());
			
			map.put("profileImage", map.get("webPath") + renameImage); // ���ϸ� ����
		} else {
			map.put("profileImage", null); // null �� �غ�
		}
		
		// DAO�� ȣ���ؼ� ������ �̹��� ����
		int result = dao.updateProfile(map);
		
		// DB ���� ���� �� �޸𸮿� �ӽ� ����Ǿ��ִ� ������ ������ ����
		if (result > 0 && map.get("profileImage") != null) {
			uploadImage.transferTo(new File(map.get("folderPath") + renameImage));
			
			// transferTo() : �ش� ������ ������ ��� + �̸����� ����
		}

		return result;
	}
	
	

	
	
	
	
}
