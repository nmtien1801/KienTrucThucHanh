package iuh.observer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //create subject
        MyTopPic topic = new MyTopPic();
//create observers
        Observer obj1 = new MyTopicsubscriber("Obj1");
        Observer obj2 = new MyTopicsubscriber("Obj2");
        Observer obj3 = new MyTopicsubscriber("Obj3");
//register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
//attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        //check if any update is available
        obj1.update();
//now send message to subject
        topic.postMessage("New Message");
    }
}