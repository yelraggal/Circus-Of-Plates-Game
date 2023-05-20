package Iterator;

import java.util.List;

public class ArrayIterator implements MyIterator {
    private int index ;
    private List<Integer> list;

    public ArrayIterator(List list) {
        this.list = list;
        index=0;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            return list.get(index++);
        }
        return 0;
    }

    @Override
    public void remove() {
        list.remove(--index);
    }


    @Override
    public int getIndex() {
       return index;
    }

}
