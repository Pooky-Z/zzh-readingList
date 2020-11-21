package com.zzh.ch07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")

public class BookController {
    @Autowired
    BookRepository repository;

    @Autowired
    AmazonProperties amazon;

    String reader="zzh";

    @RequestMapping(method = RequestMethod.GET)
    String readingList(Model model){
        List<Book> books=repository.findAllByReader(reader);
        model.addAttribute("reader",reader);
        if(books!=null){
            model.addAttribute("books",books);
        }
        return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    String addToReadingList(Model model,Book book){
        book.setReader(reader);
        repository.save(book);
        System.out.println(amazon.getAssociateId());
        model.addAttribute("book",book);
        return "redirect:/";
    }

}
