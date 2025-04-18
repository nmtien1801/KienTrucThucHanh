package ObserverPattern;

public class ObserverTest {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();

        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        MyTopic topic1 = new MyTopic();

        obj1.update();

        topic.postMessage("New Message");

        obj1.update();

        topic.postMessage("New Message 1");
    }
}
