package src.test.java;

import com.keyin.tree.Tree;
import com.keyin.tree.TreeRepository;
import com.keyin.tree.TreeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TreeServiceTest {
    @Test
    void testCreateTree() {
        TreeRepository mockRepo = Mockito.mock(TreeRepository.class);
        TreeService service = new TreeService(mockRepo);

        List<Integer> inputNumbers = Arrays.asList(5, 3, 8, 2, 4);
        Tree tree = new Tree();
        tree.setInputNumbers(inputNumbers);
        tree.setTreeStructure("{ \"value\": 5, \"left\": { \"value\": 3, ...");

        when(mockRepo.save(any(Tree.class))).thenReturn(tree);

        Tree result = service.createTree(inputNumbers);

        assertEquals(inputNumbers, result.getInputNumbers());
        assertEquals("{ \"value\": 5, \"left\": { \"value\": 3, ...", result.getTreeStructure());
        verify(mockRepo, times(1)).save(any(Tree.class));
    }

    @Test
    void testGetAllTrees() {
        TreeRepository mockRepo = Mockito.mock(TreeRepository.class);
        TreeService service = new TreeService(mockRepo);

        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        List<Tree> mockTrees = Arrays.asList(tree1, tree2);

        when(mockRepo.findAll()).thenReturn(mockTrees);

        List<Tree> result = service.getAllTrees();

        assertEquals(2, result.size());
        verify(mockRepo, times(1)).findAll();
    }
}
