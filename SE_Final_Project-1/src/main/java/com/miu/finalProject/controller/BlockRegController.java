package com.miu.finalProject.controller;

import com.miu.finalProject.domain.Block;
import com.miu.finalProject.domain.Entry;
import com.miu.finalProject.service.BlockService;
import com.miu.finalProject.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlockRegController {
    @Autowired
    BlockService blockService;

    @Autowired
    EntryService entryService;

    @RequestMapping(value = "/block",method = RequestMethod.GET)
    public String blockRegForm(@ModelAttribute("newBlock") Block block, Model model){
        List<Block> blockList = new ArrayList<Block>();
        blockList.addAll(blockService.getAllBlock());

        List<String> entryNameList = new ArrayList<>();
       // System.out.println(blockList);
        for(Entry e : entryService.getAllEntry()){
            entryNameList.add(e.getEntryName());
        }
        System.out.println("entry name list................"+entryNameList);
       model.addAttribute("entryNameList", entryNameList);
        model.addAttribute("blockList",blockList);
       model.addAttribute("newBlock", block);
        return "addBlockForm";
    }

    @RequestMapping(value = {"/addnewblock"}, method = RequestMethod.POST)
    public String registerNewBlock(@ModelAttribute("newBlock") Block block,Model model){
        Entry entry = entryService.getEntryByEntryName(block.getBlockName());
        entry.addBlock(block);
        blockService.save(block);
        System.out.println("block............." + block);
        return "redirect:/block";
        
    }
}
