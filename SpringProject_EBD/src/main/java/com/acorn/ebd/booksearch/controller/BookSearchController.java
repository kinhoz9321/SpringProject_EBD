package com.acorn.ebd.booksearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.booksearch.service.BookSearchService;

@Controller
public class BookSearchController {
    @Autowired
    private BookSearchService service; 
    
    //Ű���尡 �������� �ְ� ������������ 
    //�������� �������� �������� �Ȱ������� 
    @RequestMapping("/bookList.do")
    public ModelAndView bookList(@RequestParam(required=false)String keyword){//키워드가 없어도 
        ModelAndView mav = new ModelAndView();
        
        if(keyword !=null)
        {
            mav.addObject("bookList",service.searchBook(keyword,10,1));
        }
        mav.setViewName("bookList");
        return mav;
    }	
}
