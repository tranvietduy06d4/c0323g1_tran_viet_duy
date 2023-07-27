package com.example.controller;

import com.example.dto.SongDto;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/song/list")
    public String showList(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").ascending());
        Page<Song> songPage = songService.findAll(pageable);
        model.addAttribute("songPage",songPage);
        return "list";
    }

    @GetMapping("/song/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto",new SongDto());
        return "create";
    }

    @PostMapping("/song/create")
    public String createSong(@Valid @ModelAttribute SongDto songDto,
                             BindingResult bindingResult,
                             Model model, RedirectAttributes redirectAttributes) {
        Song song = new Song();
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("songDto",songDto);
            return "create";
        }
        BeanUtils.copyProperties(songDto,song);
        songService.createSong(song);
        redirectAttributes.addFlashAttribute("message","Add new song success");
        return "redirect:/song/list";
    }

}
