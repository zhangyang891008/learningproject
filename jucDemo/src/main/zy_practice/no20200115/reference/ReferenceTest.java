package no20200115.reference;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reference持有对象
 *
 *
 */
public class ReferenceTest {
    private static ReferenceQueue<BigObj> rq = new ReferenceQueue<>();

    public static void visit(){
        Reference<? extends BigObj> pollObj = rq.poll();
        if(pollObj!=null){
            System.out.println("visit "+pollObj + " " + pollObj.toString());
        }
    }

    public static void main(String[] args) {

        //SoftReference
        List<SoftReference<BigObj>> sr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sr.add(new SoftReference<BigObj>(new BigObj("sr"+i), rq));
            System.out.println("soft add:" + i);
            visit();
        }

        //weakReference
        List<WeakReference<BigObj>> wr = new ArrayList<>();
        for (int i = 11; i < 20; i++) {
            wr.add(new WeakReference<BigObj>(new BigObj("wr"+i), rq));
            System.out.println("weak add:"+i);
            visit();
        }

        SoftReference<BigObj> softRef = new SoftReference(new BigObj("softRef"), rq);
        WeakReference<BigObj> weakRef = new WeakReference<>(new BigObj("weakRef"), rq);
        System.gc();

        List<PhantomReference<BigObj>> pr = new ArrayList<>();

        for (int i = 31; i < 40; i++) {
            pr.add(new PhantomReference<BigObj>(new BigObj("pr"+i), rq));
            System.out.println("phantom add:"+i);
            //visit();
        }
        System.gc();
        //PhantomReference

        for (int i = 0; i < 20; i++) {
            visit();
        }
        
        System.out.println("fff");
    }
}

class BigObj{

    String id ;

    public BigObj(String id){
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize "+ id);
    }
}