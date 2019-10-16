/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author admin
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        
        boolean admin = false;
        
        
        for (GrantedAuthority auth : a.getAuthorities()) {
            if ("ROLE_ADMIN".equals(auth.getAuthority())){
              admin = true;
            }
        }   
        
        if(admin){
          response.sendRedirect(request.getContextPath()+"/admin/");
        }else{
          response.sendRedirect(request.getContextPath()+"/home");
        }
    }
    
}
