package ua.edu.ucu.apps.Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class GroupTest {

    @Test
    public void testSignatureApply() {
        List<Integer> results = new ArrayList<>();
        Signature<Integer> signature = new Signature<>(results::add);

        signature.apply(5);
        assertEquals(1, results.size());
        assertEquals(5, results.get(0));
    }

    @Test
    public void testGroupApply() {
        List<Integer> results = new ArrayList<>();
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(results::add))
             .addTask(new Signature<>(x -> results.add(x * x)));

        group.apply(4);

        assertEquals(2, results.size());
        assertEquals(4, results.get(0));
        assertEquals(16, results.get(1));
    }

    @Test
    public void testGroupIdStamping() {
        Group<Integer> group = new Group<>();
        Signature<Integer> signature1 = new Signature<>(x -> {});
        Signature<Integer> signature2 = new Signature<>(x -> {});
        group.addTask(signature1).addTask(signature2);

        group.apply(0);

        String groupId = signature1.getHeader("groupId");
        assertNotNull(groupId);
        assertEquals(groupId, signature2.getHeader("groupId"));
    }

    @Test
    public void testNestedGroups() {
        List<String> results = new ArrayList<>();
        Group<String> nestedGroup = new Group<>();
        nestedGroup.addTask(new Signature<>(results::add))
                   .addTask(new Signature<>(x -> results.add(x.toUpperCase())));

        Group<String> group = new Group<>();
        group.addTask(nestedGroup)
             .addTask(new Signature<>(x -> results.add("Final: " + x)));

        group.apply("test");

        assertEquals(3, results.size());
        assertEquals("test", results.get(0));
        assertEquals("TEST", results.get(1));
        assertEquals("Final: test", results.get(2));
    }
}
