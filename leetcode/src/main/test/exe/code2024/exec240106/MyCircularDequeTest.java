package exe.code2024.exec240106;

import com.linle.exe.code2024.exec240106.MyCircularDeque;
import org.junit.Test;

/**
 * @description:
 * @author: chendeli
 * @date: 2024-01-06 22:11
 */
public class MyCircularDequeTest {
    @Test
    public void test1(){
        MyCircularDeque myCircularDeque = new MyCircularDeque(8);
        myCircularDeque.insertFront(5);
        myCircularDeque.deleteFront();
        myCircularDeque.insertLast(3);
        myCircularDeque.insertLast(7);
        myCircularDeque. insertLast(7);
        myCircularDeque.deleteLast();
        myCircularDeque.insertLast(4);
    }
}
