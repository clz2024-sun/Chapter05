package com.javaex.ex04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PersonApp {

	public static void main(String[] args) throws IOException {
		
		//리스트 생성
		List<Person> personList = new ArrayList<Person>();
		
		// 읽기 스트림
		InputStream in = new FileInputStream("C:\\javaStudy\\MS949.txt");
		InputStreamReader isr = new InputStreamReader(in, "MS949");
		BufferedReader br = new BufferedReader(isr);
		
		//한줄씩 읽기 반복
		while(true) {
			
			//파일을 한줄씩 읽는다
			String str = br.readLine();
			
			//데이터없으면 끝
			if(str==null) {
				break;
			}
			//데이터가 있으면
		    //데이터를 #으로 나눠주세요 split()
			String[] personInfo = str.split("#");
			String name = personInfo[0];
			String hp = personInfo[1];
			String company = personInfo[2];
			
			//person으로 묶는다
			Person person = new Person(name, hp, company);
			//System.out.println(person.toString());
			
			//리스트에 담는다
			personList.add(person);
		}
		
		//전체출력
		for(int i=0; i<personList.size(); i++) {
			System.out.println(personList.get(i).toString());
		}
		
		//이름만 출력
		for(int i=0; i<personList.size(); i++) {
			System.out.println(personList.get(i).getName());
		}
		
		
		br.close();
	}

}
