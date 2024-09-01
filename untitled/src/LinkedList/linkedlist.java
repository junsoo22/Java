package LinkedList;

public class linkedlist <T>{
    public Node<T> head;
    public int size;
    public linkedlist(){
        head=null;
        size=0;
    }

    //T -> 타입 파라미터
    public void addFirst(T item){   //새로운 노드를 만들어서 연결리스트의 맨 앞에 삽입
        Node<T>newNode=new Node<>(item);   //노드 객체 생성(추가할 데이터 저장)
        newNode.next=head;    //새로운 노드의 next 필드가 현재의 head노드 가리키도록 함
        head=newNode;       //새로운 노드를 새로운 head 노드로 한다.
        size++;        //노드 추가됨
    }

    //만약 before node가 연결리스트으ㅔ 마지막 노드여서 그 다음 노드가 없다면,
    //before.next=null이다.
    public void addAfter(Node<T> before, T item){
        Node<T>temp=new Node<>(item);
        temp.next=before.next;
        before.next=temp;
        size++;    //노드 추가됨
    }

    public void add(int index,T item){  //연결리스트의 index번째의 위치에 새로운 데이터 삽입
        if (index<0||index>size){    //노드의 개수가 size이므로
            return;
        }
        if(index==0){
            addFirst(item);
        }
        else{
            Node<T>q=getNode(index-1);
            addAfter(q,item);
        }


    }

    //단순 연결리스트에 새로운 노드를 삽입할 때, 삽입할 위치의 바로 팡 노드의 주소가 필요하다.
    //즉 어떤 노드의 뒤에 삽입하는 것은 간단하지만, 반대로 어떤 노드의 앞에 삽입하는 것은 간단하지 않다.

    public T removeFirst(){
        if (head==null){
            return null;
        }
        else{
            T temp=head.data;      //현재 head가 가리키는 노드의 data 임시 저장
            head=head.next;     //head가 가리키는 것은 head가 가리키는 노드의 다음 노드
            size--;
            return temp;        //삭제한 data 반환
        }
    }

    public T removeLast(Node<T>before){
        if (before.next==null){
            return null;
        }
        else{
            T temp=before.next.data;
            before.next=before.next.next;
            size--;
            return temp;
        }
    }

    public T remove(int index){    //index번쨰 노드를 삭제하고, 그 노드에 저장된 데이터를 반환
        if (index<0||index>=size) {    //노드의 개수가 size이므로
            return null;
        }
        if(index==0){
            return removeFirst();
        }
        Node<T>prev=getNode(index-1);
        return removeLast(prev);
    }

    public T remove(T item){     //입력된 스트링을 저장한 노드를 찾아 삭제한다. 삭제된 노드에 저장된 스트링을 반환
        //삭제할 노드를 찾았음. 하지만 노드를 삭제하기 위해서는 삭제할 노드가 아니라 직전 노드의 주소가 필요함.
        //q는 항상 p의 직전 노드를 가리킴. p가 첫번째 노드일 경우 q는 null임
        Node<T>p=head;
        Node<T>q=null;
        while(p!=null && !p.data.equals(item)) {
            q = p;
            p = p.next;
        }
        if(p==null){
            return null;
        }
        if (q==null){    //찾고있는 노드가 첫번째 노드이다.
            return removeFirst();
        }
        else
            return removeLast(q);    //q의 다음 노드 삭제
    }


    public int indexOf(T item){    //search, 입력된 데이터 item과 동일한 데이터를 저장한 노드를 찾아서 그 노드번호(index)를 반환
        Node<T>p=head;
        int index=0;
        while(p!=null){
            if (p.data.equals(item))
                return index;
            else{
                p=p.next;
                index++;
            }
        }
        return -1;
    }

    public Node<T> getNode(int index){    //연결리스트의 index번째 노드의 주소 반환
        Node<T>p=head;    //p가 첫번째 노드 가리킴
        if (index<0||index>=size){    //노드의 개수가 size이므로
            return null;
        }
        for(int i=0;i<index;i++){
            p=p.next;
        }
        return p;
    }

    public T get(int index){    //index번째 노드에 저장된 데이터 반환
//        Node<T>p=head;    //p가 첫번째 노드 가리킴
        if (index<0||index>=size){    //노드의 개수가 size이므로
            return null;
        }
//        for(int i=0;i<index;i++){
//            p=p.next;
//        }
//        return p.data;

        return getNode(index).data;
    }

    public static void main(String[] args) {
        linkedlist<String> list=new linkedlist<>();
        list.addFirst("Monday");
        list.addFirst("Sunday");
        list.add(1,"Friday");
        list.add(0,"Monday");    //M, S ,F
        list.add(2, "Thuseday");   //M S,T,F

        String str=list.get(2);   //str = "Tuseday"
        list.remove(2);      //TuseDay 삭제, M, S ,F
        int pos=list.indexOf(("Friday"));    //pos = 2
    }
}

class Node <T>{    //제너릭 클래스로 만듬
    public T data;
    public Node<T> next;    //나 자신과 똑같은 타입이어야 함

    public Node(T data){
        this.data=data;
        next=null;
    }
}