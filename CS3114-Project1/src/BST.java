import java.util.Iterator;

/**
 * @author juliam8 && abbym1
 *
 */
public class BST<K extends Comparable<? super K>, D> implements Iterable<K>{
	//constructor
	BST(){ root = null; node_count = 0; }
	
    @Override
    public Iterator<K> iterator() {
        return new BST_Iterator(root);
    }
	
	//clear, apparently
	public void clear() { root = null; node_count = 0; }
	
	//insert a node into the BST
	//input must be a comparable data type
	public void insert(K k, D d) {
		root = insert_helper(root, k, d);
		node_count++;
	}
	
	public BST_node<K, D> insert_helper(BST_node<K, D> rt, K k, D d){
		if(rt == null) return new BST_node<K, D>(k, d);
		if(rt.key().compareTo(k) >= 0)
			rt.set_l(insert_helper(rt.left(), k, d));
		else
			rt.set_r(insert_helper(rt.right(), k, d));
		return rt;	
	}	
	
	protected BST_node<K, D> remove_helper(BST_node<K, D> rt) {	//remove the temp found by find_helper
		if (rt.left() == null)
			return rt.right();
		else if (rt.right() == null)
			return rt.left();
		else {	//two children
			BST_node<K, D> temp = get_min(rt.right());
			rt.set_data(temp.data());
			rt.set_key(temp.key());
			rt.set_r(delete_min(rt.right()));
			return rt;
		}
	}
	
	private BST_node<K, D> get_min(BST_node<K, D> rt){
		if (rt.left() == null)
			return rt;
		else 
			return get_min(rt.left());
	}
	
	private BST_node<K, D> delete_min(BST_node<K, D> rt){
		if (rt.left() == null)
			return rt.right();
		else {
			rt.set_l(delete_min(rt.left()));
			return rt;
		}
	}

	
	public void dump() {
		if (root != null) {
			dump_helper(root);
		}
	}

	private void dump_helper(BST_node<K, D> rt) {	//in order traversal
		if (rt != null) {
			dump_helper(rt.left());
			System.out.print(rt.key().toString());
			System.out.print(rt.data().toString() + "\n");
			dump_helper(rt.right());
		}
	}
	
	BST_node<K, D> find_helper(BST_node<K, D> rt, K key) {
		if (rt == null) return null;
		if (rt.key().compareTo(key) > 0)
			return find_helper(rt.left(), key);
		else if (rt.key().compareTo(key) < 0)
			return find_helper(rt.right(), key);
		else
			return rt;	
	}

	
	void intersection() {}
	
	public BST_node<K, D> root() {
		return root;
	}
	
	public int node_count() {
		return node_count;
	}
	
	protected BST_node<K, D> root;
	protected int node_count;
	

	public class BST_Iterator implements Iterator<K> {
		//i know this is wrong but it's a start
		BST_Iterator(BST_node<K, D> root){ root = null;}//root = null; node_count = 0; }

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}


