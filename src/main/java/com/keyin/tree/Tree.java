package com.keyin.tree;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Integer> inputNumbers;

    @Lob
    private String treeStructure;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }
}
