package com.keyin.tree;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TreeController {
    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enterNumbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        // Convert input string to a list of integers
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();


        Tree tree = service.createTree(numberList);
        model.addAttribute("tree", tree);
        return "treeResult";
    }

    @GetMapping("/previous-tree")
    public String previousTrees(Model model) {
        List<Tree> trees = service.getAllTrees();
        model.addAttribute("trees", trees);
        return "previousTrees";
    }

    @GetMapping("/api/tree")
    @ResponseBody
    public List<Tree> getTreesAsJson() {
        return service.getAllTrees();
    }

}
