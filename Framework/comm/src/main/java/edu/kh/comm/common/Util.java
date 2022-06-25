package edu.kh.comm.common;

import java.text.SimpleDateFormat;

public class Util {
	// ���ϸ� ���� �޼ҵ�
    public static String fileRename(String originFileName) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

    	int ranNum = (int) (Math.random() * 100000); // 5�ڸ� ���� ���� ����

    	String str = "_" + String.format("%05d", ranNum);

    	String ext = originFileName.substring(originFileName.lastIndexOf("."));
  
    	return date + str + ext;
   }
}
