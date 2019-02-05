/**
 * @author juliam8
 *
 */
public class BST_Rectangle<K, D> extends BST<RectKey, RectData> {
	
	//BST_Rectangle(){ root = null; node_count = 0; }
	
	BST_node<RectKey, RectData> remove(RectKey k) {	//maybe should be made null
		//RectKey k = new RectKey(node_name);
		if (root != null) {	
		    BST_node<RectKey, RectData> temp = find_helper(root, k); // First find it
		    if (temp != null) {
		      root = remove_helper(temp, k); // removed "root = "
		      node_count--;
		    }
		    return temp;
		}
		return null;	//return null
	}
	
	BST_node<RectKey, RectData> remove(RectData d){		///Ah I don't know if it should be void or not
		if (root != null) {
			BST_node<RectKey, RectData> temp = find_helper_data(root, d);
		    if (temp != null) {
			      root = remove_helper(temp, temp.key()); // removed "root = "
			      node_count--;
		    }
		    return temp;
		}
		return null;
	}
	
	//remove the temp found by find_helper
	/*protected BST_node<RectKey, RectData> remove_helper_data(BST_node<RectKey, RectData> rt, RectData data) {
		//BST_node<RectKey, RectData> mytemp = null;
		if (rt == null) return null;
		if (rt.data().compareTo(data) == 0) {
		  //  if (rt.left() != null)
		    	//mytemp = rt.set_l(remove_helper_data(rt.left(), data));
		  //  if (mytemp == null)
		        //result = locate(p,famTree.right);
	//			rt.set_l(remove_helper_data(rt.left(), data));
		//	else if (rt.data().compareTo(data) < 0)
			//	rt.set_r(remove_helper_data(rt.left(), data));
		}
		else {		
			if (rt.left() == null)
				return rt.right();
			else if (rt.right() == null)
				return rt.left();
			else {	//two children
				BST_node<RectKey, RectData> temp = get_min(rt.right());
				rt.set_data(temp.data());
				rt.set_key(temp.key());
				rt.set_r(delete_min(rt.right()));
			}
		}
		return rt;
	}*/
		
	
	BST_node<RectKey, RectData> find_helper_data(BST_node<RectKey, RectData> rt, RectData d) {
		if (rt == null) return null;
		
		if (rt.data().compareTo(d) == 1)
			return rt;
		else if (rt.left() != null)
			return find_helper_data(rt.left(), d);
		else
			return find_helper_data(rt.right(), d);
	}
	
	
	BST_node<RectKey, RectData> search(String node_name) {
		RectKey k = new RectKey(node_name);
		BST_node<RectKey, RectData> temp = find_helper(root, k);
		return temp;
	}
	

	
	void regionsearch(int[] coordinates) {
		
	}
	
	void intersection() {
		
	}

}
