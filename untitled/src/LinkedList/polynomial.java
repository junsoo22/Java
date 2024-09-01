package LinkedList;

public class polynomial{
    public char name;
    public linkedlist<Term> terms;

    public polynomial(char name) {
        this.name = name;
        terms=new linkedlist<>();
    }

    public char getName() {
        return name;
    }

    //기존의 다항식에 새로운 항을 추가하는 메서드
    //1. 추가하려는 항과 동일 차수의 항이 이미 있는 경우: 기존항의 계수만 변경(합이 0이 되버리면 삭제)
    //2. 그렇지 않은 경우: 새로운 항을 삽입(항들은 차수의 내림차순으로 항상 정렬됨)
    public void addTerm(int coef, int expo){
        if(coef==0){
            return;
        }

        Node<Term> p=terms.head;
        Node<Term>q=null;
        while(p!=null && p.data.expo>expo){
            q=p;
            p=p.next;
        }

        //1. 추가하려는 항과 동일 차수의 항이 이미 있는 경우: 기존항의 계수만 변경(합이 0이 되버리면 삭제)
        if(p!=null && p.data.expo==expo){
            p.data.coef+=coef;
            if (p.data.coef==0){
                if(q==null){
                    terms.removeFirst();
                }
                else{
                    terms.removeLast(q);
                }
            }
        }
        //2. 그렇지 않은 경우: 새로운 항을 삽입(항들은 차수의 내림차순으로 항상 정렬됨)
        else{
            Term t=new Term(coef, expo);
            if(q==null){
                terms.addFirst(t);
            }
            else
                terms.addAfter(q,t);
        }
    }

    public int calc(int x){
        int result=0;
        Node<Term>p=terms.head;
        while(p!=null){
            result+=p.data.calc(x);
            p=p.next;
        }
        return result;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name+"(x)=");
        Node<Term>p=terms.head;
        while(p!=null){
            sb.append("+"+p.data.toString());
            p=p.next;
        }
        return sb.toString();
    }
}

class Term{
    public int coef;
    public int expo;

    public Term(int coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    public int calc(int x){
        return coef*(int)Math.pow(x,expo);
    }

    public String toString(){
        return coef+"x^"+expo;
    }
}
