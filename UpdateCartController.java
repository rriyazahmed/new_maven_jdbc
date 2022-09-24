package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.CartDTO;

public class UpdateCartController {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		CartDTO cdto=new CartDTO();
		CartDAO cdao=new CartDAO();
		
		System.out.println("enter the id ");
		int id = sc.nextInt();
		
		String result=cdao.updateCart(id);
		System.out.println("UPDATED");
		
	}


}
