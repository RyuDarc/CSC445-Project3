package RAFT_Battleship.server;

/**
 *
 * @author zachf
 */
public class HashTable {

    static class Node {
        final Object key;
        int val;
        Node(Object k, int  v){
            key = k;
            val = v;
        }
    }

    Node[] table = new Node[8];
    int size;   // # of elements in table

    int get(Object key){
        int h = MurmurHash2.hash32(key.toString());
        int i = h & (table.length-1);
        if(table[i] != null){               // if slot has something,
            if(key.equals(table[i].key)) {    // check if it's actually the key we're looking for
                return table[i].val;
            }
            else                           // or if not the key we're looking for,
                i = LinearProbe(i, key);   // linear probe whole table for matching key (because of open address approach), but if none, return next open slot.
        }
        if(table[i] == null)               // if LinearProbe returned an empty slot,
            return 0;
        else if(key.equals(table[i].key)) {  // or if LinearProbe returned a slot with a matching key
            return table[i].val;
        }

        return 0;					   // fall through and return nothing if matching key was not found
    }

    void put(Object key, int val) {
        int h = MurmurHash2.hash32(key.toString());
        int i = h & (table.length-1);
        if(table[i] != null){               // if collision,
            if(key.equals(table[i].key)){   // and same key,
                table[i].val = val;
                return;
            }
            else                           // or if not same key,
                i = LinearProbe(i, key);   // linear probe whole table for matching key, but if none, return next open slot.
        }
        if(table[i] == null)               // if LinearProbe returned an empty slot,
            table[i] = new Node(key, val);
        else {                             // or if LinearProbe returned a slot with a matching key.
            table[i].val = val;
            return;
        }
        ++size;
        if(((double) size/(double) table.length) > 0.75)
            resize();
    }

    void resize() {
        Node[] oldTable = table;
        Node[] newTable = new Node[oldTable.length * 2];
        for(int i = 0; i < table.length; ++i){
            if(oldTable[i] != null){
                int h = MurmurHash2.hash32(oldTable[i].key.toString());
                int j = h & (newTable.length-1);
                if(newTable[j] != null)    // if collision, linearly probe for next open slot.
                    j = nextEmptySlot(j, newTable);
                newTable[j] = new Node(oldTable[i].key, oldTable[i].val);
            }
        }
        table = newTable;
    }

    void printAll() {
        int k = 0;
        for(int i = 0; i < table.length; ++i) {
            if(table[i] != null){
                System.out.println(k + " Key: " + table[i].key + ", Val: " + table[i].val);
                k++;
            }
        }
    }

    void remove(Object key) {
        int h = MurmurHash2.hash32(key.toString());
        int i = h & (table.length-1);
        if(!key.equals(table[i].key))   // if the key isn't at where it's supposed to be,
            i = LinearProbe(i, key);    // LinearProbe to find it.
        table[i] = null;                // clear that slot, i.e. remove
        size--;
    }

    private int nextEmptySlot(int i, Node[] newTable) {
        int index = i;
        while(index < newTable.length){    // look to the right of i for an open slot
            if(newTable[index] == null)
                return index;
            index++;
        }
        if(index >= table.length)   // if the previous loop reached the end of the table,
            index = 0;              // wrap around to the front, and then
        while(index < i){           // look from all the way to the left until reaching i or an empty slot.
            if(newTable[index] == null)
                return index;
            index++;
        }
        return i;
    }

    private int LinearProbe(int i, Object key){    // desired key not found at i. probe linearly until the key is found, but if it does not exist, return index of an empty slot.
        int index = i;
        while(index < table.length){    // look to the right of i for the desired key or next empty slot, whichever comes first.
            if(table[index] == null)
                return index;
            if(key.equals(table[index].key))
                return index;
            index++;
        }
        index = 0;                                  // wrap back around to the front,
        while(index < i && table[index] != null){   // and look from all the way to the left until reaching either i or an empty slot,
            if(key.equals(table[index].key))        // or the desired key - whichever is found first.
                return index;
            index++;
        }
        return index;                               // reaches here when an empty slot was hit.
    }

}