package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HomeWorkTest {

    private static HomeWork homeWork = new HomeWork();

    @Test
    void partitionByTest() {
        var node = createNodeList(List.of(1, 2, 3, 4, 5));
        var actual = homeWork.partitionBy(node, (value) -> value < 4);

        assertEquals(3, actual);
    }

    @Test
    void partitionByTest2() {
        var node = createNodeList(List.of(1, 2, 3, 4, 5));
        var actual = homeWork.partitionBy(node, (value) -> value < 0);

        assertEquals(0, actual);
    }

    @Test
    void partitionByTest3() {
        var actual = homeWork.partitionBy(null, (value) -> value instanceof Integer);

        assertEquals(0, actual);
    }

    @Test
    void partitionByTest4() {
        var node = createNodeList(Collections.emptyList());
        var actual = homeWork.partitionBy(node, (value) -> value < 0);

        assertEquals(0, actual);
    }

    @Test
    void partitionByTest5() {
        var node = createNodeList(List.of(4, 7, 6, 2, 1));
        var actual = homeWork.partitionBy(node, (value) -> value < 7);

        assertEquals(1, actual);
    }

    @Test
    void findNthElement1() {
        var node = createNodeList(List.of(4, 7, 6, 2, 1));
        var actual = homeWork.findNthElement(node, 3);

        assertEquals(6, actual);
    }

    @Test
    void findNthElement2() {
        var node = createNodeList(List.of(4, 7, 6, 2, 1));
        var actual = homeWork.findNthElement(node, 11);

        assertNull( actual);
    }

    @Test
    void findNthElement3() {
        var actual = homeWork.findNthElement(null, 11);

        assertNull( actual);
    }

    @Test
    void findNthElement4() {
        var actual = homeWork.findNthElement(new Node<>(1), 1);

        assertEquals(1, actual);
    }

    @Test
    void findNthElement5() {
        var actual = homeWork.findNthElement(new Node<>(1), 2);

        assertNull(actual);
    }

    private Node<Integer> createNodeList(List<Integer> list) {
        Node<Integer> firstNode = null;
        if (!list.isEmpty()) {
            firstNode = new Node<>(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                firstNode.add(list.get(i));
            }
        }
        return firstNode;
    }

}