package com.keyin.tree;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {
    private final TreeRepository repository;

    public TreeService(TreeRepository repository) {
        this.repository = repository;
    }

    public Tree createTree(List<Integer> numbers) {
        // Create the Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree(numbers.get(0));
        numbers.stream().skip(1).forEach(bst::insert);

        // Save the tree in the database
        Tree tree = new Tree();
        tree.setInputNumbers(numbers);
        tree.setTreeStructure(bst.toString());
        return repository.save(tree);
    }

    public List<Tree> getAllTrees() {
        return repository.findAll();
    }
}
