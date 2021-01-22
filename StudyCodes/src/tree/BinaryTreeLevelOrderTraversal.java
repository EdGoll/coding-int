import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.xml.soap.Node;

import tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        Integer nums[] = { 3, 9, 20, null, null, 15, 7 };
        Integer nums2[] = { 1, 2, 3, 4, null, null, 5 };
        Integer nums3[] = { 0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8 };

        BinaryTreeLevelOrderTraversal btot = new BinaryTreeLevelOrderTraversal();
        TreeNode root = btot.insertLevelOrder(nums2, new TreeNode(), 0);

        List<List<Integer>> l = btot.levelOrder(root);

        for (List<Integer> list : l) {
            for (Integer num : list) {
                System.out.print(num);
            }
            System.out.println();
        }

        // btot.amplitud(root);
    }

    // 3
    // / \
    // 9 20
    // / \
    // 15 7

    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zz = false;
        // iterate till queue is empty
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> nivel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                
                TreeNode node = queue.poll();
                // insert in queue if the child is not null
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                              
                // add the elements in level into batch
                nivel.add(node.val);
            }
            // add the batch to result
            if(zz){                
                Collections.reverse(nivel);
            }                             
            zz=!zz;            
            result.add(nivel);
        }
        return result;
    }

    public List<List<Integer>> levelOrder_(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>(); // The list containing all levels
        List<TreeNode> nodeList = new LinkedList<>(); // The list containing nodes at current level

        if (root != null)
            nodeList.add(root);
        // Keep searching breath first until no nodes can be found
        while (nodeList.size() > 0) {
            List<TreeNode> tempList = new LinkedList<>();
            List<Integer> valList = new LinkedList<>(); // The list containing integer values of nodes
            for (TreeNode node : nodeList) {
                valList.add(node.val);
                // Gradually create a new level
                if (node.left != null)
                    tempList.add(node.left);
                if (node.right != null)
                    tempList.add(node.right);
            }

            nodeList = tempList; // Move to the new level
            list.add(valList); // Add the current level to the answer
        }
        return list;
    }

    public TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;
            if (2 * i + 1 < arr.length && arr[2 * i + 1] != null) {
                root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            }
            if (2 * i + 2 < arr.length && arr[2 * i + 2] != null) {
                root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
            }
        }
        return root;
    }

    public void amplitud(TreeNode a) // SE RECIBE LA RAIZ DEL ARBOL
    {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> cola, colaAux; // DEFINICIÓN DE 2 VARIABLES DE TIPO COLA
        TreeNode aux; // DEFINICIÓN AUX DE TIPO NODOARBOL

        if (a != null) // SI EL ÁRBOL CONTIENE NODOS...
        {
            cola = new LinkedList<>(); // SE INSTANCIA EL OBJETO COLA
            colaAux = new LinkedList<>(); // SE INSTANCIA EL OBJETO COLAAUX
            cola.add(a); // SE INSERTA EL NODOARBOL "A" (RAIZ) COMO PRIMER NODO EN LA COLA
            while (!cola.isEmpty()) // MIENTRAS HAYAN ELEMENTOS EN LA COLA...
            {
                aux = cola.poll();
                colaAux.add(aux); /*
                                   * EL ELEMENTO EXTRAIDO DE LA COLA PRINCIPAL ES ASIGNADO A AUX Y A SU VEZ
                                   * INSERTADO EN LA COLA AUXILIAR
                                   */
                if (aux.left != null) // SI EL HIJO IZQUIERDO DEL NODO ACTUAL EXISTE
                {
                    cola.add(aux.left); // SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                }
                if (aux.right != null) // SI EL HIJO DERECHO DEL NODO ACTUAL EXISTE
                {
                    cola.add(aux.right); // SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                }
            }
            for (TreeNode n : colaAux) {
                System.out.println(n.val);
            }
            // POR ÚLTIMO SE IMPRIME LA COLA AUXILIAR
        }
    }

}
